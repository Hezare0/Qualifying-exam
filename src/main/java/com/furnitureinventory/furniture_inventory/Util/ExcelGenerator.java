package com.furnitureinventory.furniture_inventory.Util;

import com.furnitureinventory.furniture_inventory.Entity.Furniture;
import com.furnitureinventory.furniture_inventory.Entity.Inventory;
import com.furnitureinventory.furniture_inventory.Entity.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ExcelGenerator {
    private Inventory inventory;
    private List<Furniture> furnitureList;
    private User businessDepartmentEmployees;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelGenerator(List<Furniture> furnitureList, User businessDepartmentEmployees, Inventory inventory) {
        this.furnitureList = furnitureList;
        this.businessDepartmentEmployees = businessDepartmentEmployees;
        this.inventory = inventory;
        this.workbook = new XSSFWorkbook();
    }

    private void writeHeader() {
        sheet = workbook.createSheet("Inventory");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "Подразделение", style);
        createCell(row, 1, "Инвентарный номер", style);
        createCell(row, 2, "Материально ответственное лицо", style);
        createCell(row, 3, "Сотрудник ХО, проводивший инвентаризацию", style);
        createCell(row, 4, "Степень износа", style);
    }

    private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (valueOfCell instanceof Integer) {
            cell.setCellValue((Integer) valueOfCell);
        } else if (valueOfCell instanceof Long) {
            cell.setCellValue((Long) valueOfCell);
        } else if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
        }
        cell.setCellStyle(style);
    }
    private void write() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        for (Furniture furniture: furnitureList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, inventory.getDepartment().getDepartamentName(), style);
            createCell(row, columnCount++, furniture.getId(), style);
            createCell(row, columnCount++, furniture.getFinanciallyResponsiblePerson().getLastname() +" "+ furniture.getFinanciallyResponsiblePerson().getFirstname() +" " +furniture.getFinanciallyResponsiblePerson().getMiddlename(), style);
            createCell(row, columnCount++, businessDepartmentEmployees.getLastname() +" "+businessDepartmentEmployees.getFirstname()+" "+businessDepartmentEmployees.getMiddlename(), style);
            createCell(row, columnCount++, furniture.getDegreeOfWear().getWearName(), style);
        }
    }

    public void generateExcelFile(HttpServletResponse response) throws IOException {
        writeHeader();
        write();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}

package com.furnitureinventory.furniture_inventory.Controllers;

import com.furnitureinventory.furniture_inventory.Entity.*;
import com.furnitureinventory.furniture_inventory.Services.DegreeOfWearServices;
import com.furnitureinventory.furniture_inventory.Services.DepartmentServices;
import com.furnitureinventory.furniture_inventory.Services.FurnitureServices;
import com.furnitureinventory.furniture_inventory.Services.InventoryServices;
import com.furnitureinventory.furniture_inventory.Util.ExcelGenerator;
import com.furnitureinventory.furniture_inventory.dto.InventoryRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    
    private final DepartmentServices departmentServices;
    private final FurnitureServices furnitureServices;
    private final DegreeOfWearServices degreeOfWearServices;
    private final InventoryServices inventoryServices;

    @Autowired
    public MainController(DepartmentServices departmentServices, FurnitureServices furnitureServices, DegreeOfWearServices degreeOfWearServices,InventoryServices inventoryServices) {
        this.departmentServices = departmentServices;
        this.furnitureServices = furnitureServices;
        this.degreeOfWearServices = degreeOfWearServices;
        this.inventoryServices = inventoryServices;
    }

    @GetMapping("/")
    public String greeting(Map<String,Object> model){
        return "home";
    }

    @GetMapping("/inventory")
    public String departments(Map<String,Object> model){
        List<Department> departments = departmentServices.findAll();
        model.put("departments",departments);
        return "inventory";
    }

    @GetMapping("/inventory/{department}")
    public String addInventory(@PathVariable Department department, Principal principal,Map<String, Object> model){
        List<Furniture> furnitureList = furnitureServices.findAllByDepartment(department);
        User user = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        List<DegreeOfWear> degreeOfWearList = degreeOfWearServices.findAll();
        model.put("employee",user);
        model.put("furnitureList",furnitureList);
        model.put("degreeOfWearList",degreeOfWearList);
        model.put("department",department);
        return "createInventory";
    }

    @PostMapping("/inventory/{department}")
    public String createInventory(@PathVariable Department department, Principal principal, InventoryRequestDTO inventoryRequestDTO,Map<String,Object> model){
        List<Furniture> furnitureList = furnitureServices.findAllById(inventoryRequestDTO.getFurnitureIds());
        List<DegreeOfWear> degreeOfWearList = degreeOfWearServices.findAllById(inventoryRequestDTO.getWearIds());
        User user = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        int i = 0;
        for (Furniture furniture:furnitureList) {
            furniture.setDegreeOfWear(degreeOfWearList.get(i));
            furnitureServices.save(furniture);
        }
        Inventory inventory = new Inventory(inventoryRequestDTO.getDate(),department,user);
        inventoryServices.save(inventory);
        return "redirect:/inventory";
    }

    @GetMapping("inventory-list")
    public String viewInventory(Map<String,Object> model){
        List<Inventory> inventoryList = inventoryServices.findAll();
        model.put("inventoryList",inventoryList);
        return "inventoryList";
    }
    @GetMapping("inventory-list/excel/{inventory}")
    public void exportIntoExcelFile(@PathVariable Inventory inventory,HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=inventory" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List <Furniture> furnitureList = furnitureServices.findAllByDepartment(inventory.getDepartment());
        ExcelGenerator generator = new ExcelGenerator(furnitureList,inventory.getBusinessDepartmentEmployees(),inventory);
        generator.generateExcelFile(response);
    }
}

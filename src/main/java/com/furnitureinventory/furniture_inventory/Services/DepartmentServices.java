package com.furnitureinventory.furniture_inventory.Services;

import com.furnitureinventory.furniture_inventory.Entity.Department;
import com.furnitureinventory.furniture_inventory.Repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServices {

    private final DepartmentRepo departmentRepo;

    @Autowired
    public DepartmentServices(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }


    public void save(Department department){
        departmentRepo.save(department);
    }


    public List<Department> findAll(){
        return (List<Department>) departmentRepo.findAll(Sort.by(Sort.Direction.ASC,"departamentName"));
    }
}

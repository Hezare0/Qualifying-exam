package com.furnitureinventory.furniture_inventory.Services;

import com.furnitureinventory.furniture_inventory.Entity.DegreeOfWear;
import com.furnitureinventory.furniture_inventory.Entity.Department;
import com.furnitureinventory.furniture_inventory.Entity.Furniture;
import com.furnitureinventory.furniture_inventory.Repo.DepartmentRepo;
import com.furnitureinventory.furniture_inventory.Repo.FurnitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureServices {

    private final FurnitureRepo furnitureRepo;

    @Autowired
    public FurnitureServices(FurnitureRepo furnitureRepo) {
        this.furnitureRepo = furnitureRepo;
    }


    public void save(Furniture furniture){
        furnitureRepo.save(furniture);
    }


    public List<Furniture> findAll(){
        return (List<Furniture>) furnitureRepo.findAll(Sort.by(Sort.Direction.ASC,"furnitureTypes"));
    }
    public List<Furniture> findAllById(List<Long> ids){
        return furnitureRepo.findAllById(ids);
    }

    public List<Furniture> findAllByDepartment(Department department){
        return furnitureRepo.findAllByDepartment(department);
    }
}

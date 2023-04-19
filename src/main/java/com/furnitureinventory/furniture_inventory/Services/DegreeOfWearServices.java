package com.furnitureinventory.furniture_inventory.Services;

import com.furnitureinventory.furniture_inventory.Entity.DegreeOfWear;
import com.furnitureinventory.furniture_inventory.Entity.Department;
import com.furnitureinventory.furniture_inventory.Repo.DegreeOfWearRepo;
import com.furnitureinventory.furniture_inventory.Repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DegreeOfWearServices {

    private final DegreeOfWearRepo degreeOfWearRepo;

    @Autowired
    public DegreeOfWearServices(DegreeOfWearRepo degreeOfWearRepo) {
        this.degreeOfWearRepo = degreeOfWearRepo;
    }


    public void save(DegreeOfWear degreeOfWear){
        degreeOfWearRepo.save(degreeOfWear);
    }

    public List<DegreeOfWear> findAllById(List<Long> ids){
        return degreeOfWearRepo.findAllById(ids);
    }


    public List<DegreeOfWear> findAll(){
        return (List<DegreeOfWear>) degreeOfWearRepo.findAll();
    }
}

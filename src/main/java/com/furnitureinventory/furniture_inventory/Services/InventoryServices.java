package com.furnitureinventory.furniture_inventory.Services;

import com.furnitureinventory.furniture_inventory.Entity.DegreeOfWear;
import com.furnitureinventory.furniture_inventory.Entity.Inventory;
import com.furnitureinventory.furniture_inventory.Repo.DegreeOfWearRepo;
import com.furnitureinventory.furniture_inventory.Repo.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServices {

    private final InventoryRepo inventoryRepo;

    @Autowired
    public InventoryServices(InventoryRepo inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }


    public void save(Inventory inventory){
        inventoryRepo.save(inventory);
    }


    public List<Inventory> findAll(){
        return (List<Inventory>) inventoryRepo.findAll();
    }
}

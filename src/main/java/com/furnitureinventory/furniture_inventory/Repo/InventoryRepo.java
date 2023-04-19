package com.furnitureinventory.furniture_inventory.Repo;

import com.furnitureinventory.furniture_inventory.Entity.Department;
import com.furnitureinventory.furniture_inventory.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Inventory,Long> {
}

package com.furnitureinventory.furniture_inventory.Repo;

import com.furnitureinventory.furniture_inventory.Entity.Department;
import com.furnitureinventory.furniture_inventory.Entity.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FurnitureRepo extends JpaRepository<Furniture,Long> {
    public List<Furniture> findAllByDepartment(Department department);
}

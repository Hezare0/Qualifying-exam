package com.furnitureinventory.furniture_inventory.Repo;

import com.furnitureinventory.furniture_inventory.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,Long> {
}

package com.furnitureinventory.furniture_inventory.Repo;

import com.furnitureinventory.furniture_inventory.Entity.Role;
import com.furnitureinventory.furniture_inventory.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepo extends JpaRepository<User,Long> {
        Optional<User> findByUsername(String username);
        List<User> findUsersByRoles(Role role);
}

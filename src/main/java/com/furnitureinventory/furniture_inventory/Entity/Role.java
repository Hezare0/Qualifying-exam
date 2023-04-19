package com.furnitureinventory.furniture_inventory.Entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN("Администратор"),
    XO("сотрудниками хозяйственного отдела");

    private String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}

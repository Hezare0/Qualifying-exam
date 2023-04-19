package com.furnitureinventory.furniture_inventory.Entity;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String date;

    @ManyToOne
    @JoinColumn(name="departament_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name="businessDepartmentEmployees_id")
    private User businessDepartmentEmployees;

    public Inventory() {
    }

    public Inventory(String date, Department department, User businessDepartmentEmployees) {
        this.date = date;
        this.department = department;
        this.businessDepartmentEmployees = businessDepartmentEmployees;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public User getBusinessDepartmentEmployees() {
        return businessDepartmentEmployees;
    }

    public void setBusinessDepartmentEmployees(User businessDepartmentEmployees) {
        this.businessDepartmentEmployees = businessDepartmentEmployees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(id, inventory.id) && Objects.equals(date, inventory.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", date='" + date + '\'' +
                '}';
    }
}

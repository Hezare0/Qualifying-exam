package com.furnitureinventory.furniture_inventory.Entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String departamentName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departmentHead_id")
    private User departmentHead;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;
    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY)
    Set<Furniture> furnitures;

    public Department() {
    }

    public Department(String departamentName, User departmentHead, Company company) {
        this.departamentName = departamentName;
        this.departmentHead = departmentHead;
        this.company = company;
    }

    public User getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(User departmentHead) {
        this.departmentHead = departmentHead;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Furniture> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(Set<Furniture> furnitures) {
        this.furnitures = furnitures;
    }

    public String getDepartamentName() {
        return departamentName;
    }

    public void setDepartamentName(String departamentName) {
        this.departamentName = departamentName;
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
        Department that = (Department) o;
        return Objects.equals(id, that.id) && Objects.equals(departamentName, that.departamentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departamentName);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departamentName='" + departamentName + '\'' +
                '}';
    }
}

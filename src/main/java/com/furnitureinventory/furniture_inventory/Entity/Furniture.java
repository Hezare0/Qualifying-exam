package com.furnitureinventory.furniture_inventory.Entity;

import javax.persistence.*;


import java.util.Objects;
import java.util.Set;

@Entity
public class Furniture {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String releaseDate;
    private String initialCost;

    private String dateAssignedDepartment;

    @ElementCollection(targetClass = FurnitureType.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "furniture_type", joinColumns = @JoinColumn(name = "furniture_id"))
    @Enumerated(EnumType.STRING)
    private Set<FurnitureType> furnitureTypes;

    @ManyToOne
    @JoinColumn(name="departament_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name="financially_responsible_person_id")
    private User financiallyResponsiblePerson;

    @ManyToOne
    @JoinColumn(name="degree_of_wear_id")
    private DegreeOfWear degreeOfWear;



    public Furniture() {
    }

    public Furniture(String releaseDate, String initialCost, String dateAssignedDepartment, Set<FurnitureType> furnitureTypes, Department department, User financiallyResponsiblePerson) {
        this.releaseDate = releaseDate;
        this.initialCost = initialCost;
        this.dateAssignedDepartment = dateAssignedDepartment;
        this.furnitureTypes = furnitureTypes;
        this.department = department;
        this.financiallyResponsiblePerson = financiallyResponsiblePerson;
    }

    public User getFinanciallyResponsiblePerson() {
        return financiallyResponsiblePerson;
    }

    public void setFinanciallyResponsiblePerson(User financiallyResponsiblePerson) {
        this.financiallyResponsiblePerson = financiallyResponsiblePerson;
    }

    public DegreeOfWear getDegreeOfWear() {
        return degreeOfWear;
    }

    public void setDegreeOfWear(DegreeOfWear degreeOfWear) {
        this.degreeOfWear = degreeOfWear;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getInitialCost() {
        return initialCost;
    }

    public void setInitialCost(String initialCost) {
        this.initialCost = initialCost;
    }

    public String getDateAssignedDepartment() {
        return dateAssignedDepartment;
    }

    public void setDateAssignedDepartment(String dateAssignedDepartment) {
        this.dateAssignedDepartment = dateAssignedDepartment;
    }

    public Set<FurnitureType> getFurnitureTypes() {
        return furnitureTypes;
    }

    public void setFurnitureTypes(Set<FurnitureType> furnitureTypes) {
        this.furnitureTypes = furnitureTypes;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
        Furniture furniture = (Furniture) o;
        return Objects.equals(id, furniture.id) && Objects.equals(releaseDate, furniture.releaseDate) && Objects.equals(initialCost, furniture.initialCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, releaseDate, initialCost);
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "id=" + id +
                ", releaseDate='" + releaseDate + '\'' +
                ", initialCost='" + initialCost + '\'' +
                '}';
    }
}

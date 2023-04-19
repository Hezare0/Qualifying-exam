package com.furnitureinventory.furniture_inventory.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class DegreeOfWear {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String wearName;
    private String wearShortName;

    public DegreeOfWear() {
    }

    public DegreeOfWear(String wearName, String wearShortName) {
        this.wearName = wearName;
        this.wearShortName = wearShortName;
    }

    public String getWearName() {
        return wearName;
    }

    public void setWearName(String wearName) {
        this.wearName = wearName;
    }

    public String getWearShortName() {
        return wearShortName;
    }

    public void setWearShortName(String wearShortName) {
        this.wearShortName = wearShortName;
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
        DegreeOfWear that = (DegreeOfWear) o;
        return Objects.equals(id, that.id) && Objects.equals(wearName, that.wearName) && Objects.equals(wearShortName, that.wearShortName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, wearName, wearShortName);
    }

    @Override
    public String toString() {
        return "DegreeOfWear{" +
                "id=" + id +
                ", wearName='" + wearName + '\'' +
                ", wearShortName='" + wearShortName + '\'' +
                '}';
    }
}

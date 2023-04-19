package com.furnitureinventory.furniture_inventory.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class InventoryRequestDTO implements Serializable {
    private final String date;
    private final List<Long> furnitureIds;
    private final List<Long> wearIds;

    public InventoryRequestDTO(String date, List<Long> furnitureIds, List<Long> wearIds) {
        this.date = date;
        this.furnitureIds = furnitureIds;
        this.wearIds = wearIds;
    }

    public String getDate() {
        return date;
    }

    public List<Long> getFurnitureIds() {
        return furnitureIds;
    }

    public List<Long> getWearIds() {
        return wearIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryRequestDTO that = (InventoryRequestDTO) o;
        return Objects.equals(date, that.date) && Objects.equals(furnitureIds, that.furnitureIds) && Objects.equals(wearIds, that.wearIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, furnitureIds, wearIds);
    }

    @Override
    public String toString() {
        return "inventoryRequestDTO{" +
                "date='" + date + '\'' +
                ", furnitureIds=" + furnitureIds +
                ", wearIds=" + wearIds +
                '}';
    }
}

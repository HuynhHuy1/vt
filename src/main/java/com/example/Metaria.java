package com.example;

import java.time.LocalDate;

public abstract class Metaria implements Discount {
    private String id;
    private String name;
    LocalDate manufacturingDate;
    int cost;

    public Metaria() {
    }

    public Metaria(String id, String name, LocalDate manufacturingDate, int cost) {
        this.id = id;
        this.name = name;
        this.manufacturingDate = manufacturingDate;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public int getCost() {
        return cost;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public abstract double getAmount();

    public abstract LocalDate getExpiryDate();
}

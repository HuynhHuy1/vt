package com.example;

import java.time.LocalDate;

public class Meat extends Metaria  {
    private double weight;

    public Meat(double weight) {
        this.weight = weight;
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return this.cost * weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return this.manufacturingDate.plusDays(7);

    }

    @Override
    public double getRealMoney() {
        LocalDate nowDate = LocalDate.now();
        if (this.getExpiryDate().isBefore(nowDate.plusDays(5))) {
            return this.getAmount() * 0.7;
        } else {
            return this.getAmount() * 0.9;
        }
    }

}

package com.example;

import java.time.LocalDate;

public class CrispyFlour extends Metaria{   
    private double quantity;

    
    public CrispyFlour(int quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return this.cost * this.quantity;
    }

    @Override
    public LocalDate getExpiryDate() {
        return this.manufacturingDate.plusDays(365);
    }

    @Override
    public double getRealMoney() {
        LocalDate nowDate = LocalDate.now();
        if(this.getExpiryDate().isBefore(nowDate.plusDays(60))){
            return this.getAmount() * 0.6;
        }
        else if(this.getExpiryDate().isBefore(nowDate.plusDays(120))){
            return this.getAmount() * 0.8;
        }
        else{
            return this.getAmount() * 0.95;
        }
    }
    
}

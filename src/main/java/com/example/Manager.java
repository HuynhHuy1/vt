package com.example;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private List<Metaria> listMetarial;

    public Manager(){
        this.listMetarial = new ArrayList<>();
    }
    public void add(Metaria metaria){
        this.listMetarial.add(metaria);
    }
    public void remove(Metaria metaria){
        this.listMetarial.remove(metaria);
    }

    public List<Metaria> getList(){
        return this.listMetarial;
    }

    public double totalAmount(){
        double total = 0;
        for (Metaria metaria : listMetarial) {
            total += metaria.getAmount();
        }
        return total;
    }
    public double totalAmountDiscount(){
        double total = 0;
        for (Metaria metaria : listMetarial) {
            total += metaria.getRealMoney();
        }
        return total;
    }
}

package com.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Metaria meat1 = new Meat("M1", "Meat 1", LocalDate.parse("22-04-2023",formatter), 20, 11.9);
        Metaria meat2 = new Meat("M2", "Meat 2", LocalDate.parse("22-05-2023",formatter), 21, 11.6);
        Metaria meat3 = new Meat("M3", "Meat 3", LocalDate.parse("22-06-2023",formatter), 20, 11.8);
        Metaria meat4 = new Meat("M4", "Meat 4", LocalDate.parse("22-07-2023",formatter), 22, 11.1);
        Metaria meat5 = new Meat("M5", "Meat 5", LocalDate.parse("22-08-2023",formatter), 23, 11.5);
        Metaria crispyFlour1 = new CrispyFlour("M1", "CrispyFlour 1", LocalDate.parse("22-04-2023",formatter), 20, 11);
        Metaria crispyFlour2 = new CrispyFlour("M2", "CrispyFlour 2", LocalDate.parse("22-05-2023",formatter), 21, 12);
        Metaria crispyFlour3 = new CrispyFlour("M3", "CrispyFlour 3", LocalDate.parse("22-06-2023",formatter), 20, 13);
        Metaria crispyFlour4 = new CrispyFlour("M4", "CrispyFlour 4", LocalDate.parse("22-07-2023",formatter), 22, 14);
        Metaria crispyFlour5 = new CrispyFlour("M5", "CrispyFlour 5", LocalDate.parse("22-08-2023",formatter), 23, 15);
        manager.add(meat1);
        manager.add(meat2);
        manager.add(meat3);
        manager.add(meat4);
        manager.add(meat5);
        manager.add(crispyFlour1);
        manager.add(crispyFlour2);
        manager.add(crispyFlour3);
        manager.add(crispyFlour4);
        manager.add(crispyFlour5);


        System.out.println(" Total of 10 Metaria "  + manager.totalAmount() + " VND");
        
        System.out.println(" Difference between discounted and undiscounted  "  + ( manager.totalAmount() - manager.totalAmountDiscount() ) + " VND");
    }
}
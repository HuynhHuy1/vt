package com.example;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws IOException {
        Manager manager = new Manager();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Metaria meat1 = new Meat("M1", "Meat1", LocalDate.parse("22-04-2023", formatter), 20, 11.9);
        Metaria meat2 = new Meat("M2", "Meat2", LocalDate.parse("22-05-2023", formatter), 21, 11.6);
        Metaria meat3 = new Meat("M3", "Meat3", LocalDate.parse("22-06-2023", formatter), 20, 11.8);
        Metaria meat4 = new Meat("M4", "Meat4", LocalDate.parse("22-07-2023", formatter), 22, 11.1);
        Metaria meat5 = new Meat("M5", "Meat5", LocalDate.parse("22-08-2023", formatter), 23, 11.5);
        Metaria crispyFlour1 = new CrispyFlour("CF1", "CrispyFlour1", LocalDate.parse("22-04-2023", formatter), 20,
                11);
        Metaria crispyFlour2 = new CrispyFlour("CF2", "CrispyFlour2", LocalDate.parse("22-05-2023", formatter), 21,
                12);
        Metaria crispyFlour3 = new CrispyFlour("CF3", "CrispyFlour3", LocalDate.parse("22-06-2023", formatter), 20,
                13);
        Metaria crispyFlour4 = new CrispyFlour("CF4", "CrispyFlour4", LocalDate.parse("22-07-2023", formatter), 22,
                14);
        Metaria crispyFlour5 = new CrispyFlour("CF5", "CrispyFlour5", LocalDate.parse("22-08-2023", formatter), 23,
                15);
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

        System.out.println(" Total of 10 Metaria " + manager.totalAmount() + " VND");

        System.out.println(" Difference between discounted and undiscounted  "
                + (manager.totalAmount() - manager.totalAmountDiscount()) + " VND");

        try {
            manager.writeFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        manager.readFile();
        manager.add(new Meat("M6", "Meat1", LocalDate.parse("22-04-2023", formatter), 20, 11.9));
        manager.remove(new Meat("M1", "Meat1", LocalDate.parse("22-04-2023", formatter), 20, 11.9));
        manager.update("M4",new Meat("M4", "Meat100", LocalDate.parse("22-04-2023", formatter), 20, 11.9));
    }

}
package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    private List<Metaria> listMetarial;

    public Manager() {
        this.listMetarial = new ArrayList<>();
    }

    public void add(Metaria metaria) throws IOException {
        this.listMetarial.add(metaria);
        this.writeFile();
    }

    public void remove(Metaria metaria) throws IOException {
        this.listMetarial.remove(metaria);
        this.writeFile();
    }

    public void update(String id, Metaria newMetaria) throws IOException {
        for (Metaria metaria : listMetarial) {
            if (metaria.getId().equals(id)) {
                metaria.setName(newMetaria.getName());
                metaria.setCost(newMetaria.getCost());
                this.writeFile();
            }
        }
    }

    public List<Metaria> getList() {
        return this.listMetarial;
    }

    public double totalAmount() {
        double total = 0;
        for (Metaria metaria : listMetarial) {
            total += metaria.getAmount();
        }
        return total;
    }

    public double totalAmountDiscount() {
        double total = 0;
        for (Metaria metaria : listMetarial) {
            total += metaria.getRealMoney();
        }
        return total;
    }

    public void writeFile() throws IOException {
        String path = "/Users/mac/Documents/Document Tailwindcss/demo/src/main/java/com/example/write_file.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        for (Metaria metaria : listMetarial) {
            bw.write(metaria.getId() + " " + metaria.getName() + " " + metaria.getManufacturingDate() + " "
                    + metaria.getAmount() + " " + metaria.getCost() + "\n");
            bw.flush();
        }
    }

    public void readFile() throws IOException {
        String path = "/Users/mac/Documents/Document Tailwindcss/demo/src/main/java/com/example/read_file.txt";
        String line;
        BufferedReader br = new BufferedReader(new FileReader(path));
        while ((line = br.readLine()) != null) {
            String parts[] = line.split(" ");
            if (parts.length == 6) {
                String id = parts[0];
                String name = parts[1];
                String dateString = parts[2];
                int cost = Integer.parseInt(parts[3]);
                Double anotherAmount = Double.parseDouble(parts[4]);

                // Chuyển đổi chuỗi ngày thành đối tượng Date
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                if (id.contains("M")) {
                    Metaria metaria = new Meat(id, name, LocalDate.parse(dateString, formatter), cost, anotherAmount);
                    this.listMetarial.add(metaria);
                } else {
                    Metaria metaria = new CrispyFlour(id, name, LocalDate.parse(dateString, formatter), cost,
                            Integer.parseInt("anotherAmount"));
                    this.listMetarial.add(metaria);
                }
            }
        }

        System.out.println(" Content file reader: ");
        for (Metaria metaria : listMetarial) {
            System.out.println(metaria.getId() + " " + metaria.getName() + " " + metaria.getManufacturingDate() + " "
                    + metaria.getAmount() + " " + metaria.getCost());
        }

    }
}

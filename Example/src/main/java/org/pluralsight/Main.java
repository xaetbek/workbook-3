package org.pluralsight;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = ProductReader.readProductFromCSV("products.csv");

        for (Product p : products) {
            System.out.println("\nID: " + p.getId());
            System.out.println("Name: " + p.getName());
            System.out.println("Price: " + p.getPrice());
            System.out.println("Stock: " + p.getStock());
        }
    }
}
package org.pluralsight;

import java.io.*;
import java.util.*;

public class Inventory {
    public static ArrayList<Product> loadInventory(String filename) {
        ArrayList<Product> inventory = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    inventory.add(new Product(id, name, price));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading inventory file: " + e.getMessage());
        }
        return inventory;
    }

    public static void listAllProducts(ArrayList<Product> inventory) {
        inventory.sort(Comparator.comparing(Product::getName));
        for (Product p : inventory) {
            System.out.printf("id: %d %s - Price: $%.2f\n", p.getId(), p.getName(), p.getPrice());
        }
    }

    public static void lookupById(ArrayList<Product> inventory, int id) {
        for (Product p : inventory) {
            if (p.getId() == id) {
                System.out.printf("Found: id: %d %s - Price: $%.2f\n", p.getId(), p.getName(), p.getPrice());
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public static void findByPriceRange(ArrayList<Product> inventory, double min, double max) {
        boolean found = false;
        for (Product p : inventory) {
            if (p.getPrice() >= min && p.getPrice() <= max) {
                System.out.printf("id: %d %s - Price: $%.2f\n", p.getId(), p.getName(), p.getPrice());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products found in that price range.");
        }
    }

    public static void addProduct(ArrayList<Product> inventory, String filename, int id, String name, double price) {
        Product newProduct = new Product(id, name, price);
        inventory.add(newProduct);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(id + "|" + name + "|" + price + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

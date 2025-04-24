package org.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d %s - Price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
        }

    }
    // this method loads product objects into inventory
    public static ArrayList<Product> getInventory()
    {
        ArrayList<Product> inventory = new ArrayList<Product>();
        // Product p = new Product(1, "Laptop", 899.99);
        // inventory.add(p);
        inventory.add(new Product(1, "Laptop", 899.99));
        inventory.add(new Product(2, "Smartphone", 699.99));
        inventory.add(new Product(3, "Headphones", 199.99));
        inventory.add(new Product(4, "Monitor", 399.99));
        inventory.add(new Product(5, "Keyboard", 99.99));

        return inventory;
    }
}
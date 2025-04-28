package org.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {
        final String FILE_NAME = "inventory.csv";
        ArrayList<Product> inventory = Inventory.loadInventory(FILE_NAME);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWhat do you want to do?\n");
            System.out.println("1- List all products");
            System.out.println("2- Lookup a product by its id");
            System.out.println("3- Find all products within a price range");
            System.out.println("4- Add a new product");
            System.out.println("5- Quit the application");
            System.out.print("Enter command: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    Inventory.listAllProducts(inventory);
                    break;
                case "2":
                    System.out.print("Enter product id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Inventory.lookupById(inventory, id);
                    break;
                case "3":
                    System.out.print("Enter minimum price: ");
                    double min = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter maximum price: ");
                    double max = Double.parseDouble(scanner.nextLine());
                    Inventory.findByPriceRange(inventory, min, max);
                    break;
                case "4":
                    System.out.print("Enter product id: ");
                    int newId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    Inventory.addProduct(inventory, FILE_NAME, newId, name, price);
                    System.out.println("Product added.");
                    break;
                case "5":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid command. Please choose 1-5.");
            }
        }
    }
}

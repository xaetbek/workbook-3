package org.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductReader {
    public static List<Product> readProductFromCSV(String fileName) {

        List<Product> productList = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);

            // Skip the first line (it contains column names like id,name,price,stock)
            reader.readLine();

            String line;
            // Read each remaining line in the file
            while ((line = reader.readLine()) != null) {
                // Split the line into parts, using comma as the separator
                String[] tokens = line.split(",");

                // Check if the line has exactly 4 parts (id, name, price, stock)
                if (tokens.length == 4) {
                    int id = Integer.parseInt(tokens[0]);        // Convert the first part to an integer (ID)
                    String name = tokens[1];                     // Get the name as text
                    double price = Double.parseDouble(tokens[2]); // Convert price to a decimal number
                    int stock = Integer.parseInt(tokens[3]);     // Convert stock to an integer

                    // Create a new Product object using the parts
                    Product p = new Product(id, name, price, stock);

                    // Add the product to the list
                    productList.add(p);
//                    System.out.println(p + " was added to the list");
                }
            }
            reader.close();
        } catch (IOException e) {
            //  Print an error ve if the file can't be read
            System.out.println("Something went wrong while reading the file.");
        }
        return productList;
    }
}

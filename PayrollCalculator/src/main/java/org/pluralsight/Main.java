package org.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the file employee file to process: ");
        String inputFile = scanner.nextLine();

        System.out.print("Enter the name of the payroll file to create: ");
        String outputFile = scanner.nextLine();

        List<Employee> employees = new ArrayList<>();

        try {
            // create a FileReader object connected to the File
            FileReader fileReader = new FileReader(inputFile);

            // create a BufferedReader to manage input stream
            BufferedReader bufReader = new BufferedReader(fileReader);

            // Skip the first line (it contains column names like id,name,price,stock)
            bufReader.readLine();

            String line;
            // read each line until there is no more data
            while((line = bufReader.readLine()) != null) {
                // Split the line into parts, using comma as the separator
                String[] tokens = line.split(Pattern.quote("|"));

                // Check if the line has exactly 4 parts (id, name, price, stock)
                if (tokens.length == 4) {
                    int employeeId = Integer.parseInt(tokens[0]);        // Convert the first part to an integer (ID)
                    String name = tokens[1];                     // Get the name as text
                    double hoursWorked = Double.parseDouble(tokens[2]); // Convert price to a decimal number
                    double payRate = Double.parseDouble(tokens[3]);     // Convert stock to an integer

                    Employee employee = new Employee(employeeId, name, hoursWorked, payRate);
                    employees.add(employee);
                    // Do not print for now
//                    System.out.printf("ID: %d, Name: %s, Gross Pay: $%.2f%n",
//                            employee.getEmployeeId(),
//                            employee.getName(),
//                            employee.getGrossPay());
                }
            }
            bufReader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Write to output file using BufferedWriter
        if (outputFile.toLowerCase().endsWith(".json")) {
            writeJsonBuffered(employees, outputFile);
        } else {
            writeCsvBuffered(employees, outputFile);
        }

        System.out.println("Payroll report written to " + outputFile);
    }
    private static void writeCsvBuffered(List<Employee> employees, String filename) {
        try (
                FileWriter fileWriter = new FileWriter(filename);
                BufferedWriter bufWriter = new BufferedWriter(fileWriter)
        ) {
            bufWriter.write("id|name|gross pay");
            bufWriter.newLine();
            for (Employee e : employees) {
                String line = String.format("%d|%s|%.2f", e.getEmployeeId(), e.getName(), e.getGrossPay());
                bufWriter.write(line);
                bufWriter.newLine();
            }
            bufWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing CSV file: " + e.getMessage());
        }
    }
    private static void writeJsonBuffered(List<Employee> employees, String filename) {
        try (
                FileWriter fileWriter = new FileWriter(filename);
                BufferedWriter bufWriter = new BufferedWriter(fileWriter)
        ) {
            bufWriter.write("[");
            bufWriter.newLine();
            for (int i = 0; i < employees.size(); i++) {
                Employee e = employees.get(i);
                String jsonEntry = String.format("  { \"id\": %d, \"name\" : \"%s\", \"grossPay\" : %.2f }",
                        e.getEmployeeId(), e.getName(), e.getGrossPay());
                bufWriter.write(jsonEntry);
                if (i < employees.size() - 1) {
                    bufWriter.write(",");
                }
                bufWriter.newLine();
            }
            bufWriter.write("]");
        } catch (IOException e) {
            System.out.println("Error writing JSON file: " + e.getMessage());
        }
    }
}
package org.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();       //ArrayList for Employee objects

        // Display employee info


        try {
            // create a FileReader object connected to the File
            FileReader fileReader = new FileReader("employees.csv");

            // create a BufferedReader to manage input stream
            BufferedReader bufReader = new BufferedReader(fileReader);

            // Skip the first line (it contains column names like id,name,price,stock)
            bufReader.readLine();

            String line;
            // read each line until there is no more data
            while((line = bufReader.readLine()) != null){
                // Split the line into parts, using comma as the separator
                String[] tokens = line.split(Pattern.quote("|"));

                // Check if the line has exactly 4 parts (id, name, price, stock)
                if (tokens.length == 4) {
                    int employeeId = Integer.parseInt(tokens[0]);        // Convert the first part to an integer (ID)
                    String name = tokens[1];                     // Get the name as text
                    double hoursWorked = Double.parseDouble(tokens[2]); // Convert price to a decimal number
                    double payRate = Double.parseDouble(tokens[3]);     // Convert stock to an integer

                    Employee employee = new Employee(employeeId, name, hoursWorked, payRate);
                    employeeList.add(employee);                      //load the Employee object onto the ArrayList for Employee
                }
            }
            bufReader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        public void printEmployeeInfo() {                                                                    //method to print employee info in a specific format
            System.out.println("Printing Employee Information:");
            System.out.println();
            for (Employee employee : employeeList) {                                                           //for-each loop to iterate through
                System.out.printf("ID: %d|\tName: %s|\nGross Pay: %.2f\n\n",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay()); //print out with format so doubles are formatted as floats
            }
        }
    }
}
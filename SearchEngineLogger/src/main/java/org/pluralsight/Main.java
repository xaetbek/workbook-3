package org.pluralsight;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        searchEngineLogger actionLogger = new searchEngineLogger();

        // Log when app starts
        actionLogger.logUserActions("launch");

        while (true) {
            // Prompt user for input
            System.out.print("Enter a search term (X to exit): ");
            String userInput = scanner.nextLine().trim();

            // Exit condition
            if (userInput.equalsIgnoreCase("X")) {
                actionLogger.logUserActions("exit");
                System.out.println("Exiting application");
                break;
            }
            // Log search term if not empty
            else if (!userInput.isEmpty()) {
                actionLogger.logUserActions("search : " + userInput);
            }
        }
        scanner.close();

    }
}
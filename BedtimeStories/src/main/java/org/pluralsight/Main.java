package org.pluralsight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the name of one of the stories to read: " +
                "\n1. goldilocks.txt" +
                "\n2. hansel_and_gretel.txt" +
                "\n3. mary_had_a_little_lamb.txt");
            System.out.print("> ");
            String fileName = scanner.nextLine();
            FileInputStream fis = new FileInputStream(fileName);

            Scanner fileReader = new Scanner(fis);
            int lineNumber = 1;
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                System.out.println(lineNumber + ". " + line);
                lineNumber++;
            }
        scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, the file was not found.");
        }
    }
}
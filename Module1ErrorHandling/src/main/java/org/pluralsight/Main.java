package org.pluralsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ///////// Exercise 1 //////////
//        String[] names = {
//                "Ezra", "Elisha", "Ian",
//                "Siddalee", "Pursalane", "Zephaniah"
//        };

//        boolean success = false;
//
//        while (!success) {
//            try {
//                System.out.print("Pick a kid (select #1 - #6): ");
//                int index = scanner.nextInt();
//                scanner.nextLine(); // clear newline
//
//                if (index < 1 || index > 6) {
//                    System.out.println(" Number out of range. Pick between 1 and 6.");
//                    continue;
//                }
//                index--;
//                System.out.println(" You picked: " + names[index]);
//                success = true;
//
//            } catch (InputMismatchException e) {
//                System.out.println(" Not a valid number. Please enter digits only.");
//                scanner.nextLine(); // clear invalid input
//            } catch (Exception e) {
//                System.out.println("⚠️ Something else went wrong: " + e.getMessage());
//                scanner.nextLine();
//            }
//        }
//        scanner.close();

        //////////// Exercise 2 Guess Game /////////

        System.out.println("🎮 Welcome to the Number Guessing Game!");
        System.out.println("1. Easy Mode (1 - 10)");
        System.out.println("2. Hard Mode (1 - 100)");

        int mode = 0;

        while (mode != 1 && mode != 2) {
            System.out.print("Choose a mode (1 or 2): ");
            try {
                mode = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("❌ Please enter a number.");
                scanner.nextLine(); // clear the wrong input
            }
        }

        int maxNumber = 0;

        // Set the max number based on mode
        if (mode == 1) {
            maxNumber = 10;
        } else if(mode == 2) {
            maxNumber = 100;
        }

        // Generate a random number between 1 and maxNumber
        int correctNumber = (int)(Math.random() * 10) + 1;

        boolean success = false;

        // Loop until the user guesses the correct number
        while (!success) {
            System.out.print("Pick a number between 1 and " + maxNumber + ": ");
            try {
                int guess = scanner.nextInt();
                // Check if guess is out of range
                if (guess < 1 || guess > maxNumber) {
                    System.out.println("⚠\uFE0F Out of range! Try again.");
                    continue;
                }
                // Check if user's guess is correct
                if (guess == correctNumber) {
                    System.out.println("\uD83C\uDF89 You guessed it!");
                    success = true;
                } else if (guess < correctNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Not a number. Try again."); // Handle invalid input
                scanner.nextLine(); // Clear invalid input
            }
        }

        scanner.close();
    }
}
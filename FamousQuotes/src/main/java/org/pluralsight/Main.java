package org.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FamousQuote quote = new FamousQuote();

        System.out.println("Please, select a number between 1 and 10: ");
        int userInput = scanner.nextInt();
        userInput--;                // change number from range 1-10 to range 0-9
        System.out.println(quote.quotesList[userInput]);
    }
}
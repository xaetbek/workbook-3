package org.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class searchEngineLogger {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Logs a user action to logs.txt with a timestamp
    public static void logUserActions(String action) {
        String timeStamp = LocalDateTime.now().format(formatter);           // Get current time in formatted string
        String logEntry = timeStamp + " " + action;                         // Combine timestamp and action

        // Write to file in append mode (true means it appends)
        try (FileWriter fileWriter = new FileWriter("logs.txt", true))
        {
            fileWriter.write(logEntry + "\n");
        } catch (IOException e) {
                System.out.println("Error while logging action.. " + e.getMessage());
        }
    }
}

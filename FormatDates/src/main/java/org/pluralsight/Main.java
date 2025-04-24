package org.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        // Current date and time
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Format 1: 09/05/2021
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(currentDate.format(format1));

        // Format 2: 2021-09-05
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(currentDate.format(format2));

        // Format 3: September 5, 2021
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        System.out.println(currentDate.format(format3));

        // Format 4: Sunday, Sep 5, 2021   10:02 (LOCAL time, since GMT not available via these classes)
        DateTimeFormatter format4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy  HH:mm");
        System.out.println(currentDateTime.format(format4));

        // Challenge Format: 5:02 on 05-Sep-2021 (LOCAL time)
        DateTimeFormatter challengeFormat = DateTimeFormatter.ofPattern("H:mm 'on' dd-MMM-yyyy");
        System.out.println(currentDateTime.format(challengeFormat));
    }
}
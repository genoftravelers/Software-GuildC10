/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birthdayCalculator;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class BirthdayCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate ld = LocalDate.now();

        System.out.println("This is a Birthday Calculator");
        System.out.println("When were you born? please enter in this format MM-dd-yyyy.");
        String input = sc.nextLine();

        LocalDate birthday = LocalDate.parse(input, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        Period howOld = birthday.until(ld);

        int birthdayMonth = birthday.get(ChronoField.MONTH_OF_YEAR);
        int birthdayDay = birthday.get(ChronoField.DAY_OF_MONTH);
        int currentYear = ld.getYear();
        LocalDate birthdayCurrentYear = LocalDate.of(currentYear, birthdayMonth, birthdayDay);

        int nextYear = currentYear + 1;
        LocalDate birthdayNextYear = LocalDate.of(nextYear, birthdayMonth, birthdayDay);
        long daysUntilNextBday = ChronoUnit.DAYS.between(ld, birthdayNextYear);

        System.out.println("You are " + howOld.getYears() + " Years old.");
        System.out.println("You were born on a " + birthday.getDayOfWeek());
        System.out.println("You birthday falls on " + birthdayCurrentYear.getDayOfWeek() + " this year.");
        System.out.println("Next year, you will be " + (howOld.getYears() + 1) + " Years old.");

    }
}

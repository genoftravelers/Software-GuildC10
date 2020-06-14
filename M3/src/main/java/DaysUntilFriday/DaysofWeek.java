/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaysUntilFriday;

import java.util.Scanner;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class DaysofWeek {

   
    public static DaysUntilFriday confirmDay(String dayInput) {
        String setDay = dayInput.toUpperCase();

        switch (setDay) {
            case "SUNDAY":
                return DaysUntilFriday.SUNDAY;
            case "MONDAY":
                return DaysUntilFriday.MONDAY;
            case "TUESDAY":
                return DaysUntilFriday.TUESDAY;
            case "WEDNESDAY":
                return DaysUntilFriday.WEDNESDAY;
            case "THURSDAY":
                return DaysUntilFriday.THURSDAY;
            case "FRIDAY":
                return DaysUntilFriday.FRIDAY;
            case "SATURDAY":
                return DaysUntilFriday.SATURDAY;
            default:
                throw new UnsupportedOperationException();

        }
    }

    static public int countdowntoFriday(DaysUntilFriday day) {
        switch (day) {
            case SUNDAY: 
                return 5;
            
            case MONDAY: 
                return 4;
            
            case TUESDAY: 
                return 3;
            
            case WEDNESDAY: 
                return 2;
            
            case THURSDAY: 
                return 1;
            
            case FRIDAY: 
                return 0;
            
            case SATURDAY: 
                return 6;
            
            default: 
                throw new UnsupportedOperationException();
            
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a day. ");
        String inputDay = sc.nextLine();

        DaysUntilFriday userDay = confirmDay(inputDay);

        if (countdowntoFriday(userDay) == 0) {
            System.out.println("It is Friday today.");
        } else {
            System.out.println("You have " + countdowntoFriday(userDay) + " days until Friday.");
        }
    }

}

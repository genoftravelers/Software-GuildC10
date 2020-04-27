/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assessment;

import java.util.Scanner;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class HealthyHearts {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// scanner to read the input.

        //getting user's age.
        System.out.println("What is your age?");
        int age = sc.nextInt();// intakes the age
        int theHeartRate = 220 - age;// 
        int hrZoneMax = theHeartRate / 2;// half of maximum heart rate.
        double hrZoneMin = theHeartRate * 0.85;// 85% of maximum heart rate taken in double data type

        //Demonstrate the maximum heart rate and the targer HR Zone.
        System.out.println("Your maximim heart rate should be " + theHeartRate + " per minute.");
        System.out.println("your target HR Zone is " + hrZoneMin + " - " + hrZoneMax + " beats per min.");

    }
}

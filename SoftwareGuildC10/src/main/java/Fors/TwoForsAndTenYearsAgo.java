/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fors;

import java.util.Scanner;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class TwoForsAndTenYearsAgo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("What year would you like to count back from?");
        int year = sc.nextInt();

        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " years ago would be " + (year - i));

        }

        System.out.println("I can count backwards using a diff way too.");

        for (int i = year; i >= year - 20; i--) {
            System.out.println((year - i) + " years ago would be " + i);
        }
    }
}
/*
The ranges for starting on the first loop was 0 and ending at less than 10
The ranges for starting on teh second loop was the userinput of year and ended at userinput -10.
The first one is clearer to me because the initializing is easier to read and less codes.



*/

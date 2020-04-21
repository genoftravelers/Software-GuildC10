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
public class ForTimesFor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int counter = 0;
        System.out.println("please enter a number for times table.");
        // int input = sc.nextInt();
        int input = Integer.parseInt(sc.nextLine());
        //boolean isTrue = true;

        for (int i = 0; i < 15; i++) {
            int Result = (i + 1) * input;
            //   boolean isCorrect;

            System.out.println((i + 1) + " * " + input + " is: ");

            int userResult = sc.nextInt();

            if (userResult == Result) {
                System.out.println("correct");
                counter++;
            } else if (userResult != Result) {
                System.out.println("sorry no, the answer is :" + Result);
            }

        }
        System.out.println("you got " + counter + " correct!");
    }
}

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
public class ForTimes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("please enter a number for times table.");
        // int input = sc.nextInt();
        int input = Integer.parseInt(sc.nextLine());
        // System.out.println(input);

        for (int i = 0; i < 15; i++) {
            System.out.println((i + 1) + " * " + input + " is:" + ((i + 1) * input));
        }
    }
}

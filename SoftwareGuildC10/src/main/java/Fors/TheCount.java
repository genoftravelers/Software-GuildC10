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
public class TheCount {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int counter = 0;

        System.out.println("I LOVE TO COUNT! LET ME SHARE MY COUNTING WITH YOU!");

        System.out.println("start at ");
        int startAt = sc.nextInt();
        System.out.println("end at ");
        int endAt = sc.nextInt();
        System.out.println("count by ");
        int countBy = sc.nextInt();

        for (int i = startAt; i < endAt; i += countBy) {
            System.out.println(i + " ");
            counter++;

            if (counter % 3 == 0) {
                System.out.println("ah ah ah");
            }
        }
    }
}

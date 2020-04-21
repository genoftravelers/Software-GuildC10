/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fors;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class SpringForwardFallBack {

    public static void main(String[] args) {

        System.out.println("It's Spring");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + ", ");
        }

        System.out.println("\nOh no, its fall..");
        for (int i = 10; i > 0; i--) {
            System.out.println(i + ", ");
        }
    }
}
// For the first loop, it start with 0 and stops at less than 10 (9).
//For the second loop, it starts with   10 and ends with more than zero(1).
//We can change the range by changing zero to 1 and adding the <= sign for 10 or < 11.

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
public class TraditionalFizzBuzz {
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How many units of fizzing and buzzing do you need in your life?");
        int userInput = sc.nextInt();
       // int counter = 0;
        
        
        for(int i = 0; i < userInput; i++) {
            if(i % 3 == 0) {
                System.out.println("fizz");
            } else if (i % 5 == 0) {
                System.out.println("buzz");
            } else if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("fizz buzz");
            } else {
                System.out.println(i);
        }
    }   
        System.out.println("TRADITION!!!");
}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PP6WhilesAndDos;

import java.util.Scanner;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class StayPositive {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("What number should I count down from? ");
        
        int userInput = Integer.parseInt(sc.nextLine());
        
        if(userInput > 0){
           System.out.println("It is a positive integer.");
            System.out.println("Here goes!");
       } else if (userInput < 0 ) {
           System.out.println(" Sorry, I dont do negative integers");
       }
       
       // int startNum = 10;
        int finishNum = 1;
        
                
        while (userInput >= finishNum) {
            userInput--;
            System.out.println(userInput);
        }
       
    }
}

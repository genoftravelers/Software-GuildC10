/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessingGame;

import java.util.Scanner;

/**
 *
 * @author yooramachi
 */
public class GuessingGame {
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);
        boolean guessing = true;
        int numOfAttempts = 0;
        int numOfGuesses = (int) (Math.random() * 99 + 1);
        
        System.out.println("Guessimg a num btw 1 to 100.");
        System.out.println("What is your guess?");
        
        while (guessing) {
        numOfAttempts++;
        int userInput = SC.nextInt();
        
        if(userInput > numOfGuesses) {
            System.out.println("too high");
        } else if (userInput < numOfGuesses) {
            System.out.println("too low");
        } else {
                System.out.println("good job you got it! ");
                }
    }
        System.out.println("You tried : "+ numOfAttempts);
    }
}

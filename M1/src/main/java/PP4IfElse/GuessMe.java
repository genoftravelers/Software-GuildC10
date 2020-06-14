/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PP4IfElse;

import java.util.Scanner;

/**
 *
 * @author yooramachi
 */
public class GuessMe {
    public static void main(String[] args) {
        
        int myChoice = 5;
        int userChoice;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("I have a number. Bet you cannot guess it!");
        userChoice = Integer.parseInt(sc.nextLine());
        System.out.println("your guess: " + userChoice);
        
        if(userChoice < myChoice) {
        System.out.println( userChoice + " ? nice try - too low ! I chose " + myChoice);
        }
        
        if(userChoice == myChoice) {
            System.out.println("wow, good job, you guessed it right.");
        }
        
        if(userChoice > myChoice) {
            System.out.println("Too High, I chose " + myChoice);
        }
    }
}

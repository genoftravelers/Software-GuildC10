/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PP6WhilesAndDos;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class GuessMeFinally {
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);
      Random randomizer = new Random();
        
        int chosenNum = randomizer.nextInt(201) -100;
        int numGuess = 0;
     
        System.out.println("I've chosen a number between -100 and 100. Bet you can't guess it!");
        int userChoice = SC.nextInt();
        System.out.println("your guess: " + userChoice);
        
        
        while(chosenNum != userChoice){
           // System.out.println("I chose" + chosenNum);
           
        if(userChoice < chosenNum) {
         
        System.out.println( userChoice + " ? nice try - too low ! I chose " + chosenNum);
        
        
        } else if (userChoice > chosenNum) {
            System.out.println("Too High, I chose " + chosenNum);
            
          
        } else if (userChoice == chosenNum && numGuess == 0) {
            System.out.println("wow, good job, you guessed it right on first try.");
           
        break;
        
        } else{
            System.out.println(userChoice + "is correct.");
        break;
        }
        numGuess++;
    }
}
}

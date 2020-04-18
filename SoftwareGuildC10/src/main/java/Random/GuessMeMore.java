/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Random;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class GuessMeMore {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Random randomizer = new Random();
        
        int chosenNum = randomizer.nextInt(201) -100;
        int userChoice = randomizer.nextInt();
        
        System.out.println("I've chosen a number between -100 and 100. Bet you can't guess it!");
        userChoice = Integer.parseInt(sc.nextLine());
        System.out.println("your guess: " + userChoice);
        
        if(userChoice < chosenNum) {
            System.out.println("try again.");
            userChoice = Integer.parseInt(sc.nextLine());
        System.out.println( userChoice + " ? nice try - too low ! I chose " + chosenNum);
        }
        
        if(userChoice == chosenNum) {
            System.out.println("wow, good job, you guessed it right.");
        }
        
        if(userChoice > chosenNum) {
            System.out.println("try again.");
            userChoice = Integer.parseInt(sc.nextLine());
            System.out.println("Too High, I chose " + chosenNum);
        }
    }
}

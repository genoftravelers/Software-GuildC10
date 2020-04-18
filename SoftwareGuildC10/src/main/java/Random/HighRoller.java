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
public class HighRoller {
    public static void main(String[] args) {
        Random diceRoller = new Random();
        Scanner sc = new Scanner(System.in);
        
        int rollResult = diceRoller.nextInt(6)+1;
        
        System.out.println("How many number of sides a single die has?");
        int userInput = Integer.parseInt(sc.nextLine());
        
        System.out.println("Roll the die to generate number between 1 - "+ userInput);
        
        System.out.println("Time to Roooollllll the dice!");
        System.out.println("you rolled a " + rollResult );
        
        if(rollResult == 1){
            System.out.println("you rolled a critical failure!, Ouch.");
        }
        if (rollResult == userInput){
            System.out.println("you rolled a critical! Nice job!");
        } else{
            System.out.println("Come on you can do better.... LOL");
        }
        
    }
}

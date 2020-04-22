/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PP5Random;

import java.util.Random;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class Opinionator {
    public static void main(String[] args) {
        Random randomizer = new Random();
        System.out.println("I cannot decided what animal I like the best.");
        System.out.println("I know, Random can decide for me.");
        
        int x = randomizer.nextInt(5);
        System.out.println("The number we chose was: " + x);
        
        switch(x) {
            case 0:
                System.out.println("Llamas are the best!");
                break;
             
            case 1:
                System.out.println("Dodos are the best.");
                break;
                
            case 2:
                System.out.println("mammonths are the best");
                break;
                
            case 3:
                System.out.println("Sharks are the best");
                break;
                
            case 4:
                System.out.println("Cockatoos are just so good");
                break;
                
            case 5: 
                System.out.println("Have you ever met a naked mole rat?");
                break;
        }
        System.out.println("Thanks Random, maybe you're the best.");
    }
}
// Q. Find bug.
// A. My program doesn't show any bug.
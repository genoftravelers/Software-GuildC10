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
public class RollerCoaster {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("We're going to go on a roller coaster...");
        System.out.println("Let me know when you want to get off...!");
        
        //String keepRiding = "y";
        int loopLooped = 0;
        String keepRiding ="n";
        
        
        while(keepRiding.equals("n")){
            System.out.println("I dont want to go in it.");
        }
        System.out.println("keep going");
        loopLooped ++;
//        while(keepRiding.equals("y")){
//            
//        System.out.println("Whee!!");
//        System.out.println("Want to keep going? (y/n)");
//        keepRiding = userInput.nextLine();
//        loopLooped++;
//        }
//        
//        System.out.println("wow, that was fun.");
//        System.out.println("we looped that loop" + loopLooped + " times!!");
        
        
    }
}
// When the user enters another letter, it takes out of the loop.
// When I added a new condition with no, it got into an infinite loop as below.
/* 
I dont want to go in it.
I dont want to go in it.
I dont want to go in it.
I dont want to go in it.
I dont want to go in it.
I dont want to go in it.
I dont want to go in it.
I dont want to go in it.


*/
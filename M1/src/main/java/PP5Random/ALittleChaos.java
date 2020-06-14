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
public class ALittleChaos {
    public static void main(String[] args) {
        
        Random randomizer = new Random();
        
        System.out.println("Random can make integers: " + randomizer.nextInt());
        System.out.println("Or a double: " + randomizer.nextDouble());
        System.out.println("Or a boolean: " + randomizer.nextBoolean());
        
        int num = randomizer.nextInt(100);
        
        System.out.println("You can store a randomized result: " + num);
        System.out.println("And use it over and over again: "+ num + "," + num);
        System.out.println("Or just keep generating new values");
        System.out.println("Here's a bunch of numbes from given parameters: ");
        
        System.out.print(randomizer.nextInt(10) + ",");
        System.out.print(randomizer.nextInt(20) + ",");
        System.out.print(randomizer.nextInt(30)+ 1 + ",");
        System.out.print(randomizer.nextInt(100) + ",") ;
        System.out.print(randomizer.nextInt(51) + 50 + ".");
    }
}
// Q. What happens if you change randomizer.Next(101) to randomizer.Next(51) + 50?
// It gives a number between 0 - 100. 51-1 = 50 plus 50 = 100.

//Q. Can you include random numbers in a math statement?
//yes.

//Q.Experiment with different number types to see what the outcomes look like.
// Here's a bunch of numbes from given parameters: 
//5,3,30,69,79.
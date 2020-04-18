/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhilesAndDos;

import java.util.Random;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class LazyTeenager {
    public static void main(String[] args) {
        
        Random randomizer = new Random();
       
        String parentTells = "Clean your room!";
        Double increaseChance = randomizer.nextDouble();
        int numofTimes = 1;
        Boolean roomIsClean = false;
        
        
        do {
           System.out.println(parentTells);
           increaseChance += 0.10;
           
           if(numofTimes <= increaseChance) {
               System.out.println("Finally cleans his room.");
               break;
           }
           
           numofTimes ++;
           
           if(numofTimes > 7) {
               System.out.println("You are going to get grounded and have their Xbox confiscated.");
               break;
           }
                   
        } while (roomIsClean != true);
     
    }
}

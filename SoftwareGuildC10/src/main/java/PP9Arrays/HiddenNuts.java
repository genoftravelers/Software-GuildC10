/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PP9Arrays;

import java.util.Random;

/**
 * iterate through the hiding spaces
 * find out where the squirrel put his nut
 * print it to the screen
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class HiddenNuts {
    public static void main(String[] args) {


        String[] hidingSpots = new String[100];
        Random squirrel = new Random();
        hidingSpots[squirrel.nextInt(hidingSpots.length)] = "Nut";
        System.out.println("The nut has been hidden ...");
        
       
        
        //Nut finding code should go here.
        
        for(int i = 0; i < hidingSpots.length; i++) {
            
            if(hidingSpots[i].equals("Nut")) {
                System.out.println("found it! It's on spot # "+ i);
                break;
            }
        }
        
    }
}

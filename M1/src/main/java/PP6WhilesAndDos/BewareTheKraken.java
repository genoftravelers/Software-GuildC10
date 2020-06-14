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
public class BewareTheKraken {
    public static void main(String[] args) {
        System.out.println("Already, get those flippers and wetsuit on - we're going diving");
        System.out.println("here we go..");
        
        Scanner sc = new Scanner(System.in);
        Random randomizer = new Random();
        
        int depthDivedInFt = 0;
        
        while(depthDivedInFt < 36200) {
            System.out.println("we have swum" + depthDivedInFt + "feet.");
            int seaAnimals = randomizer.nextInt(3);
            
            switch(seaAnimals) {
                case 1:
                    System.out.println("Is that an Octopus?");
                    break;
                case 2:
                    System.out.println("Is that a starFish?");
                    break;
                case 3:
                    System.out.println("Is that a SeaHorse?? ");
                    break;
            }
            System.out.println("do you want to stop? y/n ?");
            String answer = sc.nextLine();
            if(answer.equals("y")) {
                break;
            }
            
            if(depthDivedInFt >= 2000){
                System.out.println("I think I can see Kraken,, guys..");
                System.out.println("Time to leave!");
                break;
            }
            depthDivedInFt ++;
        }
        System.out.println("");
        System.out.println("We ended up swimming" + depthDivedInFt + "feet.");
        System.out.println("I know we can do better next time.");
    }
}
// Answe : Only the conditions for that true statment will show.
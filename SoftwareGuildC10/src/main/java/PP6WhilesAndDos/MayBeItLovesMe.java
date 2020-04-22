/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PP6WhilesAndDos;

import java.util.Random;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class MayBeItLovesMe {
    public static void main(String[] args) {
        String lovesMe = "Loves Me";
        String lovesMeNot = "Loves Me Not!";
        
        Random randomizer = new Random();
        int petals = randomizer.nextInt(89-13)+13;
        
        System.out.println(petals);
        System.out.println("Here goes nothing..");
        
        //boolean ItLovesMe;
        do {
           if(petals % 2 == 0) {
            System.out.println(lovesMe);
            
            if(petals == 0){
                System.out.println("It really loves me.");
                break;
            }
            
           petals ++;
           } else{
               System.out.println(lovesMeNot);
               if(petals==0) {
                   System.out.println("bummer..");
                   break;
               }
               petals++;
           }
            
        }while(petals < 34);
        }
}

    


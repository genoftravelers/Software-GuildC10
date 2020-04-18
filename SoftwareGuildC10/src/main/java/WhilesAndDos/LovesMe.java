/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhilesAndDos;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class LovesMe {
    public static void main(String[] args) {
        String lovesMe = "Loves Me";
        String lovesMeNot = "Loves Me Not!";
        
        int petals = 0;
        
        System.out.println("Here goes nothing..");
        
        boolean ItLovesMe;
        do {
            
           if(petals % 2 == 0) {
            System.out.println(lovesMe);
            petals ++;
            
           } else {
            System.out.println(lovesMeNot);
            petals ++;
           } 
        }while(petals < 34);
    }  
}
// I chose Do while because while didnt run at all and we need a petal to be picked atleast one time to run this program.

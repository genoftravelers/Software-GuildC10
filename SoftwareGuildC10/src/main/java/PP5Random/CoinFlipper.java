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
public class CoinFlipper {
    public static void main(String[] args) {
        Random randomizer = new Random();
        double result = randomizer.nextDouble();
        
      //  boolean coinIsheads = result < 0.5;
        
        if(result > 0.5){
            System.out.println("You have got Tails.");
        }
        else if (result < 0.5) {
            System.out.println("you have got heads.");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fors;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class ForAndTwentyBlackbirds {

    
    public static void main(String[] args) {
        int birdsInPie = 0;
        for (int i = 1; i < 25; i++) {
            System.out.println("Blackbird #" + i + " goes into the pie!");
            birdsInPie++;
        }

        System.out.println("There are " + birdsInPie + " birds in there!");
        System.out.println("Quite the pie full!");
        
      
    }
}
// I changed i = 1 and i <25 because the program will start counting from 1 and 
//inorder to get 24 birds, I can either do i <= 25 or just < 25 to get to the number 24.

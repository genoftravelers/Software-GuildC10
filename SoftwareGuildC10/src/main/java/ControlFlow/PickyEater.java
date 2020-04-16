/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlFlow;

import java.util.Scanner;

/**
 *
 * @author yooramachi
 */
public class PickyEater {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("How many times has it been fried?");
        int timesFried = Integer.parseInt(userInput.nextLine());
        
        System.out.println("Does i thave any spinach in it?");
        String hasSpinach = userInput.nextLine();
        
        System.out.println("Is it ocvered in cheese?");
        String cheeseCovered = userInput.nextLine();
        
        System.out.println("How many pats of butter are on top?");
        int butterPats = Integer.parseInt(userInput.nextLine());
        
        System.out.println("Is it covered in chocolate?");
        String chocolatedCovered = userInput.nextLine();
        
        System.out.println("Does it have a funny name?");
        String funnyName = userInput.nextLine();
        
        System.out.println("Is it broccoli>");
        String isBroccoli = userInput.nextLine();
        
        if (hasSpinach.equals("y") || funnyName.equals("y")) {
            System.out.println("There's no way he'll eat that!");
            
        } else if(timesFried == 3 && chocolatedCovered.equals("y")) {
            System.out.println("Oh, it's like a deep-fried Snickers. That'll be a hit");
        } else if (timesFried == 2 && cheeseCovered.equals("y")){
            System.out.println("Mmm. Yeah, he'll each fried cheesy doodles.");
        } else if(isBroccoli.equals("y")){
            System.out.println("Oh, green stuff like that might as well go in the bin.");
        }
               
    }
}

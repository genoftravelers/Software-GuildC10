/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PracticeProgramThird;

import java.util.Scanner;

/**
 *
 * @author yooramachi
 */
public class DoItBetter {
    public static void main(String[] args) {
        int milesRun;
        int numOfHotDogs;
        int numOfLangs;
        
        Scanner SC = new Scanner(System.in);
        
        System.out.println("Hello there, how many miles can you run?");
        milesRun = Integer.parseInt(SC.nextLine());
        System.out.println("thats it? I can run " + ((milesRun * 2) + 1) + " miles haha!");
        System.out.println("How many hotdogs can you eat? ");
        numOfHotDogs = Integer.parseInt(SC.nextLine());
        System.out.println("thats it? I can eat "+ ((numOfHotDogs*2)+1) + " Hot Dogs.");
        System.out.println("how many languages can you speak?");
        numOfLangs = Integer.parseInt(SC.nextLine());
        System.out.println("too bad I can speak "+ ((numOfLangs *2)+1) +" languages");
    }
}

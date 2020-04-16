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
public class YourLifeInMovies {
    public static void main(String[] args) {
        String name;
        int yearBorn;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Hey Let's play a game! Whats your name?");
        name = sc.nextLine();
        
        
         
        System.out.println("ok, "+ name + ", when were you born?");
        yearBorn = Integer.parseInt(sc.nextLine());
        
        if(yearBorn < 2005) {
            System.out.println("Pixar's 'Up' came out over a decade ago.");
        }
        if(yearBorn < 1995) {
            System.out.println("the first Harry Potter came out over 15 years ago.");
        }
        if(yearBorn < 1985) {
            System.out.println("Space Jam came out not last decade, but the one before THAT.");
        }
        if (yearBorn < 1975) {
            System.out.println("the original Jurassic Park release is closer to the first lunar landing than it is to today.");
        }
        if(yearBorn < 1965) {
            System.out.println("the MASH TV series has been around for almost half a century!");
        }
        if(yearBorn == 1980) {
            System.out.println("well..." + name); 
            System.out.println("Did you know that Pixar's 'Up' came out over a decade ago?\n" +
"And that the first Harry Potter came out over 15 years ago!\n" +
"Also, Space Jam came out not last decade, but the one before THAT.");
        }
        
    }
}

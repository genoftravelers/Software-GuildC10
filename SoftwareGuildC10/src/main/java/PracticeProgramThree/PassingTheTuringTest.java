/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PracticeProgramThree;

import java.util.Scanner;

/**
 *
 * @author yooramachi
 */
public class PassingTheTuringTest {
    public static void main(String[] args) {
        
        
        System.out.println("Hello there!");
        Scanner sc = new Scanner(System.in);
        
       String name ;
       String favColor;
       String favAnimal;
       String favFruit;
       int favNum;
       
       System.out.println("What is your name?");
       name = sc.nextLine();
       
       System.out.println("What is your favourite color?");
       favColor = sc.nextLine();
       
       System.out.print("huh," + favColor + "? Mine's sky blue. ");
       
       System.out.println("I really like limes, They are my fav.");
       System.out.println("Whats your fav fruit? " + name);
       favFruit = sc.nextLine();
       
       System.out.println("really? "+ favFruit + "? that's wild");
        
       System.out.println("Speaking of favourites, Whats your fav num?");
       favNum = Integer.parseInt(sc.nextLine());
       
       System.out.println(favNum + " is a cool number, Mine is 10,");
       name = sc.nextLine();
       
       System.out.println("Did you know "  +favNum + " * 10 is " + (favNum * 10) + "? That's a cool number too!"); 
       
       System.out.println("Well, thanks for talking to me, "+ name);
        
       
        
        
        
    }
}

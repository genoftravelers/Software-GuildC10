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
public class MiniZork {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("You are standing in an open field west of a white house, in North Korea.");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.print("Go to the house, open the mailbox, or go to the back of the house? ");

        String action = userInput.nextLine();

        if (action.equals("open the mailbox")) {
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.print("Look inside or stick your hand in? ");
            action = userInput.nextLine();

            if (action.equals("look inside")) {
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.print("Run away or keep looking? ");
                action = userInput.nextLine();

                if (action.equals("keep looking")) {
                    System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                    System.out.println("You've been eaten by a grue.");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you alive. Possibly a wise choice.");
                }
            } else if (action.equals("stick your hand in")) { }
        } else if (action.equals("go to the house")) { }
        
        if(action.equals("go to the back of the house")) {
            System.out.println("you walk slowly");
            System.out.println("you are scared because it is getting dark");
            System.out.println("you see something moving.");
            System.out.println("go closer, go to the house?");
            action = userInput.nextLine();
            
            if(action.equals("go to the house")) {
                System.out.println("you walk back to the house");
                System.out.println("you see the mailbox.");
                System.out.println("you open the mailbox or go to the house");
                action = userInput.nextLine();
                
            } else if(action.equals("go closer")) {
                System.out.println("you heart is pounding.");
                System.out.println("There is a creature behind a tree.");
                System.out.println("Grab your pistol or go to the house"); 
                action = userInput.nextLine();
                
                if(action.equals("grab your pistol")) {
                    System.out.println("you kill the creature, it was just a rat.");
                    System.out.println("you go to the house or open the mail box?");
                    action = userInput.nextLine();
                    if(action.equals("you go to the house")){
                        System.out.println("you are in front of the house again");
                    }
                }else if (action.equals("open the mail box")) {
                    System.out.println("You open the mailbox.");
                    System.out.println("It's really dark in there.");
                    System.out.println("your hand is cut in half.");
                }
            }  
            
        }
    }
}

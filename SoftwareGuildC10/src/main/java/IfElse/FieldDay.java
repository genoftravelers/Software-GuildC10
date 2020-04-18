/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfElse;

import java.util.Scanner;

/**
 *
 * @author yooramachi
 */
public class FieldDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
       // String lastName;
        
        System.out.println("What's your last name?");
        String lastName = sc.next();
        
        if(lastName.compareTo("Baggins")< 0){
            System.out.println("you are on team red.");
        } else if(lastName.compareTo("Baggins") > 0 && lastName.compareTo("Dresden") < 0){
            System.out.println("you are on team Dark Wizaed.");
            System.out.println("Good Luck in your games!");
        } else if (lastName.compareTo("Dresden")> 0 && lastName.compareTo("Howl") < 0) {
            System.out.println("You are on Team Moving Castles.");
            System.out.println("Good Luck in your games!");
        } else if(lastName.compareTo("Howl") > 0 && lastName.compareTo("Potter")<0) {
            System.out.println("Go to Golden Snitches");
            System.out.println("Good Luck in your games!");
        } else if (lastName.compareTo("Potter") >0 && lastName.compareTo("Vimes") < 0) {
            System.out.println("Go to team Night Guards");
            System.out.println("Good Luck in your games!");
        } else if (lastName.compareTo("Vimes") > 0) {
            System.out.println("Aha! you are on team 'Black Holes' !");
            System.out.println("Good Luck in your games!");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PP4IfElse;

import java.util.Scanner;

/**
 *
 * @author yooramachi
 */
public class KnockKnock {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Knock knock, guess who?");
        String nameGuess = inputReader.nextLine();
        
        if(nameGuess.equals("Karma Dolkar")) {
            System.out.println("Hey, THats right, I am back.");
            System.out.println("....from the future");
            }
            else{
            System.out.println("Dude, do i look like " + nameGuess);
                }
        
    }
}
// Q. What happens if you change .equals() to == ?
//yellow pop out says illegal start of expression.
//Q. What happens if you don't type it in the right capitalization? How might you fix that?
// The input doesnot recognize the name, we can fix that by writing the exact name. very case sensitive.
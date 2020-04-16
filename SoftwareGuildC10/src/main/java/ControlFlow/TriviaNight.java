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
public class TriviaNight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        int userInput;
     
        System.out.println("It's TRIVIA NIGHT! Are you ready?");
        System.out.println("FIRST QUESTION");
        
        System.out.println("What is the lowest level of programming language?");
        System.out.println("1) Source Code		2) Assembly Language\n" +
"3) C#				4) Machine Code");
        userInput = Integer.parseInt(sc.nextLine());
        System.out.println("YOUR ANSWER: " + userInput);
        
        if(userInput == 2) {
          System.out.println("Correct");
          counter++;
        
        } else {
            System.out.println("incorrect");
        }
        
        
        System.out.println("SECOND QUESTION");
        System.out.println("Website Security CAPTCHA Forms Are Descended From the Work of?");
        System.out.println("1) Grace Hopper		2) Alan Turing\n" +
"3) Charles Babbage		4) Larry Page");
        userInput = Integer.parseInt(sc.nextLine());
        System.out.println("YOUR ANSWER: " + userInput);
        if(userInput == 3) {
            System.out.println("correct");
            counter++;
        } else{
            System.out.println("incorrect");
        }
        
        System.out.println("LAST QUESTION!");
        System.out.println("Which of These Sci-Fi Ships Was Once Slated for a Full-Size Replica in Las Vegas?");
        System.out.println("1) Serenity			2) The Battlestar Galactica\n" +
"3) The USS Enterprise	4) The Millennium Falcon");
        userInput = Integer.parseInt(sc.nextLine());
        System.out.println("YOUR ANSWER: " + userInput);
        if(userInput == 3) {
            System.out.println("correct");
            counter++;
        } else{
            System.out.println("incorrect");
        }
        System.out.println(counter);
        System.out.println("Nice job - you got " + counter + " correct!");
        
    }
    }
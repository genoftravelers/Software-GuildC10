/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PP3Scanner;
import java.util.Scanner;
/**
 *
 * @author yooramachi
 */
public class QuestForTheUserInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String yourName;
        String yourQuest;
        double velocityOfSwallow;
        
        System.out.print("What is your name?");
        yourName = sc.nextLine();
        
        System.out.print("What is your quest?");
        yourQuest = sc.nextLine();
        
        
        System.out.print("What is the airspeed velocity of an unlade swallow?");
        velocityOfSwallow = Double.parseDouble(sc.nextLine());
        
        System.out.println();
        System.out.println("How do you know " + velocityOfSwallow + " is correct, " + yourName + "?");
        System.out.println("your didnt even know if the swallow as Asian or Blasian!");
        System.out.println("Maybe skip answering thins about birds and go. " + yourQuest + ".");
        
    }
}

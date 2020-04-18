/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfElse;

/**
 *
 * @author yooramachi
 */
public class SpaceRustlers {
    public static void main(String[] args) {
        int spaceships = 10;
        int aliens = 25;
        int cows = 1000;
        
        if(aliens > spaceships) {
            System.out.println("Let's get going!");
        } else {
            System.out.println("There are not enough aliends to drive the spaceships");
        }
        
        if(cows == spaceships) {
            System.out.println("wow, way to plan ahead, just enough room for all walking burgers.");
        } else if(cows > spaceships) {
            System.out.println("damn, dont know how we will fit these cows here");
         // System.out.println("Oh no! The herds got restless and took over! Looks like _we're_ hamburger now!!");
        } else {
            System.out.println("Too many ships, not enough cows.");
        }
        if(aliens > cows) {
            System.out.println("Hurrah, we've got the grub! Hamburger party on Alpha Centauri!");
        } else {
            System.out.println("Oh no! The herds got restless and took over! Looks like we're hamburger now!!");
        }
    }
}
//Q. What does the else if and if do?
// if statement is evaluated independenlty of eachother. Any statement get an outcome.
// else if is considered only we want the program to perform one action if the condition statemnet is true and competely diff action if its false.

//Q. If you remove the else from the else if, what does THAT do?
// it becomes a multiple if statement.


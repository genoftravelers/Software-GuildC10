/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PracticeProgramThird;

import java.util.*;

/**
 *
 * @author yooramachi
 */
public class BiggerBetterAdder {
    public static void main(String[] args) {
        
        
        Scanner SC = new Scanner(System.in);
        
        System.out.println("Give me the first number.");
        int num1 = Integer.parseInt(SC.nextLine());
       
        System.out.println("Give me the second number.");
        int num2 = Integer.parseInt(SC.nextLine());

        System.out.println("Give me your third number.");
        int num3 = Integer.parseInt(SC.nextLine());
        
        int newNum = num1 + num2 + num3;
        System.out.println("Result: " + newNum);
    }
}

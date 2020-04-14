/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adder;

import java.util.Scanner;

/**
 *
 * @author yooramachi
 */
public class Adder {
    public static void main(String[] args) {
        int sum = 0;
        int operant1 = 0;
        int operant2 = 0;
        
        Scanner sc = new Scanner(System.in);
        
        String stringOperant1 = "";
        String stringOperant2 = "";
        
        System.out.println("please enter first num to be added");
        stringOperant1 = sc.nextLine();
        
        System.out.println("please enter the secomd num to be added");
        stringOperant2 = sc.nextLine();
        
        operant1 = Integer.parseInt(stringOperant1);
        operant2 = Integer.parseInt(stringOperant2);
        
        sum = operant1 + operant2;
        
        System.out.println("sum is : " + sum);
    }

}



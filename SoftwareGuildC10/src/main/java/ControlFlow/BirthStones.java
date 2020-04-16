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
public class BirthStones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int birthMonth;
        
        System.out.println("What month's birthstone do you want to know?");
        birthMonth = Integer.parseInt(sc.nextLine());
        //int negativeNum = Integer.parseInt(sc.nextLine());
        
        if (birthMonth < 0) {
            System.out.println("you are confused,  negative numbers do not match a month ");
        }
        else if(birthMonth == 1) {
            String num1 = "January";
            System.out.println(num1 +" 's birth strone is Garnet.");
        } else if(birthMonth == 2) {
            String num2 = "February";
            System.out.println(num2 +" 's birth strone is Amethyst.");
        } else if(birthMonth == 3) {
            String num3 = "March";
            System.out.println(num3 +" 's birth strone is Aquamarine.");
        } else if(birthMonth == 4) {
            String num4 = "April";
            System.out.println(num4 +" 's birth strone is Diamond.");
        } else if(birthMonth == 5) {
            String num5 = "May";
            System.out.println(num5 +" 's birth strone is Emerald.");
        } else if(birthMonth == 6) {
            String num6 = "June";
            System.out.println(num6 +" 's birth strone is Pearl.");
        } else if(birthMonth == 7) {
            String num7 = "July";
            System.out.println(num7 +" 's birth strone is Ruby.");
        } else if(birthMonth == 8) {
            String num8 = "August";
            System.out.println(num8 +" 's birth strone is Peridot.");
        } else if(birthMonth == 9) {
            String num9 = "September";
            System.out.println(num9 +" 's birth strone is Sapphire.");
        } else if(birthMonth == 10) {
            String num10 = "October";
            System.out.println(num10 +" 's birth strone is Opal.");
        } else if(birthMonth == 11) {
            String num11 = "November";
            System.out.println(num11 +" 's birth strone is Topaz.");
        } else if (birthMonth == 12) {
            String num12 = "December";
            System.out.println(num12 +" 's birth strone is Turquoise.");
        } 
    }
}

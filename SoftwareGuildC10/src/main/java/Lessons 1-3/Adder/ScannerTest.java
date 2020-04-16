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
public class ScannerTest {
    public static void main(String[] args) {
        String name;
        int age;
        int numComputers;
        String hometown;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("what is ur name?");
        name = sc.nextLine();
        System.out.println("what is your age?");
        age = sc.nextInt();
        System.out.println("num of computer");
        numComputers = sc.nextInt();
        sc.nextLine();
        System.out.println("enter your home town");
        hometown = sc.nextLine();
        
        
        
        System.out.println("you said:");
        System.out.println("Name: " + name);
        System.out.println("Age: "+ age);
        System.out.println("num Computer: " + numComputers);
        System.out.println("hometown: " + hometown);
    }
}

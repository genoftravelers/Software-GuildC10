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
public class AdderWhile {
    public static void main(String[] args) {
        while (true){
            System.out.println("Enter some data: ");
            Scanner myScanner = new Scanner(System.in);
            String input = myScanner.readLine();
            
            if(input != null && !input.isEmpty()) {
                System.out.println("you did not enter anything!");
            }
            else {
                break;
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classwork;

import java.util.Scanner;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */


/*
exercise:  (SumOfDigits)
1. prompt user to enter a positive integer.
    2. store input as int
    3. declare/initialize var to 0.
    4. Start loop (as long as data entered is greater than zero)
        var = var + (user input % 10)
        user input = user input / 10
    5. end loop
    6. print user input
    7. print sum 
*/
public class SumOfDigits {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        //1. prompt user to enter a positive integer.
        System.out.println("Enter a postive Number");
        
        //  2. store input as int
        int userInput = sc.nextInt();
       
        System.out.println("you entered: " + userInput);
        
        //3. declare/initialize var to 0.
        int sum = 0; 
        
        
        //4. Start loop (as long as data entered is greater than zero)
        

        while (userInput > 0) {
            
           sum = sum + (userInput % 10); //var = var + (user input % 10)
           userInput = userInput / 10; //user input = user input / 10
            
            }// 5. end loop

            System.out.println("sum of the digits is :" + sum );//  7. print sum 
            
           if(userInput < 0) {
            System.out.println("bye bye");
           // System.exit(0); // terminating 
           // break;
        
        }
        } 
    }


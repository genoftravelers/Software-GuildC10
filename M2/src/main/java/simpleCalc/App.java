/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleCalc;

import java.util.Scanner;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */

public class App {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);
        SimpleCalc mySimplecalc = new SimpleCalc();
        boolean calculate = true;
        while (calculate) {
            System.out.println("Would you like to add, subtract, multiply, divide or quit the program?");
            String userAnswers = scString.nextLine();
            switch (userAnswers) {
                case "add":
                    //Add
                    System.out.println("\nPlease enter first number to add.");
                    int userInput = sc.nextInt();
                    System.out.println("Please enter the second number to add.");
                    int userInput2 = sc.nextInt();
                    int sum = mySimplecalc.add(userInput, userInput2);
                    System.out.println("The sum of " + userInput + " and " + userInput2 + " is " + sum + ".");
                    break;
                case "subtract":
                    //Subtract
                    System.out.println("\nPlease enter first number to subtract.");
                    int userInput3 = sc.nextInt();
                    System.out.println("Please enter the second number to subtract.");
                    int userInput4 = sc.nextInt();
                    int sub = mySimplecalc.subtract(userInput3, userInput4);
                    System.out.println("The difference of " + userInput3 + " and " + userInput4 + " is " + sub + ".");
                    break;
                case "multiply":
                    //Multiply
                    System.out.println("\nPlease enter first number to multiply.");
                    int userInput5 = sc.nextInt();
                    System.out.println("Please enter the second number to multiply.");
                    int userInput6 = sc.nextInt();
                    int mul = mySimplecalc.multiply(userInput5, userInput6);
                    System.out.println("The multiplication of " + userInput5 + " and " + userInput6 + " is " + mul + ".");
                    break;
                case "divide":
                    //Division
                    System.out.println("\nPlease enter first number to divide.");
                    int userInput7 = sc.nextInt();
                    System.out.println("Please enter the second number to divide.");
                    int userInput8 = sc.nextInt();
                    int div = mySimplecalc.divide(userInput7, userInput8);
                    System.out.println("The division of " + userInput7 + " and " + userInput8 + " is " + div + ".");
                    break;
                default:
                    System.out.println("\nThank You, come back again.");
                    System.exit(0);
            }
        }
    }
}



//public class App {
//
//    public static void main(String[] args) {
//       
//        Scanner sc = null;
//        SimpleCalc mySimplecalc = new SimpleCalc();
//        boolean calculate = true;
//
//        while (calculate) {
//            sc = new Scanner(System.in);
//            System.out.println("Would you like to add, subtract, multiply, divide or quit the program?");
//            String userAnswers = sc.nextLine();
//            if (userAnswers.equals("add")) {
//                //Add
//                System.out.println("\nPlease enter first number to add.");
//                int userInput = sc.nextInt();
//                System.out.println("Please enter the second number to add.");
//                int userInput2 = sc.nextInt();
//                int sum = mySimplecalc.add(userInput, userInput2);
//                System.out.println("The sum of " + userInput + " and " + userInput2 + " is " + sum + ".");
//            }
//            if (userAnswers.equals("subtract")) {
//                //Subtract
//                System.out.println("\nPlease enter first number to subtract.");
//                int userInput3 = sc.nextInt();
//                System.out.println("Please enter the second number to subtract.");
//                int userInput4 = sc.nextInt();
//                int sub = mySimplecalc.subtract(userInput3, userInput4);
//                System.out.println("The difference of " + userInput3 + " and " + userInput4 + " is " + sub + ".");
//            }
//            if (userAnswers.equals("multiply")) {
//                //Multiply
//                System.out.println("\nPlease enter first number to multiply.");
//                int userInput5 = sc.nextInt();
//                System.out.println("Please enter the second number to multiply.");
//                int userInput6 = sc.nextInt();
//                int mul = mySimplecalc.multiply(userInput5, userInput6);
//                System.out.println("The multiplication of " + userInput5 + " and " + userInput6 + " is " + mul + ".");
//            }
//            if (userAnswers.equals("divide")) {
//                //Division
//                System.out.println("\nPlease enter first number to divide.");
//                int userInput7 = sc.nextInt();
//                System.out.println("Please enter the second number to divide.");
//                int userInput8 = sc.nextInt();
//                int div = mySimplecalc.divide(userInput7, userInput8);
//                System.out.println("The division of " + userInput7 + " and " + userInput8 + " is " + div + ".");
//            } else if (userAnswers.equals("quit")) {
//                System.out.println("\nThank You, come back again.");
//                System.exit(0);
//            }
//        }
//    }
//}


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class MathOperatorApp {

    public int calculate(MathOperator operator, int operand1, int operand2) {
        switch (operator) {
            case PLUS:
                return operand1 + operand2;
            case MINUS:
                return operand1 - operand2;
            case MULTIPLY:
                return operand1 * operand2;
            case DIVIDE:
                return operand1 / operand2;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How would you like to calculate?");
        System.out.println("\n Select from below.");
        System.out.println("Enter 1 for Addition");
        System.out.println("Enter 2 for Subtraction");
        System.out.println("Enter 3 for Multiplication");
        System.out.println("Enter 4 for Division");
        int selection = sc.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Enter operant 1:");
                int operant1 = sc.nextInt();
                System.out.println("Enter operant 2:");
                int operant2 = sc.nextInt();
                System.out.println(calculate(MathOperator.PLUS, operant1, operant2));
                ;
                break;
            case 2:
                System.out.println("Enter operant 1:");
                int operant3 = sc.nextInt();
                System.out.println("Enter operant 2:");
                int operant4 = sc.nextInt();
                System.out.println(calculate(MathOperator.MINUS, operant3, operant4));
                break;
            case 3:
                System.out.println("Enter operant 1:");
                int operant5 = sc.nextInt();
                System.out.println("Enter operant 2");
                int operant6 = sc.nextInt();
                System.out.println(calculate(MathOperator.MULTIPLY, operant5, operant6));
                break;
            case 4:
                System.out.println("Enter operant 1:");
                int operant7 = sc.nextInt();
                System.out.println("Enter operant 2:");
                int operant8 = sc.nextInt();
                System.out.println(calculate(MathOperator.DIVIDE, operant7, operant8));
                break;
            default:
                throw new UnsupportedOperationException();

        }

    }
}

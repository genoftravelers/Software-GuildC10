/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactorIntoObjects.Factorizer;

import java.util.Scanner;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the integer that you would like factored: ");
        int factor = input.nextInt();
        Factorizer f=new Factorizer(factor);

        System.out.println("Factors for " + factor + ":");

        f.factorCommand();
    }
}

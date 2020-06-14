/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PP3Scanner;

import java.util.Scanner;

/**
 *
 * @author yooramachi
 */
public class AllTheTrivia {
    public static void main(String[] args) {
        
        
        String Unit;
        String clockwisePlanet;
        String largestVolcano;
        String abundantElement;
        
        Scanner SC = new Scanner(System.in);
        
        System.out.println("What is the equivalent to 1,024 Gigabytes?");
        Unit = SC.nextLine();
        
        System.out.println("Which planet is the only one that rotates clockwise in our Solar System?");
        clockwisePlanet = SC.nextLine();
        
        System.out.println("The largest volcano ever discovered in our Solar System is located on which planet?");
        largestVolcano = SC.nextLine();
        
        System.out.println("What is the most abundant element in the earth's atmosphere?");
        abundantElement = SC.nextLine();
        
        System.out.println("Wow, 1,024 Gigabytes is a " + largestVolcano + " ! ");
        System.out.println("I didn't know that the largest ever volcano was discovered on " + Unit + " ! ");
        System.out.println("That's amazing that " + clockwisePlanet + " is the most abundant element in the atmosphere....");
        System.out.println( abundantElement + " is the only planet that rotaes clockwise, neat!");
        
    }
}

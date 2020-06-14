/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactorIntoObjects.luckySevens;

import java.util.Scanner;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Buy-In Amount: $");
        double playerBuyIn = input.nextDouble();
        LuckySevens player1 = new LuckySevens(playerBuyIn);

        System.out.println("Rolling...");

        while (player1.getMoney() > 0) {
            int roundRoll = player1.rollDice();
            player1.assessRoll(roundRoll);
            player1.trackPeak();
//            System.out.println("#" + player1.getRollCt() + " | " + roundRoll + " - $" + player1.getBank()); //debug
        }

        System.out.println("You went broke after " + player1.getCt() + " rolls...");
        System.out.println("Your highest earning was at roll " + player1.getPeakRoll() + ", you had $" + player1.getPeakPot());
    }
}

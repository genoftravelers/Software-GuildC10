/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PracticeProgramSecond;

/**
 *
 * @author yooramachi
 */
public class MenuOfChampions {
    public static void main(String[] args) {
        String WelcomeMessage = "WELCOME TO CAFE KARMA!";
        
        String food1 = "Momos";
        String food2 = "Laphing";
        String food3 = "Sukuti";
        
        double food1Price = 6.00;
        double food2Price = 7.00;
        double food3Price = 8.00;
        
        
        System.out.println(WelcomeMessage);
        System.out.println("Today's Menu is...");
        System.out.println("$" + food1Price + " *** " + food1);
        System.out.println("$" + food2Price + " ****** " +food2);
        System.out.println("$" + food3Price + " ***** " +food3);
    }
}

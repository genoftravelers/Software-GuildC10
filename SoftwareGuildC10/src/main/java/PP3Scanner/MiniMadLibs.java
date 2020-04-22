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
public class MiniMadLibs {
    public static void main(String[] args) {
        
        System.out.println("Let's Play MAD LIBS!");
        
        Scanner SC = new Scanner(System.in);
        
        System.out.println("I need a noun.");
        String noun = SC.nextLine();
        
        System.out.println("Now an adjective.");
        String adjective = SC.nextLine();
        
        System.out.println("Another noun");
        String anotherNoun = SC.nextLine();
       
        System.out.println("and a number");
        int num = Integer.parseInt(SC.nextLine());
        
        System.out.println("Another adjective");
        String anotherAdjective = SC.nextLine();
        
        System.out.println("A plural noun");
        String pluralNoun = SC.nextLine();
        
        System.out.println("another one");
        String anotherOne = SC.nextLine();
        
        System.out.println("one more");
        String oneMore = SC.nextLine();
        
        System.out.println("A verb");
        String aVerb = SC.nextLine();
        
        System.out.println("same verb(past participle)");
        String pastParticiple = SC.nextLine();
        
        System.out.println("*** NOW LETS GET MAD (libs) ***");
        System.out.println(noun + " : the " + adjective + " frontier. These are " +
        " the voyages of the starship " + anotherNoun + "." + " its " + num + 
        " -year mission: to explore strange " + anotherAdjective + pluralNoun + "," +
        " to seek out "+ adjective + anotherOne + " and "+ adjective  + ", to boldly " +
        aVerb + " where no one has " + pastParticiple + " before.");
        
        
    }
}

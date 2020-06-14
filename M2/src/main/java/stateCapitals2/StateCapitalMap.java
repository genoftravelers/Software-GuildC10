/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateCapitals2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class StateCapitalMap {

    public static void main(String[] args) throws IOException {
        Map<String, String> statesAndCapital = new HashMap<>();
        Scanner sc = new Scanner(new BufferedReader(new FileReader("MoreStateCapitals.txt")));

        while (sc.hasNextLine()) {// go through all the lines  until none
            String currentString = sc.nextLine();// read each current line
            String[] tokens = currentString.split("::");//split with delimiter
            statesAndCapital.put(tokens[0], tokens[1]);// add the current line into the HashMap.
        }

        Set<String> stateNum = statesAndCapital.keySet();// getting all the state names
        System.out.println("There are " + stateNum.size() + " states.");// getting the num of states.

        //
        System.out.println("The Capitals of each states are below : ");
        for (String state : stateNum) {
            System.out.println(state + "'s capital is " + statesAndCapital.get(state));
        }
        //____________________________GAME_________________
        
        
        Object[] stateN = statesAndCapital.keySet().toArray();
        Object[] capNames = statesAndCapital.values().toArray();
        Scanner scan = new Scanner(System.in);
        Random randomizer = new Random();
        int correct = 0;
        int incorrect = 0;
        
        System.out.println("\nTake a Quiz!");
        System.out.println("How many states do you want to test?");
        int userInput = Integer.parseInt(scan.nextLine());
        if(userInput < 0) {
            System.out.println("You need to put a postive integer.");
        }
        for(int i = 0; i < userInput; i++) {
            int randomS = randomizer.nextInt(50);
            
            System.out.println("What is the capital of "+stateN[randomS] + "?" );
            String reply = scan.nextLine();
            
            if(reply.equals(capNames[randomS])) {
                System.out.println("Thats Right!");
                correct ++;
            }else{
                System.out.println("Thats Wrong!");
                incorrect ++;
            }
        }
               System.out.println("\n Total correct : "+ correct + " & Total incorrect : " + incorrect);
    }
}

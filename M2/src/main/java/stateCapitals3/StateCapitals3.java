/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateCapitals3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class StateCapitals3 {

    public static void main(String[] args) throws Exception {// main page
        Map<String, Capital> stateCap = new HashMap<>();// add a HashMap to translate the data from .txt. taking in a string and an object called Capital.
        Scanner scRead = new Scanner(new BufferedReader(new FileReader("MoreStateCapitals2.txt")));// this will read the text file.
        while (scRead.hasNextLine()) {// whiel there is available next line, do the following.
            String currentLine = scRead.nextLine();// read each line till the next line.
            String[] token = currentLine.split("::");// add delimiter to each field in the array of strings.
            stateCap.put(token[0], new Capital(token[1], Integer.parseInt(token[2]), Double.parseDouble(token[3])));// add in the token index 0 and the rest of capital information to the stateCap as index 1 2 and 3..
        }
        Set<String> stateList = stateCap.keySet();// create a collection of set called statelist and get the keyset from the state cap.
        System.out.println("There are " + stateCap.size() + " states in the US.");// .size will get the amount of capitals.

        System.out.println("\n more information on Capital states.");
        for (String state : stateList) {// make a for loop to get a value for each key from the set called stateList.
            System.out.println(state + "'s capital is " + stateCap.get(state));
        }

        Scanner sc = new Scanner(System.in);// scanner to read the state's population.
        System.out.println("\nEnter a population limit to see the corresponding states. ");
        int popLim = sc.nextInt();//user input stored in popLim.

        for (String state : stateList) {// take the field from the statlist and do below
            Capital cap = stateCap.get(state);// get the capital.
            int staPop = cap.getPopulation();// add the populaiton to the capital.

            if (popLim < staPop) {//if userinput is less than state pop, do below
                System.out.println(state + "||" + stateCap.get(state));
            }

        }
        System.out.println("Enter area limit in sq miles to see the states corresponding states.");//ask user input for mileage
        double areaLim = sc.nextDouble();// user input stored in areaLim.

        for (String state : stateList) {//take the mileage from the statelist
            Capital cap = stateCap.get(state);// add the mileage to the cap
            double sArea = cap.getMileage();//add the mileage to the state area.

            if (areaLim < sArea) {// if arealimit is less than the state area,
                System.out.println(state + " | " + stateCap.get(state));//get field
            }
        }

    }

}

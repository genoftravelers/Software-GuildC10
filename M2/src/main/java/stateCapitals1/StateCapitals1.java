/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateCapitals1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class StateCapitals1 {
    public static void main(String[] args) {
        Map<String, String> stateNames = new HashMap<>();
        
        stateNames.put("Alabama", "Montgomery");
        stateNames.put("Alaska", "Juneau");
        stateNames.put("Arizona", "Phoenix");
        stateNames.put("Arkansas", "Little Rock");
        System.out.println("STATES");
        Set<String> keys = stateNames.keySet();
        
        for(String currentKey : keys) {
        String currentState = stateNames.get(currentKey);
            System.out.println(currentKey);
    }
        //System.out.println(stateNames.keySet());
        System.out.println("\nCAPITOLS");
        for(String currentKey : keys) {
        String currentState = stateNames.get(currentKey);
            System.out.println(currentState);
    }
        System.out.println("\nSTATE / CAPITAL PAIRS");
       for(String currentKey : keys) {
        String currentState = stateNames.get(currentKey);
            System.out.println(currentKey +" - "+ currentState );
    }
       // System.out.println(stateNames.values());
    }
}

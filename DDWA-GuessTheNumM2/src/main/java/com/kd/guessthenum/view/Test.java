/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kd.guessthenum.view;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class Test {
    
    public static void main(String[] args) {
        Random rm = new Random();
        
        Set<Integer> answer1 = new HashSet<>(); //generating random numbers of 4.
        
        while (answer1.size() < 4) {
            
            answer1.add(rm.nextInt(10));
        }
        String gNum = "";
        
        for (Integer integer : answer1) {
            gNum += integer;
        }
        System.out.println(gNum);
    }
    
}

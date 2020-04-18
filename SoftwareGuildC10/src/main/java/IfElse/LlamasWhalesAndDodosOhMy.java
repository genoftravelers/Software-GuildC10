/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfElse;

/**
 *
 * @author yooramachi
 */
public class LlamasWhalesAndDodosOhMy {
    public static void main(String[] args) {
        int llamas = 20;
        int whales = 15;
        int dodos = 0;
        
        if(dodos > 0) {
            System.out.println("I thought dodos were extinct !");
        }
        if(dodos < 0) {
            System.out.println(" How can we have negative dodos? ");
        }
        if(llamas <= whales) {
            System.out.println("Aw man, brawn over brains I guess, Whales beat llamas.");
        }
        if(llamas > whales) {
            System.out.println("llamas may be bigger, but llamas are better, ha!");
        }
        System.out.println("There has been a huge increase in the dodo population due to cloning.");
        //dodos += 100;
        
        if( (whales + llamas) < dodos) {
            System.out.println("I never thought I'd see the day when dodos ruled the earth.");
        }
        
        if(llamas > whales && llamas > dodos) {
            System.out.println("I dont know how but the llamas have come out ahead! sneakky..");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PP9Arrays;

/**
 *As many berries as possible.
 * no more than three apples. <= 3
 * no more than two kinds of apples. <= 2
 * no tomatoes = 0
 * no more than 12 kinds of fruits. <= 12 
 * 
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class FruitSalad {
    public static void main(String[] args) {
        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", 
            "Cherry Tomato", "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", 
            "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple",  
            "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple",
            "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple",
            "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};

        
        int mostTotalFruits = 12;
        String[] fruitSalad = new String[mostTotalFruits];
        
        int amountApple = 0;
        int amountOrange = 0;
        int amountFruitType = 0;
        int aSlots = 0;

        // Code Recipe for fruit salad should go here!
            for(int i = 0; i < fruit.length; i++) {
                if(amountFruitType == mostTotalFruits) {
                    break;
                } else if (fruit[i].contains("Apples") && amountApple < 3) {
                    fruitSalad[aSlots] = fruit[i];
                    amountApple++;
                    amountFruitType++;
                  //  aSlots++;
                } else if(fruit[i].contains("Orange") && amountOrange <2) {
                    fruitSalad[aSlots] = fruit[i];
                    amountApple++;
                    amountFruitType++;
                   // aSlots++;
                } else if (fruit[i].contains("berry")){
                fruitSalad[aSlots] = fruit[i];
                amountFruitType++;
                aSlots++;
            }
            }
            System.out.println("Fruit salad : ");
            for(int i = 0; i < fruitSalad.length; i++) {
                if(fruitSalad[i] == null) {
                    break;
                } else{
                    System.out.println(fruitSalad[i] + ", ");
                }
            }
    } 
    
   
       
}

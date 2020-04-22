/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PP7Fors;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class DifferentKettleOfFish {

    public static void main(String[] args) {

        for (int fish = 1; fish < 10; fish++) {
            if (fish == 2) {
                System.out.println("RED fish!");
            } else if (fish == 4) {
                System.out.println("BLUE Fish!");
            } else {
                System.out.println(fish + " fish!");
            }
        }

        //I changed the while loop into a for loop, the only thing that changed was the form.
//        int fish = 1;
//        while(fish < 10){
//            if (fish == 2) {
//                System.out.println("RED fish!");
//            } else if (fish == 4) {
//                System.out.println("BLUE Fish!");
//            } else {
//                System.out.println(fish+ " fish!");
//            }
//            fish ++;
    }
}

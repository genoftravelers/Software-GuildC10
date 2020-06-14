/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PP8Methods;

import java.util.Random;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class BarelyControlledChaos {

    public static void main(String[] args) {

        String color = kindOfColor(); // call color method here
        String animal = kindOfAnimal(); // call animal method again here
        String colorAgain = kindOfColor(); // call color method again here
        int weight = kindOfNum(10, 50); // call number method,
        // with a range between 5 - 200
        int distance = kindOfNum(10, 300); // call number method,
        // with a range between 10 - 20
        int number = kindOfNum(5, 500); // call number method,
        // with a range between 10000 - 20000
        int time = kindOfNum(1, 300); // call number method,
        // with a range between 2 - 6            

        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
                + weight + "lb " + " miniature " + animal
                + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over "
                + number + " " + colorAgain + " poppies for nearly "
                + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, "
                + "let me tell you!");
    }

    //  Method 1 
    public static String kindOfColor() {
        Random randomizer = new Random();
        int randColor = randomizer.nextInt(5);

        switch (randColor) {
            case 0:
                return "white";

            case 1:
                return "yellow";

            case 2:
                return "pink";

            case 3:
                return "green";

            case 4:
                return "black";

            default:
                return "Default";

        }

    }
    // method 2
    public static String kindOfAnimal() {
        Random randomizer = new Random();
        int randAnimal = randomizer.nextInt(5);

        switch (randAnimal) {
            case 0:
                return "Cow";

            case 1:
                return "Monkey";

            case 2:
                return "Dog";

            case 3:
                return "Cat";

            case 4:
                return "Pig";

            default:
                return "Default";

        }

    }
    //method 3
    public static int kindOfNum(int numMin, int numMax) {
        Random randomizer = new Random();
        // double randNum = randomizer.nextDouble();

        if (numMax < numMin) {
            System.out.println("The maximum number needs to be bigger than Min num");
        }
        return randomizer.nextInt(numMax - numMin) + numMin;
    }

}

/*

 * Dog Genetics
 * By: Karma Dolkar
 * Date created: 4/25/2020
 
 */
package Assessment;

import java.util.Random;// mandatory to create random numbers.
import java.util.Scanner;// mandatory to create a scanner to read user input.

/**
 * ask user for the name of dog(scanner) create method to get random % for each
 * breed adding to 100% within the method, add for-loop to go through 5 breeds
 * and calculate the sum. Pass the method breedMix to the arrays of strings for
 * breed names.
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class DogGenetics {

    public static void breedMix(String[] breedMix) {// a method to mix the dog breeds with the percentage.
        Random randomizer = new Random();// creates new random number for percentage.

        int totalPerc = 0;
        int perc;

        // In order to add 5 diff breeds with random % adding up to 100, we need a loop.
        for (int i = 0; i < breedMix.length; i++) {
            if (i == breedMix.length - 1) {// so we can get all 100 percent
                perc = 100 - totalPerc;// 100-0= 100.
            } else {
                perc = randomizer.nextInt(100 - totalPerc + 1);
                totalPerc += perc;
            }
            System.out.println(perc + "%" + breedMix[i]);// this will be added to all dog breeds during execution.
        }
    }

    public static void main(String[] args) {

        System.out.println("What is your dog's name?");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();

        System.out.println("Well then, I have this highly reliable report on " + userInput + "'s prestrigious background right here.");
        System.out.println(userInput + " is: ");

        //These strigs will be added to the breedMiz method to generate the results.
        breedMix(new String[]{" Sharpe", " Doberman", " Shitsu", " Schnauzer", " Golden Retriever"});
        System.out.println("Wow, that's QUITE the dog! ");
    }

//        int breedSelection = 7;
//        int rdAnimal = randomizer.nextInt(breedSelection);
//        String[] animalName = new String[5];
//        for (int i = 0; i < animalName.length; i++) {
//            int nameChoice = randomizer.nextInt(breedSelection);
//
//            if (nameChoice == 1) {
//                animalName[i] = "pug";
//            } else if (nameChoice == 2) {
//                animalName[i] = "Sharpe";
//            } else if (nameChoice == 3) {
//                animalName[i] = "Doberman";
//            } else if (nameChoice == 4) {
//                animalName[i] = "Shitsu";
//            } else if (nameChoice == 5) {
//                animalName[i] = "Chihuahua";
//            } else if (nameChoice == 6) {
//                animalName[i] = "Schauzer";
//            } else if (nameChoice == 7) {
//                animalName[i] = "Golden Retriever";
//            }
//        }
}

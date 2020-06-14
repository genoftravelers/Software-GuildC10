/*
 * Rock Paper Scissor
 * By: Karma Dolkar
 * Date created: 4/27/2020
 */
package Assessment;

// essentials utilites to read user input and get random number.
import java.util.Random;
import java.util.Scanner;

/**
 * Create variables and assign values. ask user for input for how many rounds
 * they want to play? use scanner create a for loop to make the rounds go and
 * make sure that the use inputs a number range 1-10 else good bye create an
 * inner if statement to output the results for each outcome for winners and
 * looser and ties. execute all results using the counters. when the loop ends,
 * ask user if they want to play again and if they don't say "thank you".
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class RockPaperScissors {

    public static boolean playing(int userPlays) {
        if (userPlays == 5) {
            System.out.println("you may play again.");
            return true;

        } else {
            System.out.println("Thanks for playing.");
            return false;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random randomizer = new Random();

        boolean plays = true;

        while (plays) {
            // initalize all variables. These will keep count of the wins and ties.
            int ties = 0;
            int userWins = 0;
            int compWins = 0;

            System.out.println("How many rounds do you want to play?");
            int rounds = sc.nextInt();// human answeres

            if (rounds <= 10) {// if user enters less btw 1 -10, they play.
                for (int i = 0; i < rounds; i++) {// for loop to make the rounds go

                    System.out.println("\nchoose 1 for rock, 2 for paper and 3 for scissors");
                    int userInput = sc.nextInt();//human enters choice

                    while (userInput > 3 || userInput < 1) {
                        System.out.println("\nplease try a number between 1 - 3.");
                        System.out.println("\nTry again");
                        // System.exit(0);
                        System.out.println("\nchoose 1 for rock, 2 for paper and 3 for scissors");
                        userInput = sc.nextInt();//human enters choice
                    }

                    int compInput = (randomizer.nextInt(3) + 1);//value passes to comp variable. (max-min)+min-> exclusive of the max.
                    System.out.println(compInput);

                    // All the possiblilies written out for wins for user and comp and ties.
                    if (userInput == compInput) {
                        System.out.println("you both chose: " + userInput);
                        System.out.println("Game is tie");
                        ties++;
                    } else if (userInput == 1 && compInput == 2) {// rock and paper
                        System.out.println("Computer Wins! you said Rock? Comp said paper. ");
                        compWins++;
                    } else if (userInput == 2 && compInput == 3) {// paper and scissor
                        System.out.println("Computer Wins! you said Paper? Comp said scisosr.");
                        compWins++;
                    } else if (userInput == 3 && compInput == 2) {// scissor and paper
                        System.out.println("You Win! you said scissor? comp said paper.");
                        userWins++;
                    } else if (userInput == 2 && compInput == 1) {// paper and rock
                        System.out.println("you win! you said paper? Comp said rock.!");
                        userWins++;
                    } else if (userInput == 1 && compInput == 3) {//rock and scissor
                        System.out.println(" you win!you said rock, comp said scissor.");
                        userWins++;
                    } else if (userInput == 3 && compInput == 1) {//scissor and rock
                        System.out.println(" Comp Win! you said scissor, comp said rock.");
                        compWins++;
                    }
                }

            } else {
                System.out.println("Number error, Bye"); // user answers a diff number they exit.
                System.exit(0);// exists game
            }
            if (userWins == compWins) {
                System.out.println("\nNumber of ties: " + ties);
            } else if (userWins > compWins) {
                System.out.println("\nYou are the over all Winner!");
            } else if (compWins > userWins) {
                System.out.println("\nThe computer is the over all Winner!");
            }

            // execute all the results.
            System.out.println("\nNumber of ties: " + ties);
            System.out.println("Number of User Wins: " + userWins);
            System.out.println("Number of Computer Wins: " + compWins);

            System.out.println("\nDo you want to play again? 5 for yes and 6 for no");
            int userPlays = sc.nextInt();
            while(!(userPlays == 5 || userPlays ==6)){
                System.out.println("Please type either 5 or 6.");
                userPlays = sc.nextInt();
        }
            
            plays = playing(userPlays);
        }
    }
}

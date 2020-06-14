/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvd.ui;

import java.util.Scanner;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class UserIOImpl implements UserIO {

    /**
     *
     * A very simple method that takes in a message to display on the console
     * and then waits for a integer answer from the user to return.
     *
     * @param message - String of information to display to the user.
     *
     */
    @Override// print message
    public void print(String message) {
        System.out.println(message);
    }

    /**
     *
     * A simple method that takes in a message to display on the console, and
     * then waits for an answer from the user to return.
     *
     * @param prompt - String explaining what information you want from the
     * user.
     * @return the answer to the message as string
     */
    @Override// ask user to print sth
    public String readString(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        String userInput = sc.nextLine();
        return userInput;
    }

    /**
     *
     * A simple method that takes in a message to display on the console, and
     * continually re prompts the user with that message until they enter an
     * integer to be returned as the answer to that message.
     *
     * @param prompt - String explaining what information you want from the
     * user.
     * @return the answer to the message as integer
     */
    public int readint(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        //  System.out.println("Enter an integer.");
        Integer userInput = sc.nextInt();
        return userInput;
    }

    /**
     *
     * A slightly more complex method that takes in a message to display on the
     * console, and continually re prompts the user with that message until they
     * enter an integer within the specified min/max range to be returned as the
     * answer to that message.
     *
     * @param prompt - String explaining what information you want from the
     * user.
     * @param min - minimum acceptable value for return
     * @param max - maximum acceptable value for return
     * @return an integer value as an answer to the message prompt within the
     * min/max range
     */
    @Override
    public int readInt(String prompt, int min, int max) {
        Scanner sc = new Scanner(System.in);
        Integer userInput;
        System.out.println(prompt);

        do {
            // System.out.println("enter a integer between a specified min and max range");
            userInput = sc.nextInt();
        } while (userInput < min || userInput > max);
        return userInput;

    }

    /**
     *
     * A simple method that takes in a message to display on the console, and
     * continually re prompts the user with that message until they enter a
     * double to be returned as the answer to that message.
     *
     * @param prompt - String explaining what information you want from the
     * user.
     * @return the answer to the message as double
     */

    @Override
    public double readDouble(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        double userInput = sc.nextDouble();
        return userInput;
    }

    /**
     *
     * A slightly more complex method that takes in a message to display on the
     * console, and continually re prompts the user with that message until they
     * enter a double within the specified min/max range to be returned as the
     * answer to that message.
     *
     * @param prompt - String explaining what information you want from the
     * user.
     * @param min - minimum acceptable value for return
     * @param max - maximum acceptable value for return
     * @return an double value as an answer to the message prompt within the
     * min/max range
     */
    @Override
    public double readDouble(String prompt, double min, double max) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        double userInput;
        do {
            System.out.println("enter a double between a specified min and max range");
            userInput = sc.nextDouble();

        } while (userInput < min || userInput > max);
        return userInput;
    }

    /**
     *
     * A simple method that takes in a message to display on the console, and
     * continually re prompts the user with that message until they enter a
     * float to be returned as the answer to that message.
     *
     * @param prompt - String explaining what information you want from the
     * user.
     * @return the answer to the message as float
     */

    @Override
    public float readFloat(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println("prompt");
        float userInput = sc.nextFloat();
        return userInput;

    }

    /**
     *
     * A slightly more complex method that takes in a message to display on the
     * console, and continually re prompts the user with that message until they
     * enter a float within the specified min/max range to be returned as the
     * answer to that message.
     *
     * @param prompt - String explaining what information you want from the
     * user.
     * @param min - minimum acceptable value for return
     * @param max - maximum acceptable value for return
     * @return an float value as an answer to the message prompt within the
     * min/max range
     */
    @Override
    public float readFloat(String prompt, float min, float max) {
        Scanner sc = new Scanner(System.in);
        float userInput;
        System.out.println(prompt);
        do {
            System.out.println("Enter a double between min and max");
            userInput = sc.nextFloat();
        } while (userInput < min || userInput > max);
        return userInput;
    }

    /**
     *
     * A simple method that takes in a message to display on the console, and
     * continually re prompts the user with that message until they enter a long
     * to be returned as the answer to that message.
     *
     * @param prompt - String explaining what information you want from the
     * user.
     * @return the answer to the message as long
     */
    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        Scanner sc = new Scanner(System.in);
        long userInput = sc.nextLong();
        return userInput;
    }

    /**
     * A slightly more complex method that takes in a message to display on the
     * console, and continually re prompts the user with that message until they
     * enter a double within the specified min/max range to be returned as the
     * answer to that message.
     *
     * @param prompt - String explaining what information you want from the
     * user.
     * @param min - minimum acceptable value for return
     * @param max - maximum acceptable value for return
     * @return an long value as an answer to the message prompt within the
     * min/max range
     */

    @Override
    public long readLong(String prompt, long min, long max) {

        Scanner sc = new Scanner(System.in);
        long userInput;
        do {
            System.out.println("Enter a long between min and max");
            userInput = sc.nextLong();
        } while (userInput < min || userInput > max);
        return userInput;

    }

    @Override
    public int readInt(String prompt) {
        throw new UnsupportedOperationException("Not supported yet.");
//To change body of generated methods, choose Tools | Templates.
    }

}

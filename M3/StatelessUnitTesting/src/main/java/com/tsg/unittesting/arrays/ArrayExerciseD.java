/** *******************************
 * The Software Guild
 * Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
 ******************************** */
package com.tsg.unittesting.arrays;

/**
 *
 * @author Karma Dolkar
 */
public class ArrayExerciseD {

    /**
     * Given an array of doubles, return the biggest number of the lot, as if
     * the decimal had gone missing!
     *
     *
     * pointFree( [1.1, .22] ) -> 22 pointFree( [ .039 , 20 , .005005 ] ) ->
     * 5005 pointFree( [ -9.9 , -700 , -.5 ] ) -> -5
     *
     * @param numbers
     * @return
     */
    public static int pointFree(double[] numbers) {
        int max = 0;//set max to zero default value
        if (numbers != null && numbers.length != 0) { //check for empty or null arrays 
            int[] wholeNums = new int[numbers.length]; //create an int array of same length
            for (int i = 0; i < numbers.length; i++) {
                wholeNums[i] = Integer.parseInt(Double.toString(numbers[i]).replace(".", ""));
                //parse Double as String              
                //replace the decimal point with nothing, essentially removing it.
                //parse this string as an integer
                //place it in the int array wholeNums
            }
            max = wholeNums[0];//set max value to first value in array in case any is less than zero
            for (int i = 0; i < wholeNums.length; i++) {
                if (wholeNums[i] > max) { //check for nums bigger than current max
                    max = wholeNums[i]; //set the max to this new value
                }
            }
        }
        return max;
    }

}

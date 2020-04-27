/*
 * Summative Sums
 * By: Karma Dolkar
 * Date created: 4/25/2020
 */
package Assessment;

/**
 * Create a sum of all the arrays create a method for adding the arrays display
 * all arrays use that method to pass down in the main method. display all the
 * sums of each array
 *
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class SummativeSums {

    public static int sumOfArray(int[] paremX) {// a method to hold the procedure of summing the array.

        int sum = 0;
        for (int i = 0; i < paremX.length; i++) {// each array will go through this loop to get sum.
            sum += paremX[i];
        }
        return sum;// must return a value for the int datatype.
    }

    public static void main(String[] args) {
        //list of all arrays
        int firstArray[] = {1, 90, -33, -55, 67, -16, 28, -55, 15};
        int secondArray[] = {999, -60, -77, 14, 160, 301};
        int thirdArray[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99};
        //display of all arrays
        System.out.println("#1 Array sum: " + sumOfArray(firstArray));
        System.out.println("#2 Array sum: " + sumOfArray(secondArray));
        System.out.println("#3 Array sum: " + sumOfArray(thirdArray));
        // if we don't add the method to the arrays, it will only print out the location address.
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PP6WhilesAndDos;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class WaitAWhile {
    public static void main(String[] args) {
        int timeNow = 11;
        int bedTime = 10;
        
        while (timeNow < bedTime) {
            System.out.println("It's only" + timeNow + " o'clock.");
            System.out.println("I think I'll stay up just a little longer..");
            timeNow ++;
        }
        System.out.println("oh, its" + timeNow + " o' clock.");
        System.out.println("Guess I should go to bed...");
    }
}
/* What happens if you change bedTime's value to 11?
-The console will print out again and again till the time is 11. Printed out 6 times in this case.

What about using bedTime's original value, but changing timeNow to 11?
- It is 11 clock and its time for bed.

If you comment out timeNow++ at the end of the loop, what happens?
- It wil go on and on in the looop..
*/
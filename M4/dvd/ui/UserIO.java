/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvd.ui;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
/*
This interface defines the methods that must be implemented by any class
that wants to directly interact with the user interface technology.

The View uses this interface to interact with the user - it is completely
unaware of the implementation details.
__________________________________________________________________________
These methods ask for and retrieve keyboard input from the user to print 
information ou to the console.
 */
public interface UserIO {

    /*Print a given String to the console. 
    The String displayed should be passed in as a parameter.*/
    void print(String msg);

    /*
    Display a given message String to prompt the user to enter in a double, then
    read in the user response and return that double value. The prompt message 
    value should be passed in as a parameter and the value that is read in should
    be the return of the method.
    
    Display a prompt to the user to enter a double between a specified min and max 
    range, and read in a double. If the user's number does not fall within the 
    range, keep prompting the user for new input until it does. The prompt 
    message, min and max values should be passed in as parameters. The value read
    in from the console should be the return of the method.
     */
    double readDouble(String prompt);

    double readDouble(String prompt, double min, double max);

    /*
    Display a given message String to prompt the user to enter in a float,
    then read in the user response and return that float value.
    The prompt message value should be passed in as a parameter and the 
    value that is read in should be return of the method.
     */
    float readFloat(String prompt);

    float readFloat(String prompt, float min, float max);

    /*
    Display a given message String to prompt the user to enter in an integer,
    then read in the user response and return that integer value. The prompt 
    message value should be passed in as a parameter and the value that is 
    read in should be the return of the method.
    
    Display a prompt to the user to enter a integer between a specified min and 
    max range, and read in a integer. If the user's number does not fall within the
    range, keep prompting the user for new input until it does. The prompt
    message, min and max values should be passed in as parameters. The value 
    read in from the console should be the return of the method.
     */
    int readInt(String prompt);

    int readInt(String prompt, int min, int max);

    /*
    Display a given message String to prompt the user to enter in a long, then
    read in the user response and return that long value. The prompt message 
    value should be passed in as a parameter and the value that is read in should
    be the return of the method.
    Display a prompt to the user to enter a long between a specified min and max 
    range, and read in a long. If the user's number does not fall within the 
    range, keep prompting the user for new input until it does. The prompt 
    message, min and max values should be passed in as parameters. The value read
    in from the console should be the return of the method.
     */
    long readLong(String prompt);

    long readLong(String prompt, long min, long max);

    /*
    Display a given message String to prompt the user to enter in a string,
    then read in the user response as a String and return that value.
    The prompt message should be passed in as a parameter and the String value
    read in should be the return value of the method.
     */
    String readString(String prompt);
}

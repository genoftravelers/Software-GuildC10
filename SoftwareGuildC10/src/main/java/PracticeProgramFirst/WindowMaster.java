/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PracticeProgramFirst;

import java.util.Scanner;

/**
 *
 * @author yooramachi
 */
public class WindowMaster {
    public static void main(String[] args) {
        //we will declare the variabels first
        float height;
        float width;
        float window;
        //we will declare the string variabels to hold the user's 
        //height and width input.    
        String stringHeight;
        String stringWidth;
        String stringWindow;
        //we declare the other variables
        float areaOfWindow;
        float cost;
        float perimeterOfWindow;
        float costOfAllWindows;
        //declare and initialize the Scanner
        Scanner myScanner = new Scanner(System.in);
        
        //get input from the user
        System.out.println("Please enter the window height: ");
        stringHeight = myScanner.nextLine();
        System.out.println("please enter the window width");
        stringWidth = myScanner.nextLine();
        System.out.println("How many windows?");
        stringWindow = myScanner.nextLine();
        
        //we convert values of height and width to float values.
        height = Float.parseFloat(stringHeight);
        width = Float.parseFloat(stringWidth);
        window = Float.parseFloat(stringWindow);
        //we calculate the area of the window
        areaOfWindow = height * width;
        perimeterOfWindow = 2 * (height * width);
        costOfAllWindows = ((areaOfWindow * 3.50f) + (perimeterOfWindow * 2.25f)* window);
        
        //we calculate the cost adding the glass (area* 3.50 & trim (pm * 2.25d.
        cost = ((areaOfWindow * 3.50f) + (perimeterOfWindow * 2.25f));
        
        System.out.println("Window height = " + stringHeight);
        System.out.println("Window height = " + stringWidth);
        System.out.println("Window area = "+ areaOfWindow);
        System.out.println("Window perimeter = " + perimeterOfWindow);
        System.out.println("Window cost = $" + cost);
        System.out.println("total windows = " + window);
        System.out.println("total cost with all windows = $" + costOfAllWindows);
    }
}

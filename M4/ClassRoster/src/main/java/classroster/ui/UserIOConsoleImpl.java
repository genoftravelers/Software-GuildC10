/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroster.ui;

import java.util.Scanner;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class UserIOConsoleImpl implements UserIO {
 @Override// print message
    public void print(String message) {
        System.out.println(message);
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override// ask user to print sth
    public String readString(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        String userInput = sc.nextLine();
        return userInput;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int readint(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
      //  System.out.println("Enter an integer.");
        Integer userInput = sc.nextInt();
        return userInput;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        Scanner sc = new Scanner(System.in);
        Integer userInput;
        System.out.println(prompt);
        
        do{
           // System.out.println("enter a integer between a specified min and max range");
            userInput = sc.nextInt();
        } while(userInput < min || userInput > max);
        return userInput;
 
    }

    @Override
    public double readDouble(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        double userInput = sc.nextDouble();
        return userInput;
    }

    @Override
    public double readDouble(String prpmpt, double min, double max) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prpmpt);
         double userInput;
        do{
            System.out.println("enter a double between a specified min and max range");
            userInput = sc.nextDouble();
            
        }while(userInput<min || userInput > max);
                return userInput;
    }

    @Override
    public float readFloat(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println("prompt");
        float userInput = sc.nextFloat();
        return userInput;
        
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        Scanner sc = new Scanner(System.in);
         float userInput ;
        System.out.println(prompt);
        do{
            System.out.println("Enter a double between min and max");
            userInput = sc.nextFloat();
        }while(userInput<min || userInput >max);
        return userInput;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        Scanner sc = new Scanner(System.in);
        long userInput = sc.nextLong();
        return userInput;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        
        Scanner sc = new Scanner(System.in);
        long userInput;
        do{
            System.out.println("Enter a long between min and max");
            userInput = sc.nextLong();
        }while(userInput < min || userInput > max);
        return userInput;
                
    }

    @Override
    public int readInt(String prompt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}

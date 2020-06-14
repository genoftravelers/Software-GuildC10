/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentQuizScores;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class StudentMap {

    public static void main(String[] args) {
        Map<String, Double> studentsInfo = new HashMap<>();
        Set<String> studentList = studentsInfo.keySet();
        System.out.println("Type the numbers to the desired students's test infomation.");

        studentsInfo.put("\nHarry ", 88.88);
        studentsInfo.put("\nTom ", 90.50);
        studentsInfo.put("\nDick ", 80.25);
        studentsInfo.put("\nJerry ", 99.00);
        studentsInfo.put("\nPotter ", 50.50);

        

        System.out.println("type 1 to see all student.");
        System.out.println("type 2 to see all the names and scores.");
        System.out.println("type 3 to add a student.");
        System.out.println("type 4 to remove a student.");
        System.out.println("type 5 to see a students' average score.");
        System.out.println("type 6 to exit.");
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        
        if (userInput == 1) {
            System.out.println("Here are the students " + studentsInfo.keySet());
        } else if(userInput == 2)
        {
           System.out.println("Here are the list of students and their grades" + studentsInfo);
        } else if (userInput == 3){
            System.out.println("Added Tommy to the list");
            studentsInfo.put("Tommy", 34.54);
            System.out.println(studentsInfo);
        } else if (userInput == 4) {
             System.out.println("Jerry was removed.");
            studentsInfo.remove("Jerry", 99.0);
        } else if(userInput == 5) {
            System.out.println("The Average score of the students are = ");
            System.out.println((99.00 + 50.50) / 5);
        }else{
            System.out.println("you have exited the program");
        System.exit(0);
    }
    }

}

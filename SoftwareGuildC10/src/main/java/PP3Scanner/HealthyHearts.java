/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PP3Scanner;

import java.util.Scanner;

/**
 *
 * @author yooramachi
 */
public class HealthyHearts {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your age?");
        int age = Integer.parseInt(sc.nextLine());
        
        int heartRate = 220 - age ;
        int hrZone = 85/heartRate;
        
        System.out.println("your maximum heart rate should be " + heartRate);
        System.out.println("your target HR Zone is " + hrZone );
        
    }
}

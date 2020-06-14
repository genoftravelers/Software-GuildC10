/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactorIntoObjects.Factorizer;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class Factorizer {
   
    private int factor;

   
//    public Factorizer() {
//        //default ctor
//    }

    public Factorizer(int factor) {
        this.factor = factor;
    }

   
    public int FactorizeIt() {
        return factor;
    }

    
   
    public void factorCommand() {
        int factorCt = 0;
        int sumOfFactors = 0;
        int numToFactor = FactorizeIt();

        
        for (int i = 1; i <= numToFactor; i++) {
            if (numToFactor % i == 0) {
                System.out.print(i + " ");
                factorCt++;
                sumOfFactors += i;
            }
        }

        System.out.println("\n" + numToFactor + " has " + factorCt + " factors");

     
        if (factorCt == 2) {
            System.out.println(numToFactor + " is a prime Number!");
        } else {
            System.out.println(numToFactor + " is a not prime Number...");
        }

   
        int perfectNumCalc = sumOfFactors - numToFactor;
        if (perfectNumCalc == numToFactor) {
            System.out.println(numToFactor + " is a perfect number!");
        } else {
            System.out.println(numToFactor + " is a not perfect number...");
        }
    }
}

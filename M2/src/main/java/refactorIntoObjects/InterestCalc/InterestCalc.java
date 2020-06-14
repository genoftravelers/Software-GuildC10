/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactorIntoObjects.InterestCalc;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class InterestCalc {
  
    private double investment;
    private double annual;
    private int term;

    
    public InterestCalc() {
      
    }

    public InterestCalc(double investment, double annual, int term) {
        this.investment = investment;
        this.annual = annual;
        this.term = term;
    }

   
    public double investment() {
        return investment;
    }

    public double eachYear() {
        return annual;
    }

    public int getTerm() {
        return term;
    }

    public void setInvestment(double investment) {
        this.investment = investment;
    }

    
    public double calcYearlyIntr() {
        double annualRate = eachYear() / 100;
        return investment() * annualRate;
    }

    
    public double calcQuarterlyIntr() {
        double quarterlyRate = (eachYear() / 4) / 100;
        return investment() * quarterlyRate;
    }

    
    public double calcMonthlyIntr() {
        double monthlyRate = (eachYear() / 12) / 100;
        return investment() * monthlyRate;
    }

    
    public double calcDailyIntr() {
        double dailyRate = (eachYear() / 365) / 100;
        return investment() * dailyRate;
    }

    public double yearEndPrinciple() {
        double yearEndPrinciple = investment() + this.calcYearlyIntr();
        this.setInvestment(yearEndPrinciple);
        return yearEndPrinciple;
    }
}

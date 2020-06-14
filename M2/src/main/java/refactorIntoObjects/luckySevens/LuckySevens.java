/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactorIntoObjects.luckySevens;

import java.util.Random;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class LuckySevens {

    public static final double WIN = 4.0;
    public static final double LOSS = 1.0;
    private double bank;
    private int rollCt;
    private int peakRoll;
    private double peakPot;


    public LuckySevens(double buyIn) {
        setMoney(buyIn);
        this.rollCt = 0;
        this.peakRoll = 0;
        this.peakPot = 0;
    }


    public double getMoney() {
        return bank;
    }

    public void setMoney(double bank) {
        if (bank > 0) {
            this.bank = bank;
        } else {
            throw new IllegalArgumentException("Invalid bet amount.");
        }
    }

    public int getCt() {
        return rollCt;
    }

    public void setCt(int rollCt) {
        this.rollCt = rollCt;
    }

    public int getPeakRoll() {
        return peakRoll;
    }

    public void setPeakRoll(int peakRoll) {
        this.peakRoll = peakRoll;
    }

    public double getPeakPot() {
        return peakPot;
    }

    public void setPeakPot(double peakPot) {
        this.peakPot = peakPot;
    }

  
    public int rollDice() {
        Random dice = new Random();

        int dice1 = dice.nextInt(6) + 1;
        int dice2 = dice.nextInt(6) + 1;

        return dice1 + dice2;
    }

    
    public void trackPeak() {
        if (this.bank > getPeakPot()) {
            setPeakPot(this.bank);
            setPeakRoll(this.rollCt);
        }
    }

    
    public void assessRoll(int userRoll) {
      
        switch (userRoll) {
            case 7: {
                
                this.bank += WIN;
                this.rollCt++;
                break;
            }
            default: {
                
                this.bank -= LOSS;
                this.rollCt++;
                break;
            }
        }
    }
}

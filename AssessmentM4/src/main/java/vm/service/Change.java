/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm.service;

import vm.dto.Coins;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class Change {

    int amtOfCents;
    int amtOfNickels;
    int amtOfDimes;
    int amtOfQuarters;

    public int getNumOfCents() {
        return amtOfCents;
    }

    public void setNumOfCents(int amtOfCents) {
        this.amtOfCents = amtOfCents;
    }

    public int getNumOfNickels() {
        return amtOfNickels;
    }

    public void setNumOfNickels(int amtOfNickels) {
        this.amtOfNickels = amtOfNickels;
    }

    public int getNumOfDimes() {
        return amtOfDimes;
    }

    public void setNumOfDimes(int amtOfDimes) {
        this.amtOfDimes = amtOfDimes;
    }

    public int getNumOfQuarters() {
        return amtOfQuarters;
    }

    public void setNumOfQuarters(int amtOfQuarters) {
        this.amtOfQuarters = amtOfQuarters;
    }

    public void changeCalc(int leftAmount) {
        amtOfQuarters = leftAmount / Coins.QUARTER.getValue();
        leftAmount = leftAmount % Coins.QUARTER.getValue();

        amtOfDimes = leftAmount / Coins.DIME.getValue();
        leftAmount = leftAmount % Coins.DIME.getValue();

        amtOfNickels = leftAmount / Coins.NICKEL.getValue();
        leftAmount = leftAmount % Coins.NICKEL.getValue();

        amtOfCents = leftAmount;
    }

}

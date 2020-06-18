/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm.dto;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public enum Coins {
    PENNY(1), NICKEL(5), DIME(10), QUARTER(25);

    int value;

    Coins(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

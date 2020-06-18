/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm.service;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */

//EXCEPTION WILL BE THROWN WHEN THERE IS NO ENOUGH MONEY FROM THE USER.
public class InsufficientMoneyException extends Exception {

    public InsufficientMoneyException(String message) {
        super(message);
    }

    public InsufficientMoneyException(String message, Throwable cause) {
        //We want VmDaoException to act like Exception
        super(message, cause);
    }
}

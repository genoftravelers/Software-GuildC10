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

//EXCEPTION WILL BE THROWN WHEN DATA IS NOT VALID.
public class ItemValidationException extends Exception{
    
    public ItemValidationException (String message) {
        super(message);
    }
    
    public ItemValidationException(String message, Throwable cause) {
        super(message, cause);
    }
    
}

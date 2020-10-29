/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.service;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class OrderDataInvalidException extends Exception {

    public OrderDataInvalidException(String message) {
        super(message);
    }

    public OrderDataInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kd.guessthenum.service;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class InvalidNumException extends Exception {
    public InvalidNumException(String message) {
        super(message);
    }

    public InvalidNumException(String message, Throwable cause) {
        super(message, cause);
    }
}

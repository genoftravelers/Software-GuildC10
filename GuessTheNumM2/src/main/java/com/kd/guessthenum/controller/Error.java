/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kd.guessthenum.controller;

import java.time.LocalDateTime;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class Error {
    private LocalDateTime timestamp = LocalDateTime.now();
    private String message;
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

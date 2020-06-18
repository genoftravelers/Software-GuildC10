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

//WILL THROW THIS ERROR WHEN DUPLICATE NAME IS INSERTED.
public class VmDuplicateNameException extends Exception {

    public VmDuplicateNameException(String message) {
        super(message);
    }

    public VmDuplicateNameException(String message, Throwable cause) {
        super(message, cause);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroster.dao;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class ClassRosterPersistenceException extends Exception {
    public ClassRosterPersistenceException(String message) {
        super(message);
    }
    public ClassRosterPersistenceException(String message, Throwable cause){
        super(message, cause);
    }
}

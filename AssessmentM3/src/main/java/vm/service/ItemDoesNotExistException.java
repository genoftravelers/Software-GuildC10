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

//EXCEPTION WILL BE THROWN WHEN ITEMS DONT EXIST.
public class ItemDoesNotExistException extends Exception {
    
   //exception that can get thrown

    //Constructor takes in String message.
    //We use this constructor when sth is wrong in our app or sth doesnt pass the
    //validation rules.
    //We could throw a new VmDaoException with a message describing the problem.
    public ItemDoesNotExistException(String message) {
        //we want VmDaoException to act like the parent Exception, therefore "super".
        super(message);
    }

    //Constructor takes in String messages and Throwable cause (not exception
    //because Exception extends Throwable.
    //We use this constructor when sth is wrong in our app caused by another 
    //exception.
    //We catch the error and pass a message and the cause of the error and throw
    //newly created Exception.
    public ItemDoesNotExistException(String message, Throwable cause) {
        //We want VmDaoException to act like Exception
        super(message, cause);
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvd.dao;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
/*
EXCEPTIONS- Error conditions in java.
Professional Developers know how to handle exceptions and recover gracefully.
In other words, predictable error conditions are expected and do not crash the
program because additional code is written to handle these tum-time errors.
we use TRY-CATCH-FINALLY and THROWS keywords to handle exceptions.

DvdDaoException - application-specific exceptions let the caller know that
something wrong in the DAO but it doesnt indicate anything about the
underlying implementaion.
 */
public class DvdDaoException extends Exception {//wrap any implementation-specific 
    //exception that can get thrown

    //Constructor takes in String message.
    //We use this constructor when sth is wrong in our app or sth doesnt pass the
    //validation rules.
    //We could throw a new DvdDaoException with a message describing the problem.
    public DvdDaoException(String message) {
        //we want DvdDaoException to act like the parent Exception, therefore "super".
        super(message);
    }

    //Constructor takes in String messages and Throwable cause (not exception
    //because Exception extends Throwable.
    //We use this constructor when sth is wrong in our app caused by another 
    //exception.
    //We catch the error and pass a message and the cause of the error and throw
    //newly created Exception.
    public DvdDaoException(String message, Throwable cause) {
        //We want DvdDaoException to act like Exception
        super(message, cause);
    }
}

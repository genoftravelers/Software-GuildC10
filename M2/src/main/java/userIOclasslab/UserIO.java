/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userIOclasslab;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public interface UserIO {

    void print(String message);

    String readString(String prompt);

    int readint(String prompt);

    int readInt(String prompt, int min, int max);

    double readDouble(String prompt);

    double readDouble(String prpmpt, double min, double max);

    float readFloat(String prompt);

    float readFloat(String prompt, float min, float max);

    long readLong(String prompt);

    long readLong(String prompt, long min, long max);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author Zaw L Than
 */
public interface UserIO {
    
    void print(String msg);
    String readString(String prompt);
    
    int readInt(String prompt);
    int readInt(String prompt, int min, int max);
    
    long readLong(String prompt);
    long readLong(String prompt, long min, long max);
    
    float readFloat(String prompt);
    float readFloat(String prompt, float min, float max);
    
    double readDouble(String prompt);
    double readDouble(String prompt, double min, double max);
}

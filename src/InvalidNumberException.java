/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class InvalidNumberException extends Exception {
    
    public InvalidNumberException()
    {
        toString();
    }
    
    public String toString()
    {
        return String.format("Invalid Number ERROR");
    }
    
}

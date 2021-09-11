/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crosscameronassignment2;

import java.util.ArrayList;

/**
 *
 * @author Cameron Cross
 */
public class Account {

    private double balance;
    private String accID;
    protected Person p;
   
/**
 * Constructor that creates an account and sets the balance to 0
 * @param p
 * @param accID 
 */
    public Account(Person p, String accID) {
        balance = 0;
        this.p = p;
        this.accID = accID;
       
    }

    /**
     * returns the Person holding the account
     * @return Person
     */
    public Person getPerson() {
        return p;
    }
    
    /**
     * Sets the balance to the balance - the passed in parameter
     * @param x 
     */
    public void withdraw(double x) {
        balance = balance - x;
    }
    
    /**
     * Adds the parameter x to the balance
     * @param x 
     */
    public void deposit(double x) {
        balance = balance + x;
    }
    
    /**
     * returns the balance of the account
     * @return double balance
     */
    public double getBalance() {
        return balance;
    }
/**
 * Gets the account id number
 * @return String
 */

    public String getAccID() {
        return accID;
    }

   /**
    * Prints out information about the account
    * @return String
    */
    @Override
   public String toString() {
       return "Account title: " + getAccID() + ", Account owner: " + p.getName() + ", Account balance: $" + getBalance();
               
               }

}

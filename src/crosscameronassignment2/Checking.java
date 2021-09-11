/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crosscameronassignment2;

/**
 *
 * @author Cameron Cross
 */
public class Checking extends Account {
  
    /**
     * Creates an account of type checking
     * @param p
     * @param accId 
     */
    public Checking(Person p, String accId) {
        super(p, accId);
    }


   
    
    
    /**
     * Returns information about the checking account
     * @return String
     */
    @Override
    public String toString() {
       return "Account type: Checking, Account title: " + getAccID() + ", Account owner: " + p.getName() + ", Account balance: $" + getBalance()+ ", Interest rate: 2.0%";
          
    }
    
}

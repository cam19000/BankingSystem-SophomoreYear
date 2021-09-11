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
public class Saving extends Account {
   
   /**
    * Constructor that creates a new savings account.
    * @param p
    * @param accID 
    */ 
    public Saving(Person p, String accID) {
        super(p, accID);
    }
    
    
    
    /**
     * Returns useful information about the savings account
     * @return String
     */
    @Override
    public String toString() {
       return "Account type: Savings, Account title: " + getAccID() + ", Account owner: " + p.getName() + ", Account balance: $" + getBalance() + ", Interest rate: 3.2%";
          
    }
    

    
   
}

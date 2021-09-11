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
public class CD extends Account {

    /**
     * Creates a new account of type CD
     * @param p
     * @param accId 
     */
    public CD(Person p, String accId) {
        super(p, accId);
    }
   
    
/**
 * Prints out information about the certificate of deposit
 * @return String
 */
    
    @Override
    public String toString() {
       return "Account type: CD, Account title: " + getAccID() + ", Account owner: " + p.getName() + ", Account balance: $" + getBalance()+ ", Interest rate: 4.5%";
          
    }
}

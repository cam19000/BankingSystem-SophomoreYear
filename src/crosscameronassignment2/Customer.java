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
public class Customer extends Person{

    
    /**
     * creates a person of type customer
     * @param name
     * @param userName 
     */
    public Customer(String name, String userName) {
        super(name, userName);
        
    }
    
    
    /**
     * returns useful information about the customer such
     * @return String
     */
    @Override
    public String toString() {
        
        
        return "(Customer) Name: " + getName() + ", Username: " + getUserName();
    }
    
    
}

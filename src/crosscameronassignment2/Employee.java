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
public class Employee extends Person {
   
    /**
     * creates a person of type employee
     * @param name
     * @param position
     * @param userName 
     */
    public Employee(String name, String position, String userName) {
     super(name,position,userName);
       
    }
    
   
    /**
     * returns useful information about the employee
     * @return String
     */
    @Override
    public String toString () {
        
        
        return "(Employee) Name: " + getName() + ", Position: " + getPosition() +", Username: "+ getUserName();
    }
    
}

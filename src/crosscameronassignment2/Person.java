/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crosscameronassignment2;

import java.util.Iterator;

/**
 *
 * @author Cameron Cross
 */
public class Person {
    private String name;
    private String position;
    private String userName;
    
    /**
     * Constructor to create a new person with a name and username
     * @param name
     * @param userName 
     */
    public Person(String name, String userName) {
        this.name = name;
        this.userName = userName;
        
        
    }
    
    /**
     * Constructor to create a person with a position, username, and name
     * @param name
     * @param position
     * @param userName 
     */
    
    public Person(String name, String position, String userName) {
        this.name = name;
        this.position = position;
        this.userName = userName;
    }

    /**
     * returns the name of the person
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * returns the position of the person
     * @return String
     */
    public String getPosition() {
        return position;
    }
/**
 * returns the username of the person
 * @return 
 */
    public String getUserName() {
        return userName;
    }
    
    
}

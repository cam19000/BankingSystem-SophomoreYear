/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crosscameronassignment2;

import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Cameron Cross
 */
public class Start {

    public static void main(String[] args) {
       // Creates a bank object and sets name to "Cross"
        Bank b = new Bank("Cross");

        // Prints the welcome information to the bank
        System.out.println("Hello, welcome to Cross Bank. Listed "
                + "below \nyou will find many different options that \nyou can choose from. Enter the number "
                + "that corresponds to the option \nyou want to pick. Enjoy your "
                + "time at Cross Bank!");

        // Main loop for the bank, runs through a switch of the many different choices
        while (true) {
            Bank.listOptions();
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    b.addEmployee();
                    break;
                case 2:
                    b.listEmployees();
                    break;

                case 3:
                    b.addCustomer();
                    break;
                case 4:
                    b.listCustomers();
                    break;
                case 5:
                    b.createAccount();
                    break;
                case 6:
                    System.out.println("Enter your customer username");
                    sc.nextLine();
                    String userName = sc.nextLine();
                    b.listCustomerAccounts(userName);
                    break;
                case 7:
                    b.withdraw();
                    break;
                case 8:
                    b.deposit();
                    break;

                case 9:
                    System.out.println("You must be an employee in order to access these options. If you are a customer, contact an employee if you wish to delete an account. Enter your employee username.");
                    sc.nextLine();
                    String uN = sc.nextLine();
                    while (b.getEmployee(uN) == null) {
                        System.out.println("Sorry, your username is incorrect. Enter 'exit' to quit.");
                        uN = sc.nextLine();
                        if(uN.equals("exit")) {
                            return;
                        }
                    }
                    b.employeeOptions();
                    break;
                    
                case 10:
                    return;
            }
        }

    }

}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crosscameronassignment2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Cameron Cross
 */
public class Bank {

    String bankName;
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Saving> savings = new ArrayList<>();
    private ArrayList<Checking> checkings = new ArrayList<>();
    private ArrayList<CD> cds = new ArrayList<>();

    public Bank(String bankName) {
        this.bankName = bankName;

    }
/**
 * Asks the user for a name of the employee they want to create, asks for a username for that employee
 * Checks to see if the username is already in use by another employee
 * If the username is not in use, the employee is created and added to the ArrayList of employees.
 */
    public void addEmployee() {
        System.out.println("What would you like the name of the employee to be?");
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();

        System.out.println("What would you like the position of the employee to be?");
        String p = sc.nextLine();

        System.out.println("What would you like the employee's user name to be?");
        String userName = sc.nextLine();

        Iterator iter = getEmployees().iterator();
        while (iter.hasNext()) {
            Employee curEmployee = (Employee) iter.next();
            while (curEmployee.getUserName().equals(userName)) {
                System.out.println("Sorry, the id numer is already taken. Please enter a new id number.");
                userName = sc.nextLine();
            }
        }

        Employee x = new Employee(n, p, userName);
        employees.add(x);

    }

    /**
     * Returns the ArrayList of Employees.
     * @return employees (ArrayList)
     */
    public ArrayList getEmployees() {

        return employees;
    }

    /**
     * Prints out the toString() method for each of the employees.
     */
    public void listEmployees() {
        Iterator iter = employees.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    /**
     * Returns an employee object by looping through the employee ArrayList and comparing the passed in 
     * username to each employees username.
     * @param userName
     * @return Employee (object)
     */
    public Employee getEmployee(String userName) {
        Employee retVal = null;
        Iterator iter = employees.iterator();
        while (iter.hasNext()) {
            Employee curEmployee = (Employee) iter.next();
            if (curEmployee.getUserName().equals(userName)) {
                retVal = curEmployee;
                break;
            }
        }
        return retVal;
    }

    /**
     * returns the ArrayList of customers
     * @return customers(ArrayList)
     */
    public ArrayList getCustomers() {

        return customers;
    }
/**
 * Returns a customer object by looping through the customers ArrayList and comparing the passed in 
  * username to each customers username.
 * @param userName
 * @return Customer(Object)
 */
    public Customer getCustomer(String userName) {
        Customer retVal = null;
        Iterator iter = customers.iterator();
        while (iter.hasNext()) {
            Customer curCustomer = (Customer) iter.next();
            if (curCustomer.getUserName().equals(userName)) {
                retVal = curCustomer;
                break;
            }

        }
        return retVal;
    }
/**
 * Lists of the toString method for each of the customers by looping through the customers array.
 */
    public void listCustomers() {
        Iterator iter = customers.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    /**
     * Asks the user for a name and username then checks to see if the username is already in use by 
     * a current customer, if not, the customer is created with that name and username and added to the customers array.
     */
    public void addCustomer() {
        System.out.println("What would you like the name of the customer to be?");
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();

        System.out.println("What would you like the customer's username to be?");
        String custUserName = sc.nextLine();

        Iterator i = getCustomers().iterator();
        while (i.hasNext()) {
            Customer c = (Customer) i.next();
            while (c.getUserName().equals(custUserName)) {
                System.out.println("Sorry, the username is already taken. Please enter a new username.");
                custUserName = sc.nextLine();

            }

        }

        Customer x = new Customer(n, custUserName);
        customers.add(x);
    }

    /**
     * Lists the different options for the main loop in the main method in start.
     */
    public static void listOptions() {
        System.out.println("1: Add an employee");
        System.out.println("2: List employees");
        System.out.println("3: Add a customer");
        System.out.println("4: List customers");
        System.out.println("5: Create an account");
        System.out.println("6: View your accounts");
        System.out.println("7: Withdraw from an account");
        System.out.println("8: Deposit money into an account");
        System.out.println("9: Employee options");
        System.out.println("10: Exit");
    }

    /**
     * Creates an account for a customer based on which username the user enters.
     * Checks to see if a customer exists under the given username that the customer gives
     * If the customer does not exist, it informs the user and offers the user to exit the program
     * Once the user has entered a valid customer username. Then asks the customer for an account name.
     * Then the method goes through checkings, savings, and cds ArrayLists
     * to check if the user has entered a valid account name (one that is available.) If the user has entered a valid
     * account name, he or she is prompted with the option of making a checking, savings, or CD account.
     */
    public void createAccount() {
        System.out.println("What is your customer username?");
        Scanner sc = new Scanner(System.in);
        String custUserName = sc.nextLine();
        Customer c = getCustomer(custUserName);
        while (c == null) {
            System.out.println("Sorry, no customer was found under that username. Please enter the correct username.");
            System.out.println("Enter 'exit' to quit");
            custUserName = sc.nextLine();
            if (custUserName.equals("exit")) {
                return;
            }
            c = getCustomer(custUserName);
        }

        System.out.println("Enter a title for your account. You will need this title to access your account.");
        String accID = sc.nextLine();
        while (getSaving(accID) != null) {
            System.out.println("Sorry, that title is taken. Please enter a different title.");
            accID = sc.nextLine();
        }
        while (getCD(accID) != null) {
            System.out.println("Sorry, that title is taken. Please enter a different title.");
            accID = sc.nextLine();
        }

        while (getChecking(accID) != null) {
            System.out.println("Sorry, that title is taken. Please enter a different title.");
            accID = sc.nextLine();
        }

        System.out.println("What type of account would you like to create?");
        System.out.println("1: Savings Account");
        System.out.println("2: Checking Account");
        System.out.println("3: CD Account");
        int type = sc.nextInt();
        switch (type) {
            case 1:
                Saving s = new Saving(c, accID);
                savings.add(s);
                System.out.println("Congratulations " + c.getName() + "! Your savings account has been created under the title: " + accID);
                break;
            case 2:
                Checking d = new Checking(c, accID);
                checkings.add(d);
                System.out.println("Congratulations " + c.getName() + "! Your checking account has been created under the title: " + accID);
                break;
            case 3:
                CD e = new CD(c, accID);
                cds.add(e);
                System.out.println("Congratulations " + c.getName() + "! Your certificate of deposit account has been created under the title: " + accID);
                System.out.println(e.toString());
                break;
        }

    }

    /**
     * Loops through each of the savings accounts in the array to check if one contains the passed in account ID, 
     * once found, the account returns the saving account object.
     * @param accID
     * @return Saving(object)
     */
    public Saving getSaving(String accID) {

        Saving retVal = null;
        Iterator iter = savings.iterator();
        while (iter.hasNext()) {
            Saving curSaving = (Saving) iter.next();
            if (curSaving.getAccID().equals(accID)) {
                retVal = curSaving;
                break;
            }

        }
        return retVal;
    }

    /**
     * Loops through each of the checking accounts in the array to check if one contains the passed in account ID, 
     * once found, the account returns the checking account object.
     * @param accID
     * @return Checking(object)
     */
    public Checking getChecking(String accID) {

        Checking retVal = null;
        Iterator iter = checkings.iterator();
        while (iter.hasNext()) {
            Checking curChecking = (Checking) iter.next();
            if (curChecking.getAccID().equals(accID)) {
                retVal = curChecking;
                break;
            }

        }
        return retVal;
    }
/**
 * Loops through each of the CD accounts in the array to check if one contains the passed in account ID, 
  * once found, the account returns the CD account object.
 * @param accID
 * @return CD(object)
 */
    public CD getCD(String accID) {

        CD retVal = null;
        Iterator iter = cds.iterator();
        while (iter.hasNext()) {
            CD curCD = (CD) iter.next();
            if (curCD.getAccID().equals(accID)) {
                retVal = curCD;
                break;
            }

        }
        return retVal;
    }

    /**
     * Checks to see if any accounts of type Saving, Checking, or CD contain the customer passed in
     * If any of them do, it prints out the toString method for each account containing the customer
     * @param userName 
     */
    public void listCustomerAccounts(String userName) {
        Iterator iter = savings.iterator();
        while (iter.hasNext()) {
            Saving curSaving = (Saving) iter.next();
            if (curSaving.getPerson().getUserName().equals(userName)) {
                System.out.println(curSaving.toString());
               
            }
        }

        Iterator i = checkings.iterator();
        while (i.hasNext()) {
            Checking curChecking = (Checking) i.next();
            if (curChecking.getPerson().getUserName().equals(userName)) {
                System.out.println(curChecking.toString());
               
            }
        }

        Iterator j = cds.iterator();
        while (j.hasNext()) {
            CD curCD = (CD) j.next();
            if (curCD.getPerson().getUserName().equals(userName)) {
                System.out.println(curCD.toString());
               
            }
        }
    }

    /**
     * Asks for the customers username and displays the users accounts
     * Asks the user to enter the account title that he or she wishes to withdraw from and explains 
     * the $20 fee for withdrawing from a cd account
     * Checks through each type of account in a loop to see if the account exists
     * If the account exists, it checks to see if the withdraw amount exceeds the balance
     * If the withdraw amount does not exceed the balance, the money is withdrawn from the account.
     * 
     */
    public void withdraw() {
        System.out.println("What is your username?");
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();
        System.out.println("Your accounts are listed below.");
        listCustomerAccounts(userName);
        System.out.println("enter the title of the account you would like to withdraw from. Keep in mind, if you withdraw from a CD account before it matures, there will be a $20 fee.");
        String accID = sc.nextLine();
        System.out.println("Enter the amount you would like to withdraw.");

        double withdrawAmt = sc.nextDouble();

        if (getCD(accID) != null) {
            while (withdrawAmt + 20 > getCD(accID).getBalance()) {
                System.out.println("Sorry, that withdraw exceeds your balance. Please enter a new withdraw amount.");
                withdrawAmt = sc.nextDouble();
            }
            getCD(accID).withdraw(withdrawAmt + 20);
            System.out.println("Transaction complete! Your new balance is: $" + getCD(accID).getBalance());
            return;
        }
        if (getChecking(accID) != null) {
            while (withdrawAmt > getChecking(accID).getBalance()) {
                System.out.println("Sorry, that withdraw exceeds your balance. Please enter a new withdraw amount.");
                withdrawAmt = sc.nextDouble();
            }
            getChecking(accID).withdraw(withdrawAmt);
            System.out.println("Transaction complete! Your new balance is: $" + getChecking(accID).getBalance());
            return;
        }
        if (getSaving(accID) != null) {
            while (withdrawAmt > getSaving(accID).getBalance()) {
                System.out.println("Sorry, that withdraw exceeds your balance. Please enter a new withdraw amount.");
                withdrawAmt = sc.nextDouble();
            }
            getSaving(accID).withdraw(withdrawAmt);
            System.out.println("Transaction complete! Your new balance is: $" + getSaving(accID).getBalance());
            return;
        }
        System.out.println("Transaction failed. Please check the title name entered.");

    }

    /**
     * Asks for the customers username and displays the users accounts
     * Asks the user to enter the account title that he or she wishes to deposit into
     * Checks through each type of account in a loop to see if the account exists
     * If the account exists, the money is deposited into the account.
     */
    
    public void deposit() {
        System.out.println("What is your username?");
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();
        System.out.println("Your accounts are listed below.");
        listCustomerAccounts(userName);
        System.out.println("enter the title of the account you would like to deposit money into.");
        String accID = sc.nextLine();
        System.out.println("Enter the amount you would like to deposit.");
     
            double depositAmt = sc.nextDouble();
while(depositAmt < 0){
    System.out.println("Error, please enter an amount greater than 0.");
    depositAmt = sc.nextDouble();
}
        
        if (getCD(accID) != null) {
            getCD(accID).deposit(depositAmt);
            System.out.println("Transaction complete! Your new balance is: $" + getCD(accID).getBalance());
            return;
        }
        if (getChecking(accID) != null) {
            getChecking(accID).deposit(depositAmt);
            System.out.println("Transaction complete! Your new balance is: $" + getChecking(accID).getBalance());
            return;
        }
        if (getSaving(accID) != null) {

            getSaving(accID).deposit(depositAmt);
            System.out.println("Transaction complete! Your new balance is: $" + getSaving(accID).getBalance());
            return;
        }
        System.out.println("Transaction failed. Please check the title name entered.");

    }

    /**
     * Loops through each account array and prints out the toString method for every account.
     */
    public void listAllAccounts() {
        Iterator iter = savings.iterator();
        while (iter.hasNext()) {
            Saving curSaving = (Saving) iter.next();
            System.out.println(curSaving.toString());

        }

        Iterator i = checkings.iterator();
        while (i.hasNext()) {
            Checking curChecking = (Checking) i.next();
            System.out.println(curChecking.toString());

        }

        Iterator j = cds.iterator();
        while (j.hasNext()) {
            CD curCD = (CD) j.next();
            System.out.println(curCD.toString());
            
        }
    }

    /**
     * Method for employee access only (authorization for the method is checked in the start class)
     * case 1 allows an employee to view the toString method for all customer accounts
     * case 2 allows an employee to delete a customer account based on the account title given by the user
     * it does this by looping through each of the account arrays checking to see if an account exists, and if it does, the account is deleted
     * Case 3 allows an employee to delete    
     */
    public void employeeOptions() {
        System.out.println("What would you like to do?");
        System.out.println("1: List all customer accounts");
        System.out.println("2: Delete a customer account");
        System.out.println("3: Delete a customer from the system and all of their accounts");
        Scanner sc = new Scanner(System.in);
        String r = sc.nextLine();
        switch (r) {
            case "1":
                listAllAccounts();
                break;
            case "2":
                System.out.println("What type of account would you like to delete?");
                System.out.println("1: Savings");
                System.out.println("2: Checking");
                System.out.println("3: CD");

                String type = sc.nextLine();
                switch (type) {
                    case "1":
                        System.out.println("Enter the account number of the savings account");
                        String accID = sc.nextLine();
                        while (getSaving(accID) == null) {
                            System.out.println("Sorry, no saving account is under that account ID");
                            accID = sc.nextLine();
                            if (accID.equals("exit")) {
                                return;
                            }
                        }
                        savings.remove(getSaving(accID));

                        break;
                    case "2":
                        System.out.println("Enter the account number of the checking account");
                        accID = sc.nextLine();

                        while (getChecking(accID) == null) {
                            System.out.println("Sorry, no checking account is under that account ID");
                            accID = sc.nextLine();
                            if (accID.equals("exit")) {
                                return;
                            }
                        }
                        

                        checkings.remove(getChecking(accID));
                        break;
                    case "3":
                        System.out.println("Enter the account number of the CD account");
                        accID = sc.nextLine();

                        while (getCD(accID) == null) {
                            System.out.println("Sorry, no CD account is under that account ID");
                            accID = sc.nextLine();
                            if (accID.equals("exit")) {
                                return;
                            }
                        }

                        cds.remove(getCD(accID));
                        break;
                    default:
                        System.out.println("Sorry, please enter a number between 1 and 3");
                        type = sc.nextLine();
                        break;
                        
                }
                break;
            case "3":
                System.out.println("Enter the username of the customer you would like to remove. The customer will be removed from the system along with all of the accounts he or she owned.");
                String custId = sc.nextLine();
                while (getCustomer(custId) == null) {
                    System.out.println("Sorry, the customer username you entered was incorrect. Enter a new username or enter 'exit' to quit.");
                    custId = sc.nextLine();
                    if (custId.equals("exit")) {
                        return;
                    }
                }

                System.out.println("The following customer has been removed.");
                System.out.println(getCustomer(custId));

                System.out.println("The following accounts of the customer have also been removed.");

                
                   for(int i = savings.size()-1; i >= 0 ; i--) {
                       Saving curSaving = savings.get(i);
                       if(curSaving.getPerson().getUserName().equals(custId)) {
                           System.out.println(curSaving.toString());
                           savings.remove(curSaving);
                       }
                   }

                for(int i = checkings.size()-1; i >= 0 ; i--) {
                       Checking curChecking = checkings.get(i);
                       if(curChecking.getPerson().getUserName().equals(custId)) {
                           System.out.println(curChecking.toString());
                           checkings.remove(curChecking);
                       }
                   }

                for(int i = cds.size()-1; i >= 0 ; i--) {
                       CD curCD = cds.get(i);
                       if(curCD.getPerson().getUserName().equals(custId)) {
                           System.out.println(curCD.toString());
                           cds.remove(curCD);
                       }
                   }
                customers.remove(getCustomer(custId));
                break;

        }
    }

}

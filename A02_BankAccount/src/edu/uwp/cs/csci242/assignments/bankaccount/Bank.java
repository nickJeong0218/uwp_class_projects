package edu.uwp.cs.csci242.assignments.bankaccount;

/**
 * This class will give all information to make a bank account except id, and run for fictional person.
 * <p>
 *     Bank class will have 7 class-variables: 1 customer, 3 account name and 3 balances.
 *     Also, it will instantiate an object from each class: Checking, Savings and CollegeSavings.
 *     This class will also have 2 methods: main(String [] args) and printBalances().
 *     In the main method, it will have bank transaction records for fictional person.
 *     In printBalances(), there will be a formatted output to print out 3 bank accounts: Checking, CollegeSavings, Savings.
 * </p>
 * <p>
 *     This class will invoke printBalances() method in the main method after each transaction.
 *     Some methods in classes that instantiates objects throw exceptions, the main method, which is like a main driver, will catch all the exceptions.
 *     There will be 6 instance transactions for a fictional customer.
 * </p>
 * @author YunHwan Jeong
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs none
 */
public class Bank {

    /*
    This variable is a class variable that holds a customer's name.
     */
    private static final String NAME = "Jared Burgess";

    /*
    This variable is a class variable that holds a account's name.
     */
    private static final String NAME_FOR_ACCOUNT1 = "Checking";

    /*
    This variable is a class variable that holds a account's name.
     */
    private static final String NAME_FOR_ACCOUNT2 = "College savings";

    /*
    This variable is a class variable that holds a account's name.
     */
    private static final String NAME_FOR_ACCOUNT3 = "Savings";

    /*
    This variable is a class variable that holds a balance of an account.
     */
    private static final double BALANCE_FOR_ACCOUNT1 = 2000;

    /*
    This variable is a class variable that holds a balance of an account.
     */
    private static final double BALANCE_FOR_ACCOUNT2 = 10000;

    /*
    This variable is a class variable that holds a balance of an account.
     */
    private static final double BALANCE_FOR_ACCOUNT3 = 1000;

    /*
    This is a Checking object that gets 3 of class variables as parameters.
     */
    public static Checking myChecking = new Checking(NAME, NAME_FOR_ACCOUNT1, BALANCE_FOR_ACCOUNT1);

    /*
    This is a Savings object that gets 3 of class variables as parameters except used variables ( customer is one and only ).
     */
    public static Savings mySavings = new Savings(NAME, NAME_FOR_ACCOUNT3, BALANCE_FOR_ACCOUNT3);

    /*
    This is a Savings object that gets 3 of class variables as parameters except used variables ( customer is one and only ).
     */
    public static CollegeSavings myCollegeSavings = new CollegeSavings(NAME, NAME_FOR_ACCOUNT2, BALANCE_FOR_ACCOUNT2);

    /**
     * This method will be used to task all the other classes.
     * <p>
     *     The main method will make 6 transactions on purpose to test this project.
     *     Whenever the transaction is done, it will invoke printBalances() method to print out the result.
     *     To run main method, it will use class-level objects: myChecking, myCollegeSavings and mySavings.
     * </p>
     * <p>
     *     In the method, there are calling the methods that throw exceptions. So it will use 'try-catch' blocks to catch exceptions.
     *     Also, there will be a few numeric variables. Those are given values to text the project.
     * </p>
     * @param args
     */
    public static void main(String [] args) {

        // Invoke printBalances() to display the result.
        printBalances();

        /* 1st transaction starts. */

        // Initialize a variable for paying check.
        double payCheck = 5000;

        // Show the pay check value in output following the format.
        System.out.printf("Got a paycheck: $%,.2f", payCheck);
        System.out.println("  1000 in college savings, then half in savings & half in checking.");

        // Make a try-catch block due to the exceptions.
        try {
            myCollegeSavings.deposit(1000);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // Initialize a variable for left paying check.
        double leftPayCheck = payCheck - 1000;

        // Make a try-catch block due to the exceptions.
        try {
            mySavings.deposit(leftPayCheck / 2);
            myChecking.deposit(leftPayCheck / 2);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // Invoke printBalances() to display the result.
        printBalances();

        /* 1st transaction done. */


        /* 2nd transaction starts. */

        // Indicate that 2nd transaction is for interest.
        System.out.println("Time for interest!.");

        // Make a try-catch block due to the exceptions.
        try {
            myChecking.applyInterest(1);
            myCollegeSavings.applyInterest(1, 12);
            mySavings.applyInterest(1, 12);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // Invoke printBalances() to display the result.
        printBalances();

        /* 2nd transaction done. */


        /* 3rd transaction starts. */

        // Start 3rd transaction: withdrawing money from Checking.
        System.out.println("Write some bills...");

        // Initialize a variable for house mortgage.
        double houseMortgage1 = 150;

        // Make a try-catch block due to the exceptions.
        try {
            myChecking.writeCheck(houseMortgage1);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // Show the house mortgage in output following the format.
        System.out.printf("> House mortgage, $%,.2f...\n", houseMortgage1);

        // Initialize a variable for house mortgage.
        double houseMortgage2 = 1975.45;

        // Make a try-catch block due to the exceptions.
        try {
            myChecking.writeCheck(houseMortgage2);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // Show the house mortgage in output following the format.
        System.out.printf("> House mortgage, $%,.2f...\n", houseMortgage2);

        // Initialize a variable for gas & electric.
        double gasAndElectric = 145.68;

        // Make a try-catch block due to the exceptions.
        try {
            myChecking.writeCheck(gasAndElectric);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // Show the gas & electric fee in output following the format.
        System.out.printf("> Gas and electric, $%,.2f...\n", gasAndElectric);

        // Initialize a variable for water.
        double water = 60.34;

        // Make a try-catch block due to the exceptions.
        try {
            myChecking.writeCheck(water);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // Show the price for water in output following the format.
        System.out.printf("> Water, $%,.2f...\n", water);

        // Initialize a variable for TV/Internet/Phone.
        double electronicDevice = 277.45;

        // Make a try-catch block due to the exceptions.
        try {
            myChecking.writeCheck(electronicDevice);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // Show the electronic fee in output following the format.
        System.out.printf("> TV/Internet/phone, $%,.2f...\n", electronicDevice);


        // Invoke printBalances() to display the result.
        printBalances();

        /* 3rd transaction done. */


        /* 4th transaction starts. */

        // Show that 4th transaction will be about living life.
        System.out.println("Live life...");

        // Initialize a variable for groceries.
        double groceries = 226.9;

        // Make a try-catch block due to the exceptions.
        try {
            myChecking.writeCheck(groceries);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // Show the groceries in output following the format.
        System.out.printf("> Groceries, $%,.2f...\n", groceries);

        // Initialize a variable for going out at night.
        double nightOut = 177.8;

        // Make a try-catch block due to the exceptions.
        try {
            myChecking.writeCheck(nightOut);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // Show the night going out in output following the format.
        System.out.printf("> Night out, $%,.2f...\n", nightOut);

        // Initialize a variable for fixing car.
        double fixCar = 733.66;

        // Make a try-catch block due to the exceptions.
        try {
            myChecking.writeCheck(fixCar);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // Show the fixing car pay in output following the format.
        System.out.printf("> Fix car, $%,.2f...\n", fixCar);

        // Invoke printBalances() to display the result.
        printBalances();

        /* 4th transaction done. */


        /* 5th transaction starts. */

        // Initialize a variable for vacation..
        double forVacation = 4000;

        // Show the vacation budget in output following the format.
        System.out.printf("> Vacation, $%,.2f...\n", forVacation);

        // Make a try-catch block due to the exceptions.
        try{
            myChecking.writeCheck(forVacation);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // Print out the shortage of the balance in Checking and Savings.
        System.out.println("> Not enough in checking+savings... Take from college fund at a penalty...");

        // Initialize a variable for possible amount in Savings.
        double availableAmount = 3000;

        // Make a try-catch block due to the exceptions.
        try {
            mySavings.withdraw(availableAmount);
            myCollegeSavings.withdraw(forVacation - availableAmount);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // Display that going vacation is possible.
        System.out.println("> Funds available... going on vacation!");

        // Invoke printBalances() to display the result.
        printBalances();

        /* 5th transaction done. */


        /* 6th transaction starts. */

        // Initialize a variable for tuition.
        double tuition = 8000;

        // Show the tuition fee in output following the format.
        System.out.printf("> Tuition, $%,.2f...\n", tuition);

        // Make a try-catch block due to the exceptions.
        try {
            myCollegeSavings.withdrawForCollege(tuition);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // Invoke printBalances() to display the result.
        printBalances();

        /* 6th transaction done. */
    }

    /**
     * This method will make a format for printing out the bank account information.
     * <p>
     *     This method will use 3 class-level objects by invoking toString() methods from each classes.
     *     With returned strings from the objects, it will add more strings and characters to make output more formatted.
     *     The format of the account information is 5 lines, and has boundaries to be split with other letters.
     * </p>
     */
    public static void printBalances() {

        // Start the form with the customer's name and some boundary characters.
        System.out.println("+-- Customer: " +  myChecking.getCustomer() + " ---");

        // Print out the Checking account info first.
        System.out.println("| Current balance of checking " + myChecking.toString());

        // Print out the CollegeSavings account info second.
        System.out.println("| Current balance of college savings " + myCollegeSavings.toString());

        // Print out the Savings account info third.
        System.out.println("| Current balance of savings " + mySavings.toString());

        // Print out boundary at last.
        System.out.println("+-----------------------------");
    }
}

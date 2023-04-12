package edu.uwp.cs.csci242.assignments.bankaccount;

/**
 * This class will be used for making a Savings account.
 * <p>
 *     The Savings class will make a Savings account extending the Account class.
 *     There is no instance variable, because this class will use instance variables which are inherited from Account class.
 *     As a result of inheritance, all the instance methods will also be assumed existed.
 *     Also, this class will have 2 constructors that one is default and the other one gets 3 parameters, similar to the Account constructors.
 * </p>
 * <p>
 *     This Savings class will extend Account class to get attributes and methods from the Account class.
 *     Additionally, there will be 2 methods: applyInterest() and getInterest().
 *     Savings class will use applyInterest() and getInterest() methods to calculate interest for savings account.
 * </p>
 * @author YunHwan Jeong
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs none
 */
public class Savings extends Account {

    /**
     * This constructor is a default, no-arg, constructor.
     * <p>
     *     This Savings constructor has a super class caller: super() implicitly and automatically.
     *     Therefore, even if it looks like it has nothing, it has an instance variable from Account class, id.
     *     Likewise the default constructor in Account class, the other instance variables are not initialized.
     * </p>
     */
    public Savings() {
    }

    /**
     * This constructor is a parameterized constructor, initializing all instance variables.
     * <p>
     *     This constructor will have 3 parameters, which are a customer's name, a account's name, and a balance of an account.
     *     By using a super class caller, this constructor works almost same as the constructor in Account class.
     *     Therefore, these 3 parameters will be sent to the Account parameterized constructor, and they will be used in the same way in that constructor.
     * </p>
     * <p>
     *     When this constructor uses the super class caller, it should be used in explicit way.
     *     That is because for this Savings constructor, it wants to use the parameters. Therefore, it needs to use parameterized caller, not a default caller.
     * </p>
     * @param customerParam This parameter indicates the name of a customer which is one of the instance variables.
     * @param nameParam This parameter indicates the name of a bank account which is one of the instance variables.
     * @param balanceParam This parameter indicates the amount of budget in a back account. It will be 'double' data type to be floating point as mentioned in class diagram.
     */
    public Savings(String customerParam, String nameParam, double balanceParam) {

        // Invoke super class's constructor to inherit parameterized constructor in Account class, which is a super class.
        super(customerParam, nameParam, balanceParam);
    }

    /**
     * This method will get the interest of Savings account in specific way.
     * <p>
     *     To get the interest for the Savings accounts, this method will use a property of Interest class.
     *     To use the property of that class, this method will instantiate an object of the Interest class.
     *     Then, it will initialize a double data type variable to use as a interest holder.
     * </p>
     * <p>
     *     To invoke the proper method: compound(), to Savings account in Interest class, for calculating,
     *     this method needs to give 4 arguments: principal, interesting rate, times per a year and count.
     *     principal is gotten from getter in Account class, and the count and times per a year are same as the parameters.
     *     Therefore, it will need to initialize a variable for interesting rate by giving set value.
     *     After calculating the interest invoking the method from Interest class, it will return the variable that holds the interest.
     * </p>
     * @param periodParam This parameter indicates how many times the interest will be calculated.
     * @param timesPerYearParam This parameter indicates how many times the interest will be calculated in a year.
     * @return It will return a double data type variable that holds the amount of interest.
     */
    public double getInterest(int periodParam, int timesPerYearParam) {

        // Instantiate an object of Interest.
        Interest interCheck = new Interest();

        // Initialize a variable with formatted rate for interest of checking account.
        double rateForInterest =  0.0125;

        // Invoke a proper method to calculate the interest.
        double savingsInterest = interCheck.compound(getBalance(), rateForInterest,timesPerYearParam, periodParam);

        return savingsInterest;             // Return the double variable: checkingInterest.
    }

    /**
     * This method will apply the interest to the original balance.
     * <p>
     *     This method will get the amount of the interest of the balance from getInterest() method.
     *     Using the parameters as arguments to invoke this method, this method will initialize a variable to hold the amount of the interest.
     *     This method will initialize one more variable to return total balance after applying the interest.
     *     For new variable, it will give the sum of the original balance and the interest from getInterest() method.
     * </p>
     * <p>
     *     Actually, this method needs to modify the balance, it will invoke deposit() method to add the amount of the interest to the balance of the account.
     *     Additionally, it will return the addition of original balance and the calculated interest.
     * </p>
     * @param periodParam This parameter indicates how many times the interest will be calculated.
     * @param timesPerYearParam This parameter indicates how many times the interest will be calculated in a year.
     * @return It will return a double data type variable which holds the sum of the balance and the interest.
     */
    public double applyInterest(int periodParam, int timesPerYearParam) {

        // Initialize a variable to hold the amount of interest that calculated in getInterest() method.
        double savingsInterest = getInterest(periodParam, timesPerYearParam);

        // Initialize a variable to hold the sum of original balance and the interest.
        double balanceWithInterest = getBalance() + savingsInterest;

        // Invoke deposit() method to modify account balance actually.
        this.deposit(savingsInterest);

        return balanceWithInterest;             // Return a double variable: balanceWithInterest.
    }
}
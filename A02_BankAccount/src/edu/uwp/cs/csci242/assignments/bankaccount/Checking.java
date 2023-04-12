package edu.uwp.cs.csci242.assignments.bankaccount;

/**
 * This class will be used for making a Checking account.
 * <p>
 *     The Checking class will make a checking account extending the Account class.
 *     There is no instance variable, because this class will use instance variables which are inherited from Account class.
 *     As a result of inheritance, all the instance methods will also be assumed existed.
 *     Also, this class will have 2 constructors that one is default and the other one gets 3 parameters, similar to the Account constructors.
 * </p>
 * <p>
 *     This Checking class will extend Account class to get attributes and methods from the Account class.
 *     Additionally, there will be 3 methods: applyInterest(), getInterest() and writeCheck().
 *     Checking class will use applyInterest() and getInterest() methods to calculate interest for checking account,
 *     and it will use writeCheck() method to withdraw budget in this checking account.
 *     Due to the withdraw() method in Account class, this class can throw an exception: IllegalArgumentException.
 *     The reason why it has the possibility to throw an exception is because writeCheck() class will call withdraw() method.
 * </p>
 * @author YunHwan Jeong
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs none
 */
public class Checking extends Account{

    /**
     * This constructor is a default, no-arg, constructor.
     * <p>
     *     This Checking constructor has a super class caller: super() implicitly and automatically.
     *     Therefore, even if it looks like it has nothing, it has an instance variable from Account class, id.
     *     Likewise the default constructor in Account class, the other instance variables are not initialized.
     * </p>
     */
    public Checking() {
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
     *     That is because for this Checking constructor, it wants to use the parameters. Therefore, it needs to use parameterized caller, not a default caller.
     * </p>
     * @param customerParam This parameter indicates the name of a customer which is one of the instance variables.
     * @param nameParam This parameter indicates the name of a bank account which is one of the instance variables.
     * @param balanceParam This parameter indicates the amount of budget in a back account. It will be 'double' data type to be floating point as mentioned in class diagram.
     */
    public Checking(String customerParam, String nameParam, double balanceParam) {

        // Invoke super class's constructor to inherit parameterized constructor in Account class, which is a super class.
        super(customerParam, nameParam, balanceParam);
    }

    /**
     * This method will get the interest of checking account in specific way.
     * <p>
     *     To get the interest for the checking accounts, this method will use a property of Interest class.
     *     To use the property of that class, this method will instantiate an object of the Interest class.
     *     Then, it will initialize a double data type variable to use as a interest holder.
     * </p>
     * <p>
     *     Before get the interest, this method will check one condition: either the balance of the account is greater than or equal to 700 dollars.
     *     To check the condition, it will use an 'if-statement'. If the balance is proper to get the interest, it will use a proper method in Interest class.
     *     To invoke the proper method: simple(), to checking account in Interest class, this method needs to give 3 arguments: principal, interesting rate and count.
     *     principal is gotten from getter in Account class, and the count is same as the parameter.
     *     Therefore, it will need to initialize a variable for interesting rate by giving set value.
     *     After calculating the interest invoking the method from Interest class, it will return the variable that holds the interest.
     * </p>
     * @param timesParam This parameter indicates how many times the interest will be calculated.
     * @return It will return a double data type variable that holds the amount of interest.
     */
    public double getInterest(int timesParam) {

        // Instantiate an object of Interest.
        Interest interCheck = new Interest();

        // Initialize a double data type variable to hold the amount of the interest.
        double checkingInterest = 0;

        // Use an if-statement to determine whether the balance is in a good condition to get interest.
        if(getBalance() >= 700) {
            double rateForInterest = 0.02;      // Initialize a variable with formatted rate for interest of checking account.

            // Invoke a proper method to calculate the interest.
            checkingInterest = interCheck.simple(getBalance() - 700, rateForInterest, timesParam);
        }

        return checkingInterest;                // Return the double variable: checkingInterest.
    }

    /**
     * This method will apply the interest to the original balance.
     * <p>
     *     This method will get the amount of the interest of the balance from getInterest() method.
     *     Using the parameter as an argument to invoke this method, this method will initialize a variable to hold the amount of the interest.
     *     This method will initialize one more variable to return total balance after applying the interest.
     *     For new variable, it will give the sum of the original balance and the interest from getInterest() method.
     * </p>
     * <p>
     *     Actually, this method needs to modify the balance, it will invoke deposit() method to add the amount of the interest to the balance of the account.
     *     Additionally, it will return the addition of original balance and the calculated interest.
     * </p>
     * @param timesParam This parameter indicates how many times the interest will be calculated.
     * @return It will return a double data type variable which holds the sum of the balance and the interest.
     */
    public double applyInterest(int timesParam) {

        // Initialize a variable to hold the amount of interest that calculated in getInterest() method.
        double checkingInterest = getInterest(timesParam);

        // Initialize a variable to hold the sum of original balance and the interest.
        double balanceWithInterest = getBalance() + checkingInterest;

        // Invoke deposit() method to modify account balance actually.
        this.deposit(checkingInterest);

        return balanceWithInterest;             // Return a double variable: balanceWithInterest.
    }

    /**
     * This method will subtract some amount from the balance of the account.
     * <p>
     *     This method will get a parameter for the amount of check.
     *     Before just writing a check, it will check whether the amount for check is available or not.
     *     Therefore, it will use an ' if-statement' to determine the condition.
     *     If the amount for check is larger than account balance, then it will throw an exception: IllegalArgumentException.
     *     Or if the check amount is possible to check out, it will invoke withdraw() method to subtract as much as the parameter.
     *     After checking and calculating, it will return the amount of check.
     * </p>
     * @param amountParam This parameter indicates the amount for check out.
     * @return It will return the amount of check out.
     * @throws IllegalArgumentException This exception will be thrown if the amount for check out is greater than balance of the account.
     */
    public double writeCheck(double amountParam) throws IllegalArgumentException {

        // Initialize a variable to hold the amount of check-out.
        double check = amountParam;

        // Use an if-statement to check whether the check-out amount is available or not. if not, throw an exception.
        if(check > getBalance()) {
            throw new IllegalArgumentException("> Funds not available... Must transfer...");
        }

        // If the check out amount is possible to do that, invoke withdraw() to check out as much as the value that check-out variable holds.
        else {
            withdraw(check);
        }

        return check;           // Return a double variable: check.
    }
}

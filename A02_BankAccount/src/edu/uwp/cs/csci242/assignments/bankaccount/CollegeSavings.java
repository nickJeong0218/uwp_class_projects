package edu.uwp.cs.csci242.assignments.bankaccount;

/**
 * This class will be used for making a College savings account.
 * <p>
 *     The CollegeSavings class will make a CollegeSavings account extending the Savings class.
 *     There is no instance variable, because this class will use instance variables which are inherited from Savings class.
 *     And the Savings class inherits the Account class. Therefore, this class use instance variables in Account class.
 *     As a result of inheritance, all the instance methods will also be assumed existed.
 *     Also, this class will have 2 constructors that one is default and the other one gets 3 parameters, similar to the Account constructors.
 * </p>
 * <p>
 *     This CollegeSavings class will extend Savings class to get attributes and methods from the Savings class.
 *     Additionally, there will be 2 methods: withdraw() and withdrawForCollege().
 *     The withdraw() method will override the method in Account class to withdraw some budget from the account. This is same.
 *     However, it has a difference with the withdraw() method in Account class. It will calculate a penalty for the withdraw() in this class.
 *     withdrawForCollege() method is almost same as the withdraw() method in Account class.
 * </p>
 * @author YunHwan Jeong
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs none
 */
public class CollegeSavings extends Savings {

    /**
     * This constructor is a default, no-arg, constructor.
     * <p>
     *     This CollegeSavings constructor has a super class caller: super() implicitly and automatically.
     *     Therefore, even if it looks like it has nothing, it has an instance variable from Savings class.
     *     Likewise the default constructor in Savings class, the other instance variables are not initialized.
     * </p>
     */
    public CollegeSavings() {
    }

    /**
     * This constructor is a parameterized constructor, initializing all instance variables.
     * <p>
     *     This constructor will have 3 parameters, which are a customer's name, a account's name, and a balance of an account.
     *     By using a super class caller, this constructor works almost same as the constructor in Savings class.
     *     Therefore, these 3 parameters will be sent to the Savings parameterized constructor, and they will be used in the same way in that constructor.
     * </p>
     * <p>
     *     When this constructor uses the super class caller, it should be used in explicit way.
     *     That is because for this CollegeSavings constructor, it wants to use the parameters. Therefore, it needs to use parameterized caller, not a default caller.
     * </p>
     * @param customerParam This parameter indicates the name of a customer which is one of the instance variables.
     * @param nameParam This parameter indicates the name of a bank account which is one of the instance variables.
     * @param balanceParam This parameter indicates the amount of budget in a back account. It will be 'double' data type to be floating point as mentioned in class diagram.
     */
    public CollegeSavings(String customerParam, String nameParam, double balanceParam) {

        // Invoke super class's constructor to inherit parameterized constructor in Savings class, which is a super class.
        super(customerParam, nameParam, balanceParam);
    }

    /**
     * This method will withdraw money from the CollegeSavings balance.
     * <p>
     *     It will override a method in Account class, because the Account class, which is the super-class of this class has a method same with this method.
     *     Therefore, before coding the method, indicate the overriding using @.
     * </p>
     * <p>
     *     This withdraw() method will charge a penalty: 10% of withdraw. Therefore, before withdraw the amount of parameter, it will calculate the amount of the penalty.
     *     Then, the calculated amount will be set to a new variable with the amount of the parameter. Also, the left-over amount will be set to the other new variable.
     *     After setting values, it will invoke a withdraw() method from Account class, so when in invokes the withdraw() method, it need a reserve word: super.
     *     Finally, it will return the left-over amount.
     * </p>
     * @param amountParam This parameter indicates the amount of money to be withdrawn in the account.
     * @return It will return a balance after withdrawing.
     * @throws IllegalArgumentException This exception will be throw if the withdraw() in Account decides to throw an exception.
     */
    @Override
    public double withdraw(double amountParam) throws IllegalArgumentException {

        // Initialize a variable to calculate and hold the penalty.
        double penalty = (0.1 * amountParam);

        // Initialize a variable to hold the sum of the amount to withdraw and penalty.
        double totalWithdraw = amountParam + penalty;

        // Initialize a variable to hold the left amount in balance.
        double leftInBalance = getBalance() - totalWithdraw;

        // Invoke the withdraw() method from Account class, which is a super class.
        super.withdraw(totalWithdraw);

        return leftInBalance;           // Return a double variable: leftInBalance.
    }

    /**
     * This method will subtract some amount from the balance of the account.
     * <p>
     *     This method will get a parameter for the amount of withdraw. It will initialize a variable to hold left balance, because it wants to return the left amount.
     *     Then, it will invoke a withdraw() method from Account class, so when in invokes the withdraw() method, it need a reserve word: super.
     *     Also, it will return the left amount in balance.
     * </p>
     * @param amountParam This parameter indicates the amount of money to be withdrawn in the account.
     * @return It will return a balance after withdrawing.
     * @throws IllegalArgumentException This exception will be throw if the withdraw() in Account decides to throw an exception.
     */
    public double withdrawForCollege(double amountParam) throws IllegalArgumentException {

        // Initialize a vairable to hold the left amount in balance.
        double leftInBalance = getBalance() - amountParam;

        // Invoke the withdraw() method from Account class, which is a super class.
        super.withdraw(amountParam);

        return leftInBalance;           // Return a double variable: leftInBalance.
    }
}

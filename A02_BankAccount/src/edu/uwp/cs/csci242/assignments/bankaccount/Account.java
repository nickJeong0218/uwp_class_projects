package edu.uwp.cs.csci242.assignments.bankaccount;

/**
 * This class will be used for making an account.
 * <p>
 *      The Account class will make an account which is a basis of all sub-accounts.
 *      There are 4 instance variables: balance, customer, id and name. These 4 instance variables are characteristics of the account.
 *      All the instance variables will have getters, but except the 'balance' and 'id', all the other instance variables have setters.
 *      For, 'balance', it will have 2 special methods: deposit() and withdraw(). The 'id' will have an unique private method: makeId().
 *      Except these methods, the class will have 2 more methods: isAmountAvailable() and toString() to do their own functions.
 *      Also, this class will have 2 constructors that one is default and the other one gets 3 parameters.
 * </p>
 * <p>
 *     This class will mainly be used to be extended from subclasses: Checking and Savings class.
 *     When it is instantiated or extended, it can throw an exception.
 *     The deposit() and withdraw() methods will throw an exception: IllegalArgumentException.
 *     To check whether they throw an exception or not, the isAmountAvailable() method will return a boolean value to those 2 methods.
 *     Additionally, this class will have the toString() method to display the information of an account.
 * </p>
 * @author YunHwan Jeong
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs none
 */
public class Account {

    /*
    This variable is an instance variable that holds the amount of money in an account.
     */
    private double balance;

    /*
    This variable is an instance variable that holds the name of a customer.
     */
    private String customer;

    /*
    This variable is an instance variable that holds the id of an account, which consists of 10 digits.
     */
    private String id;

    /*
    This variable is an instance variable that holds the name of an account, for instance, Checking or Savings.
     */
    private String name;

    /**
     * This constructor is a default, no-arg, constructor, initializing only id.
     * <p>
     *     This Account constructor will not have any parameters. It will initialize only one instance variable: id, using makeId() method.
     *     To initialize the instance variable, it will invoke makeId() method giving the size value which is the format: 10.
     *     Therefore, this constructor will not have any initialized instance variable, except 'id'.
     * </p>
     */
    public Account() {
        this.id = makeId(10);       // Invoke a method that makes an id with given size and set that id to the instance variable using 'dot-notation'.
    }

    /**
     * This constructor is a parameterized constructor, initializing all instance variables.
     * <p>
     *     This constructor will have 3 parameters, which are a customer's name, a account's name, and a balance of an account.
     *     For 2 string-object parameters, this Account constructor will invoke 2 methods: setCustomer() and setName().
     *     For the one left parameter, it will not use the setter for that instance variable.
     *     That's because there is no setter for 'balance', according to the class diagram.
     *     Instead of using setter, the constructor will use 'dot-notation' to initialize the instance variable, balance.
     * </p>
     * <p>
     *     After setting all the instance variables using parameters, there is one left instance variable, id.
     *     For this instance variable, id, likewise the default constructor, this constructor will invoke makeId() method.
     *     When it calls the method, it will also give an argument to format the id. The actual parameter is 10.
     * </p>
     * @param customerParam This parameter indicates the name of a customer which is one of the instance variables.
     * @param nameParam This parameter indicates the name of a bank account which is one of the instance variables.
     * @param balanceParam This parameter indicates the amount of budget in a back account. It will be 'double' data type to be floating point as mentioned in class diagram.
     */
    public Account(String customerParam, String nameParam, double balanceParam) {
        setCustomer(customerParam);             // Invoke a setter to set the name of a customer.
        setName(nameParam);                     // Invoke a setter to set the name of an account.
        this.balance = balanceParam;            // Use the 'dot-notation' to set instance variable, balance, as same as the parameter for balance.
        this.id = makeId(10);         // Invoke a method that makes an id with given size and set that id to the instance variable using 'dot-notation'.
    }

    /**
     * This method will deposit money in the balance of the account.
     * <p>
     *     Before depositing the given amount, this method will check one condition.
     *     The condition that has to be checked is whether the given amount to deposit is available or not.
     *     If the amount that customer wants to deposit is unavailable, then this method will throw an exception, which is IllegalArgumentException.
     * </p>
     * <p>
     *     To check the given amount which is a parameter, it will invoke a method that returns a boolean value.
     *     After checking, if the amount that would like to be deposited is available, it will add the value of the parameter to the balance.
     *     Finally, it will return the final balance after checking and depositing.
     * </p>
     * @param amountParam This parameter indicates the amount of money to be deposited in the account.
     * @return It will return a instance variable, balance, either it is addition of the parameter and original balance or not.
     * @throws IllegalArgumentException This exception will be thrown if the boolean value from isAmountAvailable() method is false.
     */
    public double deposit(double amountParam) throws IllegalArgumentException {

        // Determine whether the boolean value to check the amount is true or false. If the boolean value is false, then throw an exception.
        if(!isAmountAvailable(amountParam)) {
            throw new IllegalArgumentException("> Can not deposit less than $1...");
        }

        // If the boolean value for checking the amount is true, then add that amount to the balance.
        else {
            this.balance += amountParam;
        }

        return balance;         // Return the instance variable: balance.
    }

    /**
     * This method will withdraw money in the balance of the account.
     * <p>
     *     Before withdrawing the given amount, this method will check one condition.
     *     The condition that has to be checked is whether the given amount to deposit is available or not.
     *     If the amount that customer wants to deposit is unavailable, then this method will throw an exception, which is IllegalArgumentException.
     * </p>
     * <p>
     *     To check the given amount which is a parameter, it will invoke a method that returns a boolean value.
     *     After checking, if the amount that would like to be withdrawn is available, it will subtract the value of the parameter from the balance.
     *     Finally, it will return the final balance after checking and withdrawing.
     * </p>
     * @param amountParam This parameter indicates the amount of money to be withdrawn in the account.
     * @return It will return a instance variable, balance, either it is subtraction of original balance and the parameter or not.
     * @throws IllegalArgumentException This exception will be thrown if the boolean value from isAmountAvailable() method is false.
     */
    public double withdraw(double amountParam) throws IllegalArgumentException {

        // Determine whether the boolean value to check the amount is true or false. If the boolean value is false, then throw an exception.
        if(!isAmountAvailable(amountParam)) {
            throw new IllegalArgumentException("> Can not withdraw less than $1...");
        }

        // If the boolean value for checking the amount is true, then subtract that amount from the balance.
        else {
            this.balance -= amountParam;
        }

        return balance;         // Return the instance variable: balance.
    }

    /**
     * This method will check whether the amount to use is available or not.
     * <p>
     *     It will get an argument which is the amount of money to use. Before check the amount, it will initialize a boolean variable as 'false'.
     *     Then, by using an 'if-statement', this method will determine if the amount of money to use is less than 1 dollar.
     *     If the amount given as the parameter is greater than or equal to 1, the boolean variable will change its value into 'true'.
     *     After determining the boolean value, this method will return the boolean variable which was used to check the amount.
     * </p>
     * @param amountParam This parameter indicates the amount of money which needs to be checked.
     * @return It will return a boolean variable that was used to check the amount.
     */
    public boolean isAmountAvailable(double amountParam) {

        // Initialize a boolean variable which will be returned as 'false'.
        boolean isAvailable = false;

        // Use an if-statement to check whether the amount of the parameter is available or not.
        // If the amount is possible to use, set the boolean variable as 'true',
        if (amountParam >= 1.00) {
            isAvailable = true;
        }

        return isAvailable;         // Return the boolean variable: isAvailable.
    }

    /**
     * This method will make an id.
     * <p>
     *     The makeId() methods will have 'private' visibility modifier. That is because the id is the most important component of the account.
     *     Also, the id is basically given by the bank, and permanent for the account.
     *     Therefore, it doesn't want to be shown in other sections, and be made in other classes, for example, sub-classes.
     * </p>
     * <p>
     *     To make an id, this method will declare a StringBuilder object.
     *     With the parameter which shows the length of the id, it will use a 'while-loop' to make the id as long as the given size.
     *     So, until the temporary id, a StringBuilder object, is shorter than the given length,
     *     the method will fill it out with a random integer by using Java's random object.
     *     After the temporary id becomes same length with the given length, this method will change the temporary id to a String object to return.
     *     Finally, it will return the id variable which the object type was changed.
     * </p>
     * @param sizeParam This parameter indicates the required length of the id.
     * @return It will return the instance variable, id, after getting a proper string.
     */
    private String makeId(int sizeParam) {

        // Declare a StringBuilder object.
        StringBuilder tempId = new StringBuilder();

        // Use a while loop to make the id have same length with required length, which is the parmeter.
        while (tempId.length() < sizeParam) {

            // Use the append() method to fill in the StringBuilder object, temporary id.
            tempId.append((int)((Math.random()*10)));
        }

        // Use the toString() method to change final id to the String object.
        this.id = tempId.toString();

        return this.id;         // Return the instance variable: id.
    }

    /**
     * This method will contain the information of an account, except customer's name, in a line.
     * <p>
     *     It will override a method in Object class, because the Object class, which is the super-class of this class has a method same with this method.
     *     Therefore, before coding the method, indicate the overriding using @.
     * </p>
     * <p>
     *     This method will have a formatted string to inform the bank accounts.
     *     For the balance information, it should be in a specific form. Therefore, this method will use format() method in String class to make the form for balance.
     *     Then, a string will be made by combining the string about the balance with the other information in the specific and required form.
     *     It will return the string that has all information at the end.
     * </p>
     * @return It will return a string object that contains all values of all instance variable but not for customer.
     */
    @Override
    public String toString() {

        // Initialize a string that will have the balance of the account.
        String textForBalance = String.format("$%,.2f", getBalance());

        // Initialize a string combining balance informing string and other instance variables in a specific form.
        String allInfo = "[" + getId() + "], '" + getName() + "' is: " + textForBalance;

        return allInfo;         // Return the string object: allInfo.
    }

    /**
     * This method is an instance method which is a getter, and it will return the instance variable, balance.
     * @return It will return a double data-type value which is held by balance, instance variable.
     */
    public double getBalance() {
        return balance;         // Return the instance variable: balance.
    }

    /**
     * This method is an instance method which is a getter, and it will return the instance variable, customer.
     * @return It will return a string that the instance variable, customer, holds.
     */
    public String getCustomer() {
        return customer;        // Return the instance variable: customer.
    }

    /**
     * This method is an instance method which is a getter, and it will return the instance variable, id.
     * @return It will return a string that the instance variable, id, holds.
     */
    public String getId() {
        return id;              // Return the instance variable: id.
    }

    /**
     * This method is an instance method which is a getter, and it will return the instance variable, name.
     * @return It will return a string that the instance variable, name, holds.
     */
    public String getName() {
        return name;
    }

    /**
     * This method will get a String object as a parameter, and give the parameter to customer, which is an instance variable.
     * @param customerParam This parameter is a String object, and it will be used to set the instance variable, customer.
     */
    public void setCustomer(String customerParam) {
        this.customer = customerParam;          // Set the instance variable, customer, as same as the parameter.
    }

    /**
     * This method will get a String object as a parameter, and give the parameter to name, which is an instance variable.
     * @param nameParam This parameter is a String object, and it will be used to set the instance variable, name.
     */
    public void setName(String nameParam) {
        this.name = nameParam;                  // Set the instance variable, name, as same as the parameter.
    }
}
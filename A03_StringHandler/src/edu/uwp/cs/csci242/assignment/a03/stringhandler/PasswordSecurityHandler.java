package edu.uwp.cs.csci242.assignment.a03.stringhandler;

/**
 * This class will be used for checking the security level of the passwords.
 * <p>
 *     This PasswordSecurityHandler class will implement StringHandler interface.
 *     This class will check the security level of a string for a password.
 *     There will be 3 class constants to represent security level: SECURITY_LEVEL_WEAK, SECURITY_LEVEL_MEDIUM and SECURITY_LEVEL_STRONG.
 *     In addition, there are 3 instance variable: length, digit and otherCharacter.
 *     Two constructors exist in the class: default and parameterized
 *     There will be also 3 getters and 3 setters, 3 processors due to implementing the StringHandler interface, securityLevel() and toString().
 * </p>
 * <p>
 *     This class will determine a password's security level in 3 parts: weak, medium and strong.
 *     To determine security level, this class will check the length of the string, which is same as the password, and the boolean values for digit and other character.
 *     If the length of the password is less than 8, the security level of that password is "weak".
 *     Otherwise, this class will check whether the password has one of digit and other character or both of them to determine among "medium" and "strong".
 *     If the password have only one of them, then the security level is "medium". Or if the password have both of them,its level is "strong".
 *     For this process, this class will use 3 methods from the StringHandler interface to inspect each character to update instance variables.
 * </p>
 * @author YunHwan Jeong
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 3
 * @bugs none
 */
public class PasswordSecurityHandler implements StringHandler {

    /*
    This variable is a class variable that holds the indicator for weak security level.
     */
    public static final String SECURITY_LEVEL_WEAK = "weak";

    /*
    This variable is a class variable that holds the indicator for medium security level.
     */
    public static final String SECURITY_LEVEL_MEDIUM = "medium";

    /*
    This variable is a class variable that holds the indicator for strong security level.
     */
    public static final String SECURITY_LEVEL_STRONG = "strong";


    /*
    This variable is an instance variable that holds the length of the password.
     */
    private int length;

    /*
    This variable is an instance variable that holds the flag indicating whether a digit is in the password or not.
     */
    private boolean digit;

    /*
    This variable is an instance variable that holds the flag indicating whether an other character is in the password or not.
     */
    private boolean otherCharacter;


    /**
     * This constructor is a default, no-arg, constructor.
     */
    public PasswordSecurityHandler() {
    }

    /**
     * This constructor is a parameterized constructor, initializing all instance variables.
     * <p>
     *     This constructor will get a string as a parameter, which means a password.
     *     To initialize the instance variables, it will invoke getters for each variable.
     * </p>
     * @param stringParam This parameter indicates the password that will be checked by this class to get the security level.
     */
    public PasswordSecurityHandler(String stringParam) {
        this.length = getLength();                      // Invoke a getter to initialize the instance variable, length.
        this.digit = isDigit();                         // Invoke a getter to initialize the instance variable, digit.
        this.otherCharacter = isOtherCharacter();       // Invoke a getter to initialize the instance variable, otherCharacter.
    }


    /**
     * This method will be used to determine the security level for the given string.
     * <p>
     *     To determine the security level, it will check all instance variables.
     *     After checking, this securityLevel() method will return a string that indicate the security level.
     *     The string that will be returned will contain one of the constants.
     * </p>
     * <p>
     *     First, this method will check the length of the string.
     *     If the length is less than 8, then the security level will automatically be "weak".
     *     If the length of the string is 8 or more than 8, this method will check the instance variables: digit and otherCharacter.
     *     If both of digit and otherCharacter are true, then the security level of the string will be "strong", otherwise it will be "medium".
     * </p>
     * @return It will return a string that holds the security level of a string which means password.
     */
    public String securityLevel() {

        String securityLevel = "";                          // Initialize a string that will be returned.

        // Determine whether the length of the string is less than 8 or not.
        if(length >= 8) {

            // Determine whether the string has both a digit and an other character or not.
            if(digit && otherCharacter) {
                securityLevel = SECURITY_LEVEL_STRONG;      // Set the security level as SECURITY_LEVEL_STRONG.
            }
            else if(digit || otherCharacter) {
                securityLevel = SECURITY_LEVEL_MEDIUM;      // Set the security level as SECURITY_LEVEL_MEDIUM.
            }
        }
        else {
            securityLevel = SECURITY_LEVEL_WEAK;            // Set the security level as SECURITY_LEVEL_WEAK.
        }

        return securityLevel;                               // Return the string that holds the security level.
    }

    /**
     * This method will determine a character which is a digit.
     * <p>
     *     processDigit() method will override the method in the StringHandler interface.
     *     It will get a char data type variable as a parameter.
     *     This method will throw an exception if the character is not fit to the specified condition.
     * </p>
     * <P>
     *     This processDigit() will set the range to check the character. The range is between 0 and 9.
     *     If the parameter, character, is in the range, then the boolean instance variable, digit, will be changed into true, and the length will be incremented.
     *     Or not, it will change the digit, instance variable, to false, and will throw an IllegalArgumentException.
     * </P>
     * @param digitParam This parameter is a character in a string that will be checked by this method, and it should be a integer that length is 1.
     * @throws IllegalArgumentException This exception will be thrown if the give character is not between 0 and 9.
     */
    @Override
    public void processDigit(char digitParam) throws IllegalArgumentException {

        // Determine whether the given numeric character is between 0 and 9.
        if((digitParam >= '0') && (digitParam <= '9')) {
            this.digit = true;              // Set the instance variable as true.
            this.length += 1;               // Increment the instance variable by 1.
        }
        else {
            this.digit = false;             // Set the instance variable as false.
            throw new IllegalArgumentException("The number should be between 0 and 9 integer.");    // Throw an exception.
        }
    }

    /**
     * This method will determine a character which is a letter.
     * <p>
     *     processLetter() method will override the method in the StringHandler interface.
     *     It will get a char data type variable as a parameter.
     *     This method will throw an exception if the character is not fit to the specified condition.
     * </p>
     * <p>
     *     This processLetter() will set the range to check the character. The range is between 'a' and 'z'.
     *     If the parameter, character, is in the range, then the length will be incremented by 1.
     *     Or not, it will throw an IllegalArgumentException.
     * </p>
     * @param letterParam This parameter is a character in a string that will be checked by this method, and it should be an Alphabet, which starts from 'A', and finishes at 'Z'.
     * @throws IllegalArgumentException This exception will be thrown if the give character is not between 'a' and 'z'.
     */
    @Override
    public void processLetter(char letterParam) throws IllegalArgumentException {

        // Determine whether the given literal character is between 'a' and 'z'.
        if((letterParam >= 'a') && (letterParam <= 'z')) {
            this.length += 1;               // Increment the instance variable by 1.
        }
        else {
            throw new IllegalArgumentException("The letter should be between 'a' and 'z'.");        // Throw an exception.
        }
    }

    /**
     * This method will determine a character which is non-digit and non-letter.
     * <p>
     *     processOther() method will override the method in the StringHandler interface.
     *     It will get a char data type variable as a parameter.
     *     This method will throw an exception if the character is not fit to the specified condition.
     * </p>
     * <p>
     *     This processOther() will set the exceptional range to check the character.
     *     The exceptional range is processDigit() or processLetter() ranges. In addition, The range includes 0 to 31 in ASCII code value.
     *     If the parameter, character, is out of the range, then the boolean instance variable, otherCharacter, will be changed into true, and the length will be incremented.
     *     Or not, it will throw an IllegalArgumentException.
     * </p>
     * @param otherParam This parameter is a character in a string that will be checked by this method, and it should not be in the range of processDigit() and processLetter().
     * @throws IllegalArgumentException This exception will be thrown if the give character is in the exceptional range.
     */
    @Override
    public void processOther(char otherParam) throws IllegalArgumentException {

        // Determine whether the given character is out of the specified exceptional ranges or not.
        if((!((otherParam >= '0') && (otherParam <= '9'))) && (!((otherParam >= 'A') && (otherParam <= 'Z')))
                && !((otherParam >= 0) && (otherParam <= 31))) {
            this.otherCharacter = true;     // Set the instance variable as true.
            this.length += 1;               // Increment the instance variable by 1.
        }
        else {
            this.otherCharacter = false;    // Set the instance variable as false.
            throw new IllegalArgumentException("The other character should be printable.");         // Throw an exception.
        }
    }

    /**
     * This method will contain the condition for the strong security level.
     * <p>
     *     It will override a method in Object class, because the Object class, which is the super-class of this class has a method same with this method.
     *     Therefore, before coding the method, indicate the overriding using @.
     * </p>
     * <p>
     *     This method will indicate the condition for getting security level as "strong".
     *     The condition is that the length of the password is longer than 8 or 8, and having both a digit and an other character, non-digit and non-letter.
     * </p>
     * @return It will return a string that holds the condition of strong security level.
     */
    @Override
    public String toString() {

        // Initialize a string with proper conditions.
        String info = "A strong password has at least eight" + "\ncharacters and contains at least one digit"
                + "\nand one special characters.";

        return info;       // Return the string that holds the conditions.
    }

    /**
     * This method is an instance method which is a getter, and it will return the instance variable, length.
     * @return It will return an int data-type value held by length, instance variable.
     */
    protected int getLength() {
        return length;              // Return the instance variable: length.
    }

    /**
     * This method is an instance method which is a getter, and it will return the instance variable, digit.
     * @return It will return an boolean data-type value held by digit, instance variable.
     */
    protected boolean isDigit() {
        return digit;               // Return the instance variable: digit.
    }

    /**
     * This method is an instance method which is a getter, and it will return the instance variable, otherCharacter.
     * @return It will return an boolean data-type value held by otherCharacter, instance variable.
     */
    protected boolean isOtherCharacter() {
        return otherCharacter;      // Return the instance variable: otherCharacter.
    }

    /**
     * This method will get an int variable as a parameter, and give the parameter to length, which is an instance variable.
     * @param length This parameter is an int variable that holds the length of the password.
     */
    public void setLength(int length) {
        this.length = length;       // Set the instance variable, length, as same as the parameter.
    }

    /**
     * This method will get a boolean variable as a parameter, and give the parameter to digit, which is an instance variable.
     * @param digit This parameter is a boolean variable that indicates whether the password has a digit or not.
     */
    public void setDigit(boolean digit) {
        this.digit = digit;         // Set the instance variable, digit, as same as the parameter.
    }

    /**
     * This method will get a boolean variable as a parameter, and give the parameter to otherCharacter, which is an instance variable.
     * @param otherCharacter This parameter is a boolean variable that indicates whether the password has an other character or not.
     */
    public void setOtherCharacter(boolean otherCharacter) {
        this.otherCharacter = otherCharacter;       // Set the instance variable, otherCharacter, as same as the parameter.
    }
}
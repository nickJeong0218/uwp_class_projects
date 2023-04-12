package edu.uwp.cs.csci242.assignment.a03.stringhandler;

/**
 * This class will be used for handling hexadecimal string.
 * <p>
 *     This HexStringHandler class will implement StringHandler interface.
 *     This class will get a string only with hexadecimal characters: from 0 to 9 and from 'A' to 'F'.
 *     There will be 4 class constants to indicate invalid number, hexadecimal system and decimal value for letters: maximum and minimum.
 *     Also, there will be 2 instance variables: validHex and number.
 *     The constructors will be a default one and a parameterized one.
 *     Additionally, there will be 2 getters and 2 setters, 3 processors due to implementing the StringHandler interface, and isValid() from Validator interface.
 * </p>
 * <p>
 *     This class will get a string with hexadecimal characters, and will change it to decimal value.
 *     To change a hexadecimal string to decimal value, it will check each character in a string by using proper processor to figure out the string is a hexadecimal string or not.
 *     If the string is a hexadecimal string, then it will change the string to decimal value, int data type, using the class constant that indicates number system.
 *     Or if the string is not a hexadecimal string, then it will give invalid number for the string.
 * </p>
 * @author YunHwan Jeong
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 3
 * @bugs none
 */
public class HexStringHandler implements StringHandler, Validator {

    /*
    This variable is a class variable that holds an int value for non-hexadecimal string.
     */
    public static final int INVALID_NUMBER = -1;

    /*
    This variable is a class variable that indicates the number system for the string.
     */
    public static final int NUMBER_SYSTEM = 16;

    /*
    This variable is a class variable that holds an int value for the minimum letter character in hexadecimal.
     */
    public static final int NUMBER_LETTER_MIN = 10;

    /*
    This variable is a class variable that holds an int value for the maximum letter character in hexadecimal.
     */
    public static final int NUMBER_LETTER_MAX = 16;


    /*
    This variable is an instance variable that holds the flag indicating whether the string is hexadecimal or not.
     */
    public boolean validHex;

    /*
    This variable is an instance variable that holds int value of hexadecimal in decimal system.
     */
    public int number;


    /**
     * This constructor is a default, no-arg, constructor.
     */
    public HexStringHandler() {
    }

    /**
     * This constructor is a parameterized constructor, initializing all instance variables.
     * <p>
     *     This constructor will get a string as a parameter, which means a hexadecimal string.
     *     To initialize the instance variables, it will invoke getters for each variable.
     * </p>
     * @param stringParam This parameter indicates the hexadecimal string that will be checked whether the string can be converted to decimal value or not.
     */
    public HexStringHandler(String stringParam) {
        this.validHex = isValid();                      // Invoke a getter to initialize the instance variable, validHex.
        this.number = getNumber(stringParam);           // Invoke a getter to initialize the instance variable, number.
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
     *     If the parameter, character, is in the range, then the boolean instance variable, validHex, will be changed into true.
     *     Or not, it will change the validHex, instance variable, to false, and will throw an IllegalArgumentException.
     * </P>
     * @param digitParam This parameter is a character in a string that will be checked by this method, and it should be a integer that length is 1.
     * @throws IllegalArgumentException This exception will be thrown if the give character is not between 0 and 9.
     */
    @Override
    public void processDigit(char digitParam) throws IllegalArgumentException {

        // Determine whether the given numeric character is between 0 and 9.
        if((digitParam >= '0') && (digitParam <= '9')) {
            this.validHex = true;           // Set the instance variable as true.
        }
        else {
            this.validHex = false;          // Set the instance variable as false.
            throw new IllegalArgumentException("The digit should be between 0 and 9 integer.");     // Throw an exception.
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
     *     This processLetter() will set the range to check the character. The range is between 'A' and 'Z'.
     *     If the parameter, character, is in the range, it will check one more condition.
     *     If the character is between 'A' and 'F', which are hexadecimal characters, then the boolean instance variable, validHex, will be changed into true.
     *     Or not, it will change the validHex, instance variable, to false, and will throw an IllegalArgumentException.
     * </p>
     * @param letterParam This parameter is a character in a string that will be checked by this method, and it should be an Alphabet, which starts from 'A', and finishes at 'Z'.
     * @throws IllegalArgumentException This exception will be thrown if the give character is not between 'A' and 'F'.
     */
    @Override
    public void processLetter(char letterParam) throws IllegalArgumentException {

        // Determine whether the given literal character is between 'A' and 'Z'.
        if((letterParam >= 'A') && (letterParam <= 'Z')) {

            // Determine whether the parameter is a hexadecimal character.
            if ((letterParam >= 'A') && (letterParam <= 'F')) {
                this.validHex = true;           // Set the instance variable as true.
            } else {
                this.validHex = false;          // Set the instance variable as false.
                throw new IllegalArgumentException("The character should be hexadecimal character: between 'A' and 'F'.");      // Throw an exception.
            }
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
     *     The exceptional range is processDigit() or processLetter() ranges.
     *     If the parameter, character, is out of the range, then the boolean instance variable, otherCharacter, will be changed into false.
     *     Also if the parameter's ASCII code value is between 0 and 31, then otherCharacter will be false.
     *     Additionally, it will throw an IllegalArgumentException.
     * </p>
     * @param otherParam This parameter is a character in a string that will be checked by this method, and it should not be in the range of processDigit() and processLetter().
     * @throws IllegalArgumentException This exception will be thrown if the give character not a hexadecimal character.
     */
    @Override
    public void processOther(char otherParam) throws IllegalArgumentException {

        // Determine whether the character is not digit nor not a letter, or the ASCII code value of it is illegal.
        if((!((otherParam >= '0') && (otherParam <= '9'))) && (!((otherParam >= 'A') && (otherParam <= 'Z')))
                || ((otherParam >= 0) && (otherParam <= 31))) {
            this.validHex = false;              // Set the instance variable as false.
            throw new IllegalArgumentException("The other character should not be hexadecimal character.");     // Throw an exception.
        }
    }

    /**
     * This method will determine whether the string is hexadecimal or not.
     * <p>
     *     isValid() method will override the method in the Validator interface.
     *     It will return a boolean variable.
     *     Because this method is a getter as well as a overriding method.
     * </p>
     * <p>
     *     This method will return the boolean data-type instance variable. validHex, after checking all the components of a string.
     * </p>
     * @return It will return a boolean data-type value held by validHex, instance variable.
     */
    @Override
    public boolean isValid() {
        return validHex;            // Return the instance variable: validHex.
    }

    /**
     * This method is an instance method which is a getter, and it will return the instance varaible, numeber.
     * <p>
     *     Depending on the other instance variable, validHex, it will return different decimal value.
     *     If the validHex is true, then this method will calculate the hexadecimal string using a class constant that indicating number system.
     *     Otherwise, it will return a int value for invalid number: INVALID_NUMBER.
     * </p>
     * @param stringParam This parameter indicates the hexadecimal string that will be determined whether it will be converted or not by the value of validHex.
     * @return It will return proper decimal value corresponding th hexadecimal string.
     */
    public int getNumber(String stringParam) {

        // Determine whether the string is hexadecimal or not.
        if(validHex) {
            this.number = Integer.parseInt(stringParam, NUMBER_SYSTEM);         // Initialize the instance variable using number system.
            return number;                                                      // Return the instance variable: number.
        }
        else {
            return INVALID_NUMBER;                                              // Return a constant that corresponds to invalid string.
        }
    }

    /**
     * This method will get a boolean variable as a parameter, and give the parameter to validHex, which is an instance variable.
     * @param validHex This parameter is a boolean variable that holds the validity of the string.
     */
    public void setValidHex(boolean validHex) {
        this.validHex = validHex;           // Set the instance variable, validHax, as same as the parameter.
    }

    /**
     * This method will get an int variable as a parameter, and give the parameter to number, which is an instance variable.
     * @param number This parameter is an int variable that holds the decimal value of the string.
     */
    public void setNumber(int number) {
        this.number = number;               // Set the instance variable, number, as same as the parameter.
    }
}
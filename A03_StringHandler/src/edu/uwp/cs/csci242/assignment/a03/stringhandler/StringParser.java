package edu.uwp.cs.csci242.assignment.a03.stringhandler;

import java.util.Scanner;

/**
 * This class will be used for parsing strings and printing out the outputs.
 * <p>
 *     StringParser class will be the main driver.
 *     This class will have an instance variable which is an instance of StringHandler. The visibility of the instance will be private.
 *     In addition, it will have 2 constructors, one is default and the other one is parameterized.
 *     This class will have 2 methods: parse() and main().
 * </p>
 * <p>
 *     The class will parse a string in a character to determine whether the string is proper to given conditions, for instance, password or hexadecimal.
 *     After parsing, it will use the methods in the StringHandler's methods with proper character.
 *     Then, it will use main() method to printout the required output;
 *     Then, it will use main() method to printout the required output;
 *     for PasswordSecurityHandler, it will print out security level, and if will print out decimal value for HexStringHandler.
 * </p>
 * @author YunHwan Jeong
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 3
 * @bugs none
 */

public class StringParser {

    /*
    This variable is an instance variable that is an object of StringHandler interface.
     */
    private StringHandler handler;


    /**
     * This constructor is a default, no-arg, constructor.
     */
    public StringParser() {
    }

    /**
     * This constructor is a parameterized constructor, initializing the instance variable.
     * <p>
     *     This constructor will get a StringHandler as a parameter, which means an function for string handling.
     *     To initialize the instance variable, it will use the parameter.
     * </p>
     * @param shParam This parameter indicates that it will handle a string with some condition.
     */
    public StringParser(StringHandler shParam) {
        this.handler = shParam;             // Initialize the instance variable as the parameter.
    }


    /**
     * This method will be used for parsing a string.
     * <p>
     *     parse() method will get a string as a parameter.
     *     It will throw an exception due to invoking the methods of classes that invoke StringHandler.
     * </p>
     * <p>
     *     This method will use a for-loop to parse a string into a character.
     *     After parsing, it will categorize a character into 3 parts: digit, letter and other character.
     *     In each category, it will invoke a method for each part by using the instance variable.
     * </p>
     * @param stringParam This parameter indicates a string that will be parsed to be determined.
     * @throws IllegalArgumentException This exception will be thrown if the methods of the interface throw.
     */
    public void parse(String stringParam) throws IllegalArgumentException {

        // Use a for-loop to parse the string.
        for(int i = 0; i < stringParam.length(); i++) {

            // Set a parsed part as a new char data-type variable.
            char ch = stringParam.charAt(i);

            // Set the range for the digit: between 0 and 9.
            if((ch >= '0') &&(ch <= '9')) {
                handler.processDigit(ch);           // Invoke a proper processor from interface using the instance variable.
            }

            // Set the range for the letter: between 'a' and 'z' or 'A' and 'Z'.
            if(((ch <= 'z') && (ch >= 'a')) || ((ch <= 'Z') && (ch >= 'A'))) {
                handler.processLetter(ch);          // Invoke a proper processor from interface using the instance variable.
            }

            // Set the range for the other character: except the ranges for digit and letter.
            if(!(ch >= '0') &&(ch <= '9') && !(((ch <= 'z') && (ch >= 'a')) || ((ch <= 'Z') && (ch >= 'A')))) {
                handler.processOther(ch);           // Invoke a proper processor from interface using the instance variable.
            }
        }
    }

    /**
     * This method will be used for main driver.
     * <p>
     *     The main method will make 2 string handlers for each situation.
     *     It will print out the format for printing out the result of handling.
     *     For the format of the PasswordSecurityHandler, it will invoke toString() method in the class.
     *     To use handlers, it will use an object of Scanner class to get the strings.
     *     Also, this method will invoke parse() method in the same class to use string handlers.
     *     When it uses the parse() method, because the parse() method throws exception, it will try catching exceptions.
     * </p>
     * @param args
     */
    public static void main(String[] args) {

        StringParser sp;            // Declare an instance of StringParser class.
        PasswordSecurityHandler psh = new PasswordSecurityHandler("");      // Initialize an instance of PasswrodSecurityHandler to use toString() method.
        HexStringHandler hsh;       // Declare an instance of HexStringHandler class.

        // Print out the format for the output, and instantiate an object of Scanner class to get the strings.
        System.out.println("run:");
        Scanner keyboard = new Scanner(System.in);

        // Prompt to get input for HexStringHandler.
        System.out.println("Enter a hexadecimal number >");
        String hexadecimalForm = keyboard.nextLine();

        // Initialize the instance of the HexStringHandler using the string that input.
        hsh = new HexStringHandler(hexadecimalForm);

        // Initialize the instance of the StringParser using the instance of the HexStringHandler.
        sp = new StringParser(hsh);

        // Use a try-catch block to check whether the exception is thrown or not.
        try {
            sp.parse(hexadecimalForm);              // Invoke the parse() method using the instance of StringParser.
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());    // Print out the message of the caught exception.
        }

        System.out.println(hexadecimalForm + "=" + hsh.getNumber(hexadecimalForm));     // Print out the result in formatted form.

        // Print out the format for the condition of the password's security level.
        System.out.println(psh.toString());

        // Prompt to get input for PasswordSecurityHandler.
        System.out.print("Enter a password > ");
        String passwordCheck = keyboard.nextLine();

        // Initialize the instance of the PasswordSecurityHandler using the string that input.
        psh = new PasswordSecurityHandler(passwordCheck);

        // Initialize the instance of the StringParser using the instance of the PasswordSecurityHandler.
        sp = new StringParser(psh);

        // Use a try-catch block to check whether the exception is thrown or not.
        try {
            sp.parse(passwordCheck);                // Invoke the parse() method using the instance of StringParser.
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());    // Print out the message of the caught exception.
        }

        System.out.println(passwordCheck + "'s security is: " + psh.securityLevel());   // Print out the result in formatted form.
    }
}
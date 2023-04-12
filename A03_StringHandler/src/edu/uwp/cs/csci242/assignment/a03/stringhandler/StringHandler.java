package edu.uwp.cs.csci242.assignment.a03.stringhandler;

/**
 * This interface will be used for handling a string.
 * <p>
 *     The StringHandler interface will be implemented by the concrete classes.
 *     The reason why this interface is implemented is because the concrete classes will be required to check strings in the class.
 *     Therefore, it will check each character in the strings that will be needed to be checked.
 * </p>
 * <p>
 *     Because this interface will be implemented to check strings in terms of characters in them,
 *     the StringHandler interface will have 3 methods for each components of the strings.
 *     There will be processDigit(), processLetter() and processOther() methods.
 *     All methods in this interface will get a character, which data type is "char", to check each character in the strings.
 *     The methods will inspect the components of the strings: digit, letter, which is one of Alphabets,
 *     and other characters, which is not included in digits and letters.
 * </p>
 * @author YunHwan Jeong
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @uwp.edu.cs.242.assignment 3
 * @bugs none
 */
public interface StringHandler {

    /**
     * This method will examine a digit in a string.
     * <p>
     *     Because this method is in an interface, it will not have any body.
     *     It will be implemented in the concrete classes, and the function of this method will be specified in the implementing classes.
     * </p>
     * <p>
     *     The processDigit() method will get a char variable as a parameter.
     *     The parameter is a numeric component of a string, and it will be examined by this method.
     *     With the specific condition after implementing, this method will determine whether the character which will be inspected is fit to the condition or not.
     * </p>
     * @param digitParam This parameter is a character in a string that will be checked by this method, and it should be a integer that length is 1.
     */
    public void processDigit(char digitParam);

    /**
     * This method will examine a letter in a sting.
     * <p>
     *     Because this method is in an interface, it will not have any body.
     *     It will be implemented in the concrete classes, and the function of the method will be specified in the implementing classes.
     * </p>
     * <p>
     *     The processLetter() method will get a char variable as a parameter.
     *     The parameter is a literal component of a string, and it will be examined by this method.
     *     With the specific condition after implementing, this method will determine whether the character which will be inspected is fit to the condition or not.
     * </p>
     * @param letterParam This parameter is a character in a string that will be checked by this method, and it should be an Alphabet, which starts from 'A', and finishes at 'Z'.
     */
    public void processLetter(char letterParam);

    /**
     * This method will be examine an other character in a string.
     * <p>
     *      Because this method is in an interface, it will not have any body.
     *      It will be implemented in the concrete classes, and the function of the method will be specified in the implementing classes.
     * </p>
     * <p>
     *     The processOther() method will get a char variable as a parameter.
     *     The parameter is non-numeric and non-literal component of a string, and it will be examined by this method.
     *     With the specific condition after implementing, this method will determine whether the character which will be inspected is fit to the condition or not.
     * </p>
     * @param otherParam This parameter is a character in a string that will be checked by this method, and it should not be in the range of processDigit() and processLetter().
     */
    public void processOther(char otherParam);
}
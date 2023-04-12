package edu.uwp.cs.csci242.assignment.a03.stringhandler;

/**
 * This interface will be used for checking a string is valid or not.
 * <p>
 *     The Validator interface will be implemented by the concrete classes.
 *     The reason why this interface is implemented is because the concrete classes will be required to check strings in the class.
 *     Therefore, it will check the strings are valid for the given condition of string.
 * </p>
 * <p>
 *     Because this interface will be implemented to determine whether the string is valid or invalid, the Validator interface will have 1 method.
 *     The method in this interface is inValid() method.
 *     This method will return a boolean value, after determining the validity.
 * </p>
 * @author YunHwan Jeong
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 3
 * @bugs none
 */
public interface Validator {

    /**
     * This method will check the validity of a string.
     * <p>
     *     Because this method is in an interface, it will not have any body.
     *     It will be implemented in the concrete classes, and the function of the method will be specified in the implementing classes.
     * </p>
     * <p>
     *     The isValid() method will have a boolean return type.
     *     The boolean value will be related to a string that will be checked in the concrete classes.
     *     With the specific condition after implementing, this method will determine whether a string is fit to the specific condition or not.
     * </p>
     * @return It will return a boolean data type variable that holds the validity of a string.
     */
    public boolean isValid();
}

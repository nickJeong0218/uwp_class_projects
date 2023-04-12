package edu.uwp.cs.csci242.assignments.bankaccount;

/**
 * This class will be used to calculate the interest.
 * <p>
 *     Interest class will not have any instance variable and any instance method.
 *     It will also not have any constructor.
 * </p>
 * <p>
 *     This class will have only 2 methods to calculate interest in different ways: simple() and compound().
 *     For this project, this class has to calculate the interest in 2 ways for Checking and Savings classes.
 *     One way is called simple interest, and the other way is called compound interst.
 *     For these 2 methods, this class will use general form that are used globally.
 * </p>
 * @author YunHwan Jeong
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs none
 * */
public class Interest {

    /**
     * This method indicates simple interest.
     * <p>
     *     As Checking account needs to get interest in simple interest way, this method will be used to get the interest in simple way.
     *     It will get 3 parameters: principleParam, interestRateParam and timeParam.
     *     For simple interest, this method just needs to multiple everything,
     *     because it will return only interest, it has to subtract the same amount of principle.
     *     After getting the interest, it will return the interest.
     * </p>
     * <p>
     *     InterestSimple = principle * ( 1 + interestRate * time ) - principle.
     *     Therefore, it becomes : InterestSimple = principle * ( interestRate * time ).
     * </p>
     * @param principalParam This parameter indicates the amount of the beginning for getting interest.
     * @param interestRateParam This parameter indicates the rate for the interest.
     * @param timeParam This parameter indicates how many times the interest should be repeated.
     * @return
     */
    public double simple(double principalParam, double interestRateParam, int timeParam) {

        // Initialize a variable using the result from the simple interest formula.
        double finalAmount = principalParam * (interestRateParam * timeParam);

        return finalAmount;             // Return a variable: finalAmount.
    }

    /**
     * This method indicates compound interest.
     * <p>
     *     As Savings account needs to get interest in compound interest way, this method will be used to get the interest in compound way.
     *     It will get 4 parameters: principleParam, interestRateParam, compoundedParam and timeParam.
     *     For compound interest, this method just needs to use the formula for compound interest, and subtract the same amount of principle.
     *     because it will return only interest, it has to subtract the same amount of principle.
     *     After getting the interest, it will return the interest.
     * </p>
     * <p>
     *     InterestCompound = principle * ( 1 + interestRate / compounded ) ^ ( compounded * time ) - principle.
     * </p>
     * @param principalParam This parameter indicates the amount of the beginning for getting interest.
     * @param interestRateParam This parameter indicates the rate for the interest.
     * @param compoundedParam This parameter indicates the repetition in a year.
     * @param timeParam This parameter indicates how many times the interest should be repeated.
     * @return
     */
    public double compound(double principalParam, double interestRateParam, int compoundedParam, int timeParam) {

        // Initialize a variable using the resulf from the simple interest formula.
        double finalAmount = principalParam * Math.pow((1 + interestRateParam / compoundedParam), (compoundedParam * timeParam)) - principalParam;

        return finalAmount;             // Return a variable: finalAmount.
    }
}

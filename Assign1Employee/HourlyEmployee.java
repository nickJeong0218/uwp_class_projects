
//
// Name: YunHwan Jeong (jeong)
// Course: CSCI 241 - Computer Science I
// Section: 001
// Assignment: 1
//
// Program/Class Description:
// This class represents hourly (non-tipped) employees in Wisconsin.
// It can be used to calculate their weekly wages.
//
// Known Bugs: none
//

public class HourlyEmployee
{
    // constants
    public static final double FED_RATE = 0.28;         // one possible rate
    public static final double STATE_RATE = 0.046;      // Wisconsin rate
    public static final double SOCIAL_SECURITY = 0.062; // employee share
    public static final double MEDICARE = 0.0145;       // employee share
    public static final double MAX_WEEKLY_HOURS = 40.0; // before overtime
    public static final double OVERTIME_RATE = 1.5;     // overtime per hour
    public static final double WISC_MIN_WAGE = 7.25;    // as of 7/24/09

    // instance variables
    private String name;             // employee name
    private double hours;            // hours this employee has worked
    private double rate;             // hourly pay rate

    private double grossPay;         // calculated from hours and rate
    private double fedWithholding;   // amount taken from this paycheck
    private double stateWithholding; // amount taken from this paycheck
    private double socSecurity;      // amount taken from this paycheck
    private double medicare;         // amount taken from this paycheck
    private double netPay;           // take-home pay

    //------------------------------------------------
    // Constructor for objects of class HourlyEmployee
    // A name is required for all employees.
    // Give her/him the minimum wage if not specified.
    //------------------------------------------------
    public HourlyEmployee(String nameParam)
    {
        // initialise instance variables
        name = nameParam;
        hours = 0.0;
        setRate(WISC_MIN_WAGE);
    }

    //------------------------------------------------
    // Constructor for objects of class HourlyEmployee
    // A name is required for all employees.
    // This constructor also takes an initial pay rate.
    //------------------------------------------------
    public HourlyEmployee(String nameParam, double initRate)
    {
        name = nameParam;
        hours = 0.0;
        setRate(initRate);
    }

    //------------------------------------------------
    // Set the employee's pay rate
    //------------------------------------------------
    public void setRate (double rateParam)
    {
        // Check to make sure the pay rate is legal in Wisconsin
        if (rateParam >= WISC_MIN_WAGE)
        {
            rate = rateParam;
        }
        else
        {
            System.out.print("ERROR! " + rateParam);
            System.out.print(" is below the $" + WISC_MIN_WAGE);
            System.out.print(" Wisconsin minimum wage.");
        }
    }

    //------------------------------------------------
    // Set the number of hours worked this week
    //------------------------------------------------
    public void setHours (double hoursParam)
    {
        // Check to make certain the hours are reasonable
        if (hoursParam >= 0.0)
        {
            hours = hoursParam;
        }
        else
        {
            System.out.println ("ERROR! Can't work negative hours.");
            System.out.println (hoursParam + " in as illegal value.");
        }
    }

    //------------------------------------------------
    // Calculate this employee's wages
    //------------------------------------------------
    public void figurePay()
    {
        //Check if employee worked overtime
        if (hours <= MAX_WEEKLY_HOURS)
        {
            grossPay = hours * rate;
        }
        else
        {
            grossPay = MAX_WEEKLY_HOURS * rate;
            double overtimeRate = OVERTIME_RATE * rate;
            double overtimeHours = hours - MAX_WEEKLY_HOURS;
            double overtimePay = overtimeHours * overtimeRate;
            grossPay += overtimePay;
        }
        fedWithholding = FED_RATE * grossPay;
        stateWithholding = STATE_RATE * grossPay;
        socSecurity = SOCIAL_SECURITY * grossPay;
        medicare = MEDICARE * grossPay;

        netPay = grossPay - fedWithholding;
        netPay -= stateWithholding;
        netPay -= socSecurity;
        netPay -= medicare;
    }

    //------------------------------------------------
    // Print the employee's weekly wages.
    // Assumes that they have already beed calculated.
    //------------------------------------------------
    public void printPay()
    {
        System.out.printf("Employee: " + name);
        System.out.printf(" ($%5.2f/hour for %4.1f hours)\n",rate,hours);
        System.out.printf("  Gross Pay:  $%9.2f\n",grossPay);
        System.out.printf("  Federal Tax Withheld:     $%7.2f\n",fedWithholding);
        System.out.printf("  State Tax Withheld:       $%7.2f\n",stateWithholding);
        System.out.printf("  Social Security Withheld: $%7.2f\n",socSecurity);
        System.out.printf("  Medicare Withheld:        $%7.2f\n",medicare);
        System.out.println("------------------------------------");
        System.out.printf("  Net Pay: $%8.2f\n",netPay);
        System.out.println();
    }

    // the main program instantiates two employees and calculates their wages
    public static void main (String args[])
    {
        // Print the program heading
        System.out.println("UW-Parkside -- Employee Payroll Program");
        System.out.println();

        // Work with the employee named Lou
        HourlyEmployee lou = new HourlyEmployee("Lou", 7.25);
        lou.setHours(34.5);
        lou.figurePay();
        lou.printPay();

        // Work with the employee named Siri
        HourlyEmployee siri = new HourlyEmployee("Siri");
        siri.setRate(12.00);
        siri.setHours(42);
        siri.figurePay();
        siri.printPay();
    }
}    
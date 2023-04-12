
/**
 *  Name: YunHwan Jeong (jeong)
 *  Course: CSCI 241 - Computer Science I
 *  Assignment: 9
 *  
 * Project/Class Description:
 *  This class is instanciabl class that will be used to make objects.
 *  The other class will use this class.
 *  This instanciable class has 3 constructors, a default, with 1 parameter and with 2 paramters.
 *  Additionally, it has a lot of instance methods, such as getters, setters, adjusting methods,
 *  printing methods and methods that use 2 objects to compare and combine.
 * 
 * Known Bugs:
 *  none
 */

public class Volume {
    // Initialize class constants.
    public static final int OUNCES_IN_GALLON = 128;            // 1 gal. = 128 oz.
    public static final double MILLILITERS_IN_OUNCE = 29.5735; // 1 oz. = 29.5735 mL.

    // Declare an instance variable.
    private int ounces;

    /** 
     * Make 3 constructors:
     *  1. A default
     *  2. with 1 parameter: ounces 
     *  3. with 2 parameters: gallons & ounces
     */
    //  1. A default
    public Volume ()   {
            ounces = 0;     // Sets the instance variable to 0.
    }
    //  2. Take 1 parameter which holds an initial number of ounces.
    //     If the parameter is negative, print an error message.
    public Volume (int ouncesParam) {
        // If the parameter is not negative, set the instance variable to the parameter.
        if (ouncesParam >= 0)   {
            ounces = ouncesParam;
        }
        // If the parameter is negative, print out an error message and set the instance variable to 0.
        else    {
            System.out.println("Error: can't set negative ounces, set to 0.");
            ounces = 0;
        }
    }
    // 3. Take 2 parameters, holding the number of gallons and ounces.
    //    If either parameter is negative, print an error message, and do not use that number. 
    //    Then, use constants to convert to ounces and save in terms of ounces.
    public Volume (int gallonsParam, int ouncesParam)   {
        // If both parameters are not negative, set the instance variable to the addition of parameters.
        // The gallon value should be converted to the ounces.

        // When BOTH GallonValue and OunceValue >= 0
        if ((gallonsParam >= 0) && (ouncesParam >= 0))  {
            // Convert to ounces and add.
            ounces = gallonsParam * OUNCES_IN_GALLON + ouncesParam;
        }
        // If either paramter is negative, set negative one(s) to 0, and repeaet the actions above.
        // The gallon value should be converted to the ounces.
        else if ((gallonsParam < 0) || (ouncesParam < 0))   {
            // When ONLY GallonValue < 0
            if ((gallonsParam < 0) && (ouncesParam >= 0))  {            
                System.out.println("Error: can't set negative gallons, set to 0.");
                gallonsParam = 0;
            }
            // When ONLY OunceValue < 0
            if ((gallonsParam >= 0) && (ouncesParam < 0))    {
                System.out.println("Error: can't set negative ounces, set to 0.");
                ouncesParam = 0;
            }
            // When BOTH GallonValue and OunceValue < 0
            if ((gallonsParam < 0) && (ouncesParam < 0))    {
                System.out.println("Error: can't set negative gallons and ounces, set to 0.");
                gallonsParam = 0;
                ouncesParam = 0;
            }
            // Convert to ounces and add.
            ounces = gallonsParam * OUNCES_IN_GALLON + ouncesParam;
        }
    }

    /**
     * From here, instance methods will be written:
     *  1) Getter(Accessor)
     *  2) Setter(Mutator)
     *  3) Adjusting amounts
     *  4) Gathering text to print, comparing and combining objects
     */
    /**
     * Write getter(accessor) methods; Here are prototypes of getters.
     *  1. int getOunces()     : returns the number of ounces in the volume.
     *  2. int getGallons()    : returns the number of gallons in the volume.
     *  3. int getOuncesLeft() : returns the number of ounces that would be left over after getting gallon(s).
     */
    // 1. getOunces(): returns the instance variable: ounces.
    public int getOunces () {
        return ounces;      // Return the instance variable.
    }
    // 2. getGallons(): divides instance variable with a constant: OUNCES_IN_GALLON, and return that number.
    public int getGallons ()    {
        int gallons = ounces / OUNCES_IN_GALLON;    // Divide instance variable by the constant.
        return gallons;                             // Return the new variable initialized with the result.
    }
    // 3. getOuncesLeft(); returns remaining number after division above.
    public int getOuncesLeft () {
        int ouncesLeft = ounces % OUNCES_IN_GALLON; // Initialize new variable with the remain from above division.
        return ouncesLeft;                          // Return the new variable.
    }

    /**
     * Write a setter(mutator) method; Here is a prototype of setter.
     *   void setOunces(int)    : sets instance variable as the parameter.
     */
    // 1. setOunces(int): 
    // Initializes instance variable with the parameter.
    // If the parameter is negative, print an error message, and make no change to volume.
    public void setOunces (int ouncesParam) {
        // When the parameter is not negative
        if (ouncesParam >= 0)   {
            ounces = ouncesParam;   // Set the instance variable to the parameter.
        }
        // When the parameter is negative
        else    {
            System.out.println("Error: can't set negative ounces; setting to 0.");  // Print out an error message.
            ounces = ounces;                                                        // Do not change the instance variable.
        }
    }

    /**
     * Write adjusting methods; Here are prototypes of adjusting methods.
     *  1. void addOunces(int)  : adds the instance variable and the parameter.
     *  2. void pour(int)       : subtracts the parameter from the instance variable.
     */
    // 1. addOunces(int):
    // Adds the parameter value to the instance variable.
    // If the parameter is negative, print an error message, and make no change to volume.
    public void addOunces (int ouncesAdd)   {
        // When the parameter is not negative
        if (ouncesAdd >= 0) {
            ounces += ouncesAdd;    // Sum up the instance variable and the parameter.
        }
        // When the parameter is negative
        else    {
            System.out.println("Can't add negative ounces. No change."); // Print out an error message.
            ounces = ounces;                                             // Do not change the instance variable.
        }
    }
    // 2. pour(int): 
    // Reduces the number of ounces in the object by the number in the parameter. 
    // If the parameter is negative, print an error message, and don't change the value.
    // If the parameter is greater than the instance variable, print an error message, and set the result as 0.
    public void pour (int ouncesPour)   {
        // When the parameter is negative
        if (ouncesPour < 0) {
            System.out.println("Can't pour out negative ounces. No change.");   // Print out an error message.
            ounces = ounces;                                                    // Do not change the instance variable.
        }
        // When parameter > instanceVariable
        else if (ouncesPour > ounces)   {
            // Print out and error message.
            System.out.println("Error: not enough left to pour out.\nCan pour out only " + ounces + " ounces.");
            // Set the instance variable to 0.
            ounces = 0;
        }
        else    {
            ounces -= ouncesPour;
        }
    }
    
    /**
     * Write instance methods for printing texts and comparing and combining objects; Here are prototypes for methods.
     *  1. String toString()        : creates and returns a string that has information about an object.
     *  2. String toStringLiters()  : creates and returns a string that holds text with liters of an object.
     *  3. boolean equals(Volume)   : compares 2 objects whether they are same or not and return the result.
     *  4. Volume combine(Volume)   : combines 2 objects and makes a new object and return the new one.
     */
    // 1. toString():
    // Creates a string that explains an object, and returns that string.
    // For the number of gallons and ounces, both of them will have 3 digits.
    public String toString ()    {
        String text = String.format("%3d gal. %3d oz.",getGallons(), getOuncesLeft());
        return text;
    }
    // 2. toStringLiters():
    // Converts instance variable, ounces, to the liters, and creates and returns a string with liters.
    // For the number of liters, it will be formatted: 2 decimals.
    // To convert, use the class constant: MILLILITERS_IN_OUNCE.
    public String toStringLiters () {
        double resultLiters = ounces * MILLILITERS_IN_OUNCE / 1000;
        String text = String.format("%6.2f liters",resultLiters);
        return text;
    }
    // 3. equals(Volume):
    // Checks one object with another object if they are same amounts.
    // If they are same, it returns TRUE. Or it returns FALSE.
    public boolean equals (Volume objectParam)  {
        boolean isEqual = false;
        if (ounces == objectParam.ounces)   {
            isEqual = true;
        }
        return isEqual;
    }
    // 4. combine(Volume):
    // Adds instance variables of two objects and makes new object with this new number.
    public Volume combine (Volume objectParam)  {
        int combinedOunces = ounces + objectParam.ounces;
        Volume newObject = new Volume(combinedOunces);
        return newObject;
    }
}

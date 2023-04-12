
/**
 * Class Name: Volume
 * Author: Erica Eddy
 * Date: April 2019
 * 
 * This class will test all methods found in the Volume class.
 */
public class TestVolume {
    public static void main(String [] args) {
        // print the constants
        System.out.println("Constant: OUNCES_IN_GALLON = " + Volume.OUNCES_IN_GALLON);
        System.out.println("Constant: MILLILITERS_IN_OUNCE = " + Volume.MILLILITERS_IN_OUNCE);
        System.out.println();
        
        // create a Volume object with the default constructor
        System.out.println("*** (v1) Test Default constructor ***");
        Volume v1 = new Volume();
        // print contents of v1
        System.out.println("v1: " + v1.toString());
        System.out.println();
        
        // create a Volume object with the first alternate constructor
        // first try with negative ounces
        // should see error message and set to 0
        System.out.println("*** (v2) Test Alternate constructor #1 (-5) ***");
        Volume v2 = new Volume(-5);
        // print contents of v2
        System.out.println("v2: " + v2.toString());
        System.out.println();
        
        // make a new v2 with positive ounces
        System.out.println("*** (v2) Test Alternate constructor #1 (150) ***");
        v2 = new Volume(150);
        // print the contents of v2 as gal+oz, and liters
        System.out.println("v2: " + v2.toString());
        // print using in liters
        System.out.println("v2: " + v2.toStringLiters());
        System.out.println();
        
        // make a v3 with second alternate constructor (gallons and ounces)
        System.out.println("*** (v3) Test Alternate constructor #2 (1,50) ***");
        Volume v3 = new Volume(1,50);
        // print the contents as gal+oz, and liters
        System.out.println("v3: " + v3.toString());
        // print using in liters
        System.out.println("v3: " + v3.toStringLiters());
        System.out.println();
        
        // change ounces in v1
        // try negative value first
        System.out.println("*** (v1) Test setOunces (-10) ***");
        v1.setOunces(-10);
        // now try positive value
        System.out.println("*** (v1) Test setOunces (150) ***");
        v1.setOunces(150);
        // print contents of v1
        System.out.println("v1: " + v1.toString());
        System.out.println("v1 gallons: " + v1.getGallons());
        System.out.println("v1 ounces left: " + v1.getOuncesLeft());
        System.out.println();
        
        // add ounces to v2
        System.out.println("*** (v2) Test addOunces (25) ***");
        v2.addOunces(25);
        // print the contents of v2 as gal+oz
        System.out.println("v2: " + v2.toString());
        System.out.println();
        
        // pour out ounces from v2
        System.out.println("*** (v2) Test pour (500) ***");
        v2.pour(500);
        // add ounces back in so next line will work
        System.out.println("*** (v2) Test addOunces (175) ***");
        v2.addOunces(175);
        // print the contents of v2 as gal+oz
        System.out.println("v2: " + v2.toString());
        
        // pour out 10 ounces
        System.out.println("*** (v2) Test pour (10) ***");
        v2.pour(10);
        // print the contents of v2 as gal+oz
        System.out.println("v2: " + v2.toString());
        System.out.println();
        
        // pour out ounces from v3
        System.out.println("*** (v3) Test pour (13) ***");
        v3.pour(13);
        // print the contents of v3 as gal+oz
        System.out.println("v3: " + v3.toString());
        System.out.println();
        
        // try equals() method
        // v1 and v2 should be different
        System.out.println("*** Test v1.equals(v2) ***");
        if (v1.equals(v2))
            System.out.println("v1 and v2 have SAME ounces.");
        else
            System.out.println("v1 and v2 have DIFFERENT ounces.");
        System.out.println();
           
        // v2 and v3 should match
        System.out.println("*** Test v2.equals(v3) ***");
        if (v2.equals(v3))
            System.out.println("v2 and v3 have SAME ounces.");
        else
            System.out.println("v2 and v3 have DIFFERENT ounces.");
        System.out.println();
            
        // combine 2 volume objects to make one with total ounces
        System.out.println("*** Test v1.combine(v4) ***");
        Volume v4 = v1.combine(v3);
        // print the contents as gal+oz, and liters
        System.out.println("v4: " + v4.toString());
        // print using in liters
        System.out.println("v4: " + v4.toStringLiters());
    }
}

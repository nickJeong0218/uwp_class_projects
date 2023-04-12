
/**
 * Name:  YunHwan Jeong (jeong)
 * Course:  CSCI-241 - Computer Science I
 * Section: 001
 * Assignment: 7
 * 
 * Project/Class Description <-- FILL THIS IN
 * 
 * Known Bugs:  none???
 */
import java.util.*;

public class Inches
{
    public static void main (String [] args)
    {
        // make an array that holds 12 different integers representing inches
        int [] myInches = {89,12,33,7,72,42,76,49,69,85,61,23};

        // ask the user whether to use fixed array or a new one of random size
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter 1 for fixed 12-element array, 2 for random array: ");
        int selection = keyboard.nextInt();
        if (selection == 2)
        {
            System.out.print("Enter # of elements in array: ");
            int length = keyboard.nextInt();

            // save the value entered by the user and make an integer array of that size
            int [] myNewInches = new int [length];

            // assign that new space to the array named myInches
            myInches = myNewInches;

            // fill all locations in the array with a random value between 1 and 95.
            for (int i = 0; i < myInches.length; i++)   {
                myInches[i] = (int)(Math.random() * 95 + 1);
            }
        }

        // print original array with inches values
        System.out.println("Printing original array contents");
        System.out.println("-----------------------------------------");
        // call the printArrayValues() method to print the values in the array
        printArrayValues(myInches);

        // print the values in the array, as ft-in combinations
        System.out.println("Printing inches");
        System.out.println("-----------------------------------------");
        // call the printInches() method to print the array values in ft-in format
        printFeetAndInches(myInches);

        // add all inches and print the sum
        System.out.println();
        System.out.println("Inches in this array total over " 
            + sumInches(myInches) + " feet");
        System.out.println();

        // ask user for upper limit on inches
        System.out.print("Enter maximum inches for sub-array: ");
        int max = keyboard.nextInt();

        // find all inches that exceed the max, and return that array
        int [] lower = createLowerArray(max, myInches);

        // print the values in the array, as ft-in combinations
        System.out.println("\nPrinting inches under " + max);
        System.out.println("-----------------------------------------");       
        // call the printFeetAndInches() method to print the lower array values in ft-in format
        printFeetAndInches(lower);

        // call method to fill in feetArray array (categories)
        int [] feetArray = buildFeetArray(myInches);

        // print the array with feet categories
        System.out.println();
        System.out.println("Grouping into categories by foot ...");
        System.out.println("   <1   <2   <3   <4   <5   <6   <7   <8");
        System.out.println("  ---- ---- ---- ---- ---- ---- ---- ----");
        // print the feetArray array contents, using printArrayValues
        printArrayValues(feetArray);

        // Place all new methods below main(); in the sequence specified in the
        // assignment description.        
    }

    // This method will be displaying integers in the array
    // 8 integers per line, and the space for each number is 5 positions.
    public static void printArrayValues (int [] arrayParam) {
        // Set a loop to print out the entries as many as the length of the array.
        for (int i = 0; i < arrayParam.length; i++) {
            System.out.printf("%5d", arrayParam[i]);    //Give 5 positions to the entry.
            // If a line is filled with 8 entries, go to next line.
            if ((((i + 1) % 8 == 0) && (i != 0)) || (i == arrayParam.length - 1))
                System.out.println();
        }
        // After finishing print out, let a line stay empty.
        System.out.println();
    }

    // This method will sum up all entries, which are in the myInches array.
    // Then, it will divide that number by 12 to get by feet unit.
    public static int sumInches (int [] arrayParam) {
        // Initialize a variable to hold the sum of inches.
        int sumOfInches = 0;

        // Declare a varible to hold the feet unit which will be returned.
        int convertToFeet;

        //Set a loop to print out the entries as many as the length of the array.
        for (int i = 0; i < arrayParam.length; i++) {
            sumOfInches += arrayParam [i];
        }
        convertToFeet = sumOfInches / 12;       // Get the correct feet.
        return convertToFeet;                   // Return the feet to main method.
    }

    // This method will be used to print out the indexes of the array
    // with a form of feet and inches.
    // For this form, we will assume that 1 ft is 12 inches.
    // Also, each numeric values will charge 2 positions,
    // including the position numbers for the array.
    public static void printFeetAndInches (int [] arrayParam)    {
        //Set a loop to print out the entries as many as the length of the array.
        for (int i = 0; i < arrayParam.length; i++) {
            System.out.printf("Inches[%2d] = ", i);     // Print out the number of the entry.
            int numForFeet = arrayParam[i] / 12;        // Set a variable for the feet unit.
            int numForInches = arrayParam[i] % 12;      // Set a variable for the inches unit.
            /**
             * For the outer if - else statements, determine the variable for feet,
             * when numForFeet is 0, 1 and greater than 1.
             * Then, for the inner if - else statements, determin the variable for inches as well,
             * when numForInches is 1 and greater than 1.
             */
            // 1. numForFeet = 0
            if (numForFeet == 0) {
                // i) numForFeet = 1
                if (numForInches == 1)
                    System.out.printf("%2d inch", numForInches);
                // ii) numForFeet > 1
                else if (numForInches > 1)
                    System.out.printf("%2d inches", numForInches);
            }
            // 2. numForFeet = 1
            else if (numForFeet == 1)    {
                System.out.printf("%2d foot", numForFeet);
                // i) numForFeet = 1
                if (numForInches == 1)
                    System.out.printf(", %2d inch", numForInches);
                // ii) numForFeet > 1
                else if (numForInches > 1)
                    System.out.printf(", %2d inches", numForInches);
            }
            // 3. numForFeet > 1
            else if (numForFeet > 1)    {
                System.out.printf("%2d feet", numForFeet);
                // i) numForFeet = 1
                if (numForInches == 1)
                    System.out.printf(", %2d inch", numForInches);
                // ii) numForFeet > 1
                else if (numForInches > 1)
                    System.out.printf(", %2d inches", numForInches);
            }
            // After printing out each expression, go to next line for following entry.
            System.out.println();
        }
    }

    // This method will determine each entry is less than given number.
    // After determining, it will make a new array to hold selected entries.
    public static int [] createLowerArray (int upperLimit, int [] arrayParam)   {
        // Make a new array to check entries.
        int [] checkArray = new int [arrayParam.length];
        int iNew = 0;                            // Set an int to get a length of new array.
        // Set a loop to print out the entries as many as the length of the array.
        for (int i = 0; i < arrayParam.length; i++) {
            // Check every entry using an if statement.
            if (arrayParam[i] < upperLimit) {
                checkArray[iNew] = arrayParam[i];
                iNew++;
            }
        }
        int [] returnArray = new int [iNew];    // Set the other new array for return.
        // Fill in the array which will be retured with selected entry(ies).
        for (int i = 0; i < iNew; i++)
            returnArray[i] = checkArray[i];
        return returnArray;                     // Return the final array to main method.
    }

    // This method will categorize all entris in 8 sections,
    // < 1ft, < 2ft, < 3ft, < 4ft, < 5ft, < 6ft, < 7ft and < 8ft.
    // After that, it will be returned to new array with 8 lenghth.
    public static int [] buildFeetArray (int [] arrayParam) {
        int [] returnArray = new int [8];       // Set a new array to be returned.
        // Set a loop to print out the entries as many as the length of the array.
        for (int i = 0; i < arrayParam.length; i++) {
            // Initialize a variable to increase each section properly.
            int feetCheck = arrayParam[i] / 12;
            // 1. less than 1 foot
            if (feetCheck < 1)
                returnArray[0]++;
            // 2. less than 2 feet
            else if (feetCheck < 2)
                returnArray[1]++;
            // 3. less than 3 feet
            else if (feetCheck < 3)
                returnArray[2]++;
            // 4. less than 4 feet
            else if (feetCheck < 4)
                returnArray[3]++;
            // 5. less than 5 feet
            else if (feetCheck < 5)
                returnArray[4]++;
            // 6. less than 6 feet
            else if (feetCheck < 6)
                returnArray[5]++;
            // 7. less than 7 feet
            else if (feetCheck < 7)
                returnArray[6]++;
            // 8. less than 8 feet
            else if (feetCheck < 8)
                returnArray[7]++;
        }
        return returnArray;         // Return the final array to main method.
    }
}
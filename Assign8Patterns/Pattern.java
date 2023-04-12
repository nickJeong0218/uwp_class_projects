
/**
 *  Name: YunHwan Jeong (jeong)
 *  Course: CSCI 241 - Computer Science I
 *  Assignment: 8
 * 
 * Project/Class Description:
 *  This class will use 2-dimensional arrays of characters: '*' and ' '.
 *  There are a bunch of methods in the class, and each method will create
 *  a different pattern of these characters.
 *  In this class a 2D array is going to be used as a grid.
 *  In the grid, many of methods which will be used in this class display patterns.
 *  All grids in this class will be considered as an exact same size.
 *  
 * Known Bugs:
 *  
 */

import java.util.*;

public class Pattern
{
    /**
     * This main method is going to invoke a lot of methods for patterns.
     * First, it will call 'findDimension()' to ask the user for an array dimension.
     * Then, it will declare a 2-dimensional array of characters
     * using the number that the user input for rows and columns,
     * and declare a character variable to hold a symbol; the character is '*'.
     * Finally, it will invoke methods in this order:
     * 1. leftDiagonal(), 2. rightDiagonal(), 3. xPattern(), 4. everyOther(), 5. pointDown(), 6.pointUp(),
     * and after each method, it will call 'print()' to print out pattern.
     */
    public static void main (String[]args)
    {
        // Initialize a variable holding int data-type by invoking findDimension method.
        int dimension = findDimension();

        // Instantiate a 2-dimensional array by using the number input by the user.
        char [][] myArray = new char [dimension][dimension];

        // Initialize a variable holding a character: '*'.
        final char sign = '*';

        // Invoke 6 methods in correct order, and print out by invoking print() method.
        myArray = leftDiagonal(sign,dimension);         // 1. leftDiagonal(char,int)
        print(myArray);                                 // Print out the first pattern.
        myArray = rightDiagonal(sign,dimension);        // 2. rightDiagonal(char,int)
        print(myArray);                                 // Print out the second pattern.
        myArray = xPattern(sign,dimension);             // 3. xPattern(char,int)
        print(myArray);                                 // Print out the third pattern.
        myArray = everyOther(sign,dimension);           // 4. everyOther(char,int)
        print(myArray);                                 // Print out the fouth pattern.
        myArray = pointDown(sign,dimension);            // 5. pointDown(char,int)
        print(myArray);                                 // Print out the fifth pattern.
        myArray = pointUp(sign,dimension);              // 5. pointUp(char,int)
        print(myArray);                                 // Print out the last pattern.

    }

    /**
     * This method will take no parameter and return an integer which will be used for rows and columns.
     * The number should be an odd number between 3 and 11, inclusive.
     * If the number entered is not fit, then keep asking until get an integer which is proper.
     */
    public static int findDimension ()
    {
        // Initialize a variable that will hold the number to be returned, and Set a scanner for input.
        int num = 0;
        Scanner keyboard = new Scanner(System.in);

        // Print out the prompt and set a number input to the variable initialized.
        do  {
            // Ask the user to input a number which is included in the condition that it wants.
            System.out.print("Enter an integer which is between 3 and 11, inclusive as well as odd: ");
            num = keyboard.nextInt();
            // Print out a correct error message for incorrent number.
            if ((num < 3) || (num > 11))
                System.out.println("The number entered is out of range.");
            else if (num % 2 == 0)
                System.out.println("The number entered is even, not odd."); 
        }   while (((num < 3) || (num > 11)) || (num % 2 == 0));
        return num;       // Return a number which fits criteria.
    }

    /**
     * From here, there will be 6 patterns on grids. All methods will take 2 same parameters: char and int.
     * Each method will make a 2-dimensional array that has special pattern.
     * After making an array, every method will return that array to main method.
     */
    /**
     * 1. leftDiagonal(char,int)
     * This method will make a pattern that has a diagonal line from upper-left to lower-right.
     */
    public static char [][] leftDiagonal (char signParam, int dimensionParam)
    {
        // Instantiate a new array which will be returned by using integer parameter.
        // Then, initialize a variable to fill out left entries, out of range.
        char [][] arrayParam = new char [dimensionParam][dimensionParam];
        char emptySign = ' ';

        // Fill in the array using a nested loop with correct condition: left diagonal.
        for (int row = 0; row < arrayParam.length; row++)   {
            for (int col = 0; col <arrayParam[row].length; col++)   {
                if (row == col)
                    arrayParam [row][col] = signParam;
                else if (row != col)
                    arrayParam [row][col] = emptySign;
            }
        }

        // Return the array.
        return arrayParam;
    }

    /**
     * 2. rightDiagonal(char,int)
     * This method will make a pattern that has a diagonal line from upper-right to lower-left.
     */
    public static char [][] rightDiagonal (char signParam, int dimensionParam)
    {
        // Instantiate a new array which will be returned by using integer parameter.
        // Then, initialize a variable to fill out left entries, out of range.
        char [][] arrayParam = new char [dimensionParam][dimensionParam];
        char emptySign = ' ';

        // Fill in the array using a nested loop with correct condition: right diagonal.
        for (int row = 0; row < arrayParam.length; row++)   {
            for (int col = 0; col <arrayParam[row].length; col++)   {
                if ((row + col) == (dimensionParam - 1))
                    arrayParam [row][col] = signParam;
                else if ((row + col) != (dimensionParam - 1))
                    arrayParam [row][col] = emptySign;
            }
        }

        // Return the array.
        return arrayParam;
    }

    /**
     * 3. xPattern(char,int)
     * This method will make a pattern that looks like a "X".
     */ 
    public static char [][] xPattern (char signParam, int dimensionParam)
    {
        // Instantiate a new array which will be returned by using integer parameter.
        // Then, initialize a variable to fill out left entries, out of range.
        char [][] arrayParam = new char [dimensionParam][dimensionParam];
        char emptySign = ' ';

        // Fill in the array using a nested loop with correct condition: X shape.
        for (int row = 0; row < arrayParam.length; row++)   {
            for (int col = 0; col <arrayParam[row].length; col++)   {
                if (((row + col) == (dimensionParam - 1)) || (row == col))
                    arrayParam [row][col] = signParam;
                else
                    arrayParam [row][col] = emptySign;
            }
        }

        // Return the array.
        return arrayParam;
    }

    /**
     * 4. everyOther(char,int)
     * This method will make a pattern that is filled of diamond shapes.
     * It will have centers of diamonds at even columns, and centers are empty.
     */
    public static char [][] everyOther (char signParam, int dimensionParam)
    {
        // Instantiate a new array which will be returned by using integer parameter.
        // Then, initialize a variable to fill out left entries, out of range.
        char [][] arrayParam = new char [dimensionParam][dimensionParam];
        char emptySign = ' ';

        // Fill in the array using a nested loop with correct condition: diamond shapes.
        for (int row = 0; row < arrayParam.length; row++)   {
            for (int col = 0; col < arrayParam[row].length; col++)  {
                if (((row % 2 == 0) && (col % 2 == 1))
                ||((row % 2 == 1) && (col % 2 == 0)))
                    arrayParam [row][col] = signParam;
                else
                    arrayParam [row][col] = emptySign;
            }
        }

        // Return the array.
        return arrayParam;
    }

    /**
     * 5. pointDown(char,int)
     * This method will make a pattern that seems like an arrow-head that point downward.
     */
    public static char [][] pointDown (char signParam, int dimensionParam)
    {
        // Instantiate a new array which will be returned by using integer parameter.
        // Then, initialize a variable to fill out left entries, out of range.
        char [][] arrayParam = new char [dimensionParam][dimensionParam];
        char emptySign = ' ';

        // Fill in the array using a nested loop with correct condition: arrow-head downward.
        for (int row = 0; row < arrayParam.length; row++)   {
            for (int col = 0; col < arrayParam[row].length; col++)  {
                // Divide columns in 2 parts; the standard is (length of column) / 2.
                // Eliminate the range of rows to manipulate the size for each integer.
                if (row <= (dimensionParam / 2))   {
                    // For indexes part that smaller than standard or same with standard:
                    if (col <= dimensionParam / 2)  {
                        if (col >= row)
                            arrayParam [row][col] = signParam; 
                        else
                            arrayParam [row][col] = emptySign;
                    }
                    // For indexes part that bigger than standard:
                    else if (col > dimensionParam / 2)  {
                        if ((arrayParam[row].length - col) > row)
                            arrayParam [row][col] = signParam;
                        else
                            arrayParam [row][col] = emptySign;
                    }
                }
            }
        }

        // Return the array.
        return arrayParam;
    }

    /**
     * 6. pointUp(char,int)
     * This method will make a pattern that seems like an arrow-head that point upward.
     */
    public static char [][] pointUp (char signParam, int dimensionParam)
    {
        // Instantiate a new array which will be returned by using integer parameter.
        // Then, initialize a variable to fill out left entries, out of range.
        char [][] arrayParam = new char [dimensionParam][dimensionParam];
        char emptySign = ' ';

        // Fill in the array using a nested loop with correct condition: arrow-head upward.
        for (int row = 0; row < arrayParam.length; row++)   {
            for (int col = 0; col < arrayParam[row].length; col++)  {
                // Divide columns in 2 parts; the standard is (length of column) / 2.
                // Eliminate the range of rows to manipulate the size for each integer.
                if (row <= (dimensionParam / 2))   {
                    // For indexes part that smaller than standard or same with standard:
                    if (col <= dimensionParam / 2)  {
                        if ((row + col) >= (dimensionParam / 2))
                            arrayParam [row][col] = signParam; 
                        else
                            arrayParam [row][col] = emptySign;
                    }
                    // For indexes part that bigger than standard:
                    else if (col > dimensionParam / 2)  {
                        if (row >= (col - dimensionParam / 2))
                            arrayParam [row][col] = signParam;
                        else
                            arrayParam [row][col] = emptySign;
                    }
                }
            }
        }

        // Return the array.
        return arrayParam;
    }

    /**
     * This method will print out 2-dimensional arrays in a form.
     * Therefore, it will have an array as a parameter, but will not return.
     * The contents of the array will be displayed being wrapped by hyphens: '-'.
     * Additionally, there will be a space between every content as well as the first and the last.
     */
    public static void print (char [][] arrayParam)
    {
        // Print out hyphens at the top before printing out the contents.
        for (int i = 0; i <= 2 * arrayParam[0].length; i++)
            System.out.print("-");

        // Go to next line after the top hyphens.
        System.out.println();

        // Make a nested-loop to print out contents of the array.
        // The outer loop will use the length of row, and the inner loop will use the length of column.
        for (int row = 0; row < arrayParam.length; row++) {
            for (int col = 0; col < arrayParam[row].length; col++)   {
                // Print out each content with a space.
                System.out.print(" " + arrayParam[row][col]);

                // Go to next line after one row.
                if (col == arrayParam[row].length - 1)
                    System.out.println();
            }
        }

        // Print out hyphens at the bottom before printing out the contents.
        for (int i = 0; i <= 2 * arrayParam[0].length; i++)
            System.out.print("-");

        // Go to next line after the bottom hyphens.
        System.out.println();
    }
}
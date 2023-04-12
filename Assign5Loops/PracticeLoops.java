
/**
 * Name: YunHwan Jeong (jeong)
 * Course: CSCI 241 - Computer Science I
 * Assignment: 5
 * 
 *Project/Class Description:
 * This class will practice 3 kinds of loops
 * 1. while  2. for  3. do-while
 * There are 5 sections to practice loops
 * and this class will use printf() command to format output
 * Also, every section ends by printing underscores
 */

import java.util.*;

public class PracticeLoops
{
    public static void main(String [] args)
    {
        /**
         * Section A
         * This section contains 1 or 2 while loop(s).
         * Section A will print out the integer values 10 - 50 orderly and reversely
         * also it is tab distance between integers.
         */
        // Print out the heading of Section A.
        System.out.println("          ------ Section A ------");
        System.out.println("(while) loop prints 10 through 50, then 50 down to 10, by tens.");
        System.out.println("Each set of numbers appears on its own line, tab distance apart.");
        System.out.println("========================================================================");

        // Write a while loop statement to print 10 through 50 in two ways.
        // Initialize value and Set a boolean variable to change increment and decrement.
        int numA = 1;
        boolean tracking = true;

        // Write a while loop with if statements to change addition and subtraction.
        while ((numA <= 5) && (numA > 0)) {
            System.out.print(numA * 10 + "\t");
            if (tracking)
                ++numA;
            else
                --numA;

            if (numA > 5)  {
                System.out.println();
                tracking = false;
                numA--;
            }
        }

        // Finish the Section A by printing out underscores.
        System.out.println("\n________________________________________________________________________");
        System.out.println();

        /**
         * Section B
         * This section contain all loop statements; while, for, do-while.
         * Section B will ask the user to input an integer between 3 and 10.
         * If the user entered incorrent value, print error message and keep asking new input value
         * by using do-while statement.
         * And while loop prints out "/\" shape as many as the user input.
         * Also, for loop sums up from 1 to the number the user entered and prints out.
         */
        // Print out the heading of Section B.
        System.out.println("          ------ Section B ------");
        System.out.println("(do-while) User enters a number between 3 and 10, inclusive.");
        System.out.println("(while) Loop runs and places that many /\\ symbol patterns");
        System.out.println("        between \"Spring\" and \"Break\".");
        System.out.println("(for) Loop runs to find the sum of all values between 1 and the entered number.");
        System.out.println("========================================================================");

        // Set a scanner to get the value from the keyboard.
        // Set a variable to be used for Section B.
        Scanner keyboard = new Scanner(System.in);
        int numB;

        // Write a do-while loop to ask the user to enter a number between 3 and 10
        // and print out error a message when the user entered wrong value.
        do  {
            System.out.print("Enter a number to use for Part B loops: ");
            numB = keyboard.nextInt();
            if ((numB < 3) || (numB > 10))
                System.out.println("Error:  number must be between 3 and 10, inclusive.");
        } while (!((numB >= 3) && (numB <= 10)));

        // After getting proper value from the user, use a while loop
        // to print out /\ between "Spring" and "Break".
        System.out.print("Spring");     // Print out "Spring" first.

        // Write the while loop to print out symbol.
        int countB = 0 ;                 // Initialize a variable to count times we need to print.
        while (countB < numB)    {
            System.out.print("/\\");
            countB++;
        }

        System.out.print("Break");      // Print out "Break" after the while loop.
        System.out.println("\n");

        // Write a for loop statement to add up to the number the user entered.
        int sum = 0;
        for (int addition = 1; addition <= numB; addition++)
            sum += addition;

        System.out.println("Sum of values 1 through " + numB + " = " + sum);        // Print out the result.

        // Close the Section B printing out underscores.
        System.out.println("________________________________________________________________________");
        System.out.println();

        /**
         * Section C
         * This section will contain do-while and for loop statements.
         * do-while loop is used to ask the user to input an integer between 5 and 50, inclusive 
         * and the integer should be a multiple of 5.
         * for loop prints values from the original down to 0 decreasing by 5 each time
         * and the width between each number is same as tab distance.
         */
        // Print out the heading of Section C.
        System.out.println("          ------ Section C ------");
        System.out.println("(do-while) User enters number: must be multiple of 5, between 5 and 50, inclusive.");
        System.out.println("(for) Loop prints values n->0, separated by tabs, by 5's.");
        System.out.println("========================================================================");

        // Set a variable name that will be used for Section C.
        int numC;

        // Write a do-while loop statement to ask the user to input.
        // If the number is not fit in the range, print an error message.
        do  {
            System.out.print("Enter a multiple of 5: ");
            numC = keyboard.nextInt();
            if (((numC < 5) || (numC > 50)) || (numC % 5 != 0))
                System.out.println("Error: Enter a multiple of 5 between 5 and 50, inclusive.");
        } while((numC % 5 != 0) || !((numC >= 5) && (numC <=50)));

        // After getting a correct value, print values
        // from the original down to 0 decreasing by 5 each time using a for loop.
        int multiple = 0;
        for (multiple = numC; multiple >= 0; multiple -= 5)
            System.out.print(multiple + "\t");

        // Finish the Section C by printing out underscores.
        System.out.println("\n________________________________________________________________________");
        System.out.println();

        /**
         * Section D
         * This section will have one for loop.
         * Section D will display a table about pounds and kilograms.
         * for loop converts pounds that increse by 15 to kilograms
         * and show the result with prinf() command to format output.
         */
        // Print out the heading of Section D.
        System.out.println("          ------ Section D ------");
        System.out.println("(for) Loop shows range of values representing weights from 1 to 91 pounds.");
        System.out.println("Using increments of 15, calculates equivalent kilograms.");
        System.out.println("==============================================================================");

        // Print the table heading.
        System.out.println("      Pounds         Kilograms");
        System.out.println("--------------------------------");

        // Use a for loop to convert and display the result on the table.
        int pounds;
        double kilograms;
        for (pounds = 1; pounds <=91; pounds += 15) {
            kilograms = pounds * 0.453592;
            System.out.printf("      %5d         %5.2f", pounds, kilograms);
            System.out.println();
        }

        // Close the Section D printing out underscores.
        System.out.println("________________________________________________________________________");

        /**
         * Section E
         * This section will use a nested loop; nested-for loop
         * Section E will make a table that prints out a same number 10 times in a row.
         * And if the number is even, then it will print (number + 2)
         */
        // Print out the heading of Section E.
        System.out.println("          ------ Section E ------");
        System.out.println("(Nested for-loop)");
        System.out.println("Starting with the integer 1, print 6 rows of digits, 10 digits per row.");
        System.out.println("If the number is odd, it will print the number.");
        System.out.println("If the number is even, it will print the number + 2.");
        System.out.println("The outer loop will control the row number.");
        System.out.println("The inner loop will print the same value 10 times.");
        System.out.println("========================================================================");

        // Write a nested-for loop to make a table which is same as the heading.
        // Print out the heading of the table.
        System.out.println("   Rows of Digits");
        System.out.println("-------------------");

        // Use a nested-for loop.
        int numE;
        for (numE = 1; numE <= 6; numE++)   {
            if (numE % 2 == 0)  {
                numE += 2;
                for(int countE = 0; countE < 10; countE++)
                    System.out.printf("%-2d", numE);
                System.out.println();
                numE -= 2;
            }
            else    {
                for(int countE = 0; countE < 10; countE++)
                    System.out.printf("%-2d", numE);
                System.out.println();
            }
        }
    }
}    
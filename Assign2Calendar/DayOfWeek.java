
/**
 *  Name: YunHwan Jeong (jeong)
 *  Course: CSCI 241 - Computer Science I
 *  Assignment: 2
 * 
 * Project/Class Description:
 *  This class will figure out the day of the week in the Gregorian calender
 *  by using a formula that require the user to type
 *  the day, month offset, and year.
 *  
 *  Known bugs:
 *   None
 */

import java.util.*;

public class DayOfWeek
{
    public static void main(String[]args)
    {
        // Print out the heading of this program
        // to explain what this program will do.
        System.out.println("This program calculates the day of the week");
        System.out.println("for any year, month and day.");
        System.out.println();

        // Request the user to type the year
        // 1. Set up Scanner for input from keyboard
        Scanner keyboard = new Scanner(System.in);

        // 2. Prompt for year
        System.out.print("Enter year (4 digits): ");
        int year = keyboard.nextInt();

        // Display the table of month offset to make the user
        // type the number that matched with the month on this table.

        System.out.println("Here is the offset nembers table:");
        System.out.println("Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec");
        System.out.println(" 0   3   3   6   1   4   6   2   5   0   3   5");
        System.out.println();

        // Prompt for the date; ask month offset first, then day
        System.out.print("Enter the month offset: ");
        int month = keyboard.nextInt();
        System.out.print("Enter day (1-31): ");
        int day = keyboard.nextInt();
        System.out.println();

        /** Complete this formula to get the day in Gregorian calendar.
         * D = (d + m + yy + q + c) modulus 7 
         * D is what this program will get; the day of week
         * d is the the day of month; the user already entered
         * m is the month offset; the user already entered
         * yy is the year within the century; 2 digits
         * q is the quotient of yy/4
        /** c is the century offset; this program will use this formula
         * c = (39 - cc) modulus 4 X 2
         * where cc is the 2 digit century
         * ex) for 2019, cc is 20
         */
        // Set undefined variables; yy, q & c
        int yearLast = year % 100;                  // for yy; yearLast
        int quotient = yearLast / 4;                // for q; quotient
        int century = (39 - year / 100) % 4 * 2;    // for c; century

        // Plug the variables in the equation to get D
        int dayOfWeek = (day + month + yearLast + quotient + century) % 7;

        // Show that this program has finished calculating to get day of week.
        System.out.println("I got it!");
        System.out.println();

        // Display the answer key to let the user know the day of week
        // which corresponds with numbers 1 through 7.
        System.out.println("0 = Sunday, 1 = Monday, 2 = Tuesday, 3 = Wednesday,");
        System.out.println("4 = Thursday, 5 = Friday, 6 = Saturday");
        System.out.println();

        // Print out the result of the equation for day of week
        System.out.println("The answer is: " + dayOfWeek);
    }
}
 
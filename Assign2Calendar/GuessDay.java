
/**
 * YunHwan Jeong (jeong)
 * 
 * Project/Class Description:
 * This class "plays" the game of guessing a month and day
 * 
 * Rather than getting a random month and day, it has to ask
 * the user to enter a month and day.
 * It then goes through series of arithmetic operations
 * which will reproduce that month and day.
 * 
 * Here is the algorithm:
 * 1. Get the month and day from the keyboard
 * 2. Multiply the month by 7
 * 3. Subtract 1
 * 4. Multiply by 13
 * 5. Add the day
 * 6. Add 3
 * 7. Multiply by 11
 * 8. Subtract the month
 * 9. Subtract the day
 * 10. Divide by 10
 * 11. Add 11
 * 12. The day is the last 2 digits, and the month is the rest
 *
 * Known bugs:  LOTS!!!
 */

import java.util.*;

public class GuessDay
{
    public static void main(String[]args)
    {
        // Print out the heading of this program
        System.out.println("Welcome to my date-guessing program!");
        System.out.println("====================================");

        // program will guess the date you enter, month and day
        System.out.println("This program will guess the month and day entered");
        System.out.println("after performing a series of arithmetic operations.");
        System.out.println();

        // Set up Scanner for input from keyboard
        Scanner keyboard = new Scanner(System.in);

        // Prompt for date (month entered first, then day)
        System.out.print("Enter month: ");
        int month = keyboard.nextInt();
        System.out.print("Enter day: ");
        int day = keyboard.nextInt();

        // Perform the operations, in order specified in algorithm
        double num = 7 * month;   // num holds the running total
        num = num - 1;
        num = num * 13;
        num = num + day;
        num = num + 3;
        num = num * 11;
        num = num - month;
        num = num - day;
        num = num / 10;
        num = num + 11;

        // extract the guess in 2 parts
        int guessMonth = (int)(num / 100);
        int guessDay = (int)(num % 100);

        // print the results
        System.out.println();
        System.out.println("Your month was: " + guessMonth);
        System.out.println("Your day was: " + guessDay);
    }
}
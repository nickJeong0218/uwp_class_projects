
/**
 *  Name: YunHwan Jeong (jeong)
 *  Course: CSCI 241 - Computer Science I
 *  Assignment: 6
 *  
 * Project/Class Description:
 *  This class will make a cake tower
 *  using proper 'for' or 'do-while' loop, and defining and invoking methods.
 *  There are 9 methods including a main method.
 *  The cake tower is constructed with 3 parts, candle, tiers, and brick stacks.
 *  
 * Known bugs:
 *  None
 */

import java.util.*;

public class CakeTower
{
    public static void main (String[]args)
    {
        int size = askForSize();
        drawTop(size);
        drawTiers(size);
        drawBrickStack(size);
    }

    // This method will be asking an integer that will be used for this class.
    // If the number that user input is out of range,
    // then this method will print out an error message which is proper for the wrong number,
    public static int askForSize ()
    {
        // Set a scanner to get an integer from the user.
        int num = 0;
        Scanner keyboard = new Scanner(System.in);
        do  {
            // Ask for the user to input a number which is fit in the range.
            System.out.print("Enter an odd integer between 3 and 9 for the size of tower: ");
            num = keyboard.nextInt();
            // It the integer is out of range, display a correct error message.
            if ((num > 9) || (num < 3))
                System.out.println("The number entered is out of the range.");
            else if (num % 2 == 0)
                System.out.println("The number entered is even."); 
        } while((num > 9) || (num < 3) || (num % 2 == 0));
        return num;         // return the integer that the user input to use for whole program.
    }

    // This method will print out two borders which are upper and lower than brick stacks each.
    // It will require three letters, and print out first and third letters only one time,
    // and repeat the second letter untill the length becomes same as the bricks.
    public static void drawBorder (char leftParam, char midParam, char rightParam, int sizeParam)
    {
        // Print out the left side of the border.
        System.out.print(leftParam);
        // Print out the middle character to be the same length of the brick stacks.
        for (int repetition = 0; repetition < (sizeParam * 9); repetition++)
            System.out.print(midParam);
        // Print out the right side of the border.
        System.out.print(rightParam + "\n");
    }

    // This method will print out one of the lines in brick stacks, a full brick line.
    // In addition, this method will be called in 'drawBrickStack' method.
    public static void drawFullBrickLine (int sizeParam)
    {
        // Print out the border of the full brick stack.
        System.out.print("[");
        // Make a brick with 9 length for each full brick.
        // The length of bricks should be same as: 9 * the integer user input.
        for (int times = 0; times < sizeParam; times++)
            System.out.print("|_______|");
        // Print out the border of the full brick stack.
        System.out.print("]\n");
    }

    // This method will print out one of the lines in brick stacks, a half brick line.
    // In addition, this method will be called in 'drawBrickStack' method.
    public static void drawHalfBrickLine (int sizeParam)
    {
        // Print out the border of the half brick stack with the first half of a brick.
        System.out.print("[|___|");
        // Make a brick with 9 length for each full brick.
        // The length of bricks should be same as: 9 * (the integer user input - 1).
        for (int times = 1; times < sizeParam; times++)
            System.out.print("|_______|");
        // Print out the border of the half brick stack with the last half of a brick.
        System.out.print("___|]\n");
    }

    // This method will invoke two methods above, drawFullBrickLine and drawHalfBrickLine.
    // This will use a 'for' loop to call two methods for a half of the integer input.
    public static void drawBrickStack (int sizeParam)
    {
        // Invoke the methods that make brick lines with the half height of the integer input,
        // and the border lines top and bottom of the brick lines.
        // 1. drawFullBrickLine(int) 2. drawHalfBrickLine(int) 3.drawBorder(char, char, char, int)
        
        // Invoke the top border line with correct characters: /, ^ and \.
        drawBorder('/', '^', '\\', sizeParam);
        for (int count = 0; count < (sizeParam / 2); count++)  {
            drawFullBrickLine(sizeParam);       // Invoke full brick line first.
            drawHalfBrickLine(sizeParam);       // Invoke half brick line second.
        }
        // Invoke the bottom border line with correct charachers: \, = and /.
        drawBorder('\\', '=', '/', sizeParam);
    }

    // This method will make the top part of the cake tower.
    // First, it will print a '*', which seems like a burning part of a match.
    // Then, it will print '|'s, which seems like a body of a match.
    // Finally, it will print out the boundary between the top part and the tier part.
    public static void drawTop (int sizeParam)
    {
        for (int count = 0; count < 4; count++)  {
            System.out.print(" ");          // Make a space before start because of the border.
            // Adjust the starting point to the center of the cake using spaces.
            for (int times = 0; times < (sizeParam / 2) * 9; times++)
                System.out.print(" ");
            // Print out the candle orderly:
            //  a multiplication sign, two vertical bars, and nine equal signs.
            if (count == 0)
                System.out.print("    *\n");
            else if ((count > 0) && (count < 3))
                System.out.print("    |\n");
            else
                System.out.print("=========\n");
        }
    }

    // This method will print out block with different lengths,
    // which is the components of the tiers.
    // The block is divided as 3 parts,
    // statring & ending parts: |.. & ..|, 6 dots: ......, 3 characters: xxx.
    public static void drawBlock (int sizeParam, int tierParam)
    {
        for (int count = 0; count < (sizeParam / 2); count++) {
            System.out.print(" ");      // Make a space before start because of the border.
            // Adjust the correct starting points using spaces.
            for (int space = (sizeParam / 2) * 9; space > (tierParam / 2) * 9; space--)
                System.out.print(" ");
            // Start the tiers with one vertical bar, and two dots.
            System.out.print("|..");
            // Repeat the patterns correctly related to the size of the cake.
            for (int repetitionDot = 1; repetitionDot <= (tierParam / 2); repetitionDot++)
                System.out.print("......");
            for (int repetitionX = 0; repetitionX < tierParam; repetitionX++)
                System.out.print("xxx");
            for (int repetitionDot = 1; repetitionDot <= (tierParam / 2); repetitionDot++)
                System.out.print("......");
            // Finish the tiers with two dots, and one vertical bar.  
            System.out.print("..|\n");
        }
    }

    // This method will invoke a method above, drawBlocks.
    // According to the integer which user input,
    // the number and length of the blocks will be changed.
    public static void drawTiers (int sizeParam)
    {
        int tierForParam = 0;           // Initialize an int for the tier of the invoked methods.
        int sizeForParam = sizeParam;   // Initialize an int for the size of the invoked methods.
        // Repeat invoking method for proper times.
        for (int tier = 1; tier <= (sizeParam / 2); tier++)   {
            // Modify the int initialized to use as a parameter.
            tierForParam = 2 * tier - 1;
            // Invoke the method for the tiers.
            // drawBlock(int, int)
            drawBlock(sizeForParam, tierForParam);
        }
    }
}
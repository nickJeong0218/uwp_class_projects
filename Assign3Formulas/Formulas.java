
/**
 *  Name: YunHwan Jeong (jeong)
 *  Course: CSCI 241 - Computer Science I
 *  Assignment: 3
 *  
 * Project/Class Description:
 *  This class will be used to calculate 
 *  by using mathematical formulas
 *  Also, this class will ask users to enter numbers 
 *  for the calculations and it will print out the result
 *  
 *  Known bugs:
 *   None
 */

import java.util.*;

public class Formulas
{
    public static void main(String[]args)
    {
        // Print out the heading of this program
        // telling users to usually input integers.
        System.out.println("This program will demonstrate mathematical formulas.");
        System.out.print("\nMost numbers entered will be integers.  ");
        System.out.println("Instructions will specify");
        System.out.println("when you can enter numbers with decimal places.");
        System.out.println();

        // Set a scanner to input numbers for formulas.
        Scanner input = new Scanner(System.in);

        // First formula:
        /**
         * This formula will ask the user to input a square's side.
         * It will calculate the square area and cube volume
         * and print out the result of calculation.
         */
        // Explain the formula and divide section for this formula.
        // If it doesn't have to be explained just divide.
        System.out.println("---------------------------------------------------------");

        // Ask the side of a square to the user.
        System.out.print("Enter the length of a square's side: ");
        int side = input.nextInt();

        // Calculate the area of the square and the volume of cube with the length.
        double areaSq = Math.pow(side,2);
        double volumeSq = Math.pow(side,3);

        // Print out the result of this formula.
        System.out.print("With side length = " + side);
        System.out.println(", square area = " + areaSq + " and cube volume = " + volumeSq);
        System.out.println("---------------------------------------------------------");
        System.out.println();

        // Second formula:
        /**
         * This formula will ask the user to input two numbers that will get into square root.
         * After getting the numbers, this formula will do square root to each number
         * and multiply two remaining numbers.
         * Finally, it will print out the result of calculation.
         */
        // Explain the formula and divide section for this formula.
        // If it doesn't have to be explained just divide.
        System.out.println("---------------------------------------------------------");
        System.out.println("Now checking if \u221a(xy) = \u221ax times \u221ay");

        // Ask two numbers to the user.
        System.out.print("Enter a value for variable x: ");
        int beforeX = input.nextInt();
        System.out.print("Enter a value for variable y: ");
        int beforeY = input.nextInt();

        // Calculate the square roots and multiplication.
        double sqrtX = Math.sqrt(beforeX);
        double sqrtY = Math.sqrt(beforeY);
        double resultOfXY = sqrtX * sqrtY;
        double sqrtXY = Math.sqrt(beforeX * beforeY);

        // Print out the results of square roots and multiplication.
        System.out.println("Square root of x = " + sqrtX);
        System.out.println("Square root of y = " + sqrtY);
        System.out.println("\u221ax times \u221ay = " + resultOfXY);
        System.out.println("Square root of x times y = " + sqrtXY);
        System.out.println("---------------------------------------------------------");
        System.out.println();

        // Third formula:
        /**
         * This formula will ask the user to input two lengths with decimal.
         * One of them is a side of square pyramid base and the other is a height.
         * This formula will calculate the area of surface area and volume
         * of the square pyramid.
         * The volume will be rounded to 3 decimal places.
         */
        // Explain the formula and divide section for this formula.
        // If it doesn't have to be explained just divide.
        System.out.println("---------------------------------------------------------");

        // Ask to type in two numbers each for the length of a side of base and height.
        // The numbers will be available with decimal.
        System.out.printf("Enter length of square pyramid base (with decimal): ");
        double sideOfBase = input.nextDouble();
        System.out.printf("Enter height of square pyramid (with decimal):      ");
        double height = input.nextDouble();

        // Display the inputs; a side of base and height.
        System.out.println("For a square pyramid with base = " + sideOfBase);
        System.out.println("and height = " + height + ",");

        // Calculate the area of surface area and volume of square pyramid.
        double areaPy = Math.pow(sideOfBase,2) + 2 * sideOfBase 
            * Math.sqrt(height * height + 0.25 * Math.pow(sideOfBase,2));
        double volumePy = 1 / 3.0 * Math.pow(sideOfBase,2) * height;

        // Round the result of surface area to 2 decimal places.
        areaPy += 0.005;
        areaPy = (int)(areaPy * 100);
        areaPy /= 100;

        // Print out the results of calculations
        System.out.println("Surface Area = " + areaPy);
        System.out.printf("Volume (rounded to 3 decimal places) = %.3f", volumePy);
    }
}
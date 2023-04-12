/**
 * Name: YunHwan Jeong (jeong)
 * Course: CSCI 241 - Computer Science I
 * Assignment: 4
 *
 * Square.java
 * 
 * This program draws a square in a Graphic Window and 
 * tests user mouse clicks to see if they clicked inside the square
 * 
 * Known bugs:  NOT FINISHED YET!
 */
import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
/*** Need another import??? ***/
import java.util.*;

public class Square extends GraphicsProgram
{
    // Instance variables
    private int side;        // the length of a side
    private int anchorX;     // the X value at the upper left corner
    private int anchorY;     // the Y value at the upper left corner

    /**
     * Constructor for objects of class Square that
     * includes square placement
     */
    public Square(int x, int y, int side)
    {
        anchorX = x;
        anchorY = y;
        this.side = side;
    }

    // mouseClicked method
    public void mouseClicked (MouseEvent e) 
    {
        // Find the location where the mouse was clicked
        int x = e.getX();
        int y = e.getY();

        // boolean variables to indicate location
        boolean isInside = false;   // indicates if click is inside (within border)
        boolean isOutside = false;  // indicates if click is outside (of the border)
        boolean isOnEdge = false;   // indicates if click is in the border area

        /*** Write an if-statement to set isInside to true when it is in range. ***/
        if ((x < (anchorX + side -1) && x > (anchorX + 1))
        && (y < (anchorY + side - 1) && y > (anchorY + 1)))
            isInside = true;

        /*** Write an if-statement to set isOutside to true when it is in range. ***/
        else if ((x < (anchorX - 1) || x > (anchorX + side + 1))
        || (y < (anchorY -1) || y > (anchorY + side + 1)))
            isOutside = true;

        /*** Write an if-statement to set isOnEdge to true when it is in range ***/
        /*** NOTE: There a hard, and an easy way to do this! ***/
        else
            isOnEdge = true;

        /*** Check the values of the boolean variables you set above. ***/
        /*** Write an if-else if-else statement to draw the appropriately-colored ***/
        /*** circle at the mouse-clicked location. ***/

        /*** These lines run when the click is on the edge. ***/
        if (isOnEdge)   {
            System.out.println ("(" + x + ", " + y + 
                ") is on the square");
            GOval circle = new GOval(x-2,y-2,4,4);
            circle.setFillColor(Color.GREEN);
            circle.setFilled(true); 
            add(circle);
        }  

        /*** These lines run when the click is inside the square ***/
        else if (isInside)   {
            System.out.println ("(" + x + ", " + y + 
                ") is inside the square");
            GOval circle = new GOval(x-2,y-2,4,4);
            circle.setFillColor(Color.RED);
            circle.setFilled(true); 
            add(circle);          
        }

        /*** These lines run when the click is outside the square ***/
        else if (isOutside)   {
            System.out.println ("(" + x + ", " + y + 
                ") is outside the square");
            GOval circle = new GOval(x-2,y-2,4,4);
            circle.setFillColor(Color.BLUE);
            circle.setFilled(true);
            add(circle);
        }

        /*** This line runs when the others are not matched ***/
        else
            System.out.println ("This should never happen!");
    }

    /**
     * Add the square to the graphic window.
     * Also, register a mouse handler.
     */
    public void startGUI()
    {
        GRect square = new GRect(anchorX, anchorY, side, side);
        add(square);
        addMouseListeners();
    }

    // main() runs to gather values and display square in graphic window
    public static void main (String [] args)
    {  
        int x = 0;      // holds the upper-left x-position
        int y = 0;      // holds the upper-left y-position
        int side = 0;   // holds length of square's side

        /*** Use println() to explain program. ***/
        System.out.println("This program draws a square in a graphic window.");
        System.out.println("Upper-left x- and y- positions, as well as side length,");
        System.out.println("will be entered from the keyboard.");

        /*** Set up a Scanner for keyboard input. ***/
        Scanner keyboard = new Scanner(System.in);

        /*** Make sure all input values are in their ranges. ***/
        System.out.print("Enter upper-left x-position between 25 and 500, inclusive: ");
        x =keyboard.nextInt();
        System.out.print("Enter upper-left y-position between 25 and 500, inclusive: ");
        y = keyboard.nextInt();
        System.out.print("Enter length of square's side, must be at least 25: ");
        side = keyboard.nextInt();

        /*** If any number is out of range, fix it. ***/
        if (x < 25 || x > 500)  {
            System.out.println("Error: the x-coordinate is out of range.");
            System.out.println("x-value changed to 25.");
            x = 25;
        }
        if (y < 25 || y > 500)  {
            System.out.println("Error: the y-coordinate is out of range.");
            System.out.println("y-value changed to 25.");
            y = 25;
        }
        if (side < 25)  {
            System.out.println("Specified side too short; changed to 25.");
            side = 25;
        }
        /*** By the time you finish, x, y and side should have ***/
        /*** values that are in range. ***/

        /*** DO NOT CHANGE THESE LINES, AND KEEP THEM AT THE
         * END OF main() ***/
        // run the constructor
        Square slate = new Square(x,y,side);
        slate.start();
        slate.startGUI();
    }
}

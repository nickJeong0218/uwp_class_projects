
package fibonacci;

import java.util.Scanner;

/**
 * A simple program to calculate Fibonacci numbers recursively.
 * @author Stuart Hansen
 */
public class RecFib {
    // A recursive function to calucate Fibonacci numbers
    public static int fibonacci (int n) {
        if (n==0 || n==1)
            return n;
        else
            return fibonacci(n-1) + fibonacci(n-2);
    }
    
    // A simple test main
    public static void main (String [] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int n = in.nextInt();
        System.out.println(fibonacci(n));
    }
}

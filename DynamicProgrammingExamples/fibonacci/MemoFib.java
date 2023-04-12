
package fibonacci;

import java.util.Scanner;

/**
 * A program to use memo-izing to speed up Fibonacci calculations.
 * @author Stuart Hansen
 */
public class MemoFib {
    private static int [] fibArray;
    
    // A recurive function using memo-izing to calculate Fibonacci numbers.
    public static int fibonacci(int n) {
        if(fibArray[n] != 0)
            return fibArray[n];
        if (n == 0 || n == 1) {
            return n;
        } else {
            fibArray[n] = fibonacci(n - 1) + fibonacci(n - 2);
            return fibArray[n];
        }
    }

    // test main
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int n = in.nextInt();
        fibArray = new int [n+1];
        
        System.out.println(fibonacci(n));
    }
}

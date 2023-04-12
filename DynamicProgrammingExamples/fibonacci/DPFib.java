package fibonacci;

import java.util.Scanner;

/**
 * A program to use dynamic programming to calculate Fibonacci numbers
 * @author Stuart Hansen
 */
public class DPFib {
    private static int [] fibArray;
    
    // Fills an array with Fibonacci numbers.
    public static void fillArray(int n) {
        fibArray = new int[n+1];
        fibArray[0] = 0;
        fibArray[1] = 1;
        for (int i=2; i<=n; i++)
            fibArray[i] = fibArray[i-1] + fibArray[i-2];
    }
    
    // A dynamic programming version of Fibonacci
    public static int fibonacci(int n) {
                return fibArray[n];
    }

    // Test main
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int n = in.nextInt();
        fillArray(n);
        
        System.out.println(fibonacci(n));
    }
}


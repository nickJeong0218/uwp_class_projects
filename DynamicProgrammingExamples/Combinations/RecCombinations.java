package Combinations;

import java.util.Scanner;

/**
 * Program to illustrate calculating combinations recursively
 * @author Stuart Hansen
 */
public class RecCombinations {
    
    // Calculates the combinations using recursion
    public static int combinations (int n, int k)
    {
        if (k==0 || n==k)
            return 1;
        else
            return combinations(n-1,k-1) + combinations(n-1, k);
    }
    
    // test main
    public static void main (String [] args) {
        System.out.print("Enter n and k: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        System.out.println(combinations(n,k));
    }
}

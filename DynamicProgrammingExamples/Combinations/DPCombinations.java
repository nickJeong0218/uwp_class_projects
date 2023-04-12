
package Combinations;

import java.util.Scanner;

/**
 * program to illustrate calculating combinations using dynamic programming.
 * @author Stuart Hansen
 */
public class DPCombinations {

    public static int combArr[][];

    // Use an array to look up the combinations
    public static int combinations(int n, int k) {
        if (n<0 || k<0 || k>n)
        {
            System.err.println("Error! n or k out of range!");
            return 0;
        }
        return combArr[n][k];
    }
    
    // Initialize the array
    public static void init() {
        combArr = new int[31][31];
        for (int i = 0; i < 31; i++) {
            combArr[i][0] = 1;
            combArr[i][i] = 1;
        }
        for (int n = 2; n < combArr.length; n++) {
            for (int k = 1; k < n; k++) {
                combArr[n][k] = combArr[n - 1][k - 1] + combArr[n - 1][k];
            }
        }
    }
    
    // Test main
    public static void main(String[] args) {
        init();

        System.out.print("Enter n and k: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        System.out.println(combinations(n, k));
    }
}
package changepossible;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Program to figure out whether change can be made using memo-izing.
 * @author Stuart Hansen
 */
public class MemoCountChange {

    private static ArrayList<Integer> coins;
    private static int canDo[][];
    private static int sum;

    // Uses a 2D array to see if it is possible to make change with the 
    // available coins
    public static boolean changePossible(int n, int nextCoin) {
        if (n == 0) {
            canDo[n][nextCoin]= 1;
            return true;
        } else if (n < 0 || n > sum || nextCoin < 0 || canDo[n][nextCoin] == -1) {
            return false;
        } else if (canDo[n][nextCoin] == 1) {
            return true;
        } else {
            canDo[n][nextCoin] = changePossible(n - coins.get(nextCoin), nextCoin - 1)
                    || changePossible(n, nextCoin - 1) ? 1 : -1;
            return canDo[n][nextCoin] == 1;
        }
    }

    // Initialize the available coins and the canDo array
    public static void init() {
        coins = new ArrayList<>();
        coins.add(1);
        coins.add(1);
        coins.add(6);
        coins.add(6);
        coins.add(6);
        coins.add(25);
        for (int c : coins) {
            sum += c;
        }
        canDo = new int[sum + 1][coins.size()];
    }

    // Helper function to print the array
    private static void printArray() {
        for (int i = 0; i < canDo.length; i++) {
            System.out.printf("%5d:", i);
            for (int j = 0; j < canDo[0].length; j++) {
                System.out.printf("%5d ", canDo[i][j]);
            }
            System.out.println();
        }
    }

    // Test main
    public static void main(String[] args) {
        init();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int n = in.nextInt();

        System.out.println(changePossible(n, coins.size() - 1));
        //printArray();
    }
}

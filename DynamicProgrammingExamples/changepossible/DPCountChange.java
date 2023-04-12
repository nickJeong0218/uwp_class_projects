package changepossible;

import java.util.ArrayList;

/**
 * A program using dynamic programming to see if we can make change with the coins we
 * have.
 *
 * @author Stuart Hansen
 */
public class DPCountChange {

    private static ArrayList<Integer> coins;
    private static int sum;

    private static boolean[] possible; 

    // In this version our function simply is an array lookup.
    public static boolean changePossible(int n) {
        if (n>=0 && n<possible.length)
            return possible[n];
        else
            return false;
    }

    // Initialize our coins and our array
    public static void init() {
        coins = new ArrayList<>();
        coins.add(1);
        coins.add(1);
        coins.add(6);
        coins.add(6);
        coins.add(7);
        coins.add(23);
        for (int c : coins) {
            sum += c;
        }
        possible = new boolean[sum+1];
        possible[0] = true;
        for (int c: coins) {
            for (int i=possible.length-1; i>=0; i--)
                if (possible[i])
                    possible[i+c] = true;               
        }
    }

    public static void main(String[] args) {
        init();

        for (int n = 0; n <=sum; n++) {
            System.out.print(changePossible(n)+ " ");
        }
    }
}

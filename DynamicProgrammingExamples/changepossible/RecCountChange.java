package changepossible;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A recursive program to see if we can make change with the coins we have.
 * @author Stuart Hansen
 */
public class RecCountChange {

    private static ArrayList<Integer> coins;
    private static int sum;
    
    // Recursively see if it is possible to make change with the coins
    // available
    public static boolean changePossible(int n, int nextCoin) {
        if (n == 0)
            return true;
        else if (n < 0 || n > sum || nextCoin < 0)
            return false;
        else
            return changePossible(n-coins.get(nextCoin), nextCoin-1) || 
                    changePossible(n, nextCoin-1);
    }
    
    // Test main
    public static void enterCoins() {
        coins = new ArrayList<>();
      
        coins.add(1);
        coins.add(6);
        coins.add(6);
        coins.add(6);
        coins.add(10);
        for (int c: coins)
            sum += c;
    }

    public static void main(String[] args) {
        enterCoins();
        
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int n = in.nextInt();
        System.out.println(changePossible(n, coins.size()-1));
    }
}

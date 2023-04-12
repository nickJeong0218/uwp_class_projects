
package longestcommonsubsequence;

/**
 * This is a recursive version of lcsLength. It gives correct answers but
 * runs slowly.
 * @author Stuart Hansen
 * @version Sping 2019
 */
public class RecLCS {
    
    // This function takes substrings from the end back towards  the front to
    // be consistent with the assignment writeup
    public static int lcsLength(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0)
            return 0;
        if (s1.charAt(s1.length()-1)==s2.charAt(s2.length()-1))
            return 1+lcsLength(s1.substring(0, s1.length()-1), s2.substring(0,s2.length()-1));
        else
            return Math.max(lcsLength(s1, s2.substring(0, s2.length()-1)), lcsLength(s1.substring(0, s1.length()-1), s2));
    }
    
    // Test main
    public static void main (String [] args) {
        String s1 = "ABCBDAB";
        String s2 = "BDCABA";

        int lcs = lcsLength(s1, s2);
        double lcsScore = 200.0*lcs / (s1.length() + s2.length());
        System.out.println("The lcs of " + s1 + " and " + s2 + " is " + lcs);
        System.out.println("The lcs score of " + s1 + " and " + s2 + " is " + lcsScore);
    }
}

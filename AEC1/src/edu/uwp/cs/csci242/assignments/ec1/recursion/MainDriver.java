package edu.uwp.cs.csci242.assignments.ec1.recursion;

/**
 * This project contains 4 recursive problems.
 * <p>
 *     The problems are followings: stringClean, countDigit, isBalanced, splitArray.
 *     stringClean problem is clearing all the duplicated characters in the string.
 *     countDigit problem is counting how many times the given digit appears.
 *     isBalanced problem is checking whether the string has matched parentheses or brackets sets.
 *     splitArray problem is checking whether the array can be divided in 2 same amount of addition.
 * </p>
 *
 * @author YunHwan Jeong
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment Extra Credit 1
 * @bugs none
 */
public class MainDriver {

    /**
     * main() method will be used as the tester.
     * <p>
     *     it will test all the recursion with given strings and numbers.
     * </p>
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Test of stringClean():");
        String str = "aaabbccccd";
        System.out.println(stringClean(str));
        System.out.println();

        System.out.println("Test of countDigit():");
        System.out.println(countDigit(111222233, 2));
        System.out.println();

        System.out.println("Test of isBalanced():");
        System.out.println(isBalanced("[]()[{}]({}[])"));
        System.out.println();

        System.out.println("Test of splitArray():");
        int[] arr = new int[]{2,3,4,5,8,9,1};
        System.out.println(splitArray(arr));
        System.out.println();

        towerOfHanoi(1);
        System.out.println();
        towerOfHanoi(2);
        System.out.println();
        towerOfHanoi(3);
    }

    /**
     * stringClean() method will be used to clear all the duplicated.
     * <p>
     *     This method will check whether the string has any continuous duplicated character.
     *     If there is, it will delete the character leaving one and only character.
     * </p>
     * @param str the string that probably with duplicated characters.
     * @return the modified string without any duplication.
     */
    public static String stringClean (String str) {
        // Check and return the string if the string is 1 letter or less.
        if(str.length() <= 1) {
            return str;
        }
        // Check and return one & only character with recursion if the next character is different.
        else if(str.charAt(0) != str.charAt(1)) {
            return str.charAt(0) + stringClean(str.substring(1));
        }
        // Check are return the recursive call if the next character is same.
        else {
            return stringClean(str.substring(1));
        }
    }

    /**
     * countDigit() method will be used to count the digit in the number.
     * <p>
     *     This method will check how many the given digit appears in the number.
     *     The numeber and the digit will be given by parameters.
     *     It will check the number backward.
     * </p>
     * @param num the number that will be checked how many times the given digit comes out.
     * @param digit the digit that will be standard.
     * @return it will return the number of the given digit in the numeber.
     */
    public static int countDigit (int num, int digit) {
        // Check and return if the number is 0.
        if(num == 0) {
            return 0;
        }
        // Check and return if the last digit is same as the standard.
        else if(num % 10 == digit){
            return 1 + countDigit(num / 10, digit);
        }
        // Return the modified number to the same method.
        else {
            return countDigit(num / 10, digit);
        }
    }

    /**
     * isBalanced() method will checking the string with parentheses or brackets.
     * <p>
     *     This method checks if square brackets, curly brackets or parentheses are existed as sets.
     *     It will return true if this condition is met.
     *     It also checks if they are in the proper order. If not, the program will return false.
     * </p>
     *
     * @param str string with parentheses or brackets.
     * @return return the state of the string with true or false.
     */
    public static boolean isBalanced (String str) {
        //Check and return if the string contains {}.
        if (str.contains("{}")) {
            return isBalanced(str.replace("{}", ""));
        }
        //Check and return if the string contains []
        else if (str.contains("[]")) {
            return isBalanced(str.replace("[]", ""));
        }
        //Check and return if the string contains ().
        else if (str.contains("()")) {
            return isBalanced(str.replace("()", ""));
        }
        //Check and return true if the string is empty string.
        else if (str.isEmpty()) {
            return true;
        }
        // if it is not in proper order, return false.
        else {
            return false;
        }
    }

    /**
     * splitArray() method will check the array by dividing 2 parts.
     * <p>
     *     This method checks if the separated two sums are equal or not.
     *     If they are same, it will return true. Or it will return false.
     * </p>
     *
     * @param array list of array with integers.
     * @return true if 2 sums from the array are equal, if not, return false.
     */
    public static boolean splitArray (int[] array) {
        int index = 0;          // Instantiate the index.
        int sum1 = 0;           // Instantiate the sum1.
        int sum2 = 0;           // Instantiate the sum2.
        return helperOfArray(array, index, sum1, sum2);         // Call recursively the helper method.
    }

    /**
     * This method will help splitArray() method.
     * <p>
     *     It will get the array, index and 2 sums from splitArray() method.
     *     If the this method passed through all the entities, then it will return the result.
     *     It will add each entities to one of the sums till the end of the array.
     * </p>
     * @param array list of array with integers.
     * @param index the element's indext number.
     * @param sum1 One of the sums that will be checked.
     * @param sum2 The other one of the sums that will be checked.
     * @return true if 2 sums from the array are equal, if not, return false.
     */
    public static boolean helperOfArray (int[] array, int index, int sum1, int sum2) {
        if(index >= array.length) {
            // Return true or false.
            return sum1 == sum2;
        }
        else {
            int value = array[index];
            // Element belongs to sum1 or sum2.
            return helperOfArray(array, index + 1, sum1 + value, sum2)
                   || helperOfArray(array, index + 1, sum1, sum2 + value);
        }
    }

    public static void towerOfHanoi(int disk) {
        towerOfHanoiHelper(disk, "a", "b", "c");
    }

    public static void towerOfHanoiHelper(int disk, String a, String b, String c) {
        if (disk == 1) {
            System.out.println(a + b);
            System.out.println(b + c);
        }
        else {
            towerOfHanoiHelper(disk - 1, a, b, c);

    }
}
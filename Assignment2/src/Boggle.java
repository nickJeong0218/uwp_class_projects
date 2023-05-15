import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Boggle class will be used to make game board for boggle and to play the game.
 * <p>
 *     This class will have 5 instance variables: board which is game board, used which is boolean 2-dimensional array, words which store found words,
 *     dictionary which is used to store all available words and currentWord which tracks the string being made.
 *     In addition, it will have 2 inner-class: Lexicon and BoggleDie. Lexicon class will be used to fill out dictionary, and BoggleDie will be used to make the game board.
 *     Then, Boggle class will have one constructor, which has no parameter, default, and 4 methods: shuffle(), printBoard(), findWords() and main() method.
 * </p>
 * <p>
 *     First, this class will fill out the dictionary using a text file, ospd.txt or enable1.txt and one of inner-classes: Lexicon.
 *     Then, it will assign the game board as 4 X 4 as well as the second board checking whether the index is used or not.
 *     While assigning the board size, it will also use BoggleDie class to give the characters to each indices.
 *     Finally, it will find all possible words which are in the dictionary by using recursive methods.
 *     It will save all found words in a TreeSet, which is one of the instance variables, and print out the board and the words.
 * </p>
 * @author YunHwan Jeong
 * @uwp.edu.cs.340.course CSCI 340 - Data Structures and Algorithm Design
 * @edu.uwp.cs.340.section 001
 * @edu.uwp.cs.340.assignment 2
 * @bugs none
 */
public class Boggle {

    /*
    This instance variable will be used to make a game board.
     */
    private BoggleDie[][] board;

    /*
    This instance variable will be used to check whether each part of game board is used or not.
     */
    private boolean [][] used;

    /*
    This instance variable will be used to store all made words made from the game board.
     */
    private TreeSet<String> words;

    /*
    This instance variable will be used to store all possible words given by a text file.
     */
    private Lexicon dictionary;

    /*
    This instance variable will be used to track the word being made from the game board.
     */
    private String currentWord = "";

    /**
     * This constructor will be used to instantiate all instance variables of Boggle class to set up for playing Boggle game.
     * <p>
     *     It will assign the size of game board and tracking board as 4 X 4 by instantiating the size of arrays 4 by 4.
     *     Then, it will also instantiate the instance variable, words, that will store all found words.
     *     In order to make the dictionary, this constructor will give a name of text file that will be used to the constructor or Lexicon class.
     *     For the instance variable tracking on the word being made on the game board, it will instantiate the instance variable with empty String object.
     * </p>
     * @throws FileNotFoundException This exception will be thrown if the constructor of Lexicon class will throw exception.
     */
    public Boggle () throws FileNotFoundException {

        this.board = new BoggleDie[4][4];                               // Instantiate the instance variable giving the size of the array.
        this.used = new boolean[4][4];                                  // Instantiate the instance variable giving the size of the array.

        this.words = new TreeSet<>();                                   // Instantiate the instance variable.

        this.dictionary = new Lexicon ("ospd.txt");            // Instantiate the instance variable giving the name of the text file.

        this.currentWord = "";                                          // Instantiate the instance variable.
    }


    /**
     * This class will be used to read one text file which gives all words which are capable of being made from the board.
     * <p>
     *     This class will have 2 instance variables: words and prefixes, which are both HashSet of String objects. Both of them will be used to find words from game boards.
     *     Then, it will have 2 constructors; one is default and omitted, and the other one is parameterized one that gets a String object as a parameter.
     *     Since this class reads a text file, it will throw an exception if it cannot find the file.
     *     Lexicon class will able have 2 methods: isWord() and inPrefix(), which return boolean values.
     * </p>
     * <p>
     *     It will basically read a text file which contains all words that are able to be made in the Boggle game.
     *     The text files to be read by this class will have same form; one word in one line.
     *     Not only does it read the text file line by line, but it also reads the line character by character to fill out both instance variables.
     *     After going through all contents in the file, both instance variables should be filled out.
     *     Therefore, this class should return correct boolean values when the instance methods are invoked by outer-class.
     * </p>
     */
    private class Lexicon {

        /*
        This instance variable will be used to store all words in the read text file.
         */
        private HashSet<String> words;

        /*
        This instance variable will be used to store all prefixes of words in the text file, as well as the words.
         */
        private HashSet<String> prefixes;

        /**
         * This constructor is a parameterized constructor that gets a String object as a parameter.
         * <p>
         *     It will make a File object using the parameter as a fileName, while instantiating the instance variables.
         *     In order to read the File object it will make a Scanner object that reads File objects.
         *     Then, if the File object is readable, then this constructor will go through all contents line by line and character by character.
         *     While reading the object line by line, it will add the line into an instance variable: words.
         *     While reading the object character by character, it will make prefix cumulatively, and add the prefix into the other instance variable: prefixes.
         * </p>
         * @param fileName This parameter indicates title of the text file.
         * @throws FileNotFoundException This exception will be thrown when the file is not found.
         */
        public Lexicon (String fileName) throws FileNotFoundException {

            this.words = new HashSet<>();                                   // Instantiate an instance variable.
            this.prefixes = new HashSet<>();                                // Instantiate an instance variable.

            File allWords = new File (fileName);                            // Instantiate a File object using the parameter.

            Scanner fileReader = new Scanner(allWords);                     // Instantiate a Scanner object to read the File object.

            if ((allWords.canRead()) && (allWords.exists())) {
                while (fileReader.hasNext()) {

                    String word = fileReader.nextLine();                    // Instantiate a String object holing a line of the File object.
                    String prefix = "";                                     // Instantiate one additional String object to make prefix.

                    this.words.add(word);                                   // Put the String object into an instance variable.

                    for (int i = 0; i <= word.length(); i++) {

                        prefix = word.substring (0, i);                     // Cut off the String object one by one.

                        this.prefixes.add (prefix);                         // Put the String object into an instance variable.
                    }
                }

                fileReader.close();                                         // Close the Scanner object.
            }
            else {
                throw new FileNotFoundException();                          // Throw an exception.
            }
        }

        /**
         * This method will check whether a String object is included in the instance variable, words.
         * <p>
         *     isWord() method will get a parameter which is a String object.
         *     Then, it will determine whether the parameter is contained in the instance variable, which is a HashSet.
         *     If the String object is in the HashSet, then it will return true boolean value. Otherwise, it will return false boolean value.
         * </p>
         * @param wordParam This parameter indicates a String object that will be tested by this method.
         * @return It will return a boolean value.
         */
        public boolean isWord (String wordParam) {

            if (this.words.contains (wordParam)) {
                return true;                            // Return true.
            }
            else {
                return false;                           // Return false.
            }
        }

        /**
         * This method will check whether a String object is included in the instance variable, prefixes.
         * <p>
         *     isPrefix() method will get a parameter which is a String object.
         *     Then, it will determine whether the parameter is contained in the instance variable, which is a HashSet.
         *     If the String object is in the HashSet, then it will return true boolean value. Otherwise, it will return false boolean value.
         * </p>
         * @param prefixParam This parameter indicates a String object that will be tested by this method.
         * @return It will return a boolean value.
         */
        public boolean isPrefix (String prefixParam) {

            if (this.prefixes.contains (prefixParam)) {
                return true;                        // Return true.
            }
            else {
                return false;                       // Return false.
            }
        }
    }


    /**
     * This class will be used to update the game board.
     * <p>
     *     It will have two instance variables: top, which is a String object, and topNumber, which has int data-type.
     *     In addition, this class will have 2 constructors; one is default and omitted, and the other one is parameterized.
     *     it also has 2 methods: roll() and getTop().
     * </p>
     * <p>
     *     BoggleDie class will mainly update the game board at the beginning of the game by assigning the values for each indices.
     *     In the outer-class, this class will be used to read a text file, which has 6 letters in a line that looks like a set of dice.
     *     Therefore, in order to get the one letter from each line of text file, it will use roll() method first to get the spot in the line.
     *     Then, it will get the letter and save it into instance variable.
     * </p>
     */
    private class BoggleDie {

        /*
        This instaace variable will be used to get the letter that will be shown on the game board.
         */
        private String top;

        /*
        This instance variable will be bused to find wihch position of the string will be selected.
         */
        private int topNumber;

        /**
         * This constructor will be used to find letters which will be used in the Boggle game.
         * <p>
         *     It will get a String object as a parameter which indicates all sides of a die.
         *     In order to select which side of the die will be used, it will invoke roll() method.
         *     With the value that roll() method returns, this constructor will instantiate an instance variable: topNumber.
         *     Then, it will use subString() method to the parameter using the information we get from the roll() method.
         * </p>
         * @param sides This parameter indicates all letters in a die.
         */
        public BoggleDie (String sides) {

            this.topNumber = this.roll();                               // Instantiate an instance variable using an instance variable.
            this.top = sides.substring (topNumber, topNumber + 1);      // Instantiate an instance variable by taking out a letter from the parameter.
        }

        /**
         * This method will be used to get the number of chosen side.
         * <p>
         *     Since a die has only 6 sides, it will use a Math.random() method multiplying 6 and type casting to int data-type.
         *     Therefore the value of the above action will be between 0 to 5 inclusively.
         *     roll() method will instantiate int data-type instance variable using the value we've gotten from random() method.
         *     After instantiating the instance variable, it will return the instance variable.
         * </p>
         * @return It will return int data-type variable which is instantiated.
         */
        public int roll() {

            this.topNumber = (int)(Math.random() * 6);          // Set the value of instance variable.
            return this.topNumber;                              // Return the instance variable.
        }

        /**
         * This method will be used to give the instance variable: top.
         * @return It will return String object instance variable.
         */
        public String getTop() {

            return this.top;                                    // Return the instance variable.
        }
    }


    /**
     * This method will be used to find the components of the game board.
     * <p>
     *     It will make a File object using the name of the text file that contains 16 dice in it. Additionally, it will instantiate a Scanner object to read the File object.
     *     Until the File object has left contents, it will choose which letters of the dice will be on the game board, using the constructor of BoggleDie class.
     *     After choosing the letter, it will give the BoggleDie object to the 2-dimensional array of BoggleDie objects.
     * </p>
     * <p>
     *     After assigning all the indices of array, it will shuffle the board using Math.random() method.
     *     In order to shuffle the board, it will use a nested-loop. Inside the loop,
     *     it will instantiate 2 int date-type variables using Math.random() method; one for row, the other for column.
     *     Then, it will copy the entry of the game board and put into temporary BoggleDie object using temporary row and column.
     *     With the temporary object, shuffle() method will exchange the curring entry which is following the nested-loop and the temporary object.
     * </p>
     * @throws FileNotFoundException This exception will be thrown if "dice.txt" file is not found.
     */
    public void shuffle() throws FileNotFoundException {

        File dice = new File ("dice.txt");                                // Instantiate the File object.
        Scanner diceReader = new Scanner (dice);                                    // Instantiate the Scanner object.

        while (diceReader.hasNext()) {
            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {

                    BoggleDie die = new BoggleDie(diceReader.nextLine());           // Instantiate the BoggleDie object.

                    this.board[row][col] = die;                                     // Fill out the array.
                }
            }
        }

        diceReader.close();                                                         // Close the Scanner object.

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {

                int tempRow = (int)(Math.random() * 4);                             // Instantiate an int variable using Math.random() method.
                int tempCol = (int)(Math.random() * 4);                             // Instantiate an int variable using Math.random() method.

                BoggleDie tempDie = this.board[tempRow][tempCol];                   // Alias new BoggleDie object with the entry in the chosen index.

                this.board[row][col] = tempDie;                                     // Exchange the 2 chosen objects.
                this.board[tempRow][tempCol] = this.board[row][col];                // Exchange the 2 chosen objects.
            }
        }
    }

    /**
     * This method will be used to print out the board.
     */
    public void printBoard() {

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {

                System.out.print (this.board[row][col].getTop());                   // Print out the letter in the index.

                System.out.print (" ");                                             // Give a space to distinguish the indices in same rows.
            }

            System.out.println();                                                   // Go to next row.
        }
    }

    /**
     * This method will be used to find the words available in current board.
     * <p>
     *     It will get 3 parameters: row and col, which are int data-type, and prefix, which is a String object.
     *     By using 2 int date-type parameters, we will get the entry in the game board, while changing the boolean value of entry in tracking board, used, to true.
     *     We will concatenate the entry's value, which is String object with the String object parameter.
     *     Then, we will check the parameter whether it can be stored in the TreeSet that saving all found words and whether it will continue the search for the words.
     * </p>
     * <p>
     *     In order to continue the search for the words, findWords() method will use recursive calls.
     *     Since the Boggle game allows horizontal, vertical and diagonal ways to compose the words, this method will use recursive calls 8 times at one time.
     *     During the recursion, if the index for next search is illegal number, then it will throw an exception: ArrayIndexOutOfBoundsException.
     *     This method will also handle the exception, using try-catch block, if the exception is thrown.
     *     After check all the possibilities with recursive calls, in order to reset the tracking board, it will change the boolean value of the chosen index into false.
     * </p>
     * @param row This parameter indicates row index of the game board.
     * @param col This parameter indicates column index of the game board.
     * @param prefix This parameter indicates the String object that is being made on the game board.
     */
    public void findWords (int row, int col, String prefix) {

        this.used[row][col] = true;                                                         // Change the boolean value of the selected index of the tracking board.
        prefix += this.board[row][col].getTop();                                            // Concatenate the String parameter with the found letter in the game board.

            if ((this.dictionary.isWord (prefix)) && (prefix.length() >= 4)) {
                this.words.add(prefix);                                                     // Save the found word if the conditions are true.
            }
            if (this.dictionary.isPrefix (prefix)) {
                // Set up the try-catch block.
                try {
                    if ((!this.used[row - 1][col - 1]) && (this.board[row - 1][col - 1] != null))           // Check NW direction in the board before recursive call.
                        findWords (row - 1, col - 1, prefix);                                     // Call the method recursively.
                }
                catch (ArrayIndexOutOfBoundsException ex) {}

                // Set up the try-catch block.
                try {
                    if ((!this.used[row - 1][col]) && (this.board[row - 1][col] != null))                   // Check N direction in the board before recursive call.
                        findWords (row - 1, col, prefix);                                              // Call the method recursively.
                }
                catch (ArrayIndexOutOfBoundsException ex) {}

                // Set up the try-catch block.
                try {
                    if ((!this.used[row - 1][col + 1]) && (this.board[row - 1][col + 1] != null))           // Check NE direction in the board before recursive call.
                        findWords (row - 1, col + 1, prefix);                                     // Call the method recursively.
                }
                catch (ArrayIndexOutOfBoundsException ex) {}

                // Set up the try-catch block.
                try {
                    if ((!this.used[row][col - 1]) && (this.board[row][col - 1] != null))                   // Check W direction in the board before recursive call.
                        findWords (row, col - 1, prefix);                                              // Call the method recursively.
                }
                catch (ArrayIndexOutOfBoundsException ex) {}

                // Set up the try-catch block.
                try {
                    if ((!this.used[row][col + 1]) && (this.board[row][col + 1] != null))                   // Check E direction in the board before recursive call.
                        findWords (row, col + 1, prefix);                                              // Call the method recursively.
                }
                catch (ArrayIndexOutOfBoundsException ex) {}

                // Set up the try-catch block.
                try {
                    if ((!this.used[row + 1][col - 1]) && (this.board[row + 1][col - 1] != null))           // Check SW direction in the board before recursive call.
                        findWords (row + 1, col - 1, prefix);                                     // Call the method recursively.
                }
                catch (ArrayIndexOutOfBoundsException ex) {}

                // Set up the try-catch block.
                try {
                    if ((!this.used[row + 1][col]) && (this.board[row + 1][col] != null))                   // Check S direction in the board before recursive call.
                        findWords (row + 1, col, prefix);                                              // Call the method recursively.
                }
                catch (ArrayIndexOutOfBoundsException ex) {}

                // Set up the try-catch block.
                try {
                    if ((!this.used[row + 1][col + 1]) && (this.board[row + 1][col + 1] != null))           // Check SE direction in the board before recursive call.
                        findWords (row + 1, col + 1, prefix);                                     // Call the method recursively.
                }
                catch (ArrayIndexOutOfBoundsException ex) {}
            }

        this.used[row][col] = false;                                        // Change the boolean value of the index of the tracking board.
    }

    /**
     * This method will be used as a main driver.
     * <p>
     *     It will instantiate an object of Boggle class to make the game board.
     *     Then, by using the shuffle() instance method, it will assign the letters to the game board, and it will print out the assigned game board, using printBoard() method.
     *     After printing out the board, it will use a nested-loop to look over all indices of the game board. For each indices, main() method will invoke findWords() method.
     *     After checking all indices, it will print out all found legal words.
     *     Since the constructor of the Boggle class may throw exception, it will use try-catch block to catch the exception.
     * </p>
     * @param args
     */
    public static void main (String[] args) {

        // Set up try-catch block.
        try {
            Boggle boggle = new Boggle();                                    // Instantiate an object of Boggle class.

            boggle.shuffle();                                                // Shuffle the game board.
            boggle.printBoard();                                             // Print out the game board.

            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {

                    boggle.findWords (row, col, boggle.currentWord);        // Invoke the instance  method.
                }
            }

            System.out.println(boggle.words);                               // Print out all found words.
        }
        catch (FileNotFoundException ex) {
            ex.getCause();                                                  // Get the cause of the exception.
        }
    }
}
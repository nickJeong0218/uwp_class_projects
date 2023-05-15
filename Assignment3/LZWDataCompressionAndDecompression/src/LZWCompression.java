import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class will be used to compress a text file.
 * <p>
 *     LZWCompression class will have an instance variable named by dictionary. This instance variable is a hashMap whose keys are String and values are Integer.
 *     Also, it will have a class constant variable that indicates the maximum size of hashMap.
 *     Then, there will be 2 constructors, one is default and the other is parameterized. This class will have 5 instance methods:
 *     getDictionary(), setDictionary(), fillBaseDictionary(), fillDictionary() and encode(), as well. Additionally, it will have its own main() method.
 * </p>
 * <p>
 *     LZWCompression class will compress a text file according to Lempel-Ziv-Welch data compression algorithm.
 *     Before using LZW compression algorithm, this class will fill in the hashMap, which is the instance variable, with original ASCII values: 0 - 127.
 *     Then, while walking through whole text file, it will fill in the hashMap, dictionary, until it reaches the end of the file or the maximum size of hashMap.
 *     For the last step of the algorithm, it will write down the characters that match with the values of ASCII code in the compressed file.
 *     In order to encode the text file, it will use the filled hashMap, dictionary.
 * </p>
 * @author YunHwan Jeong
 * @edu.uwp.cs.340.course CSCI 340 - Data Structures and Algorithm Design
 * @edu.uwp.cs.340.section 001
 * @edu.uwp.cs.340.assignment 3
 * @bugs none
 */
public class LZWCompression {
    /*
    This instance variable will be used to save String objects in text file and ASCII values of them as entries.
     */
    private HashMap<String, Integer> dictionary;

    /*
    This class constant variable will indicate the maximum size of instance variable.
     */
    public static final int MAX_SIZE = 256;

    /**
     * This constructor will fill out the instance variable, hashMap, walking through a given text file.
     * <p>
     *     It will instantiate the instance variable as start of constructor.
     *     Then, it will fill out the dictionary, instance variable, with original ASCII codes.
     *     Then, it will fill out the instance variable, walking through a given text file.
     * </p>
     * @param fileNameParam This parameter indicates the name of the given file.
     */
    public LZWCompression (String fileNameParam) {
        this.dictionary = new HashMap<>();                      // Instantiate the instance variable.
        fillBaseDictionary();                                   // Invoke an instance variable.
        fillDictionary (fileNameParam);                         // Invoke an instance variable.
    }

    /**
     * This method will be used to fill in the instance variable before looking up the text file.
     * <p>
     *     fillBaseDictionary() will have an int data-type variable to indicate the value of ASCII code.
     *     Then, until it reaches the maximum value of ASCII code, it will put entries of String and Integer in the instance variable.
     * </p>
     */
    public void fillBaseDictionary() {
        int index = 0;                      // Instantiate an int data-type variable with value 0.

        while (index < 128) {
            char ascii = (char)index;       // Instantiate a char data-type variable using instantiated int variable.
            dictionary.put (String.valueOf (ascii), index);      // Put the String and Integer in the instance variable.
            index++;
        }
    }

    /**
     * This method will be used to fill in the instance variable looking up a text file.
     * <p>
     *     It will get a String object parameter that indicates the name of file.
     *     With the parameter, this method will instantiate a RandomAccessFile object only to read it.
     *     Then, fillDictionary() method will walk through the text file, filling in the instance variable according to the LZW compression algorithm.
     *     While walking through the file, if this method finds an error or reaches the end of the file, then it will catch a related exception.
     * </p>
     * <p>
     *     Here is the LZW compression algorithm:
     *     This algorithm will process a file one character at a time. It starts with str: the current string, set to "".
     *     The next character to be processed is ch.
     *
     *      if str + ch is in the dictionary
     *          set str to str + ch
     *      else
     *          output the index of the str
     *          add str + ch to the dictionary
     *          set str to ch
     *
     *     Repeat the process until you reach the end of the file. Output the index of the final index.
     * </p>
     * @param fileNameParam This parameter indicates the name of the file.
     */
    public void fillDictionary (String fileNameParam) {
        try {
            RandomAccessFile file = new RandomAccessFile (fileNameParam, "r");        // Instantiate a RandomAccessFile using the parameter.

            String str = "";                                         // Instantiate a String object with "".

            while (dictionary.size() <= MAX_SIZE) {
                char ch = (char)file.readByte();                     // Instantiate a char data-type variable reading the file contents.

                StringBuilder sb = new StringBuilder (str);          // Instantiate a StringBuilder object to modify String object.
                sb.append (ch);                                      // Concatenate the StringBuilder object using char data-type variable.
                str = sb.toString();                                 // Convert StingBuilder object to String object.

                if (this.dictionary.containsKey (str)) {
                    str = str;                                       // Keep the String object.
                } else {
                    System.out.println (this.dictionary.size());     // Print out the index of String object that will be put in the dictionary.
                    dictionary.put (str, dictionary.size());         // Put in the entry of String object and Integer value in the instance variable.
                    str = String.valueOf (ch);                       // Change the String object to char data-type variable.
                }
            }

            System.out.println ("The size of dictionary is: " + this.dictionary.size());        // Print out the size of dictionary.

            file.close();                                           // Close the file.
        }
        catch (Exception ex) {
            if (ex instanceof EOFException) {
                System.out.println ("End of file reached.");        // Print out a proper message.
            }
            else {
                System.out.println ("An error is found: " + ex);    // Print out an error message.
            }
        }
    }

    /**
     * This method will be used to encode the text file.
     * <p>
     *     encode() method will get a String object that indicates the name of file as a parameter.
     *     With the parameter, it will instantiate 1 File object and 1 RandomAccessFile object.
     *     File object will be a text file that will be encoded, and RandomAccessFile will be a file that store encoded data.
     * </p>
     * <p>
     *     By instantiating a Scanner object that reads File object, this method will go over whole contents in the text file.
     *     Scanner will read the text fill line by line, and encode() method will use the instance variable to find the String that dictionary has.
     *     With a loop, it will concatenate a checking String object character by character in each line.
     *     Whenever encode() method find the String object that cannot be concatenated anymore, then it will get the value from dictionary,
     *     and write down the value as char data-type in compressed file.
     * </p>
     * @param fileNameParam This parameter indicates the name of file.
     */
    public void encode (String fileNameParam) {
        try {
            File file = new File (fileNameParam);            // Instantiate a File object.
            RandomAccessFile compressedFile = new RandomAccessFile (fileNameParam + ".lzw", "rw");       // Instantiate a RandomAccessFile object.

            Scanner fileReader = new Scanner (file);        // Instantiate a Scanner object reading the File object.
            String checkStr = "";                           // Instantiate a String object to check String object partially.

            while (fileReader.hasNext()) {
                String sentence = fileReader.nextLine() + "\n";             // Instantiate a String object with next line in the File object.
                int j = 0;                                                  // Instantiate an int data-type variable to trace loops.

                while (j < sentence.length()) {
                    StringBuilder checkSb = new StringBuilder (checkStr);   // Instantiate a StringBuilder object to modify checking String object.

                    char checkCh = sentence.charAt (j);                     // Instantiate a char data-type variable with character in next position.
                    checkSb.append (checkCh);                               // Append the character to the StringBuilder object.

                    j++;                                                    // Update loop control variable.

                    while ((this.dictionary.containsKey (checkSb.toString())) && (j < sentence.length() - 1)) {
                        checkCh = sentence.charAt (j);                      // Instantiate a char data-type variable with character in next position.
                        checkSb.append (checkCh);                           // Append the character to the StringBuilder object.

                        j++;                                                // Update loop control variable.
                    }

                    checkStr = checkSb.toString();                          // Convert StringBuilder object to Sting object.

                    if (j < sentence.length() && checkStr.length() > 1) {
                        checkStr = checkStr.substring (0, checkStr.length() - 1);       // Cut off the last character in the String object.
                        j--;                                                            // Update loop control variable.
                    }

                    int asciiValue = this.dictionary.get (checkStr);        // Instantiate an int data-type variable with value in dictionary.
                    compressedFile.writeByte (asciiValue);                  // Write down the char data-type object correspoding to the value it got.

                    checkStr = "";                                          // Reset the checking String object.
                }
            }

            fileReader.close();                                             // Close a file.
            compressedFile.close();                                         // Close a file.
        }
        catch (Exception ex) {
            if (ex instanceof EOFException) {
                System.out.println ("End of file reached.");                // Print out a proper message.
            }
            else {
                System.out.println ("An error is found: " + ex);            // Print out an error message.
            }
        }
    }

    /**
     * This is a getter of the instance variable.
     * @return It returns instance variable.
     */
    public HashMap<String, Integer> getDictionary() {
        return dictionary;          // Return the instance variable.
    }

    /**
     * This is a setter of the instance variable.
     * @param dictionaryParam This parameter indicates a hashMap that instance variable will get.
     */
    public void setDictionary (HashMap<String, Integer> dictionaryParam) {
        this.dictionary = dictionaryParam;               // Instantiate the instance variable with parameter.
    }

    /**
     * This method will be used as a main driver of LZW compression.
     * <p>
     *     It will ask users the name of text file to compress.
     *     With the input, it will instantiate an object of LZWCompression class, and invoke an instance method to encode the file.
     * </p>
     * @param args
     */
    public static void main (String[] args) {
        Scanner keyBoard = new Scanner (System.in);                     // Instantiate a Scanner object to get input.

        System.out.print ("Enter the name of the file to encode: ");    // Prompt to input file name.
        String fileName = keyBoard.nextLine();                          // Instantiate a String object with the input.

        LZWCompression compression = new LZWCompression (fileName);     // Instantiate a LZWCompression object.

        compression.encode (fileName);                                  // Invoke an instance method.
    }
}
import java.io.EOFException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * This class will be used to decompress a lzw file.
 * <p>
 *     LZWDecompression class will have an instance variable named reverseDictionary.
 *     Also, it will have 2 constructors; one is default, and the other one is parameterized. This class will have 2 instance methods: fillReverseDictionary() and decode().
 *     It will have its own main() method as well.
 * </p>
 * <p>
 *     LZWDecompression class will make a dictionary that will be used to convert lzw file to text file.
 *     The instance variable, which is the dictionary for decompression, will be filled in, using the dictionary in LZWCompression.
 *     After filling in the dictionary, it will walk through a compressed file, which is lzw file, and decompress the file using the dictionary for decompression.
 *     The result of decompression will be displayed in a text file.
 * </p>
 * @author YunHwan Jeong
 * @uwp.edu.cs.340.course CSCI 340 - Data structures and Algorithm Design
 * @uwp.edu.cs.340.section 001
 * @uwp.edu.cs.340.assignment 3
 * @bugs none
 */
public class LZWDecompression {
    /*
    This instance variable will be used to save String objects in text file and ASCII values of them as entries reversely.
     */
    private HashMap<Integer, String> reverseDictionary;

    /**
     * This constructor will fill out the instance variable, hashMap, walking through a given lzw file.
     * <p>
     *     It will instantiate the instance variable at the beginning of construction.
     *     Then, it will fill out the instance variable, walking through a given compressed lzw file.
     * </p>
     * @param fileNameParam This parameter indicates the name of the given file.
     */
    public LZWDecompression(String fileNameParam) {
        this.reverseDictionary = new HashMap<>();           // Instantiate the instance variable.
        this.fillReverseDictionary (fileNameParam);         // Invoke an instance method.
    }

    /**
     * This method will be used to fill in the instance variable looking up a lzw file.
     * <p>
     *     It will get a String object parameter that indicates the name of file.
     *     With the parameter, this method will instantiate an LZWCompression object, and will get a dictionary from the LZWCompression class.
     *     By making a set of keys in the dictionary in LZWCompression object. Then, with an iterator of the set, it will go over from 0 index to the end of the set.
     *     While going over the set, it will flip the key and value, and put in the dictionary of this class.
     * </p>
     * @param fileNameParam This parameter indicates the name of the given file.
     */
    public void fillReverseDictionary(String fileNameParam) {
        LZWCompression lzwCompression = new LZWCompression (fileNameParam);     // Instantiate an object of LZWCompression class.
        HashMap<String, Integer> dictionary = lzwCompression.getDictionary();   // Get the dictionary of the instantiated object.

        Set<String> stringSet = dictionary.keySet();                            // Instantiate a set of String object by getting the set of keys of dictionary.

        Iterator<String> stringItr = stringSet.iterator();                      // Instantiate an iterator of the set.

        while (stringItr.hasNext()) {
            String str = stringItr.next();                                      // Instantiate a String object with the next entry of iterator.
            int index = dictionary.get (str);                                   // Instantiate an int data-type variable with the value of String object above in dictionary.

            this.reverseDictionary.put (index, str);                            // Put the entry of Integer and String in the instance variable hashMap.
        }
    }

    /**
     * This method will be used to decode the lzw compressed file.
     * <p>
     *     decode() method will get a String object that indicates the name of file as a parameter.
     *     With the parameter, it will instantiate2 RandomAccessFile object. One of them is considered as a compressed file and the other one is the file where the result of decompression will be displayed.
     * </p>
     * <p>
     *     It will walk though a RandomAccessFile object which is considered as compressed file, and read character by character.
     *     Then, using the instance variable, reverseDictionary, decode() method will convert each character to int data-type and then to the String obejct in the instance variable.
     * </p>
     * @param fileNameParam This parameter indicates the name of file.
     */
    public void decode (String fileNameParam) {
        try {
            RandomAccessFile compressedFile = new RandomAccessFile (fileNameParam + ".lzw", "r");       // Instantiate a RandomAccessFile object.
            RandomAccessFile file = new RandomAccessFile ("test.txt", "rw");                            // Instantiate a RandomAccessFile object.

            while (true) {
                int asciiValue = compressedFile.readByte();         // Instantiate an int data-type variable by reading the compressed file.

                if (asciiValue < 0)
                    asciiValue += LZWCompression.MAX_SIZE;                              // Add up 256 if the int value is negative.

                if (this.reverseDictionary.containsKey (asciiValue)) {
                    file.writeBytes (this.reverseDictionary.get (asciiValue));          // Write down the value of the int value in dictionary of this class in the result file.
                }
            }
        } catch (Exception ex) {
            if (ex instanceof EOFException) {
                System.out.println ("End of file reached.");                            // Print out a proper message.
            } else {
                System.out.println ("An error is found: " + ex);                        // Print out an error message.
            }
        }
    }

    /**
     * This method will be used as a main driver of LZW decompression.
     * <p>
     *     It will ask users the name of lzw file to decompress.
     *     With the input, it will instantiate an object of LZWDecompression class, and invoke an instance method to decode the file.
     * </p>
     * @param args
     */
    public static void main(String[] args) {
        Scanner keyBoard = new Scanner (System.in);     // Instantiate a Scanner object to get input.
        String fileName;                                // Initialize a String object.

        do {
            System.out.print ("Enter the name of the file to decode: ");    // Prompt to input file name.

            fileName = keyBoard.nextLine();                                 // Give a String object the input.

            if (!fileName.substring (fileName.length() - 4).equals (".lzw")) {
                System.out.println ("Wrong file type.\nFile name should be lzw file.");      // Print out the error message.
            }

        } while (!fileName.substring(fileName.length() - 4).equals(".lzw"));

        LZWDecompression decompression = new LZWDecompression (fileName.substring (0, fileName.length() - 4));      // Instantiate a LZWDecompression object.

        decompression.decode (fileName.substring (0, fileName.length() - 4));                                       // Invoke an instance method.
    }
}

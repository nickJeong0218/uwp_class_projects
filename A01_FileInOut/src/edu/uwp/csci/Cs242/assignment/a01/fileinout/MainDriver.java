package edu.uwp.csci.Cs242.assignment.a01.fileinout;

import java.io.FileNotFoundException;

/**
 * This class will give input and output files to read and write in files.
 * <p>
 *     This class will have only one method: main(String [] args).
 *     In the main method, it will have two String objects for input file name and output file name.
 *     Additionally, there will be a boolean variable to check whether files exist or nat.
 * </p>
 * <p>
 *     This class will also instantiate an object from FileInOut class.
 *     Because the FileInOut object throws exceptions, it will instantiate the object in try-catch block.
 *     Also, it will use a while-loop to read the contents in input file, and to write the contents of input file to output file.
 *     Finally, after the while-loop, this class will invoke a method from FileInOut class to close files.
 * </p>
 *  * @author YunHwan Jeong
 *  * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 *  * @edu.uwp.cs.242.section 001
 *  * @edu.uwp.cs.242.assignment 1
 *  * @bugs none
 */
public class MainDriver {
    /**
     * This class will be used to test the FileInOut class.
     * <p>
     *     It will have two file names for input and output files, a boolean variable to check possibility of open the files
     *     and a String to transmit the contents of the input file to the output file.
     * </p>
     * <p>
     *     In the method, there will be an instantiation of a FileInOut object.
     *     Due to the thrown exceptions by the constructor in FileInOut class, this class will have a try-catch block.
     *     In the try-catch block, there will be also a while-loop to transmit the contents from one file to the other file.
     *     After transmitting, it will close files which were used for transmitting.
     * </p>
     * @param args
     */
    public static void main(String [] args) {
        String inputName = "TestFileInput.txt";         // Initialize a String variable.
        String outputName = "TestFileOutput.txt";       // Initialize a String variable.
        boolean canOpen = false;                        // Initialize a boolean variable as false.
        String textInFile;                              // Initialize a String variable to transmit the contents of files.

        // Determine whether files are able to open, and if they are able to, change the value of the boolean variable to true.
        if((inputName.length() != 0) && (outputName.length() != 0)) {
            canOpen = true;
        }

        // Make a try-catch block due to the exceptions.
        try{
            // Instantiate the FileInOut object.
            FileInOut fileIO = new FileInOut(inputName, outputName, canOpen);

            // Make a while loop to transmit the contents of files. Control the loop with the left contents in input file.
            while(fileIO.getInFile().hasNext()) {
                textInFile = fileIO.getInFile().nextLine();      // Set the string for transmitting with the line in input file.
                fileIO.getOutFile().println(textInFile);        // Print out the string variable in output file.
            }

            // Close the files after finishing reading and writing.
            fileIO.closeFiles();

            }
        catch (Exception ex) {
            System.out.println(ex.getMessage());                // If any exception is thrown, print out the error message.
        }
    }
}

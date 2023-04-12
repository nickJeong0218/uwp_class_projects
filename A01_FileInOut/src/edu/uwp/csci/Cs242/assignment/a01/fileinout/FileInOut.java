package edu.uwp.csci.Cs242.assignment.a01.fileinout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This Class will use for inputting and outputting files.
 * <p>
 *     FileInOut class will be related to 2 files, which are text files, and one is input file, and the other one is output file.
 *     It will have 6 class-level instance variables. 2 of these variables are constant variable that have default file names for each file.
 *     The others are instance variables: input file name, output file name, input file using Scanner class to read contents in input file,
 *     and output file using PrintWriter class to write in output file.
 *     All instance variables will have their own getters, and there will be setters for file names.
 *     This class will have methods to open and close files:
 *     openFiles() which invokes openInFile(), openOutFile() and closeFiles() which invokes closeInFile() and closeOutFile().
 * </p>
 * <p>
 *     This class will make an object in MainDriver class which is main class of this project. While instantiate an object, it will throw exceptions.
 *     In openInFile() and openOutFile() methods, there are statements that throw exceptions: FileNotFoundException and IllegalArgumentException.
 *     For these 2 methods, to check whether to throw exceptions or not,
 *     they will instantiate File objects for each files, and use instance methods of File class: exist() and canRead().
 *     After deciding, input File will be an object of Scanner class. Likewise, output file will be an object of PrintWriter class.
 * </p>
 * @author YunHwan Jeong
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 1
 * @bugs none
 */
public class FileInOut {
    /*
     * This variable is class constant variable, and it contents default input file name.
     */
    public static final String DEFAULTINFILENAME = "default_in.txt";

    /*
     * This variable is class constant variable, and it contents default output file name.
     */
    public static final String DEFAULTOUTFILENAME = "default_out.txt";

    /*
     * This variable is an instance variable that holds the name of input file.
     */
    private String inFilename;

    /*
     * This variable is an instance variable that holds the name of output file.
     */
    private String outFilename;

    /*
     * This instance variable is an object of Scanner class, and it will be used to read input file.
     */
    private Scanner inFile;

    /*
     * This instance variable is an object of PrintWriter class, and it will be used to write output file.
     */
    private PrintWriter outFile;

    /**
     * This constructor will open input file and output file, checking if files are available to open.
     * <p>
     *     FileInOut constructor will have 3 parameters, which are an input file name, an output file name and a boolean variable.
     *     This constructor will call two instance methods: setInFilename(), setOutFilename().
     *     By invoking these methods, it will use 2 String parameters for each setter to set the instance variables: inFilename and outFilename.
     *     After using setters, this constructor will check whether files are able to be opened.
     *     If they are possible, it will invoke a class method which is named as openFiles() invoking 2 methods: openInFile() and openOutFile().
     * </p>
     * <p>
     *     Because this constructor invoke a method that throw exceptions, it will throw same exceptions as well as the methods invoked.
     *     Due to the exceptions, this constructor will be instantiated in try-catch block in where the method that will have an object of FileInOut class.
     * </p>
     * @param inFilenameParam This parameter indicates the name of file that is used as an input.
     * @param outFilenameParam This parameter indicates the name of file that is used as an input.
     * @param canOpen This parameter will be used to decide whether this constructor will open files or not.
     * @throws FileNotFoundException This exception is a checked exception that is occurred by exist() method in File class to check whether the file exists.
     * @throws IllegalArgumentException This exception is an unchecked exception that is occurred by canRead() method in File class to determine the file is readable.
     */
    public FileInOut(String inFilenameParam, String outFilenameParam, boolean canOpen) throws FileNotFoundException, IllegalArgumentException {
        setInFilename(inFilenameParam);             // Invoke a setter to set the input file name.
        setOutFilename(outFilenameParam);           // Invoke a setter to set the output file name.

        //After check the possibility of open files, if it is possible open files by invoking a method.
        if(canOpen) {
            openFiles();
        }
    }

    /**
     * This method will open input File.
     * <p>
     *     Before open the file, it will check 2 conditions. First condition is existence of the file.
     *     If there is no file, this method will throw a checked exception, which is FileNotFoundException.
     *     The other condition is readable file name. It means it will check the length of the file name.
     *     If the file is not readable, the method will throw an unchecked exception, which is IllegalArgumentException.
     * </p>
     * <p>
     *     To check these two conditions, the method will instantiate a File object which indicates input.
     *     Then it is going to invoke 2 instance methods from File class: exist() and canRead().
     *     After checks, it will instantiate a Scanner object with the checked file.
     * </p>
     * @throws IllegalArgumentException This exception will be thrown if the length of file name is zero.
     * @throws FileNotFoundException This exception will be thrown if the file does not exist.
     */
    public void openInFile() throws FileNotFoundException, IllegalArgumentException {

        File fileIN = new File(inFilename);         // Instantiate a File object.

        // Check whether the file exists, and if it doesn't, throw an exception.
        if(!fileIN.exists()) {
            throw new FileNotFoundException("File is not exist.");
        }

        // Check whether the file is readable, and if it is not, throw an exception.
        if(!fileIN.canRead()) {
            throw new IllegalArgumentException("Filename should contain at least one character.");
        }

        // Make a Scanner object with the checked file.
        this.inFile = new Scanner(fileIN);
    }

    /**
     * This method will open output file.
     * <p>
     *     Before open the file, it will check 2 conditions. First condition is existence of the file.
     *     If there is no file, this method will throw a checked exception, which is FileNotFoundException.
     *     The other condition is readable file name. It means it will check the length of the file name.
     *     If the file is not readable, the method will throw an unchecked exception, which is IllegalArgumentException.
     * </p>
     * <p>
     *     To check these two conditions, the method will instantiate a File object which indicates output.
     *     Then it is going to invoke 2 instance methods from File class: exist() and canRead().
     *     After checks, it will instantiate a Scanner object with the checked file.
     * </p>
     * @throws FileNotFoundException This exception will be thrown if the length of file name is zero.
     * @throws IllegalArgumentException This exception will be thrown if the file does not exist.
     */
    public void openOutFile() throws FileNotFoundException, IllegalArgumentException {

        File fileOut = new File(outFilename);           // Instantiate a File object.

        // Check whether the file exists, and if it doesn't, throw an exception.
        if(!fileOut.exists()) {
            throw new FileNotFoundException("File does not exist.");
        }

        // Check whether the file is readable, and if it is not, throw an exception.
        if(!fileOut.canRead()) {
            throw new IllegalArgumentException("Filename should contain at least one character.");
        }

        // Make a PrintWriter object with the checked file.
        this.outFile = new PrintWriter(fileOut);
    }

    /**
     * This method will invoke two methods, openInFile() and openOutFile(), to open both files together at one time.
     * @throws FileNotFoundException This exception will be thrown if the length of file name is zero.
     * @throws IllegalArgumentException This exception will be thrown if the file does not exist.
     */
    public void openFiles() throws FileNotFoundException, IllegalArgumentException {
        this.openInFile();          // Invoke a method to open input file.
        this.openOutFile();         // Invoke a method to open output file.
    }

    /**
     * This method will close input file after reading the contents in the file.
     */
    public void closeInFile() {
        inFile.close();         // Close the input file.
    }

    /**
     * This method will close output file after writing the contents in the file.
     */
    public void closeOutFile() {
        outFile.close();        // Close the output file.
    }

    /**
     * This method will invoke two methods, closeInFile() and closeOutFile(), to close both files together at one time.
     */
    public void closeFiles() {
        this.closeInFile();         // Invoke a method to close input file.
        this.closeOutFile();        // Invoke a method to close output file.
    }

    /**
     * This method is an instance method which is a getter, and it will return the instance variable, inFilename.
     * @return It will return a String that the instance variable, named inFilename, holds.
     */
    public String getInFilename() {
        return inFilename;          // Return the instance variable: inFilename.
    }

    /**
     * This method is an instance method which is a getter, and it will return the instance variable, outFilename.
     * @return It wil return a String that the instance variable, named outFilename, holds.
     */
    public String getOutFilename() {
        return outFilename;         // Return the instance variable: outFilename.
    }

    /**
     * This method is an instance method which is a getter, and it will return the instance variable, inFile.
     * @return It will return an object of Scanner class that one of the instance variables contains.
     */
    public Scanner getInFile() {
        return inFile;              // Return the instance variable: inFile.
    }

    /**
     * This method is an instance method which is a getter, and it will return the instance variable, outFile.
     * @return It will return an object of PrintWriter class that one of the instance variable contains.
     */
    public PrintWriter getOutFile() {
        return outFile;             // Return the instance variable: outFile.
    }

    /**
     * This method  will get a String object as a parameter, and give the parameter to  inFilename, which is an instance variable.
     * @param inFilenameParam This parameter is a String object, and will be used to set inFilename.
     */
    public void setInFilename(String inFilenameParam) {
        this.inFilename = inFilenameParam;          // Set the instance variable, inFilename, as same as the parameter.
    }

    /**
     * This method  will get a String object as a parameter, and give the parameter to  outFilename, which is an instance variable.
     * @param outFilenameParam This parameter is a String object, and will be used to set outFilename.
     */
    public void setOutFilename(String outFilenameParam) {
        this.outFilename = outFilenameParam;        // Set the instance variable, outFilename, as same as the parameter.
    }
}
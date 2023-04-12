package edu.uwp.cs.csci380.project.PB.simpleaccess_V2;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * This class will be used to set up configuration of this project.
 * <p>
 *     Configuration class will have 2 instance variables, 1 constructor and 4 instance variables.
 *     The 2 instance variables: fileReader and properties will be used to read the app property file
 *     and store the information from the file. Also, the Configuration class will have 4 instance methods,
 *     which are categorized in setter() and getter().
 * </p>
 * <p>
 *     This class will read the file which is named as the parameter of the constructor.
 *     Then, it will use an instance variable to store the information of the file.
 *     With the storing instance variable, it will use an instance method to bring out the information required.
 * </p>
 * @author Yunhwan(Nick) Jeong
 * @edu.uwp.cs.380.course CSCI - 380 Database Management Systems
 * @edu.uwp.cs.380.section 001
 * @edu.uwp.cs.380.assignment 2
 * @bugs none
 */
public class Configuration {
    /*
    This instance variable will be used to read the File Object.
     */
    private FileReader fileReader;

    /*
    This instance variable will be used to hold the information of the app property file.
     */
    private Properties properties;

    /**
     * This constructor will be used to bring information of app property file.
     * <p>
     *     Configuration constructor will get a String object as a parameter, which is the name of the app property file name.
     *     Then, with the String object parameter, it will read the file by instantiating the instance variable.
     *     After Instantiating instance variables with proper values, it will load the information of the app property file,
     *     and save if to an instance variable. If the File object that will be read doesn't exist, it will throw an IOException.
     * </p>
     * @param configFilename    This parameter indicates the name of the app property file name.
     * @throws IOException  This exception may be thrown if the object named by the parameter doesn't exist.
     */
    public Configuration(String configFilename) throws IOException {
        this.fileReader = new FileReader(configFilename);   // Instantiate an instance variable.
        this.properties = new Properties();                 // Instantiate an instance variable.

        this.properties.load(fileReader);                   // Load the information of the instance variable.
    }

    /**
     * This method is an instance method which is a getter, and it will return the instance variable, fileReader.
     * @return  It returns an instance variable, fileReader, which is a FileReader object.
     */
    public FileReader getFileReader() {
        return this.fileReader;
    }

    /**
     * This method will get the specified property.
     * <p>
     *     getProperty() will get a String object as a parameter, which is a name of the app property.
     *     It will check whether the instance variable which holds the information of the app property file
     *     has an app property name in the instance variable.
     *     If it exists, then it will return the value of the specified property. Otherwise, it will throw an IOException.
     * </p>
     * @param propName  This parameter indicates the name of the app property.
     * @return  It will return the value of the specified app property.
     * @throws IOException  This exception will be thrown if the app property doesn't exist in the instance variable.
     */
    public String getProperty(String propName) throws IOException {
        // Determine whether the instance variable holds the app property.
        if(this.properties.containsKey(propName)) {
            return this.properties.getProperty(propName);       // Return the value of the app property.
        } else {
            throw new IOException("Input property doesn't exist.");     // Throw an IOException.
        }
    }

    /**
     * This method  will get a FileReader object as a parameter, and give the parameter to fileReader, which is an instance variable.
     * @param fileReader This parameter is a FileReader object, and will be used to set fileReader.
     */
    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;       // Instantiate an instance variable.
    }

    /**
     * This method will be used to set a property of the app.
     * <p>
     *     setProperty() will get 2 String objects as parameters, which are property name and the value of the property.
     *     It will check whether the property exists, using the name of the property.
     *     If it exists, then it will set the value of the property with the other parameter to the property that is specified.
     *     Otherwise, it will add a property in the instance variable using 2 parameters.
     * </p>
     * @param propName  This parameter indicates the name of the property.
     * @param propValue This parameter indicates the value of the property.
     * @return  It will return the String object that indicates how the property is set.
     */
    public String setProperty(String propName, String propValue) {
        // Determine whether the instance variable holds the property.
        if(this.properties.containsKey(propName)) {
            this.properties.setProperty(propName, propValue);   // Set the property with a parameter.
        } else {
            this.properties.put(propName, propValue);           // Put the property in the instance variable.
        }

        return "Property " + propName +  " has been set as " + propValue + ".";     // Return a String object indicating the setup.
    }
}

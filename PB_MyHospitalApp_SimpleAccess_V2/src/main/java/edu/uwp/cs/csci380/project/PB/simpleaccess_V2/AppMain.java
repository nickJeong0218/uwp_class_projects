package edu.uwp.cs.csci380.project.PB.simpleaccess_V2;

import java.sql.ResultSet;
import java.util.Scanner;

/**
 * This class will be used as a main driver of this project.
 * <p>
 *     This AppMain class will instantiate an object from Connection class.
 *     Then, it will use instance methods from the class, using the instance.
 *     Since the instance methods from the Connection class throw exceptions, it will use try-catch block.
 * </p>
 * @author Yunhwan(Nick) Jeong
 * @edu.uwp.cs.380.course CSCI - 380 Database Management Systems
 * @edu.uwp.cs.380.section 001
 * @edu.uwp.cs.380.assignment 2
 * @bugs none
 */
public class AppMain {
    /**
     * This main method will be used to run the project.
     * <p>
     *     With an object of the Connection class, it will connect the project to the SSH tunnel.
     *     Then, it will connect the project to the Database Server, using the instance methods of the Connection class.
     *     After connecting the project to the Database, it will print out the result of the query in a format.
     * </p>
     * @param args
     */
    public static void main(String[] args) {
        // Set up a try-catch block.
        try {
            Connection connection = new Connection();   // Instantiate a Connection object.

            connection.sshConnect();    // Invoke an instance method in order to connect to SSH tunnel.

            System.out.println("Establishing database connection via tunnel...");   // Print out the process of connection.

            Scanner keybd = new Scanner(System.in);     // Instantiate a Scanner object to get inputs.

            System.out.println("Enter your database username:");                    // Print out a prompt to get username.
            String dbUsername = keybd.nextLine();                                   // Instantiate a String object with an input.
            connection.getConfiguration().setProperty("db.username", dbUsername);   // Set an app property with input.

            System.out.println("Enter your database password:");                    // Print out a prompt to get password.
            String dbPassword = keybd.nextLine();                                   // Instantiate a String object with an input.
            connection.getConfiguration().setProperty("db.password", dbPassword);   // Set an app property with input.

            connection.dbConnect(dbUsername, dbPassword);       // Invoke an instance method in order to connect to database.

            System.out.println("Running an easy database query...");    // Print out the process of connection.
            // Instantiate a ResultSet object using an instance method of Connection object.
            ResultSet resultSet = connection.dbRunQuery("SELECT * FROM CUSTOMER;");

            System.out.println("{\n  [");       // Print out format.
            // Check whether the result set of query has left information.
            while(resultSet.next()) {
                // Print out the entity of query in a format.
                System.out.println("    { CustomerID: " + resultSet.getString(1) + ", LastName: " + resultSet.getString(2)
                        + ", FirstName: " + resultSet.getString(3) + ", EmailAddress: " + resultSet.getString(4)
                        + ", Phone: " + resultSet.getString(5) + " },");
            }
            System.out.println("  ]\n}");       // Print out format.

            connection.dbClose();               // Invoke an instance method to disconnect this project from database.

        } catch (Exception e) {
            System.out.println(e.getMessage()); // Print out the message of caught exception.
            System.exit(1);              // Execute the program.
        }
    }
}

package edu.uwp.cs.csci380.project.simpleaccess_V1;

/**
 * This class will be used as a main driver of this project.
 * <p>
 *     This AppMain class will instantiate each objects from SshConnection and MySqlConnection classes.
 *     Then, it will use instance methods from those classes, using instances.
 *     Since the instance methods from each class throw exceptions, it will use try-catch block.
 * </p>
 * @author Yunhwan(Nick) Jeong
 * @edu.uwp.cs.380.course CSCI - 380 Database Management Systems
 * @edu.uwp.cs.380.section 001
 * @edu.uwp.cs.380.assignment 1
 * @bugs none
 */
public class AppMain {
    /**
     * This main method will be used to run the project.
     * <p>
     *     With an object of SshConnection, it will connect the local system to the database server.
     *     While it is connected, it will get information from the database using SQL statements with a MySqlSimpleQuery object.
     *     After getting the information and printing it out in a format, it will disconnect the local system and the database server.
     * </p>
     * @param args
     */
    public static void main(String[] args) {
        try {
            SshConnection sshConnection = new SshConnection();              // Instantiate a SshConnection object.

            sshConnection.connectSsh();                                     // Invoke an instance method to connect to remote system.

            MySqlSimpleQuery mySqlSimpleQuery = new MySqlSimpleQuery();     // Instantiate a MySqlSimpleQuery object.

            mySqlSimpleQuery.setUpQuery(sshConnection.getSession());        // Invoke an instance method to let it use SQL statements.
            mySqlSimpleQuery.printQuery();                                  // Invoke an instance method to print out the result of SQL statements.

            sshConnection.disconnectSsh();                                  // Invoke an instance method to disconnect from the system connected.
        } catch (Exception e) {
            System.out.println(e.getMessage());                             // Print out the message from the caught exception.
            System.exit(1);                             // Terminate the program.
        }
    }
}

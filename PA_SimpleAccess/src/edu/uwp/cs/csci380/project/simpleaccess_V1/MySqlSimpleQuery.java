package edu.uwp.cs.csci380.project.simpleaccess_V1;

import com.jcraft.jsch.Session;
import java.sql.*;

/**
 * This class will be used to get result from a database.
 * <p>
 *     This class will have 3 class constants, 3 instance variables, 1 omitted constructor and 8 instance methods.
 *     The class constants: DB-USERNAME, DB_PASSWORD & CONNECTION_URL indicate the username of database, password of database
 *     and url used to connect the database. 3 instance variables: connection, statement & resultSet will be used to use SQL commands in Java.
 *     The constructor of this class is omitted because it is a default constructor.
 *     The instance methods will be categorized in 3 group: getters, setters and about queries.
 * </p>
 * <p>
 *     MySqlSimpleQuery class will get information about database server from class constants.
 *     With the class constants, it will connect to the database in the server, using an instance method: setUpQuery().
 *     Then, after connecting to the database, it will make a SQL statement with instance variables.
 *     After getting the result of SQL statement, it will print out the result in a format with printQuery() method.
 * </p>
 * @author Yunhwan(Nick) Jeong
 * @edu.uwp.cs.380.course CSCI - 380 Database Management Systems
 * @edu.uwp.cs.380.section 001
 * @edu.uwp.cs.380.assignment 1
 * @bugs none
 */
public class MySqlSimpleQuery {
    /*
    This class constant holds the username of database server.
     */
    private final String DB_USERNAME = "jeong";

    /*
    This class constant holds the password of database server.
     */
    private final String DB_PASSWORD = "wT-3ndUt";

    /*
    This class constant holds the url that will be used to connect to database.
     */
    private final String CONNECTION_URL = "jdbc:mysql://localhost:4321/QACS_db?characterEncoding=utf8";

    /*
    This instance variable holds a Connection object that connects DriveManger and Statement objects.
     */
    private Connection connection;

    /*
    This instance variable holds a Statement object that makes SQL statements.
     */
    private Statement statement;

    /*
    This instance variable holds the result of the SQL statement.
     */
    private ResultSet resultSet;

    /**
     * This method will be used to use SQL statements.
     * <p>
     *     This method will get a Session as a parameter. it will check whether the parameter, session, is connected.
     *     With the condition that the Session object given as a parameter is connected, setUpQuery() will connect to the database.
     *     In order to make a connection with the database, it will use class constants.
     *     Then, it will make SQL statements that will be used in the database in the server.
     *     The result of SQL statements will be stored in an instance variable, resultSet.
     * </p>
     * @param session   This parameter is a Session object that will be checked whether it is connected to certain system.
     * @throws ClassNotFoundException   This exception will be thrown if the className is unable to be found.
     * @throws SQLException This exception will be thrown if the SQL statements don't work properly.
     */
    public void setUpQuery(Session session) throws ClassNotFoundException, SQLException {
        // Check the connection of parameter.
        if(session.isConnected()) {
            Class.forName("com.mysql.cj.jdbc.Driver");      // Load a database Driver.
            System.out.println("Query from Mysql Database!");         // Print out the string that indicates the loading driver works well.

            this.connection = DriverManager.getConnection(CONNECTION_URL, DB_USERNAME, DB_PASSWORD);    // Instantiate an instance variable by connecting Driver loaded.
            System.out.println("Connection URL: " + CONNECTION_URL);    // Print out the string that indicates the connecting process works properly.

            this.statement = connection.createStatement();      // Instantiate an instance variable to make SQL statements.

            // Instantiate an instance variable with the result of the SQL statement.
            this.resultSet = statement.executeQuery("SELECT CustomerID, LastName, FirstName, EmailAddress, Phone FROM CUSTOMER");
        } else {
            System.out.println("Session doesn't exist.");       // Print out a message about the reason why it cannot use the parameter, session.
        }
    }

    /**
     * This method will be used to print out the result of SQL statements.
     * <p>
     *     This method will print out the introduction before printing out the result of SQL statements in a format.
     *     Then, by using instance method in a ResultSet object. it will repeat printing the entities.
     *     To get data from the ResultSet object, it will also use instance methods, getString().
     * </p>
     * @throws SQLException This exception will be thrown if the instance variable, resultSet, doesn't have information that has been requested.
     */
    public void printQuery() throws SQLException {
        System.out.println("Query result");     // Print out introduction.
        System.out.println("------------");     // Print out introduction.

        System.out.println("{\n  [");           // Print out introduction.

        while(this.resultSet.next()) {          // Check the existence of next entity.
            // Print out the entity, using getString() method from ResultSet.
            System.out.println("    { CustomerID: " + resultSet.getString(1) + ", LastName: " + resultSet.getString(2)
            + ", FirstName: " + resultSet.getString(3) + ", EmailAddress: " + resultSet.getString(4)
            + ", Phone: " + resultSet.getString(5) + " },");
        }

        System.out.println("  ]\n}");           // Print out the format.
    }

    /**
     * This method is an instance method which is a getter, and it will return the instance variable, connection.
     * @return  It returns an instance variable, connection, which connects Driver and Statements.
     */
    public Connection getConnection() {
        return this.connection;     // Return an instance variable.
    }

    /**
     * This method is an instance method which is a getter, and it will return the instance variable, statement.
     * @return  It returns an instance variable, statement, which makes SQL statements.
     */
    public Statement getStatement() {
        return this.statement;      // Return an instance variable.
    }

    /**
     * This method is an instance method which is a getter, and it will return the instance variable, resultSet.
     * @return  It returns an instance variable, resultSet, which holds the result of SQL statements.
     */
    public ResultSet getResultSet() {
        return this.resultSet;      // Return an instance variable.
    }

    /**
     * This method  will get a Connection object as a parameter, and give the parameter to connection, which is an instance variable.
     * @param connection This parameter is a Connection object, and will be used to set connection.
     */
    public void setConnection(Connection connection) {
        this.connection = connection;       // Instantiate an instance variable.
    }

    /**
     * This method  will get a Statement object as a parameter, and give the parameter to statement, which is an instance variable.
     * @param statement This parameter is a Statement object, and will be used to set statement.
     */
    public void setStatement(Statement statement) {
        this.statement = statement;         // Instantiate an instance variable.
    }

    /**
     * This method  will get a ResultSet object as a parameter, and give the parameter to resultSet, which is an instance variable.
     * @param resultSet This parameter is a ResultSet object, and will be used to set resultSet.
     */
    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;         // Instantiate an instance variable.
    }
}

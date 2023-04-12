package edu.uwp.cs.csci380.project.PB.simpleaccess_V2;

import com.jcraft.jsch.*;
import java.sql.*;
import java.io.IOException;

/**
 * This class will be used to connect this project to UWP CS Database Server.
 * <p>
 *     Connection class will have a class constant, 6 instance variables, one constructor and 18 instance methods.
 *     The class constant holds the name of a file that indicates the properties of this project: PROPERTY_FILE_NAME.
 *     The instance variables: jSch and session will be used to connect this project to SSH, and other instance variables:
 *     connection, statement and resultSet will be used to connect Database server and to do certain actions in the database.
 *     The other instance variable: configuration will be used to use the properties of this project in this class.
 *     The constructor will be instantiate some instance variables to use them properly.
 *     The instance methods are seperated in 3 groups: methods doing some actions, getters and setters.
 * </p>
 * <p>
 *     The Connection class will work in 2 parts, which are connecting SSH and connecting Database Server.
 *     With the properties of this project, it will connect this project to SSH in order to get into Database Server.
 *     After connected to SSH, this class will connect this project to a Database Server using the properties as well.
 *     In addition to connect to the Database Server, this class will make a query from the connected database.
 *     Most of the properties that will be used to connect and to make a query are in the property file, and the others
 *     are going to be generated by instance methods.
 * </p>
 * @author Yunhwan(Nick) Jeong
 * @edu.uwp.cs.380.course CSCI - 380 Database Management Systems
 * @edu.uwp.cs.380.section 001
 * @edu.uwp.cs.380.assignment 2
 * @bugs none
 */
public class Connection {
    /*
     * This class constant variable holds the name of the property file name.
     */
    private final String PROPERTY_FILE_NAME = "app.properties";

    /*
     * This instance variable holds a JSch object.
     */
    private JSch jsch;

    /*
    This instance variable holds a Session object from JSch.
     */
    private Session session;

    /*
    This instance variable holds a Connection object that connects DriveManger and Statement objects.
     */
    private java.sql.Connection connection;

    /*
    This instance variable holds a Statement object that makes SQL statements.
     */
    private Statement statement;

    /*
    This instance variable holds the result of the SQL statement.
     */
    private ResultSet resultSet;

    /*
    This instance variable holds Configuration object to bring app properties.
     */
    private Configuration configuration;

    /**
     * This constructor will be used to instantiate an object of this Connection class.
     * <p>
     *     In order to instantiate the instance variable, jSch, it requires to import jsch package.
     *     Also, in order to bring the app properties, it will instantiate the instance variable, configuration,
     *     with Configuration class, using the class constant variable: PROPERTY_FILE_NAME.
     * </p>
     * <p>
     *     Since the constructor of Configuration may throw IOException,
     *     it will instantiate a try-catch block where this method invoked.
     * </p>
     * @throws IOException This exception will be thrown if the file holding the app properties doesn't exist.
     */
    public Connection() throws IOException {
        this.jsch = new JSch();                                         // Instantiate an instance variable.
        this.configuration = new Configuration(PROPERTY_FILE_NAME);     // Instantiate an instance variable.
    }

    /**
     * This method will be used to connect this project to SSH.
     * <p>
     *     sshConnect() method will instantiate an instance variables, session, using another instance variable, jSch.
     *     With the instance method of JSch object, getSession(), it will instantiate the instance variable.
     *     Since the getSession() method requires username, hostname and port number, it will assign parameters of the getSession().
     *     The parameters will be given from app property file. To bring the information of the app property file,
     *     it will use the instance variable: configuration. With configuration, it will use the instance method, getProperty(),
     *     to get required properties: username, hostname & port number.
     * </p>
     * <p>
     *     After the instance variable is instantiated, this method will set more information,
     *     such as password and configuration of the session. To do these steps, it will use instance methods of Session object.
     *     Since the password of the session is a property, it will use the instance variable, configuration, to get password property.
     *     Then in order to set the session configuration, this method will invoke the instance method, setConfig() from Session.
     * </p>
     * <p>
     *     After connecting and setting for SSH connection, it will set port forwarding to Database Server.
     *     In order to do port forwarding, it will get 2 port numbers from app property file.
     *     one port number is local port number, and the other port number is Database server port number.
     *     This port forwarding will be forwarded from local to Database server.
     * </p>
     * <p>
     *     To keep tracking the process of connecting, it will print out some strings before and after each setting-up and connecting.
     *     In addition, because the instance methods from jsch package may throw JSchException,
     *     and the instance method, getProperty(), from Configuration may throw IDException,
     *     it will instantiate a try-catch block where this method invoked.
     * </p>
     * @throws JSchException This exception will be thrown if the Session object doesn't work properly.
     * @throws IOException This exception will be thrown if the Configuration object cannot file the specified properties.
     */
    public void sshConnect() throws JSchException, IOException {
        this.session = this.jsch.getSession(                            // Instantiate an instance variable with another instance variable.
                this.configuration.getProperty("ssh.username"),
                this.configuration.getProperty("ssh.host"),
                Integer.parseInt(this.configuration.getProperty("ssh.port")));

        this.session.setPassword(this.configuration.getProperty("ssh.password"));   // Set the password of the session.
        this.session.setConfig("StrictHostKeyChecking", "no");                      // Set the configuration of the session.

        System.out.println("Establishing SSH connection...");                       // Print out the process of the connection.
        this.session.connect();                                                     // Connect the session.

        int lPort = Integer.parseInt(this.configuration.getProperty("local.database.port"));    // Instantiate an int variable with a property.
        int rPort = Integer.parseInt(this.configuration.getProperty("remote.database.port"));   // Instantiate an int variable with a property.

        System.out.println("localhost:" + lPort + " -> localhost:" + rPort);        // Print out the process of the connection.
        int portForwardingNumber = this.session.setPortForwardingL(                 // Create a port forwarding.
                lPort, this.configuration.getProperty("remote.database.host"), rPort);
        System.out.println("done.");                                                // Print out the process of the connection.

    }

    /**
     * This method will be used to connect this project to Database Server.
     * <p>
     *     dbConnect() method will get 2 String object parameters: username & password, in order to connect to Database Server.
     *     It will check the condition of Session of SSH using an instance variable, session, and instance method of it, isConnected().
     *     With the condition that the instance variable, session, is connected, it will start to connect to Database Server.
     *     In order to make a connection with the Database, it will use the app properties and instance methods: makeDriverString() and makeUrlString().
     *     Since it will use app properties, it will use an instance variable which gets information from app property file, configuration.
     *     With the information gotten from app property file and the instance methods, it will make a connect to SQL Database Server.
     * </p>
     * <p>
     *     To keep tracking the process of connecting, it will print out some strings before and after each setting-up and connecting.
     *     Additionally, during the process of connecting Database Sever, it may throw exceptions: ClassNotFoundException, SQLException.
     *     Also, it will throw IOException if the instance methods that will give information may occur problem.
     *     It may also throw JSchException if the Session object is not connected.
     * </p>
     * @param username  This parameter gives the username of Database server.
     * @param password  This parameter gives the password of Database server.
     * @throws ClassNotFoundException   This exception will be thrown if the Driver class doesn't exist.
     * @throws SQLException This exception will be thrown if the Database connection is not valid.
     * @throws IOException  This exception will be thrown if the instance methods throw exception.
     * @throws JSchException    This exception will be thrown if the Session object is not connected.
     */
    public void dbConnect(String username, String password) throws ClassNotFoundException, SQLException, IOException, JSchException {
        // Check the connection of the instance variable.
        if(this.session.isConnected()) {
            Class.forName(makeDriverString());      // Load a database Driver.

            System.out.println("Connection URL: " + makeUrlString());       // Print out the connecting URL to indicate the process of connecting.
            // Instantiate an instance variable by connecting Driver loaded.
            this.connection = DriverManager.getConnection(makeUrlString(), username, password);
            System.out.println("done.");            // Print out the process of connecting.
        } else {
            throw new JSchException("Session is not connected");            // Throw an exception if the boolean value if false.
        }
    }

    /**
     * This method will be used to make a query from the connected Database.
     * <p>
     *     dbRunQuery() will get a String object as a parameter, which indicates the SQL statement.
     *     It will use an instance variable, statement, to make a SQL statement.
     *     After executing the statement, it will save the result in another instance variable, resultSet.
     *     Then it will return the instance variable, resultSet.
     * </p>
     * <p>
     *     Since this method works in SQL Database, it may throw SQLException if the process doesn't work in proposed way.
     * </p>
     * @param queryString   This parameter indicates the SQL statement that will be executed.
     * @return  It will return the ResultSet after running the statement in the database.
     * @throws SQLException This exception may be thrown if the process of SQL statement is not appropriate.
     */
    public ResultSet dbRunQuery(String queryString) throws SQLException {
        this.statement = this.connection.createStatement();         // Instantiate an instance variable.
        this.resultSet = this.statement.executeQuery(queryString);  // Instantiate an instance variable.

        return this.resultSet;          // Return an instance variable.
    }

    /**
     * This method will be used to close the Database.
     * <p>
     *     dbClose() will disconnect the connection to Database.
     *     Therefore, it will disconnect the connection to Database with an instance method of an instance variable, connection.
     *     Then it will disconnect the SSH connection as well in order to keep the project securely.
     *     Since the instance variable: connection works in SQL Database, it will throw a SQLException if it makes an error
     *     while processing the closing statement.
     * </p>
     * @throws SQLException This exception may be thrown if the prcoss of closing the database doesn't work well.
     */
    public void dbClose() throws SQLException {
        this.connection.close();        // Close the Database connection.
        this.session.disconnect();      // Close the SSH connection.
    }

    /**
     * This method will be used to make a String object that will be used to load a database Driver.
     * <p>
     *     Since There are a few types of Database, it will check which database this project will connect.
     *     If it is matched, then it will return a String object that will be used to load a Database Driver.
     *     If the database that this project wants to connect is not matched with the database type of the app property file,
     *     then it will throw an IOException.
     * </p>
     * @return  It returns a String object used to load a database Driver.
     * @throws IOException  This exception will be thrown if it can't find matched property from the file.
     */
    private String makeDriverString() throws IOException {
        // Determine whether the database type.
        if(this.configuration.getProperty("db.database").equals("mysql")) {
            return "com.mysql.cj.jdbc.Driver";  // Return a String object;
        } else {
            throw new IOException();            // Throw an exception.
        }
    }

    /**
     * This method will be used to make a String object that will be used to connect Database in the Database Server.
     * <p>
     *     In order to connect to a database in the server in SQL, it requires a URL, and this method will
     *     make a URL which will connect this project to the database where we want to make a query.
     *     If the database where this project wants to connect doesn't exist, it will throw an IOException.
     * </p>
     * @return  It will return a String object used to connect to a database.
     * @throws IOException  This exception will be thrown if it can't find matched property from the file.
     */
    private String makeUrlString() throws IOException {
        // Return a String object.
        return this.configuration.getProperty("db.driver") + ":" + this.configuration.getProperty("db.database")
                + "://" + this.configuration.getProperty("remote.database.host") + ":" + this.configuration.getProperty("local.database.port")
                + "/" + this.configuration.getProperty("db.name") + "?characterEncoding=utf8";
    }

    /**
     * This method is an instance method which is a getter, and it will return the instance variable, jSch.
     * @return  It returns an instance variable, jSch, which is a JSch object.
     */
    public JSch getJsch() {
        return this.jsch;
    }

    /**
     * This method is an instance method which is a getter, and it will return the instance variable, session.
     * @return  It returns an instance variable, session, which is a Session object.
     */
    public Session getSession() {
        return this.session;
    }

    /**
     * This method is an instance method which is a getter, and it will return the instance variable, connection.
     * @return  It returns an instance variable, connection, which connects this project to a database.
     */
    public java.sql.Connection getConnection() {
        return this.connection;
    }

    /**
     * This method is an instance method which is a getter, and it will return the instance variable, statement.
     * @return  It returns an instance variable, statement, which makes a query from a database.
     */
    public Statement getStatement() {
        return this.statement;
    }

    /**
     * This method is an instance method which is a getter, and it will return the instance variable, resultSet.
     * @return  It returns an instance variable, resultSet, which stores the result of SQL statement.
     */
    public ResultSet getResultSet() {
        return this.resultSet;
    }

    /**
     * This method is an instance method which is a getter, and it will return the instance variable, configuration.
     * @return  It returns an instance variable, configuration, which gets information from the app property file.
     */
    public Configuration getConfiguration() {
        return this.configuration;
    }

    /**
     * This method  will get a JSch object as a parameter, and give the parameter to jSch, which is an instance variable.
     * @param jsch This parameter is a JSch object, and will be used to set jSch.
     */
    public void setJsch(JSch jsch) {
        this.jsch = jsch;
    }

    /**
     * This method  will get a Session object as a parameter, and give the parameter to session, which is an instance variable.
     * @param session This parameter is a Session object, and will be used to set session.
     */
    public void setSession(Session session) {
        this.session = session;
    }

    /**
     * This method  will get a Connection object as a parameter, and give the parameter to connection, which is an instance variable.
     * @param connection This parameter is a Connection object, and will be used to set connection.
     */
    public void setConnection(java.sql.Connection connection) {
        this.connection = connection;
    }

    /**
     * This method  will get a Statement object as a parameter, and give the parameter to statement, which is an instance variable.
     * @param statement This parameter is a Statement object, and will be used to set statement.
     */
    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    /**
     * This method  will get a ResultSet object as a parameter, and give the parameter to resultSet, which is an instance variable.
     * @param resultSet This parameter is a ResultSet object, and will be used to set ResultSet.
     */
    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    /**
     * This method  will get a Configuration object as a parameter, and give the parameter to configuration, which is an instance variable.
     * @param configuration This parameter is a Configuration object, and will be used to set configuration.
     */
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}

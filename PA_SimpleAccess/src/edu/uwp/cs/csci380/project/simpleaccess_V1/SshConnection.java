package edu.uwp.cs.csci380.project.simpleaccess_V1;

import com.jcraft.jsch.*;

/**
 * This class will be used to connect local system and UW-Parkside Lab System.
 * <p>
 *     SshConnection class will have 2 class constants, 2 instance variables, 1 constructor and 6 instance methods.
 *     2 class constants indicate username and password that will be used in ssh: SSH_USERNAME & SSH_PASSWORD.
 *     The instance variables: jSch & session, will be used to make a ssh connection. session will be made from jSch.
 *     The constructor of this class will instantiate an instance variable: jSch. For instance methods, there are 2 getters
 *     and 2 setters for each instance variables, and connectSsh() & disconnectSsh() which are used to start connecting SSH
 *     and end connecting SSH.
 * </p>
 * <p>
 *     This class will set up information that will be used to connect SSH into the class constant.
 *     Then, it will make a JSch object by the constructor. After the JSch object is instantiated with an instance variable, jSch,
 *     it will make a Session object with the instance variable assigned.
 *     With the Session object, this class will connect to an UW-Parkside lab system. After the session is connected to the lab system,
 *     it will create a port forwarding to CS Database Server, using port number 3306.
 * </p>
 * @author Yunhwan(Nick) Jeong
 * @edu.uwp.cs.380.course CSCI - 380 Database Management Systems
 * @edu.uwp.cs.380.section 001
 * @edu.uwp.cs.380.assignment 1
 * @bugs none
 */
public class SshConnection {
    /*
    This class constant holds username of the UW-parkside lab system.
     */
    private final String SSH_USERNAME = "jeong";

    /*
    This class constant holds password of the UW-parkside lab system.
     */
    private final String SSH_PASSWORD = "YunHwan0218!";

    /*
    This instance variable holds a JSch object.
     */
    private JSch jSch;

    /*
    This instance variable holds a Session object from JSch.
     */
    private Session session;

    /**
     * This constructor will be used to instantiate an instance variable: jSch.
     * <p>
     *     In order to instantiate the instance variable, jSch, it requires to import jsch package.
     * </p>
     */
    public SshConnection() {
        this.jSch = new JSch();     // Instantiate an instance variable.
    }

    /**
     * This method will be used to connect local system to certain system.
     * <p>
     *     connectSsh() will instantiate an instance variable: session, using the other instance variable, jSch.
     *     With the instance method of JSch object, getSession(), it will instantiate the instance variable.
     *     Since the getSession() method requires username, hostname and port number, it will assign parameters of the getSession().
     *     the username will be given by the class constant, but the hostname and port number are hard coded, because
     *     these two parameters are specific. The reason why they are hard coded is because the hostname is only one, and port number
     *     is set to 22 due to SSH connection.
     * </p>
     * <p>
     *     After the instance variable is instantiated, it will give the password of the remote system by setPassword() from Session object.
     *     Then it will set configuration of the instantiated Session object with the setConfig() method.
     *     After setting up the Session object, password of remote system and configuration, connectSsh() will connect to
     *     the designated system with connect() method from Session object.
     * </p>
     * <p>
     *     After connecting to the designated system using SSH, it will create port forwarding.
     *     For this step, it assumes that the port number of local system is 4321. Then, since the port number of CS Database Server is 3306,
     *     it will assign 3306 to the rport parameter. Before creating port forwarding, it already connected to the remote system,
     *     the host will be "localhost".
     * </p>
     * <p>
     *     To keep tracking the process of connecting, it will print out some strings before and after each setting-up and connecting.
     *     In addition, because the instance methods from jsch package will throw JSchException,
     *     it will instantiate a try-catch block where this method invoked.
     * </p>
     * @throws JSchException This exception will be thrown if the parameters given to the instance methods from jsch package are incorrect.
     */
public void connectSsh() throws JSchException {
        System.out.print("Building the session...");            // Print out the process of connection.
        this.session = jSch.getSession(this.SSH_USERNAME, "basil.cs.uwp.edu", 22);  // Instantiate an instance variable.
        System.out.println("done.");                            // Print out the process of connection.

        session.setPassword(this.SSH_PASSWORD);                 // Set the password of the session.
        session.setConfig("StrictHostKeyChecking", "no");       // Set the configuration of the session.

        System.out.print("Establishing SSH Connection...");     // Print out the process of connection.
        session.connect();                                      // Connect the session.
        System.out.println("done.");                            // Print out the process of connection.

        // Create the port forwarding.
        int portForwardingNumber = session.setPortForwardingL(4321, "localhost", 3306);
        System.out.println("Assigned port: " + portForwardingNumber);   // Print out the process of connection.
    }

    /**
     * This method will be used to disconnect the connection made from connectSsh() method.
     */
    public void disconnectSsh() {
        this.session.disconnect();      // Disconnect the session connected.
    }

    /**
     * This method is an instance method which is a getter, and it will return the instance variable, jSch.
     * @return  It will return a JSch object which is an instance variable, named jSch.
     */
    public JSch getJSch() {
        return this.jSch;       // Return the instance variable.
    }

    /**
     * This method is an instance method which is a getter, and it will return the instance variable, session.
     * @return  It will return a Session object which is an instance variable, named session.
     */
    public Session getSession() {
        return this.session;    // Return the instance variable.
    }

    /**
     * This method  will get a JSch object as a parameter, and give the parameter to jSch, which is an instance variable.
     * @param jSch This parameter is a JSch object, and will be used to set jSch.
     */
    public void setJSch(JSch jSch) {
        this.jSch = jSch;       // Instantiate an instance variable.
    }

    /**
     * This method  will get a Session object as a parameter, and give the parameter to session, which is an instance variable.
     * @param session This parameter is a Session object, and will be used to set session.
     */
    public void setSession(Session session) {
        this.session = session; // Instantiate an instance variable.
    }
}
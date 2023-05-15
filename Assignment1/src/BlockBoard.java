import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * This class will make a block puzzle game.
 * <p>
 *     BlockBoard class will make a block board that users can rotate and flip to get the area as large as they can.
 *     In order to use Java GUI, this class inherits JFrame class. It will have 3 instance variables: MAX_DEPTH, root and countSmash.
 *     BlockBoard class will also have a constructor which doesn't get any parameter.
 *     Then, it will have an inner-class, Node, which will be the main part of moving puzzles.
 *     Also, this class will have a method, commandBox(), that returns a JPanel to inform valid commands. At last, it will have a main() method, which is a main driver of this class.
 * </p>
 * <P>
 *     BlockBoard class will offer a container to play block puzzle games by inheriting JFrame.
 *     In the constructor, the instance variable, root, will be instantiated by the inner-class.
 *     In the method returning JPanel, this class will fill out a JPanel with a player's name and commands by using JLabel.
 *     Since the block puzzle game allows 10 moves for players, this class will repeat same process for ten times in main() method.
 * </P>
 * @author YunHwan Jeong
 * @uwp.edu.cs.340.course CSCI 340 - Data Structures and Algorithm Design
 * @edu.uwp.cs.340.section 001
 * @edu.uwp.cs.340.assignment 1
 * @bugs none
 */
public class BlockBoard extends JFrame {

    /*
    This is a constant instance variable that holds the upper limitation of the depth in the block puzzle game.
     */
    private final int MAX_DEPTH = 4;

    /*
    This is an instance variable that holds the fundamental node of the block board.
     */
    private Node root;

    /*
    This is a boolean instance variable that determines whether smash() method of the inner-class can be used or not.
     */
    private boolean canSmash = true;

    /**
     * This constructor is a default constructor.
     * <p>
     *     This constructor will instantiate an instance variable which is the fundamental node of the block board with a constructor of inner-class.
     *     It will also use a JFrame method, add(), to put the fundamental node into JFrame.
     *     When it puts the instance variable, it will use a BorderLayout to settle the block puzzle at center of JFrame.
     * </p>
     */
    public BlockBoard () {
        this.root = new Node (0);            // Instantiate the instance variable.
        add (this.root, BorderLayout.CENTER);            // Add the instantiated variable to JFrame using BorderLayout.
    }


    /**
     * This class will make and manipulate the node of block board.
     * <p>
     *     Node class will make each node in the block puzzle; the nodes are composed with child in quad tree structure, color and depth.
     *     In order to use Java GUI, it will inherits JPanel. In addition, this class will have 3 instance variables: child, which is a quad tree structure, color and depth.
     *     Node class will have 2 constructors; one is default and omitted, and the other is parameterized by an int variable.
     *     Then, this class will have 6 methods: smash(), rotateClockWise(), rotateCounterClockWise(), flipLeftAndRight(), flipTopAndBottom() and selectCommand().
     *     The former 5 methods will be used to manipulate the block board, and the last one will be used to correspond with input from the users.
     * </p>
     * <p>
     *     This class will make a node linked to 4 nodes in next depth using 2-dimensional array to indicate the child nodes of a current node.
     *     It will assign random colors for each node within 4 colors: red, green, blue, yellow.
     *     In order to make different sizes of nodes, this class will split the nodes into 4 nodes randomly; the node in the first depth has to be split.
     *     Manipulating the block board after assigning all nodes in random 4 sizes will usually happen with 4 methods.
     * </p>
     */
    public class Node extends JPanel {

        /*
        This is an instance variable that holds 4 child nodes in "current depth + 1" linked with current node.
         */
        Node[][] child;

        /*
        This is an instance variable that holds the color of the node importing java.awt.Color.
         */
        Color color;

        /*
        This is an instance variable indicating the depth of the node.
         */
        int depth;

        /**
         * This constructor is a parameterized constructor.
         * <p>
         *     It will get an int data-type parameter indicating the depth of current node. With the parameter, it will instantiate an instance variable.
         *     Then, by using switch-block, it will assign the color of the node.
         *     In order to make the sizes of nodes differently, it will invoke smash() method using the int data-type parameter.
         *     After instantiating all instance variables, it will update nodes in Java GUI.
         * </p>
         */
        public Node (int depthParam) {
            this.depth = depthParam;                                // Instantiate an instance variable using parameter.

            int numberForColor = (int) (Math.random() * 4);         // Instantiate an int variable to use as a determinant for color using Math.random() method.

            switch (numberForColor) {                               // Make a switch-block using an int variable instantiated with Math.random() method.
                // When the int variable is 0,
                case 0:
                    this.color = Color.RED;                         // Set the color as red.
                    break;                                          // Escape the switch block.

                // When the int variable is 1,
                case 1:
                    this.color = Color.GREEN;                       // Set the color as green.
                    break;                                          // Escape the switch block.

                // When the int variable is 2,
                case 2:
                    this.color = Color.BLUE;                        // Set the color as blue.
                    break;                                          // Escape the switch block.

                // When the int variable is 3,
                case 3:
                    this.color = Color.YELLOW;                      // Set the color as yellow.
                    break;                                          // Escape the switch block.
            }

            double numberForSmash = Math.random();                  // Instantiate a double data-type variable to determine whether the node will be split.

            if (numberForSmash < Math.exp(-0.25 * this.depth)) {
                this.child = smash(this.depth);                     // Initialize the linked child nodes by invoking smash() method.

                revalidate();                                       // Update in Java GUI.
            }

            setBackground(this.color);                              // Fill out the node with initialized color.
            setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));      // Set the border for node.
        }

        /**
         * This method will be used to break down a node into 4 smaller nodes.
         * <p>
         *     It will get an int variable as a parameter. Before breaking down the node, this method will set layout to update Java GUI.
         *     Additionally, it will fill out the back ground of the bock board with gray color.
         *     Then, it will check whether the instance variable, child, is null or not.
         *     If the instance variable is not null, that is, the node has children, then it will return current instance variable.
         *     Also, it will return an error message.
         *     If the instance variable is null, then it will break down the node into 4 children after checking the depth of the node.
         * </p>
         * <p>
         *     If the depth of the node is less than maximum depth, then it will initialize the instance variable as 2 by 2 array.
         *     Then, by using nested loop, it will instantiate each child with the constructor of this Node class giving one bigger integer value.
         *     Inside the nested loop, it will also update Java GUI by using add() method. Then it will return updated instance variable.
         *     Or if the depth of the node is greater than or equal to the maximum depth, then this method won't change anything and return null.
         * </p>
         * @param depthParam This parameter indicates the depth of current node which may be split.
         * @return It will return the 2 dimensional array which rows and columns are 2 for each, containing nodes inside.
         */
        public Node[][] smash (int depthParam) {
            setLayout (new GridLayout (2, 2));                                   // Set layout likely to the 2 dimensional array.
            setBackground (Color.GRAY);                                                     // Set the background color as gray.

            if (this.child != null) {
                System.out.println ("This node has already been smashed.");                 // Print out the error message.
                return this.child;                                                          // Return the instance variable.
            }
            else {
                if (depthParam < MAX_DEPTH) {
                    this.child = new Node[2][2];                                            // Initialize the instance variable with the size 2 by 2.

                    // Set up the nested loop that will go through all indices of 2 dimensional array.
                    for (int r = 0; r < 2; r++) {
                        for (int c = 0; c < 2; c++) {
                            this.child[r][c] = new Node(depthParam + 1);        // Instantiate each entries with new node objects of one deeper depth.
                            add(this.child[r][c]);                                          // Update the Java GUI.
                        }
                    }
                    return this.child;                                                      // Return the instance variable.
                }
                else {
                    return null;                                                            // Return null.
                }
            }
        }

        /**
         * This method will be used to rotate the block board clockwise.
         * <p>
         *     In order to change the children of the node, it will change the instance variable, child.
         *     It will make a temporary 2 dimensional array to hold the changed children.
         *     After assigning all indices with new elements, the instance variable will aliasing to the temporary 2 dimensional array.
         * </p>
         * <p>
         *     After changing the instance variable, it will update Java GUI.
         *     First, it will remove existed image of the node to change the GUI.
         *     Then, by using the nested loop, it will add new nodes in block board substituting the old node.
         * </p>
         */
        public void rotateClockwise() {
            Node[][] tempChild = new Node[2][2];                // Instantiate a 2 dimensional array as big as the instance variable.

            tempChild[0][0] = this.child[1][0];                 // Fill in the index of temporary array with proper moved child node.
            tempChild[0][1] = this.child[0][0];                 // Fill in the index of temporary array with proper moved child node.
            tempChild[1][0] = this.child[1][1];                 // Fill in the index of temporary array with proper moved child node.
            tempChild[1][1] = this.child[0][1];                 // Fill in the index of temporary array with proper moved child node.

            removeAll();                                        // Remove the current node from Java GUI.

            this.child = tempChild;                             // Alias the instance variable with the instantiated array.

            // Make a nested loop to go over all indices of the arrays.
            for (int r = 0; r < 2; r++) {
                for (int c = 0; c < 2; c++) {
                    add (this.child[r][c]);                      // Update the block board with children.
                }
            }
        }

        /**
         * This method will be used to rotate the block board counter-clockwise.
         * <p>
         *     In order to change the children of the node, it will change the instance variable, child.
         *     It will make a temporary 2 dimensional array to hold the changed children.
         *     After assigning all indices with new elements, the instance variable will aliasing to the temporary 2 dimensional array.
         * </p>
         * <p>
         *     After changing the instance variable, it will update Java GUI.
         *     First, it will remove existed image of the node to change the GUI.
         *     Then, by using the nested loop, it will add new nodes in block board substituting the old node.
         * </p>
         */
        public void rotateCounterClockwise() {
            Node[][] tempChild = new Node[2][2];                // Instantiate a 2 dimensional array as big as the instance variable.

            tempChild[0][0] = this.child[0][1];                 // Fill in the index of temporary array with proper moved child node.
            tempChild[0][1] = this.child[1][1];                 // Fill in the index of temporary array with proper moved child node.
            tempChild[1][0] = this.child[0][0];                 // Fill in the index of temporary array with proper moved child node.
            tempChild[1][1] = this.child[1][0];                 // Fill in the index of temporary array with proper moved child node.

            removeAll();                                        // Remove the current node from Java GUI.

            this.child = tempChild;                             // Alias the instance variable with the instantiated array.

            // Make a nested loop to go over all indices of the arrays.
            for (int r = 0; r < 2; r++) {
                for (int c = 0; c < 2; c++) {
                    add (this.child[r][c]);                      // Update the block board with children.
                }
            }
        }

        /**
         * This method will be used to flip left and right of the block board.
         * <p>
         *     In order to change the children of the node, it will change the instance variable, child.
         *     It will make a temporary 2 dimensional array to hold the changed children.
         *     After assigning all indices with new elements, the instance variable will aliasing to the temporary 2 dimensional array.
         * </p>
         * <p>
         *     After changing the instance variable, it will update Java GUI.
         *     First, it will remove existed image of the node to change the GUI.
         *     Then, by using the nested loop, it will add new nodes in block board substituting the old node.
         * </p>
         */
        public void flipLeftAndRight() {
            Node[][] tempChild = new Node[2][2];                // Instantiate a 2 dimensional array as big as the instance variable.

            tempChild[0][0] = this.child[0][1];                 // Fill in the index of temporary array with proper moved child node.
            tempChild[0][1] = this.child[0][0];                 // Fill in the index of temporary array with proper moved child node.
            tempChild[1][0] = this.child[1][1];                 // Fill in the index of temporary array with proper moved child node.
            tempChild[1][1] = this.child[1][0];                 // Fill in the index of temporary array with proper moved child node.

            removeAll();                                        // Remove the current node from Java GUI.

            this.child = tempChild;                             // Alias the instance variable with the instantiated array.

            // Make a nested loop to go over all indices of the arrays.
            for (int r = 0; r < 2; r++) {
                for (int c = 0; c < 2; c++) {
                    add (this.child[r][c]);                      // Update the block board with children.
                }
            }
        }

        /**
         * This method will be used to flip top and bottom of the block board.
         * <p>
         *     In order to change the children of the node, it will change the instance variable, child.
         *     It will make a temporary 2 dimensional array to hold the changed children.
         *     After assigning all indices with new elements, the instance variable will aliasing to the temporary 2 dimensional array.
         * </p>
         * <p>
         *     After changing the instance variable, it will update Java GUI.
         *     First, it will remove existed image of the node to change the GUI.
         *     Then, by using the nested loop, it will add new nodes in block board substituting the old node.
         * </p>
         */
        public void flipTopAndBottom() {
            Node[][] tempChild = new Node[2][2];                // Instantiate a 2 dimensional array as big as the instance variable.

            tempChild[0][0] = this.child[1][0];                 // Fill in the index of temporary array with proper moved child node.
            tempChild[0][1] = this.child[1][1];                 // Fill in the index of temporary array with proper moved child node.
            tempChild[1][0] = this.child[0][0];                 // Fill in the index of temporary array with proper moved child node.
            tempChild[1][1] = this.child[0][1];                 // Fill in the index of temporary array with proper moved child node.

            removeAll();                                        // Remove the current node from Java GUI.

            this.child = tempChild;                             // Alias the instance variable with the instantiated array.

            // Make a nested loop to go over all indices of the arrays.
            for (int r = 0; r < 2; r++) {
                for (int c = 0; c < 2; c++) {
                    add (this.child[r][c]);                      // Update the block board with children.
                }
            }
        }

        /**
         * This method will be used to communicate with the input.
         * <p>
         *     It will get 2 parameters: one is command String, and the other one is int variable for depth.
         *     This method will throw an NullPointerException if the command String is not equal to the existed commands or the int data-type parameter is not less than maximum depth.
         *     It will use equals() methods to determine which action should be performed.
         * </p>
         * @param commandParam This parameter is a string object that indicates move to be occurred.
         * @param depthParam This parameter indicates the depth of the node to be moved.
         */
        public void selectCommand (String commandParam, int depthParam) throws NullPointerException{
            if (depthParam < MAX_DEPTH) {
                if (commandParam.equals("RC")) {
                    rotateClockwise();                                      // Invoke proper method.
                }
                else if (commandParam.equals("RCC")) {
                    rotateCounterClockwise();                               // Invoke proper method.
                }
                else if (commandParam.equals("FLR")) {
                    flipLeftAndRight();                                     // Invoke proper method.
                }
                else if (commandParam.equals("FTB")) {
                    flipTopAndBottom();                                     // Invoke proper method.
                }
                else if (commandParam.equals("S") && canSmash) {
                    canSmash = false;                                       // Change the value of instance variable.
                    smash(depthParam);                                      // Invoke proper method.
                }
                else {
                    System.out.println ("Wrong Command");        // Print out the error message.
                }
            }
            else {
                throw new NullPointerException("Wrong Command");            // Throw exception.
            }
        }
    }

    /**
     * This method will be used to show the player's name and valid commands on Java GUI.
     * <p>
     *     It will instantiate a JPanel which will contain information.
     *     This method will set the size and the background color of the JPanel.
     *     commandBox() method will use a Scanner to update player's name.
     *     Also, additionally it will set layout as GridLayout to put the information in a form.
     *     Then, for all components, it will use JLabel to write the information.
     *     At last, after finishing making all components that will be in JPanel, it will update Java GUI using add() method, and will return the JPanel.
     * </p>
     * @return It will return the JPanel containing information.
     */
    public JPanel commandBox () {
        JPanel commandBox = new JPanel();                                   // Instantiate a JPanel.

        commandBox.setSize(500, 400);                         // Set the size of JPanel.
        commandBox.setLayout(new GridLayout(3, 3));             // Set the layout as grid.
        commandBox.setBackground(Color.BLACK);                              // Set the background color as black.

        Scanner userNameReader = new Scanner(System.in);                    // Instantiate a Scanner.
        System.out.print("Enter your name: ");                              // Display prompt.
        String userName = userNameReader.nextLine().toUpperCase();          // Instantiate a string object with input.

        JLabel JUser = new JLabel(userName);                                // Instantiate a JLabel.
        JUser.setForeground(Color.ORANGE);                                  // Set the color of component.

        JLabel JCommandRC = new JLabel("RC: rotate RC");                // Instantiate a JLabel.
        JCommandRC.setForeground(Color.WHITE);                               // Set the color of component.

        JLabel JCommandRCC = new JLabel("RCC: rotate RCC");             // Instantiate a JLabel.
        JCommandRCC.setForeground(Color.WHITE);                              // Set the color of component.

        JLabel JCommandFLR = new JLabel("FLR: flip Left & Right");      // Instantiate a JLabel.
        JCommandFLR.setForeground(Color.WHITE);                              // Set the color of component.

        JLabel JCommandFTB = new JLabel("FTB: flip Top & Bottom");      // Instantiate a JLabel.
        JCommandFTB.setForeground(Color.WHITE);                              // Set the color of component.

        JLabel JCommandS = new JLabel("S: smash Cell");                 // Instantiate a JLabel.
        JCommandS.setForeground(Color.WHITE);                                // Set the color of component.

        JLabel JCommandEND = new JLabel("END: finish Game");            // Instantiate a JLabel.
        JCommandEND.setForeground(Color.WHITE);                              // Set the color of component.

        commandBox.add(JUser);                                                  // Update Java GUI.
        commandBox.add(new JLabel(""));                                    // Update Java GUI to make the output neat.
        commandBox.add(new JLabel(""));                                    // Update Java GUI to make the output neat.
        commandBox.add(JCommandRC);                                             // Update Java GUI.
        commandBox.add(JCommandRCC);                                            // Update Java GUI.
        commandBox.add(JCommandFLR);                                            // Update Java GUI.
        commandBox.add(JCommandFTB);                                            // Update Java GUI.
        commandBox.add(JCommandS);                                              // Update Java GUI.
        commandBox.add(JCommandEND);                                            // Update Java GUI.

        return commandBox;                                                      // Return the JPanel.
    }

    /**
     * This method will be used as a main driver.
     * <p>
     *     main() method will instantiate an object of BlockBoard class. Since the BlockBoard class inherits JFrame, it can set the size and the close operation.
     *     In addition, it will instantiate a JPanel to hold the information. Then, it will add JPanel to JFrame.
     *     After setting up the fundamental stuffs, main() method will change the visibility to true.
     * </p>
     * <p>
     *     It will use a loop to repeat 10 times. In the loop, there will be 2 Scanners: one is for user, and the other is for input string.
     *     By using the second scanner, it will compare with valid commands. if the command is valid, then it will invoke manipulating methods to update GUI.
     * </p>
     * @param args
     */
    public static void main(String[] args) {
        BlockBoard myBlockBoard = new BlockBoard();                                 // Instantiate an object of BlockBoard class.
        myBlockBoard.setSize(500, 600);                               // Set the size of JFrame.
        myBlockBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                // Set the close operation of JFrame.

        JPanel commandBox = myBlockBoard.commandBox();                              // Instantiate an object by invoking a method.
        myBlockBoard.add (commandBox, BorderLayout.SOUTH);                          // Update Java GUI.
        myBlockBoard.setVisible(true);                                              // Change the visibility to show up.

        // Make up a loop to repeat asking input for 10 times.
        for (int i = 0; i < 10; i++) {
            Scanner keyBoard = new Scanner(System.in);                              // Instantiate a Scanner.
            System.out.println("Enter your move");                                  // Display prompt.
            String commandLine = keyBoard.nextLine().toUpperCase();                 // Instantiate a string object fixing the input string.

            Scanner commandScanner = new Scanner(commandLine);                      // Instantiate a Scanner to read the input string.
            String command = commandScanner.next();                                 // Instantiate a string object to hold only command.

            if (!command.equals("END")) {
                Node block = myBlockBoard.root;                                     // Instantiate a Node object with the instance variable of BlockBoard class.
                int countDepth = 0;                                                 // Instantiate an int data-type variable to count the depth of block node.

                // Set up the try-catch block to handle exception.
                try {
                    while (commandScanner.hasNextInt()) {
                        int row = commandScanner.nextInt();                         // Instantiate an int data-type variable to indicate the row of child.
                        int col = commandScanner.nextInt();                         // Instantiate an int data-type variable to indicate the column of child.

                        block = block.child[row][col];                              // Update the block node using row and column.
                        countDepth++;                                               // Increment the int variable that counting the depth.
                    }
                        block.selectCommand(command, countDepth);                   // Invoke a method to change the block board.
                        block.revalidate();                                         // Update Java GUI.
                }
                catch (Exception ex) {
                    ex.getMessage();                                                // Get message of the exception.
                }
            }
            else {
                break;                                                              // Escape the for-loop.
            }
        }
        System.out.println("Game Done.");                                           // Print out the message indicating the end of the game.
    }
}
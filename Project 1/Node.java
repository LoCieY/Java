/** 
    Class designed/written by: Jiacong Chen
    FileName: Node.java
    Developed for: ICS 211 Project #1
    Program description: This class represents a single Node used to build a singly linked list. Each Node stores an integer and a reference to the next Node.
    Limitations: This class can only stores integer values         
**/

public class Node {
        
        private int data;
        private Node next;

        /** 
            Brief Description: Creates an empty Node
            Parameters: None
            Precondition: None
            Postcondition: A Node is created and is initialized with deafult initial value to 0 and next to null.
            Return value: None
            Throws: None
        **/
        public Node() { 
            data = 0;
            next = null;
        }

        /** 
            Brief Description: Creates a node with specified integer
            Parameters: data (the integer value that is stored in the Node)
            Precondition: None
            Postcondition: The Node contains the specified data and does not point to another Node
            Return value: None
            Throws: None
        **/
        public Node(int data) {
            this.data = data;
            next = null;
        }

        /** 
            Brief Description: Returns the integer stored in the Node
            Parameters: None
            Precondition: The Node has been created first
            Postcondition: The integer stored in the Node remains unchanged
            Return value: The integer value stored in the Node
            Throws: None
        **/
        public int getData() {

            return data;

        }

        /** 
            Brief Description: Returns the Node referenced by next
            Parameters: None
            Precondition: The Node has been created
            Postcondition: The current Node's next reference is returned
            Return value: The next Node or null if there is no next Node.
            Throws: None
        **/
        public Node getNext() {

            return next;

        }

        /** 
            Brief Description: Sets the node Referenced by next
            Parameters: next (the Node that current Node should points to)
            Precondition: next may reference another Node or be null
            Postcondition: The current Node's next is updated
            Return value: None
            Throws: None
        **/
        public void setNext(Node next) {
            this.next = next;
        }


    }

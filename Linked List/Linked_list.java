
/**
    Class designed/written by: Jiacong Chen
    FileName: Linked_list.java
    Developed for: ICS 211 Project #1
    Program Description: A simple  dynamic single linked list for storing integers. Provides easy to use methods to add, remove, search, print, and count integers.
    limitations: This linked list can only work with integers and store integer values only.
 **/


public class Linked_list {

    private Node head;

    /**
        Brief Description: Creates an empty linked list.
        Parameters: None
        Precondition: None
        Postcondition: The linked list is created with head set to null;
        Return value: none
        Throws: none
    **/
    public Linked_list() {
       head = null; 
    }

    /**
        Brief Description: Checks whether the linked list is empty
        Parameters: None
        Precondition: The linked list has been created
        Postcondition: The list is chcked to determine whether head is null.
        Return value: true if the list is empty; false otherwise.
        Throws: none
    **/
    public boolean IsEmpty() {
        return head == null;
    }

    /**
        Brief Description: Inserts a new Node at the beginning of the list
        Parameters: value (the integer value to insert)
        Precondition: The linked list has been created
        Postcondition: A new node containing value becomes the first Node.
        Return value: None
        Throws: none
    **/
    public void insertAtHead(int value) {
        Node newNode = new Node(value);
        
        // Connect the new Node to the current First Node.
        newNode.setNext(head);

        // Make the new Node the first Node in the list.
        head = newNode;

        System.out.println(value + " is added to the head of the list.");
    }

    /**
        Brief Description: Inserts a new Node at the end  of the list
        Parameters: value (the integer value to insert to tail)
        Precondition: The linked list has been created
        Postcondition: A new node containing value becomes the Last Node.
        Return value: None
        Throws: none
    **/
    public void insertAtTail(int value) {

        Node newNode = new Node(value);

        // if the list is empty, the new Node becomes the head
        if (head == null) {
            head = newNode;
            System.out.println(value + " is successfully inserted at tail.");
            return;
        }

        Node currentCursor = head;

        // Move the cursuor to the Last Node in the list
        for (currentCursor = head; currentCursor.getNext() != null; currentCursor = currentCursor.getNext());
        currentCursor.setNext(newNode);

        System.out.println(value + " is successfully inserted at tail.");

    }

    /**
        Brief Description: Prints all values in the linked list
        Parameters: None
        Precondition: The linked list has been created
        Postcondition: The values in the list are displayed from head to tail
        Return value: None
        Throws: none
    **/
    public void printLinkedList() {
        System.out.print("Current List: ");
        printRecursive(head);
    }

    /**
        Brief Description: Recursively prints the value from the specified Node through the end of the list.
        Parameters: cursor (the current Node being processed)
        Precondition: cursor is either a valid Node or null.
        Postcondition: All values from cursor through the end of the list are printed.
        Return value: None
        Throws: none
    **/
    private void printRecursive(Node cursor) {

        // Base Case 1: The list is empty.
        if (cursor == null) { 
            System.out.println("The list is empty.");
            return; 
        }

        // Base Case 2: Last Node
        if (cursor.getNext() == null) {
            System.out.println(cursor.getData());
            return;
        }

        System.out.print(cursor.getData() + " ");

        // Recursive Case: Move to the next Node.
        printRecursive(cursor.getNext()); // Recursive Case
    }


    /**
        Brief Description: Counts the total number of Nodes in the list
        Parameters: none
        Precondition:  The linked list has been created
        Postcondition: Every Node is counted and the total is printed
        Return value: None
        Throws: none
    **/
    public void countNodes() {
        int nodeCounts = 0;

        // If there is no node in the list
        if (head == null) {
            System.out.println("Node Counts: " + nodeCounts);
            return;
        }
        
        // Traverse the list and count each node
        for (Node cursor = head; cursor != null; cursor = cursor.getNext()) {
            nodeCounts++;
        }

        System.out.println("Node Counts: " + nodeCounts);
    }

    /**
        Brief Description: Searches the list for a specified integer value.
        Parameters: target (the integer value to search for)
        Precondition:  The linked list has been created
        Postcondition:The program displays wheter target is found or not
        Return value: None
        Throws: none
    **/
    public void isThere(int target) {

        // If the list is empty
        if (head == null) {
            System.out.println("Value Not Found: List is Empty");
            return;
        }

        Node cursor;
        boolean found = false;

        // Traverse the list until the value is found or the end is reached
        for (cursor = head; cursor != null; cursor = cursor.getNext()) {

            if (cursor.getData() == target) {
                found = true;
                System.out.println(target + " is found in the list");
                break;
            }
        }

        if (!found)
            System.out.println(target + " is not found in the list.");
    }

    /**
        Brief Description: Removes the first Node from the list
        Parameters: none
        Precondition: The linked list has been created
        Postcondition: The first Node is removed and head points to the next Node.
        Return value: None
        Throws: none
    **/
    public void removeFromHead() {
        if (head == null) {
            System.out.println("The List is Empty: No Head Integer Removed.");
            return;
        }
        int removedValue = head.getData();

        // Move head to the second Node, removing the original head.
        head = head.getNext();

        System.out.println(removedValue + " is succesfully removed from the head.");

    }

    /**
        Brief Description: Removes the last Node from the list
        Parameters: none
        Precondition: The linked list has been created
        Postcondition: The last node is removed. If multiple Nodes exists, the previous Node becomes the last Node.
        Return value: None
        Throws: none
    **/
    public void removeFromTail() {

        if (head == null) {
            System.out.println("The List is Empty: No Tail Integer Removed.");
            return;
        }

        if (head.getNext() == null) {
            int removedValue = head.getData();
            head = null;

            System.out.println(removedValue + " is sucessfully removed from the tail.");
            return;
        }

        Node cursor;
        Node previous = null;

        for (cursor = head; cursor != null; cursor = cursor.getNext()) {
            if (cursor.getNext() == null) {
                System.out.println(cursor.getData() + " is sucessfully removed from the tail.");
                previous.setNext(null);
                return;
            }

            previous = cursor;
    
        }
    }

    /**
        Brief Description: Counts how many times a specified integer occurs in the linked list
        Parameters: value (the integer value to count)
        Precondition: The linked list has been created
        Postcondition: Every occurence of value is counted and the total is printed afterwards.
        Return value: None
        Throws: none
    **/
    public void countOccurence(int value) {

        Node cursor;

        int occurenceCounts = 0;

        if (head == null) {
            System.out.println("Value Not Found: List is empty.");
            return;
        }

        // Traverse the entire list and count matching values
        for (cursor = head; cursor != null; cursor = cursor.getNext()) {

            if (cursor.getData() == value) {
                occurenceCounts++;
            }
        }

        System.out.println(value + " has appeared " + occurenceCounts + " times.");

    }

    /**
        Brief Description: Inserts a new Node at a specified index position
        Parameters: value (the integer value to insert) and position (the zero based index position where the value is inserted.)
        Precondition: The linked list has been created and position is an integer.
        Postcondition: If position is valid, a new Node containing value is inserted at the specified index position
        Return value: None
        Throws: none
    **/
    public void insertAt(int value, int position) {

        // No negative index positions are allowed
        if (position < 0) {
            System.out.println("Not Valid: Index cannot be negative. Please try again.");
            return;
        }

        // Position 0 means inserting at the head.
        if (position == 0) {
            System.out.print("Original List: ");
            printRecursive(head);

            insertAtHead(value);

            System.out.print("New List: ");
            printRecursive(head);

            return;
        }

        int count = 0;

        Node cursor;

        // Traverse the list until the Node before the desired position is reached.
        for (cursor = head; cursor != null; cursor = cursor.getNext()) {

            if (count == position - 1) {
                
                System.out.print("Original List: ");
                printRecursive(head);

                Node newNode = new Node(value);

                newNode.setNext(cursor.getNext());
                cursor.setNext(newNode);

                System.out.println("Sucessfully inserted '" + value + "' at index " + position + ".");
                System.out.print("New List: ");
                printRecursive(head);

                return;
            }
            count++;
        }

        // The requested position is outside the current list.
        if (position > count) {
            System.out.println("Not Valid: The location of insert is greater than list size.");
            System.out.print("Current List: ");
            printRecursive(head);
            
            return;
        }
    }

}
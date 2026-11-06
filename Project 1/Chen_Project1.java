/** 
 
    Program by: Jiacong Chen
    FileName: Chen_Project1.java
    Program Description: 
        This program provides a menu for operating a dynamic singly linked list 
        containing integer values. The user can insert, remove, search, print, and 
        count values in the linked list. This program satisfies ICS 211's Project 
        #1 requirement and extra credits.
    Input:
        Menu selections, integer values, and index positions are entered by the user.
        Invalid inputs are rejected and the user is required to enter an integer
    Algorithm:
        The program creates a Linked_list object and repeatedly displays a menu.
        Based on the user's selection, the corresponding linked list operation
        is performed. The program continues until the user chooses to exit
    Output:
        The program displays the menu and the results of the selected linked list 
        operations, including successful operation messages and appropriate 
        error messages.
    File/Classes used:
        Node.java and Linked_list.java
    Authored by: Jiacong Chen

**/

import java.util.Scanner;

public class Chen_Project1 {

    /**
        Brief Description: Ask the user wheter to return to the main menu. Only letter y or n is allowed for input.
        Parameters: input (Scanner used to receive user input)
        Precondition: input has been created
        Postcondition: The user's input is checked to determine whether the program should continue
        Return value: true if the user enters Y or y; false otherwise;
        Throws: none
    **/
    public static boolean continueMenu(Scanner input) {

        System.out.print("Would you like to return to the menu? (Y/N): ");
        char answer = input.next().charAt(0);

        while (answer != 'Y' && answer != 'y' && answer != 'N' && answer != 'n') {
            System.out.print("Invalid input. Please enter Y or N: ");
            answer = input.next().charAt(0);
        }

        return answer == 'Y' || answer == 'y';
    }

    /**
        Brief Description: Clears the terminal display
        Parameters: None
        Precondition: The program is running in a terminal that supports ANSI ewscape sequences
        Postcondition: Terminal is cleared
        Return value: None
        Throws: none
    **/
    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

    /**
        Brief Description: Reads and validates an integer from the user
        Parameters: input (Scanner used to receive user input)
        Precondition: input has been created
        Postcondition: Invalid non-integer input is removed until an integer is entered.
        Return value: The integer entered by the user.
        Throws: none
    **/
    public static int getInteger(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer");
            input.next();
        }

        return input.nextInt();
    }

    /**
        Brief Description: Run the interactive linked list menu
        Parameters: args (command-line agruments)
        Precondition: The program is started with a valid Java runtime
        Postcondition: Menu continues until the user chooses to exit
        Return value: None
        Throws: none
    **/
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Linked_list linkedList = new Linked_list();

        boolean continueMenu = true;

        while (continueMenu) {

            clearTerminal();

            // Print the available linked list operations
            System.out.println("======================");
            System.out.println("LINKED LIST MENU");
            System.out.println("======================");
            System.out.println("0. Variable Location Insert");
            System.out.println("1. Insert at Head");
            System.out.println("2. Insert at Tail");
            System.out.println("3. Count Nodes");
            System.out.println("4. Remove From Head");
            System.out.println("5. Remove From Tail");
            System.out.println("6. Find a Value");
            System.out.println("7. Count Occurences");
            System.out.println("8. Print List");
            System.out.println("9. Exit");
            System.out.println("======================");

            // Get choice from the user
            System.out.print("Enter your choice: ");
            int inputChoice = getInteger(input);

            // Perform choice

            switch (inputChoice) {
                
                // Insert at specific index position
                case 0:
                    System.out.print("Enter an integer value to insert: ");
                    int valueToInsert = getInteger(input);

                    System.out.print("Choose an index position to insert '" + valueToInsert + "': ");
                    int locationToInsert = getInteger(input);

                    linkedList.insertAt(valueToInsert, locationToInsert);
                    break;
                
                // Insert at head
                case 1:
                    System.out.print("Enter an integer to insert at head: ");
                    int head = getInteger(input);

                    linkedList.insertAtHead(head);
                    break;
                
                // Insert at tail    
                case 2:
                    System.out.print("Enter an integer to insert at tail: ");
                    int tail = getInteger(input);

                    linkedList.insertAtTail(tail);
                    break;

                // Count Nodes
                case 3:
                    linkedList.countNodes();

                    break;
                // Remove head
                case 4:
                    linkedList.removeFromHead();
                    
                    break;
                
                // Remove tail
                case 5:
                    linkedList.removeFromTail();

                    break;
                
                // Check if the target value is in the list
                case 6:
                    System.out.print("Enter an target integer value to find: ");
                    int targetValue = getInteger(input);

                    linkedList.isThere(targetValue);
                    break;

                // Count how many times the target value appeared
                case 7:
                    System.out.print("Enter an target integer value to find occurence: ");

                    int occurenceValue = getInteger(input);
                    linkedList.countOccurence(occurenceValue);

                    break;

                // Print List
                case 8:
                    linkedList.printLinkedList();
                    
                    break;

                // Exit menu
                case 9:
                    continueMenu = false;
                    clearTerminal();
                    System.out.println("Mahalo for using my program!! Hope to see you next time :P");

                    break;
                
                // Error preventer to prevent unexpected inputs
                default:
                    System.out.println("Invalid Input: Please try again.");
                

            }
            
            // Ask whether the user wants to continue after each operation
            if (continueMenu) {
                continueMenu = continueMenu(input);
                
                if (!continueMenu) {
                    clearTerminal();
                    System.out.println("Mahalo for using my program!! Hope to see you next time :P");
                }
            }
        }
    }
}
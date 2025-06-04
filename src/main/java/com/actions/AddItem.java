package src.main.java.com.actions;

// this action class is to add items to the to do list

import java.util.Scanner;

public class AddItem {
    /**
     * Prompts the user to enter a new to-do item and returns the input string.
     * 
     * @param scanner The Scanner instance to use for reading user input.
     * @return The string entered by the user.
     */
    public static String getItemFromUser(Scanner scanner) {
        System.out.print("Enter the new item: ");
        return scanner.nextLine();
    }
}
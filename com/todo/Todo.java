package com.todo;

import com.actions.AddItem;
import com.dispay.TodoDisplay;
import java.util.Scanner;

public class Todo {
    public static void main(String[] args) {

        AddItem addItem = new AddItem();

        // display welcome once
        try (Scanner input = new Scanner(System.in)) {
            // display welcome once
            System.out.println("~~~~~~~~~~~~~~~Tommy's Todo~~~~~~~~~~~~~~~");

            boolean isQuit = false;
            String userChoice;

            // loop the app
            // end the loop when user says yes
            while (!isQuit) {

                // display the menu
                TodoDisplay.displayMenu();

                userChoice = input.nextLine();

                // use switch case method for checking
                switch (userChoice) {
                    case "1" -> {
                        System.out.println("Adding new item.");
                        String newItem = addItem.addItem();
                        System.out.println("You have entered: " + newItem);
                    }
                    case "2" -> {
                        System.out.println("Editing Item.");
                    }
                    case "3" -> {
                        System.out.println("Deleting Item.");
                    }
                    case "4" -> {
                        System.out.println("You are quitting the app");
                        isQuit = true;
                    }
                    default -> System.err.println(">>> Invalid option selected! Please try again!");
                }

                // 4 will be used to end the loop
                if (userChoice.equals("4")) {
                    isQuit = true;
                }
            }
        }
    }
}
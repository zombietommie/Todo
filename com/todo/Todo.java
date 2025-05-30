package com.todo;

import com.dispay.TodoDisplay;
import java.util.Scanner;

public class Todo {
    public static void main(String[] args) {

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
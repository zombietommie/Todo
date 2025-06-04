package src.main.java.com.todo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import src.main.java.com.actions.AddItem;
import src.main.java.com.actions.DeleteItem;
import src.main.java.com.dispay.TodoDisplay;

public class Todo {

    private static List<String> todoItems = new ArrayList<>();
    private static final String DATA_FILE = "todolist.ser"; // File to store the to-do list

    public static void main(String[] args) {
        loadTodoList();

        Scanner userInputScanner = new Scanner(System.in);
        // display welcome once
        System.out.println("~~~~~~~~~~~~~~~Tommy's Todo~~~~~~~~~~~~~~~");

        boolean isQuit = false;
        String userChoice;

        // loop the app
        while (!isQuit) {
            // display the menu
            TodoDisplay.displayMenu();
            displayCurrentItems(); // Display current items before asking for choice

            userChoice = userInputScanner.nextLine();

            // use switch case method for checking
            switch (userChoice) {
                case "1" -> {
                    String newItem = AddItem.getItemFromUser(userInputScanner);
                    if (newItem != null && !newItem.trim().isEmpty()) {
                        todoItems.add(newItem);
                        saveTodoList(); // Save the list after adding an item
                        System.out.println("'" + newItem + "' has been added to your To-Do list.");
                    } else {
                        System.out.println("No item added. Input was empty.");
                    }
                }
                case "2" -> {
                    System.out.println("Editing Item. (Not yet implemented)");

                }
                case "3" -> {
                    System.out.println("Deleting Item. (Not yet implemented)");
                    DeleteItem.selectItemToDelete();
                }
                case "4" -> {
                    System.out.println("You are quitting the app. Goodbye!");
                    isQuit = true;
                }
                default -> System.err.println(">>> Invalid option selected! Please try again!");
            }
            System.out.println(); // Add a newline for better readability before next menu display
        }
        userInputScanner.close(); // Close the scanner when the application exits
    }

    private static void displayCurrentItems() {
        if (todoItems.isEmpty()) {
            System.out.println("\nYour to-do list is currently empty.");
        } else {
            System.out.println("\nCurrent To-Do Items:");
            for (int i = 0; i < todoItems.size(); i++) {
                System.out.println((i + 1) + ". " + todoItems.get(i));
            }
        }
        System.out.println("----------------------------------------");
    }

    @SuppressWarnings("unchecked") // For the cast from Object to List<String> during deserialization
    private static void loadTodoList() {
        try (FileInputStream fis = new FileInputStream(DATA_FILE);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            todoItems = (List<String>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No existing to-do list found (" + DATA_FILE + "). Starting with an empty list.");
            todoItems = new ArrayList<>(); // Ensure list is initialized
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading to-do list from " + DATA_FILE + ": " + e.getMessage());
            todoItems = new ArrayList<>(); // Start with an empty list on error
        }
    }

    private static void saveTodoList() {
        try (FileOutputStream fos = new FileOutputStream(DATA_FILE);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(todoItems);
        } catch (IOException e) {
            System.err.println("Error saving to-do list to " + DATA_FILE + ": " + e.getMessage());
        }
    }
}
package com.actions;

// this action class is to add items to the to do list

import java.util.Scanner;

public class AddItem {

    String newItem;

    Scanner input = new Scanner(System.in);

    public String addItem() {

        newItem = input.nextLine();
        return newItem;

    }
}
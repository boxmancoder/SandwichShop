package com.sandwich;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Screens {
    private static ArrayList<ItemOrder> orderList = new ArrayList<ItemOrder>();
    private static UUID orderNumber = UUID.randomUUID();
    private static String formattedOrderNumber = orderNumber.toString().substring(0, 5);
    private static Order currentOrder = new Order(formattedOrderNumber, orderList);

    static Scanner scanner = new Scanner(System.in);
    static  boolean appRunning = true;
    public static void homeScreen() {
        while(appRunning){
        System.out.println("Welcome to my Sandwich Shop!");
        System.out.println("What would you like to do today? :) ");
        System.out.println("PLease select an appropriate keyword: ");
        System.out.println("(1) --->  New Order");
        System.out.println("(0) --->  Exit");

        String homeScreenChoice = scanner.nextLine();

            switch (homeScreenChoice) {
                case "1" -> {
                    // Calls the orderScreen method which takes you to a new menu
                   orderScreen(currentOrder);
                }
                case "0" -> {
                    // Code for exit
                    System.out.println("Thanks for visiting! Good-Bye :D ");
                    appRunning = false;
                }
                default -> System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    public static void orderScreen(Order currentOrder) {
        boolean continueOrder = true;

        while (continueOrder) {
            System.out.println("Please choose from the following OPTIONS: ");
            System.out.println("\tS * Add SANDWICH");
            System.out.println("\tC * Add CHIPS");
            System.out.println("\tD * Add DRINKS");
            System.out.println("\tV * To VIEW Order");
            System.out.println("\tX * CANCEL Order");
            System.out.println("\tH * Back to HOME screen");
            System.out.print("Please ENTER your selection: ");
            String orderScreenChoice = scanner.nextLine();

            switch (orderScreenChoice.toUpperCase()) {
                case "S":
                    // This method adds the sandwich
                    Sandwich.addSandwich(Screens.currentOrder);
                    break;
                case "C":
                     //code to add chips
                    Chips.addChips(Screens.currentOrder);
                    break;
                case "D":
                   Drinks.addDrinks(Screens.currentOrder);
                    break;
                case "V":
                    // Code to view order
                    break;
                case "X":
                    // Code to cancel order
                    break;
                case "H":
                    // Code to go back to home screen
                    continueOrder = false;
                    System.out.println("Returning to home screen.");
                    System.out.println("--------------------------------------------------");
                    break;
                default:
                    System.out.println("Error. Please choose a valid option.");
            }
        }
    }
}



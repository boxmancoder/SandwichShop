package com.sandwich;

import java.util.Scanner;

public class Screens {

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
                case "1" ->
                    // Calls the orderScreen method which takes you to a new menu
                        Screens.orderScreen();
                case "0" -> {
                    // Code for exit
                    System.out.println("Thanks for visiting! Good-Bye :D ");
                    appRunning = false;
                }
                default -> System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    public static void orderScreen() {
        boolean continueOrder = true;

        while (continueOrder) {
            System.out.println("Please choose from the following OPTIONS: ");
            System.out.println("(S)  --->  Add SANDWICH");
            System.out.println("(C)  --->  Add CHIPS");
            System.out.println("(D)  --->  Add DRINKS");
            System.out.println("(V)  --->  To VIEW Order");
            System.out.println("(X)  --->  CANCEL Order");
            System.out.println("(H)  --->  Back to HOME screen");
            System.out.print("Please ENTER your selection: ");
            String orderScreenChoice = scanner.nextLine();

            switch (orderScreenChoice.toUpperCase()) {
                case "S":
                    //
                    return;
                case "C":
                     Chips.addChips();
                     //chips.addChips(orderList);
                    return;
                case "D":
                    // Code to add drinks
                    return;
                case "V":
                    // Code to view order
                    return;
                case "X":
                    // Code to cancel order
                    return;
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



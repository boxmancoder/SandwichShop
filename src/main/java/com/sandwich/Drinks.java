package com.sandwich;


import java.util.Scanner;



public class Drinks extends ItemOrder {
    public enum DrinkFlavors{
        SPRITE(1),
        PEPSI(2),
        COKE(3),
        WATER(4),
        LEMONADE(5),
        ICED_TEA(6),
        DIET_COKE(7),
        ORANGE_FANTA(8),
        DR_PEPPER(9);

        private final int value;
        DrinkFlavors(int value){
            this.value = value;
        }
        public int getValue(){
            return value;
        }
    }
    private DrinkFlavors flavor;
    private String size;
    public Drinks(DrinkFlavors flavor, String size) {
        this.flavor = flavor;
        this.size = size;
    }

    @Override
    public double getPrice() {
        double price;

        switch (size.toUpperCase()){
            case "SMALL":
                price = 2.00;
                break;
            case "MEDIUM":
                price = 2.50;
                break;
            case "LARGE":
                price = 3.00;
                break;
            default:
                price = 0;
                break;
        }
        return price;
    }



    @Override
    public String stringFormat() {
        StringBuilder builder = new StringBuilder();
        builder.append("DRINK: ")
                .append(getSize())
                .append(" ")
                .append(getFlavor())
                .append(" - $")
                .append(getPrice());
        return builder.toString();
    }

    public static void addDrinks(Order currentOrder) {
        Scanner userScanner = new Scanner(System.in);
        System.out.println("Please choose from the following FLAVORS: ");

        for (DrinkFlavors drinkFlavor : DrinkFlavors.values()) {
            System.out.println("\t" + drinkFlavor.getValue() + " * " + drinkFlavor);
        }

        boolean validFlavorChoice = false;
        DrinkFlavors selectedFlavor = null;

        while (!validFlavorChoice) {
            System.out.print("Please enter your NUMBER selection for flavor (or enter 0 to cancel): ");

            if (userScanner.hasNextInt()) {
                int flavorInput = userScanner.nextInt();
                userScanner.nextLine();

                if (flavorInput == 0) {
                    System.out.println("Skipping drink selection. Returning to the main menu.\n");
                    return;
                }

                for (DrinkFlavors drinkFlavor : DrinkFlavors.values()) {
                    if (drinkFlavor.getValue() == flavorInput) {
                        selectedFlavor = drinkFlavor;
                        validFlavorChoice = true;
                        break;
                    }
                }

                if (!validFlavorChoice) {
                    System.out.println("Invalid choice. Please try again.");
                }
            } else {
                userScanner.nextLine(); // Clear the invalid input from the scanner buffer
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        System.out.println("Please choose the SIZE by typing the NUMBER: ");
        System.out.println("(1) SMALL");
        System.out.println("(2) MEDIUM");
        System.out.println("(3) LARGE");

        boolean validSizeChoice = false;
        String selectedSize = null;

        while (!validSizeChoice) {
            System.out.print("Please enter a NUMBER selection based on size: ");
            int sizeInput = userScanner.nextInt();
            userScanner.nextLine();

            switch (sizeInput) {
                case 1 -> {
                    selectedSize = "SMALL";
                    validSizeChoice = true;
                }
                case 2 -> {
                    selectedSize = "MEDIUM";
                    validSizeChoice = true;
                }
                case 3 -> {
                    selectedSize = "LARGE";
                    validSizeChoice = true;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        Drinks drinkChoice = new Drinks(selectedFlavor, selectedSize);
        currentOrder.getOrderItems().add(drinkChoice);
        System.out.printf("%s %s: $%.2f successfully added to your order.\n\n",
                drinkChoice.getSize(), drinkChoice.getFlavor(), drinkChoice.getPrice());
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public DrinkFlavors getFlavor() {
        return flavor;
    }

    public void setFlavor(DrinkFlavors flavor) {
        this.flavor = flavor;
    }
}

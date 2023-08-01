package com.sandwich;

import java.util.ArrayList;
import java.util.Scanner;

import static com.sandwich.Screens.orderScreen;


public class Sandwich extends ItemOrder {
    public enum SandwichSize{
        FOUR_INCHES(1),
        EIGHT_INCHES(2),
        TWELVE_INCHES(3);

        private final int value;
        SandwichSize(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    private final SandwichSize size;
    private final boolean isToasted;
    private final BreadType breadType;
    private final ArrayList<Meats> meats;
    private final ArrayList<Cheese> cheeses;
    private final ArrayList<FreeToppings> freeToppings;

    public Sandwich(SandwichSize size, boolean isToasted, BreadType breadType) {
        this.size = size;
        this.isToasted = isToasted;
        this.breadType = breadType;

        meats = new ArrayList<Meats>();
        cheeses = new ArrayList<Cheese>();
        freeToppings =  new ArrayList<FreeToppings>();
    }

    public Sandwich(SandwichSize size, boolean isToasted, BreadType breadType, ArrayList<Meats> meats,
                    ArrayList<Cheese> cheeses, ArrayList<FreeToppings> freeToppings){
        this.size = size;
        this.isToasted = isToasted;
        this.breadType = breadType;
        this.meats = meats;
        this.cheeses = cheeses;
        this.freeToppings = freeToppings;
    }

    public void addMeat(Meats.MeatTypes meatTypes, boolean extra){
        Meats meat = new Meats(meatTypes, extra, size);
        meats.add(meat);
    }

    public void addCheese(Cheese.CheeseType cheeseType, boolean extra){
        Cheese cheese = new Cheese(cheeseType, extra, size);
        cheeses.add(cheese);
    }

    public void addFreeToppings(FreeToppings topping){
        freeToppings.add(topping);
    }
    @Override
    public double getPrice() {
        double sandwichPrice;

        switch (size){
            case FOUR_INCHES -> {
                sandwichPrice = 5.50;
                break;
            }
            case EIGHT_INCHES -> {
                sandwichPrice = 7.00;
                break;
            }
            case TWELVE_INCHES -> {
                sandwichPrice = 8.50;
                break;
            }
            default -> sandwichPrice = 0;
        }

        double cheesePrice = cheeses.stream().mapToDouble(Cheese::getPrice).sum();
        double meatsPrice = meats.stream().mapToDouble(Meats::getPrice).sum();
        return sandwichPrice + cheesePrice + meatsPrice;
    }

    @Override
    public String stringFormat() {
        StringBuilder builder = new StringBuilder();
        builder.append("CUSTOM SANDWICH: ")
                .append("\n")
                .append(size)
                .append(isToasted ? " toasted" : "")
                .append(" ")
                .append(breadType)
                .append("\n");

        builder.append("MEAT: ");
        for (Meats meat : meats) {
            builder.append(meat.getMeatTypes()).append(", ");
        }
        builder.delete(builder.length() - 2, builder.length()); // Remove the extra comma and space

        builder.append("\nCHEESE: ");
        for (Cheese cheese : cheeses) {
            builder.append(cheese.getCheeseType()).append(", ");
        }
        builder.delete(builder.length() - 2, builder.length()); // Remove the extra comma and space

        builder.append("\nFREE TOPPINGS: ");
        for (FreeToppings topping : freeToppings) {
            builder.append(topping).append(", ");
        }
        builder.delete(builder.length() - 2, builder.length()); // Remove the extra comma and space

        builder.append("\nSANDWICH TOTAL: $").append(String.format("%.2f", getPrice()));

        return builder.toString();
    }

    public static void addSandwich(Order currentOrder) {
        Scanner userScanner = new Scanner(System.in);
        System.out.println("Please enter the NUMBER of the SIZE of your sandwich: ");
        for (SandwichSize sandwichSize : SandwichSize.values()) {
            System.out.println("\t" + sandwichSize.getValue() + " * " + sandwichSize);
        }

        int userSizeInput;
        while (true) {
            String input = userScanner.nextLine().trim();
            if (input.matches("\\d+") && input.length() == 1) {
                userSizeInput = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Invalid Input. Please enter a single number for the size.");
            }
        }

        SandwichSize selectedSize = null;

        for (SandwichSize size : SandwichSize.values()) {
            if (size.getValue() == userSizeInput) {
                selectedSize = size;
                break;
            }
        }

        if (selectedSize == null) {
            System.out.println("Invalid Input.");
            return;
        }

        System.out.println("Please enter the NUMBER of the type of BREAD: ");
        for (BreadType breadType : BreadType.values()) {
            System.out.println("\t" + breadType.getValue() + " * " + breadType);
        }

        int userBreadInput;
        while (true) {
            String input = userScanner.nextLine().trim();
            if (input.matches("\\d+") && input.length() == 1) {
                userBreadInput = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Invalid Input. Please enter a single number for the bread type.");
            }
        }

        BreadType selectedBread = null;

        for (BreadType breadType : BreadType.values()) {
            if (breadType.getValue() == userBreadInput) {
                selectedBread = breadType;
                break;
            }
        }

        if (selectedBread == null) {
            System.out.println("Invalid Input.");
            return;
        }

        System.out.println("Did you want your bread TOASTED? (Y/N)");

        boolean isToasted;
        while (true) {
            String toastedInput = userScanner.nextLine().trim().toLowerCase();
            if (toastedInput.equals("y") || toastedInput.equals("n")) {
                isToasted = toastedInput.equals("y");
                break;
            } else {
                System.out.println("Invalid Input. Please enter 'Y' for Yes or 'N' for No.");
            }
        }
        ArrayList<Meats.MeatTypes> selectedMeats = new ArrayList<>();

        System.out.println("Please enter the NUMBER of the MEAT you want added: ");
        for (Meats.MeatTypes meatType : Meats.MeatTypes.values()) {
            System.out.println("\t" + meatType.getValue() + " * " + meatType);
        }

        int userMeatInput = 0;
        while (true) {
            String meatInput = userScanner.nextLine().trim();

            // Use a regular expression to check if the input contains only a single number
            if (meatInput.matches("\\d+") && meatInput.length() == 1) {
                userMeatInput = Integer.parseInt(meatInput);
                break;
            } else {
                System.out.println("Invalid Input: Please enter a single number for meat selection.");
            }
        }

        boolean isValidMeat = false;
        for (Meats.MeatTypes meatType : Meats.MeatTypes.values()) {
            if (meatType.getValue() == userMeatInput) {
                selectedMeats.add(meatType);
                isValidMeat = true;
                break;
            }
        }

        if (!isValidMeat) {
            System.out.println("Invalid Input: " + userMeatInput);
            return;
        }

        System.out.println("Do you want to add extra meat? (Y/N)");
        String addExtraMeatInput = userScanner.nextLine();
        boolean addExtraMeat = addExtraMeatInput.equalsIgnoreCase("y");

            System.out.println("Please enter the NUMBER of the CHEESE/s you want added: ");
            for (Cheese.CheeseType cheeseType : Cheese.CheeseType.values()) {
                System.out.println("\t" + cheeseType.getValue() + " * " + cheeseType);
            }
            String cheeseInput = userScanner.nextLine();
            String[] cheeseNumbers = cheeseInput.split(" ");
            ArrayList<Cheese.CheeseType> selectedCheeseTypes = new ArrayList<>();

            for (String cheeseNumber : cheeseNumbers) {
                int number = Integer.parseInt(cheeseNumber.trim());

                boolean isValidCheese = false;
                for (Cheese.CheeseType cheeseType : Cheese.CheeseType.values()) {
                    if (cheeseType.getValue() == number) {
                        selectedCheeseTypes.add(cheeseType);
                        isValidCheese = true;
                        break;
                    }
                }
                if (!isValidCheese) {
                    System.out.println("Invalid Input: " + number);
                }
            }

            System.out.println("Do you want extra cheese? (Y/N)");
            String extraCheeseInput = userScanner.nextLine();
            boolean addExtraCheese = extraCheeseInput.equalsIgnoreCase("y");

            System.out.println("Please enter the NUMBER of the FREE TOPPING/s you want added or press ENTER to skip: ");
            for (FreeToppings freeTopping : FreeToppings.values()) {
                System.out.println("\t" + freeTopping.getValue() + " * " + freeTopping);
            }

            String toppingsInput = userScanner.nextLine();
            String[] toppingsNumbers = toppingsInput.split(" ");
            ArrayList<FreeToppings> selectedToppings = new ArrayList<>();

            for (String toppingNumber : toppingsNumbers) {
                int number = Integer.parseInt(toppingNumber.trim());

                boolean isValidTopping = false;
                for (FreeToppings freeTopping : FreeToppings.values()) {
                    if (freeTopping.getValue() == number) {
                        selectedToppings.add(freeTopping);
                        isValidTopping = true;
                        break;
                    }
                }
                if (!isValidTopping){
                    System.out.println("Invalid Input: " + number);
                }
            }

            if (toppingsInput.isEmpty()) {
                String[] toppingTypes = toppingsInput.split(",");
                for (String topping : toppingTypes) {
                    try {
                        FreeToppings selectedTopping = FreeToppings.valueOf(topping.trim().toUpperCase());
                        selectedToppings.add(selectedTopping);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid topping: " + topping);
                    }
                }
            }

            Sandwich customSandwich = new Sandwich(selectedSize, isToasted, selectedBread);

            for (Meats.MeatTypes meatType : selectedMeats) {
                customSandwich.addMeat(meatType, addExtraMeat);
            }

            for (Cheese.CheeseType cheeseType : selectedCheeseTypes) {
                customSandwich.addCheese(cheeseType, addExtraCheese);
            }

            for (FreeToppings topping : selectedToppings) {
                customSandwich.addFreeToppings(topping);
            }

            if (currentOrder != null) {
                currentOrder.getOrderItems().add(customSandwich);
                System.out.println(customSandwich.stringFormat());
            } else {
                System.out.println("ERROR");
            }

            orderScreen(currentOrder);
        }
        }



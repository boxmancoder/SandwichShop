package com.sandwich;


import java.util.Scanner;

public class Chips extends ItemOrder {
    private final ChipType chipType;

    @Override
    public double getPrice() {
        return 1.50;
    }


    public enum ChipType{
        ORIGINAL_LAYS(1),
        FRITOS(2),
        BBQ_LAYS(3),
        DORITOS(4),
        BLUE_DORITOS(5),
        ORIGINAL_SUNCHIPS(6),
        PLANTAIN_CHIPS(7);
        private final int value;

        ChipType(int value){
            this.value = value;
        }
    }
    public Chips(ChipType chipType){
        this.chipType = chipType;
    }
    public ChipType getChipType(){
        return  chipType;
    }

    @Override
    public String stringFormat() {
        StringBuilder builder = new StringBuilder();
        builder.append("CHIP: ")
                .append(getChipType())
                .append(" - $")
                .append(getPrice());
        return builder.toString();
    }
    public static void addChips(Order currentOrder) {
        Scanner userScanner = new Scanner(System.in);
        System.out.println("Please choose from the following FLAVORS: ");

        for (ChipType chipType : ChipType.values()) {
            System.out.println("\t" + chipType.value + " * " + chipType);
        }

        boolean validChipChoice = false;
        ChipType selectedType = null;

        while (!validChipChoice) {
            System.out.print("Please enter your NUMBER selection for flavor (or enter 0 to cancel): ");

            if (userScanner.hasNextInt()) {
                int flavorInput = userScanner.nextInt();
                userScanner.nextLine();

                if (flavorInput == 0) {
                    System.out.println("Skipping chips selection. Returning to the main menu.\n");
                    return;
                }

                for (ChipType chipType : ChipType.values()) {
                    if (chipType.value == flavorInput) {
                        selectedType = chipType;
                        validChipChoice = true;
                        break;
                    }
                }

                if (!validChipChoice) {
                    System.out.println("Invalid choice. Please try again.");
                }
            } else {
                userScanner.nextLine(); // Clear the invalid input from the scanner buffer
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        Chips chipChoice = new Chips(selectedType);
        currentOrder.getOrderItems().add(chipChoice);
        System.out.printf("%s: $%.2f successfully added to your order.\n\n",
                chipChoice.getChipType(), chipChoice.getPrice());
    }
}

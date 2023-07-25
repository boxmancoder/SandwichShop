package com.sandwich;

import java.util.ArrayList;
import java.util.Scanner;

public class Chips extends ItemOrder {
    @Override
    public double getPrice() {
        return 1.50;
    }

    public enum ChipType{
        ORIGINAL_LAYS,
        FRITOS,
        BBQ_LAYS,
        DORITOS,
        BLUE_DORITOS,
        ORIGINAL_SUNCHIPS,
        PLANTAIN_CHIPS

    }

    public static void addChips(){
        Scanner scanner =  new Scanner(System.in);

        System.out.println("What Chips would you like? :");
        System.out.println("(1) ---> ORIGINAL_LAYS");
        System.out.println("(2) ---> FRITOS");
        System.out.println("(3) ---> BBQ_LAYS");
        System.out.println("(4) ---> DORITOS");
        System.out.println("(5) ---> BLUE_DORITOS");
        System.out.println("(6) ---> ORIGINAL_SUNCHIPS");
        System.out.println("(7) ---> PLANTAIN_CHIPS");
        int chipChoice = Integer.parseInt(scanner.nextLine());

        Chips.ChipType selectedChips = null;
        switch (chipChoice) {
            case 1:
                selectedChips = Chips.ChipType.ORIGINAL_LAYS;
                break;
            case 2:
                selectedChips = Chips.ChipType.FRITOS;
                break;
            case 3:
                selectedChips = Chips.ChipType.BBQ_LAYS;
                break;
            case 4:
                selectedChips = Chips.ChipType.DORITOS;
                break;
            case 5:
                selectedChips = Chips.ChipType.BLUE_DORITOS;
                break;
            case 6:
                selectedChips = Chips.ChipType.ORIGINAL_SUNCHIPS;
                break;
            case 7:
                selectedChips = Chips.ChipType.PLANTAIN_CHIPS;
                break;
            default:
                System.out.println("Invalid choice for chip type.");
                return;
        }

        System.out.println("Chips added to your order! :D ");
    }

}

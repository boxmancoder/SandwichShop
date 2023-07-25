package com.sandwich;

import java.util.ArrayList;

public class Sandwich extends ItemOrder {
    public enum SandwichSize{
        FOUR_INCHES,
        EIGHT_INCHES,
        TWELVE_INCHES
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
}

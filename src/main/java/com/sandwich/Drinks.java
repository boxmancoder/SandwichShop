package com.sandwich;

public class Drinks extends ItemOrder {
    public enum DrinkFlavors{
        SPRITE,
        PEPSI,
        COKE,
        WATER,
        LEMONADE,
        ICED_TEA,
        DIET_COKE,
        ORANGE_FANTA,
        DR_PEPPER
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
}

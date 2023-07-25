package com.sandwich;

public class Cheese extends ExtraCharge {
    public enum CheeseType {
        AMERICAN,
        PROVOLONE,
        CHEDDAR,
        SWISS
    }
    private final Sandwich.SandwichSize size;

    public Cheese(CheeseType cheeseType, boolean hasExtra, Sandwich.SandwichSize size) {
        super(hasExtra);
        this.size = size;
    }
    @Override
    public double getPrice() {
        double regularPrice;
        double extraPrice;

        switch(size){
            case FOUR_INCHES:
                regularPrice = 0.75;
                extraPrice = 0.30;
                break;
            case EIGHT_INCHES:
                regularPrice = 1.50;
                extraPrice = 0.60;
                break;
            case TWELVE_INCHES:
                regularPrice = 2.25;
                extraPrice = 0.90;
                break;
            default:
                regularPrice = 0;
                extraPrice = 0;
                break;
        }
         if(hasExtra()){
             return regularPrice + extraPrice;
         } else {
             return regularPrice;
         }
    }
}

package com.sandwich;

public class Meats extends ExtraCharge {
    public enum MeatTypes{
        STEAK,
        HAM,
        SALAMI,
        ROAST_BEEF,
        CHICKEN,
        BACON
    }
  private final Sandwich.SandwichSize size;

    public Meats(MeatTypes meatTypes, boolean hasExtra, Sandwich.SandwichSize size) {
        super(hasExtra);
        this.size = size;
    }
    @Override
    public double getPrice() {
        double regularPrice;
        double extraPrice;

        switch(size){
            case FOUR_INCHES:
                regularPrice = 1.00;
                extraPrice = 0.50;
                break;
            case EIGHT_INCHES:
                regularPrice = 2.00;
                extraPrice = 1.00;
                break;
            case TWELVE_INCHES:
                regularPrice = 3.00;
                extraPrice = 1.50;
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

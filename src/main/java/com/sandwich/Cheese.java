package com.sandwich;

public class Cheese extends ExtraCharge {
    public enum CheeseType {
        AMERICAN(1),
        PROVOLONE(2),
        CHEDDAR(3),
        SWISS(4);

        private final int value;
        CheeseType(int value){
            this.value = value;
        }
        public int getValue(){
            return value;
        }
    }
    private final Sandwich.SandwichSize size;
    private final CheeseType cheeseType;

    public Cheese(CheeseType cheeseType, boolean hasExtra, Sandwich.SandwichSize size) {
        super(hasExtra);
        this.cheeseType = cheeseType;
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

    public CheeseType getCheeseType() {
        return cheeseType;
    }
}

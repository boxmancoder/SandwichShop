package com.sandwich;

public abstract class ItemOrder {

    private  static int nextItemNumber = 1;

    private final int itemNumber;

    public abstract double getPrice();
    public abstract String stringFormat();

    public ItemOrder(){
        this.itemNumber = nextItemNumber;
        nextItemNumber++;
    }

    public int getItemNumber() {
        return itemNumber;
    }
}

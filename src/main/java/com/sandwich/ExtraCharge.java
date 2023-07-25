package com.sandwich;

public abstract class  ExtraCharge {
    private final boolean hasExtra;
    public abstract double getPrice();

    public ExtraCharge(boolean hasExtra){
        this.hasExtra = hasExtra;
    }

    public boolean hasExtra(){
        return hasExtra;
    }
}

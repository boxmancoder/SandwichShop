package com.sandwich;


    public enum BreadType {
        WHITE(1),
        WHEAT(2),
        RYE(3),
        WRAP(4);
        private final int value;

        BreadType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
package com.sandwich;

public enum FreeToppings {
        LETTUCE(1),
        GREEN_PEPPERS(2),
        ONIONS(3),
        TOMATOES(4),
        JALEPENOS(5),
        CUCUMBERS(6),
        PICKLES(7),
        GUACEMOLE(8),
        MUSHROOMS(9),
         MAYO(10),
        MUSTARD(11),
        KETCHUP(12),
        RANCH(13),
        THOUSAND_ISLANDS(14),
        VINAIGRETTE(15);

        private final int value;

        FreeToppings(int value){
                this.value = value;
        }

        public int getValue() {
                return value;
        }
}

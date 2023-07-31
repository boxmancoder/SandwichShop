package com.sandwich;

import java.util.ArrayList;
import java.util.UUID;

import static com.sandwich.Screens.homeScreen;

public class Order {

    private String orderNumber;
    private ArrayList<ItemOrder> itemOrders;

    public Order(String orderNumber, ArrayList<ItemOrder> itemOrders) {
        this.orderNumber = orderNumber;
        this.itemOrders = itemOrders;
    }

    public String getOrderNumber() {
        UUID generatedOrderID = UUID.randomUUID();
        String printedOrderID = generatedOrderID.toString().substring(0, 5);
        return printedOrderID;
    }

    public ArrayList<ItemOrder> getOrderItems() {
        return itemOrders;
    }

    public void setOrderItems(ArrayList<ItemOrder> itemOrders) {
        this.itemOrders = itemOrders;
    }

    public double calculateTotalCost() {
        double totalCost = 0;

        for (ItemOrder itemOrder : itemOrders){
            totalCost += itemOrder.getPrice();
        }

        return  totalCost;
    }

    public void removeItem(ItemOrder item) {
        itemOrders.remove(item);
    }
}

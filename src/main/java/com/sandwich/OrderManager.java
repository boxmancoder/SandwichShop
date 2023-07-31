package com.sandwich;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class OrderManager {
    //Where the reader and writer are
    private static final String ordersDirectory = "orders/";

    public static void writeOrder(Order order) {

        String orderID = order.getOrderNumber();
        String fileName = generateFileName(orderID);

        try {
            FileWriter receipt = new FileWriter(fileName);
            BufferedWriter receiptWriter = new BufferedWriter(receipt);
            receiptWriter.write(orderToString(order));
            receiptWriter.close();
            System.out.println("Order No: " + orderID + " SUCCESSFULLY PLACED!" + "\n");

        } catch (IOException e) {
            System.out.println("ERROR: Could not write receipt.");
            e.printStackTrace();
        }
    }

    public static void readOrder(String orderID) {

        String fileName = generateFileName(orderID);

        try {
            FileReader receipt2 = new FileReader(fileName);
            BufferedReader receiptReader = new BufferedReader(receipt2);

            String receiptLine;

            while (((receiptLine) = receiptReader.readLine()) != null) {
                System.out.println(receiptLine);
            }

        } catch (IOException e) {
            System.out.println("ERROR: Cannot VIEW Receipt");

        }
    }

    private static String generateFileName(String orderID) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter receiptFormat = DateTimeFormatter.ofPattern("yyyy.MM.dd_hh:mm:ss");
        String receiptDateTime = currentDateTime.format(receiptFormat);

        return ordersDirectory+ receiptDateTime + "_OrderID:" + orderID.toString() + ".txt";

    }

    private static String orderToString(Order order) {
        StringBuilder receiptBuilder = new StringBuilder();
        receiptBuilder.append("Order Number: ").append(order.getOrderNumber()).append("\n");

        ArrayList<ItemOrder> itemOrders = order.getOrderItems();
        for (ItemOrder item : itemOrders) {
            receiptBuilder.append(itemToString(item)).append("\n").append(order.calculateTotalCost());
        }

        return receiptBuilder.toString();
    }

    private static String itemToString(ItemOrder item) {
        if (item instanceof Sandwich sandwich) {
            return sandwich.stringFormat() + "\nSandwich Total Cost: " + sandwich.getPrice();
        }else if (item instanceof Drinks drinks) {
            return drinks.stringFormat();
        }else if (item instanceof Chips chips) {
            return chips.stringFormat();
        }else {
            return "Unknown item";
        }
    }
}

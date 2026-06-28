package com.sahane.yash;

import com.sahane.yash.common.Utility.*;
import com.sahane.yash.model.Order;

import com.sahane.yash.engine.OrderMatchingEngine;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import com.sahane.yash.common.Utility;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        OrderMatchingEngine service = new OrderMatchingEngine();

        Thread matchingThread = new Thread(() -> {
            try {
                service.startOrderMatching();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        matchingThread.start();

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("Enter Order Side (B or S) : ");
            OrderSide side = sc.next().equalsIgnoreCase("B") ? OrderSide.BUY : OrderSide.SELL ;

            BigDecimal price = new BigDecimal(-1);
            System.out.println("Enter Order Price : ");
            price = sc.nextBigDecimal();
            while(price.compareTo(new BigDecimal(0)) < 1) {
                System.out.println("Enter Valid Price : ");
                price = sc.nextBigDecimal();
            }

            int quantity = 0;
            System.out.println("Enter Order Quantity : ");
            quantity = sc.nextInt();
            while(quantity <= 0) {
                System.out.println("Enter Valid Quantity : ");
                quantity = sc.nextInt();
            }


            Order order = new Order(Utility.generateOrderId(), side, price, quantity);
            System.out.println("Order placed successfully" + order.toString());

            Utility.incomingOrderQueue.add(order);
        }


    }
}
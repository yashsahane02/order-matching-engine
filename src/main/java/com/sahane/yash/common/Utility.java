package com.sahane.yash.common;

import com.sahane.yash.model.Order;
import com.sahane.yash.model.Trade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Utility {
    private static final AtomicInteger orderIdSequence = new AtomicInteger(1);
    private static LocalDate currentDate = LocalDate.now();

    public enum OrderSide {
        BUY,
        SELL
    }

    public enum OrderStatus {
        NEW,
        PARTIALLY_FILLED,
        FILLED,
        CANCELLED
    }

    public enum OrderType {
        LIMIT,
        MARKET
    }

    public static synchronized String generateOrderId() {

        LocalDate today = LocalDate.now();

        if (!today.equals(currentDate)) {
            currentDate = today;
            orderIdSequence.set(1);
        }

        long seq = orderIdSequence.getAndIncrement();

        return today.format(DateTimeFormatter.BASIC_ISO_DATE)
                + String.format("%06d", seq);
    }

    private static final AtomicInteger tradeIdSequence = new AtomicInteger(1);

    public static synchronized String generateTradeId() {

        LocalDate today = LocalDate.now();

        if (!today.equals(currentDate)) {
            currentDate = today;
            tradeIdSequence.set(1);
        }

        long seq = tradeIdSequence.getAndIncrement();

        return today.format(DateTimeFormatter.ofPattern("ddMMyyyy")) + String.format("%06d", seq);
    }


    //Matched orders
    public static List<Trade> matchedOrderList = new ArrayList<>();

    //ORDER MATCHING QUEUE
    public static BlockingQueue<Order> incomingOrderQueue = new LinkedBlockingQueue<>();

    //BUY ORDER QUEUE
    public static PriorityQueue<Order> buyQueue = new PriorityQueue<>((a, b) -> {

        int priceComparison = b.getPrice().compareTo(a.getPrice());   // Higher price
        if (priceComparison != 0) return priceComparison;

        return a.getOrderId().compareTo(b.getOrderId()); // Earlier orderId
    });

    //SELL ORDER QUEUE
    public static PriorityQueue<Order> sellQueue = new PriorityQueue<>((a, b) -> {

        int priceComparison = a.getPrice().compareTo(b.getPrice()); // Lower price

        if (priceComparison != 0) {
            return priceComparison;
        }

        return a.getOrderId().compareTo(b.getOrderId()); // Earlier orderId
    });
}

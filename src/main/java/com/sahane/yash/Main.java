package com.sahane.yash;

import com.sahane.yash.model.Order;
import com.sahane.yash.model.OrderSide;
import com.sahane.yash.model.OrderStatus;
import com.sahane.yash.model.OrderType;

import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
        Order o1 = new Order(123, OrderSide.BUY, 10, 1, OrderType.LIMIT);
        System.out.println(o1.toString());
    }
}
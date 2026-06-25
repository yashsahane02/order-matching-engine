package com.sahane.yash.model;

import java.sql.Timestamp;

public class Order {
    private long orderId;

    private OrderSide orderSide;

    private double price;

    private int quantity;

    private OrderStatus orderStatus;

    private OrderType orderType;

    private long timestamp;

    public Order(long orderId, OrderSide orderSide, double price, int quantity, OrderType orderType) {
        this.orderId = orderId;
        this.orderSide = orderSide;
        this.price = price;
        this.quantity = quantity;
        this.orderStatus = OrderStatus.NEW;
        this.orderType = orderType;
        this.timestamp = System.currentTimeMillis();
    }


    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderSide getOrderSide() {
        return orderSide;
    }

    public void setOrderSide(OrderSide orderSide) {
        this.orderSide = orderSide;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderSide=" + orderSide +
                ", price=" + price +
                ", quantity=" + quantity +
                ", orderStatus=" + orderStatus +
                ", orderType=" + orderType +
                ", timestamp=" + timestamp +
                '}';
    }
}

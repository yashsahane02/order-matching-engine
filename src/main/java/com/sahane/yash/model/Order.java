package com.sahane.yash.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;
import com.sahane.yash.common.Utility.*;


public class Order {
    private String orderId; //format YYYYMMDD+ AtomicLong

    private OrderSide orderSide;

    private BigDecimal price;

    private int quantity;

    private OrderStatus orderStatus;

    private OrderType orderType;

    private Instant timestamp;

    private static final AtomicLong order = new AtomicLong(0);
    public Order(String orderId, OrderSide orderSide, BigDecimal price, int quantity) {
        this.orderId = orderId;
        this.orderSide = orderSide;
        this.price = price;
        this.quantity = quantity;
        this.orderStatus = OrderStatus.NEW;
        this.timestamp = Instant.now();
        if(getPrice().compareTo(new BigDecimal(0)) == 0){
            this.orderType = OrderType.MARKET;
        } else {
            this.orderType = OrderType.LIMIT;
        }
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
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

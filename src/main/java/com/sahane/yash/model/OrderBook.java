package com.sahane.yash.model;

public class OrderBook {
    private int buyOrsellQty;

    private double price;

    private long buyOrderId;

    private long sellOrderId;

    private long timestamp;

    public int getBuyOrsellQty() {
        return buyOrsellQty;
    }

    public void setBuyOrsellQty(int buyOrsellQty) {
        this.buyOrsellQty = buyOrsellQty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getBuyOrderId() {
        return buyOrderId;
    }

    public void setBuyOrderId(long buyOrderId) {
        this.buyOrderId = buyOrderId;
    }

    public long getSellOrderId() {
        return sellOrderId;
    }

    public void setSellOrderId(long sellOrderId) {
        this.sellOrderId = sellOrderId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}

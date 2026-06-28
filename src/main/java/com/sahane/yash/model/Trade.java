package com.sahane.yash.model;

import java.math.BigDecimal;
import java.time.Instant;

public class Trade {


    private String tradeId;
    private int buyOrsellQty;

    private BigDecimal price;

    private String buyOrderId;

    private String sellOrderId;

    private Instant timestamp;

    public Trade(int buyOrsellQty, BigDecimal price, String buyOrderId, String sellOrderId, Instant timestamp, String tradeId) {
        this.buyOrsellQty = buyOrsellQty;
        this.price = price;
        this.buyOrderId = buyOrderId;
        this.sellOrderId = sellOrderId;
        this.timestamp = timestamp;
        this.tradeId = tradeId;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }
    public int getBuyOrsellQty() {
        return buyOrsellQty;
    }

    public void setBuyOrsellQty(int buyOrsellQty) {
        this.buyOrsellQty = buyOrsellQty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBuyOrderId() {
        return buyOrderId;
    }

    public void setBuyOrderId(String buyOrderId) {
        this.buyOrderId = buyOrderId;
    }

    public String getSellOrderId() {
        return sellOrderId;
    }

    public void setSellOrderId(String sellOrderId) {
        this.sellOrderId = sellOrderId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "OrderBook{" +
                "tradeId='" + tradeId + '\'' +
                ", buyOrsellQty=" + buyOrsellQty +
                ", price=" + price +
                ", buyOrderId='" + buyOrderId + '\'' +
                ", sellOrderId='" + sellOrderId + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

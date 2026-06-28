package com.sahane.yash.engine;

import com.sahane.yash.common.Utility;
import com.sahane.yash.model.Order;
import com.sahane.yash.model.OrderBook;


import java.time.Instant;

import static com.sahane.yash.common.Utility.*;

public class OrderMatchingEngine {

    public void startOrderMatching() throws InterruptedException {

        while (true) {

            Order order = incomingOrderQueue.take();

            if (order.getOrderSide() == OrderSide.BUY) {
                processBuyOrder(order);
            } else {
                processSellOrder(order);
            }
        }
    }

    private void processBuyOrder(Order buyOrder) {
        while (buyOrder.getQuantity() > 0 && !sellQueue.isEmpty()) {

            Order sellOrder = sellQueue.peek();

            // No match possible
            if((buyOrder.getOrderType().equals(OrderType.LIMIT) && (buyOrder.getPrice().compareTo(sellOrder.getPrice()) < 0))){
                    break;
            }

            executeTrade(buyOrder, sellOrder);

            // Remove the resting sell order if fully executed
            if (sellOrder.getQuantity() == 0) {
                sellQueue.poll();
            }
        }

        if (buyOrder.getQuantity() > 0 && buyOrder.getOrderType().equals(OrderType.LIMIT)) {
            buyQueue.offer(buyOrder);
        }
        System.out.println("Buy Queue Size : " + buyQueue.size());
    }

    private void processSellOrder(Order sellOrder) {

        while (sellOrder.getQuantity() > 0 && !buyQueue.isEmpty()) {

            Order buyOrder = buyQueue.peek();
            if(sellOrder.getOrderType().equals(OrderType.LIMIT) && (buyOrder.getPrice().compareTo(sellOrder.getPrice()) < 0)){
                    break;
            }

            executeTrade(buyOrder, sellOrder);

            // Remove the resting buy order if fully executed
            if (buyOrder.getQuantity() == 0) {
                buyQueue.poll();
            }
        }

        if (sellOrder.getQuantity() > 0 && sellOrder.getOrderType().equals(OrderType.LIMIT)) {
            sellQueue.offer(sellOrder);
        }
        System.out.println("Sell Queue Size : " + sellQueue.size());
    }

    private void executeTrade(Order buyOrder, Order sellOrder) {

        int tradedQty = Math.min(
                buyOrder.getQuantity(),
                sellOrder.getQuantity());

        buyOrder.setQuantity(
                buyOrder.getQuantity() - tradedQty);

        sellOrder.setQuantity(
                sellOrder.getQuantity() - tradedQty);


        OrderBook trade = new OrderBook(
                tradedQty,
                sellOrder.getPrice(),
                buyOrder.getOrderId(),
                sellOrder.getOrderId(),
                Instant.now(),
                generateTradeId());

        System.out.println(trade.toString());

        matchedOrderList.add(trade);
    }
}

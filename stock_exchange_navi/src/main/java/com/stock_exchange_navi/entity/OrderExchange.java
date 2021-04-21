package com.stock_exchange_navi.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author akshay on 21/04/21
 */
@Getter
@Setter
public class OrderExchange {

    /**
     * Storing all orders here for future reference. Assuming this goes to persistence DB
     */
    private List<Order> originalSellOrders;
    private List<Order> originalBuyOrders;

    private Map<Long,Order> activeSellOrders;
    private Map<Long,Order> activeBuyOrders;

    public OrderExchange() {
        this.originalSellOrders =new LinkedList<>();;
        this.originalBuyOrders =new LinkedList<>();;
        this.activeSellOrders =new ConcurrentHashMap<>();;
        this.activeBuyOrders =new ConcurrentHashMap<>();;
    }

    public void addBuyOrder(Order order){
        this.getOriginalBuyOrders().add(order);
        activeBuyOrders.put(order.getOrderId(), order);
    }

    public void addSellOrder(Order order){
        this.getOriginalSellOrders().add(order);
        activeSellOrders.put(order.getOrderId(), order);
    }
}

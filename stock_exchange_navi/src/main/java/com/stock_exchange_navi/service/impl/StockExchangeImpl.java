package com.stock_exchange_navi.service.impl;

import com.stock_exchange_navi.entity.Transaction;
import com.stock_exchange_navi.entity.Order;
import com.stock_exchange_navi.entity.OrderExchange;
import com.stock_exchange_navi.service.StockExchange;
import com.stock_exchange_navi.utils.Constants;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author akshay on 21/04/21
 */
@Slf4j
@Getter
public class StockExchangeImpl implements StockExchange {
    private Map<String, OrderExchange> orderExchangeMap;

    public StockExchangeImpl() {
        orderExchangeMap =new HashMap<String, OrderExchange>();
    }

    private void init(List<Order> orders){
        log.info("Initializing stock Exchange");
        orders.stream().forEach( orderObj -> {
                    OrderExchange orderExchange;
                    if(orderExchangeMap.containsKey(orderObj.getStock())){
                        orderExchange= orderExchangeMap.get(orderObj.getStock());
                    }else{
                        orderExchange=new OrderExchange();
                    }

                    if(orderObj.getType().equalsIgnoreCase(Constants.OrderType.BUY.getOrder())) {
                        orderExchange.addBuyOrder(orderObj);
                    }else{
                        orderExchange.addSellOrder(orderObj);
                    }
                    orderExchangeMap.put(orderObj.getStock(), orderExchange);
                }
        );
    }

    @Override
    public void initTrading() {
        log.info("Starting with the trading process");
        List<Transaction> transactions=new LinkedList<>();
        /**
         * To optimize the search between buy and sell orders, Iterating only on the active orders.
         * With persistent storage we can add filter out sell orders based on active buy orders
         */
        for(Map.Entry<String, OrderExchange> entry: orderExchangeMap.entrySet()){
            for(Order buyOrder: entry.getValue().getActiveBuyOrders().values()){
                for(Order sellOrder: entry.getValue().getActiveSellOrders().values()){
                    processOrder(transactions, entry, buyOrder, sellOrder);
                    /**
                     * If the current buy order is closed then we need not check for
                     * further sell orders
                     */
                    if(buyOrder.getQuantity()==0){
                        break;
                    }
                }
            }
        }

        log.info("Final Transaction List");
        log.info("{}",transactions);;
        print(transactions);
    }

    private void processOrder(List<Transaction> transactions, Map.Entry<String, OrderExchange> entry, Order buyOrder, Order sellOrder) {
        int quantity = 0;
        if(sellOrder.isOrderStatus()){
            if(sellOrder.getPricePerUnit()<= buyOrder.getPricePerUnit()){
                quantity= buyOrder.getQuantity();
                /**
                 * If sell order quantity is less than buy quantity and price in range
                 * then we process the sell order and same amount of stocks will be
                 * equated in buy order
                 */
                if(sellOrder.getQuantity()< buyOrder.getQuantity()){
                    quantity= sellOrder.getQuantity();;
                    buyOrder.setQuantity(buyOrder.getQuantity()- sellOrder.getQuantity());
                    sellOrder.setQuantity(0);
                }else{
                    sellOrder.setQuantity(sellOrder.getQuantity()- buyOrder.getQuantity());
                    buyOrder.setQuantity(0);
                    buyOrder.setOrderStatus(false);
                    log.info("Closing buy order {}", buyOrder);
                    /**
                     * Optimizing the order iterations
                     */
                    entry.getValue().getActiveBuyOrders().remove(buyOrder.getOrderId());
                }

                if(sellOrder.getQuantity()==0){
                    sellOrder.setOrderStatus(false);
                    log.info("Closing sell order {}", sellOrder);
                    /**
                     * Optimizing the order iterations
                     */
                    entry.getValue().getActiveSellOrders().remove(sellOrder.getOrderId());
                }

                Transaction transaction = new Transaction(sellOrder.getOrderId(), buyOrder.getOrderId(),quantity, sellOrder.getPricePerUnit());
                transactions.add(transaction);
            }
        }
    }

    private void print(List<Transaction> transactions) {
        for(Transaction transaction: transactions){
            log.info("#{} {} {} {}", transaction.getBuyOrderId(), transaction.getPricePerUnit(), transaction.getQuantity(), transaction.getSellOrderId());
        }
    }

    /**
     * Submit set of orders to exchange
     * @param orders
     */
    @Override
    public void submitTradingRequests(List<Order> orders) {
        init(orders);
    }
}

package com.stock_exchange_navi.service;

import com.stock_exchange_navi.entity.Order;

import java.util.List;

/**
 * @author akshay on 21/04/21
 */
public interface StockExchange {
    public void initTrading();

    public void submitTradingRequests(List<Order> orders);
}

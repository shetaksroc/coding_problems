package com.stock_exchange_navi;

import com.stock_exchange_navi.entity.Order;
import com.stock_exchange_navi.service.StockExchange;
import com.stock_exchange_navi.service.impl.StockExchangeImpl;
import com.stock_exchange_navi.utils.FileReader;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author akshay on 21/04/21
 */
public class MainApp {

    public static final String FILE_NAME = "stock_exchange";

    public static void main(String[] args) throws IOException {
        BasicConfigurator.configure();
        /**
         * Loading the trade requests from file
         */
        List<String> readFiles= FileReader.readLines(FILE_NAME);
        List<Order> orders=readFiles.stream().map( order -> new Order(order)).collect(Collectors.toList());
        StockExchange exchange=new StockExchangeImpl();
        /**
         * Future extensions:
         * InitTrading can be a Listener and there can other services which initiates Request and submit
         * it to Stock Exchange through exchange.submit(List<Order>) method and InitTrading
         * process can work the new transactions
         */
        exchange.submitTradingRequests(orders);
        exchange.initTrading();
    }
}

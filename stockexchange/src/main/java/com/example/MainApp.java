package com.example;

import com.example.service.impl.StockExchangeImpl;
import com.example.utils.FileReader;

import java.io.IOException;
import java.util.List;

/**
 * @author akshay on 19/01/19
 */
public class MainApp {
    public static void main(String[] args) throws IOException {
//        List<String> readFiles= FileReader.readFileAsList("stock_exchange");
        List<String> readFiles= FileReader.readFileAsList("stock_exchange_new");
        StockExchangeImpl exchange=new StockExchangeImpl(readFiles);
        exchange.analyze();
        exchange.printPortFolio();
    }
}

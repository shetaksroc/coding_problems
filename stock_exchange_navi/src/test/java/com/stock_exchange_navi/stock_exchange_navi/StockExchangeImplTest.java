package com.stock_exchange_navi.stock_exchange_navi;

import com.stock_exchange_navi.entity.Order;
import com.stock_exchange_navi.service.impl.StockExchangeImpl;
import com.stock_exchange_navi.utils.FileReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * @author akshay on 21/04/21
 */
public class StockExchangeImplTest {

    public static final String FILE_NAME = "stock_exchange";
    private List<String> readFiles;

    @Before
    public void setUp() throws Exception {
        readFiles= FileReader.readLines(FILE_NAME);
    }

    @Test
    public void testInitStockExchange_whenValidOrderIsLoaded() {
        StockExchangeImpl stockExchange=new StockExchangeImpl();
        Order order=new Order(readFiles.get(0));
        stockExchange.submitTradingRequests(Collections.singletonList(order));
        Assert.assertTrue(stockExchange.getOrderExchangeMap().containsKey("BAC"));
        Assert.assertTrue(stockExchange.getOrderExchangeMap().get("BAC").getActiveSellOrders().size()==1);
        Assert.assertTrue(stockExchange.getOrderExchangeMap().get("BAC").getOriginalSellOrders().size()==1);

        Assert.assertTrue(stockExchange.getOrderExchangeMap().get("BAC").getActiveBuyOrders().size()==0);
        Assert.assertTrue(stockExchange.getOrderExchangeMap().get("BAC").getOriginalBuyOrders().size()==0);
    }
}

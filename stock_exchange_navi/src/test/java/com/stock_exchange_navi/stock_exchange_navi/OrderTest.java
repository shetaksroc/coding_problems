package com.stock_exchange_navi.stock_exchange_navi;

import com.stock_exchange_navi.entity.Order;
import com.stock_exchange_navi.utils.FileReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

/**
 * @author akshay on 21/04/21
 */
public class OrderTest {

    public static final String FILE_NAME = "stock_exchange";
    private List<String> readFiles;

    @Before
    public void setUp() throws Exception {
        readFiles= FileReader.readLines(FILE_NAME);
    }

    @Test
    public void testOrderConstructor_WhenValidOrderIsPassed() {
        Order order=new Order(readFiles.get(0));
        Assert.assertTrue(Objects.nonNull(order));
        Assert.assertTrue(order.getOrderId()==1);
        Assert.assertTrue(order.getStock().equals("BAC"));
    }

    /**
     * Todo
     * Add More tests to validate the input
     */
}

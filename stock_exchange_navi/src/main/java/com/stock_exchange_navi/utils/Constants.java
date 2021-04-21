package com.stock_exchange_navi.utils;

import lombok.Getter;

/**
 * @author akshay on 21/04/21
 */
public class Constants {

    @Getter
    public enum OrderType{
        BUY("Buy"),
        SELL("Sell");

        private String order;

        OrderType(String order) {
            this.order = order;
        }

    }
}

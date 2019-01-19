package com.example.utils;

import lombok.Getter;

/**
 * @author akshay on 19/01/19
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

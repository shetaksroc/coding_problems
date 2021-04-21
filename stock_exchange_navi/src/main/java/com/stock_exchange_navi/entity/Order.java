package com.stock_exchange_navi.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author akshay on 21/04/21
 */
@Getter
@Setter
@ToString
public class Order {
    private Long orderId;
    private String time;
    private String stock;
    private String type;
    private Integer quantity;
    private Double pricePerUnit;
    private boolean orderStatus;

    public Order(String line) {
        String[] temp=line.split(" ");
        this.orderId = Long.valueOf(temp[0]);
        this.time = temp[1];
        this.stock = temp[2];
        this.type = temp[3];
        this.pricePerUnit = Double.valueOf(temp[4]);
        this.quantity = Integer.valueOf(temp[5]);
        this.orderStatus= true;
    }
}

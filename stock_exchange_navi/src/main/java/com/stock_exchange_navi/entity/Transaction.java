package com.stock_exchange_navi.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @author akshay on 21/04/21
 */
@Getter
@Setter
@ToString
public class Transaction {

    private Long sellOrderId;
    private Long buyOrderId;
    private Integer quantity;
    private Double pricePerUnit;

    public Transaction(Long sellOrderId, Long buyOrderId, Integer quantity, Double pricePerUnit) {
        this.sellOrderId = sellOrderId;
        this.buyOrderId = buyOrderId;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }
}

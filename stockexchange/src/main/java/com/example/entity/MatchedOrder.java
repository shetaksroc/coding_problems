package com.example.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author akshay on 19/01/19
 */
@Getter
@Setter
public class MatchedOrder {
    private Integer sellOrderId;
    private Integer buyOrderId;
    private Integer quantity;
    private Double pricePerUnit;

    public MatchedOrder(Integer sellOrderId, Integer buyOrderId, Integer quantity, Double pricePerUnit) {
        this.sellOrderId = sellOrderId;
        this.buyOrderId = buyOrderId;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public String toString() {
        return "MatchedOrder{" +
                "sellOrderId=" + sellOrderId +
                ", buyOrderId=" + buyOrderId +
                ", quantity=" + quantity +
                ", pricePerUnit=" + pricePerUnit +
                '}';
    }
}

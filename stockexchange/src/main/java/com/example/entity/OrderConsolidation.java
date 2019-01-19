package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author akshay on 19/01/19
 */
@Getter
@Setter
public class OrderConsolidation {

    public void increaseTotalAvailableQuantity(Integer totalAvailableQuantity) {
        this.totalAvailableQuantity += totalAvailableQuantity;
    }

    private Integer totalAvailableQuantity;
    private List<Order> sellOrders;
    private List<Order> buyOrders;
    private Double minBuyPrice;
    private Double maxBuyPrice;

    public void setTotalStocksPurchased(Integer totalStocksPurchased) {
        this.totalStocksPurchased += totalStocksPurchased;
    }

    private Integer totalStocksPurchased;



    public OrderConsolidation() {
        this.sellOrders =new LinkedList<Order>();;
        this.buyOrders =new LinkedList<Order>();;
        this.totalAvailableQuantity=0;
        minBuyPrice=0D;
        maxBuyPrice=0D;
        totalStocksPurchased=0;
    }

    public void setMaxBuyPrice(Double pricePerUnit) {
        if(this.maxBuyPrice==0 || pricePerUnit>this.maxBuyPrice){
            this.maxBuyPrice=pricePerUnit;
        }
    }

    public void setMinBuyPrice(Double pricePerUnit) {
        if(this.minBuyPrice==0 || this.minBuyPrice>pricePerUnit) {
            this.minBuyPrice = pricePerUnit;
        }
    }

    @Override
    public String toString() {
        return "OrderConsolidation{" +
                "totalAvailableQuantity=" + totalAvailableQuantity +
                ", sellOrders=" + sellOrders +
                ", buyOrders=" + buyOrders +
                '}';
    }
}

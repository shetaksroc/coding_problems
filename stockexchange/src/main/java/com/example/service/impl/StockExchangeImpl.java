package com.example.service.impl;

import com.example.entity.MatchedOrder;
import com.example.entity.Order;
import com.example.entity.OrderConsolidation;
import lombok.Getter;

import java.util.*;

/**
 * @author akshay on 19/01/19
 */
@Getter
public class StockExchangeImpl implements StockExchange {
    private Map<String, OrderConsolidation> orderConsolidationMap;
    private Map<Integer,String> orderTimeMap;

    public StockExchangeImpl(List<String> orders) {
        orderConsolidationMap=new HashMap<String, OrderConsolidation>();
        orderTimeMap=new HashMap<Integer,String>();
        init(orders);
    }

    private void init(List<String> orders){
        orders.stream().forEach(
                order -> {
                    Order orderObj= new Order(order);
                    OrderConsolidation orderConsolidation;
                    if(orderConsolidationMap.containsKey(orderObj.getStock())){
                        orderConsolidation=orderConsolidationMap.get(orderObj.getStock());

                    }else{
                        orderConsolidation=new OrderConsolidation();
                    }
                    orderConsolidation.increaseTotalAvailableQuantity(orderObj.getQuantity());
                    if(orderObj.getType().equalsIgnoreCase("buy")) {
                        orderConsolidation.getBuyOrders().add(orderObj);
                        orderConsolidation.setMaxBuyPrice(orderObj.getPricePerUnit());
                        orderConsolidation.setMinBuyPrice(orderObj.getPricePerUnit());
                    }else{
                        orderConsolidation.getSellOrders().add(orderObj);
                    }
                    Collections.sort(orderConsolidation.getBuyOrders(), new TimeSort());
                    Collections.sort(orderConsolidation.getBuyOrders(), new PriceSort());

                    Collections.sort(orderConsolidation.getSellOrders(), new TimeSort());
                    Collections.sort(orderConsolidation.getSellOrders(), new PriceSort());

                    orderConsolidationMap.put(orderObj.getStock(), orderConsolidation);
                    orderTimeMap.put(orderObj.getOrderId(),orderObj.getTime());
                }
        );
    }

    public static class TimeSort implements Comparator<Order>{
        @Override
        public int compare(Order o1, Order o2) {
            return checkTime(o1.getTime(),o2.getTime())?0:1;
        }
    }

    public static class PriceSort implements Comparator<Order>{
        @Override
        public int compare(Order o1, Order o2) {
            return o1.getPricePerUnit().compareTo(o2.getPricePerUnit());
        }
    }

    @Override
    public String toString() {
        return "StockExchange{" +
                "orderConsolidationMap=" + orderConsolidationMap +
                '}';
    }

    public void analyze() {
        List<MatchedOrder> matchedOrderList=new LinkedList<>();
        for(Map.Entry<String,OrderConsolidation> entry: orderConsolidationMap.entrySet()){
           for(Order buyorder: entry.getValue().getBuyOrders()){
               for(Order sellOrder: entry.getValue().getSellOrders()){
                   if(checkTime(buyorder.getTime(),sellOrder.getTime())){
                       int quantity = 0;
                       if(sellOrder.isOrderStatus()){
                           if(sellOrder.getQuantity()>=buyorder.getQuantity() && sellOrder.getPricePerUnit()<=buyorder.getPricePerUnit()){
                               quantity=buyorder.getQuantity();
                               sellOrder.setQuantity(sellOrder.getQuantity()-buyorder.getQuantity());
                               if(sellOrder.getQuantity()==0){
                                   sellOrder.setOrderStatus(false);
                               }
                               buyorder.setQuantity(0);
                               buyorder.setOrderStatus(false);
                               MatchedOrder matchedOrder = new MatchedOrder(sellOrder.getOrderId(),buyorder.getOrderId(),quantity, sellOrder.getPricePerUnit());
                               matchedOrderList.add(matchedOrder);
                               entry.getValue().setTotalStocksPurchased(quantity);
                           }else if(sellOrder.getQuantity()<=buyorder.getQuantity() && sellOrder.getPricePerUnit()<buyorder.getPricePerUnit()){
                               quantity=sellOrder.getQuantity();
                               buyorder.setQuantity(buyorder.getQuantity()-sellOrder.getQuantity());
                               sellOrder.setOrderStatus(false);
                               sellOrder.setQuantity(0);
                               if(buyorder.getQuantity()==0){
                                   buyorder.setOrderStatus(false);
                               }
                               MatchedOrder matchedOrder = new MatchedOrder(sellOrder.getOrderId(),buyorder.getOrderId(),quantity, sellOrder.getPricePerUnit());
                               matchedOrderList.add(matchedOrder);
                               entry.getValue().setTotalStocksPurchased(quantity);
                           }
                       }

                       if(buyorder.getQuantity()==0){
                           break;
                       }
                   }
               }
           }
        }

        System.out.println(matchedOrderList.toString());
    }

    public static boolean checkTime(String buyTime, String sellTime) {
        String[] buyTimeArrray=buyTime.split(":");
        String[] sellTimeArrray=sellTime.split(":");

        if(Integer.parseInt(sellTimeArrray[0])<Integer.parseInt(buyTimeArrray[0])){
            return true;
        }else if(Integer.parseInt(sellTimeArrray[0])>Integer.parseInt(buyTimeArrray[0])){
            return false;
        }
        else if(Integer.parseInt(sellTimeArrray[0])==Integer.parseInt(buyTimeArrray[0])){
            return Integer.parseInt(sellTimeArrray[1])<Integer.parseInt(buyTimeArrray[1]);
        }
        return false;
    }

    public void printPortFolio() {
        for(Map.Entry<String,OrderConsolidation> entry: orderConsolidationMap.entrySet()){
            System.out.println("Stock:"+ entry.getKey());
            System.out.println("Total stocks:"+ entry.getValue().getTotalStocksPurchased());
            System.out.println("Min:"+ entry.getValue().getMinBuyPrice());
            System.out.println("Max:"+ entry.getValue().getMaxBuyPrice());
        }
    }
}

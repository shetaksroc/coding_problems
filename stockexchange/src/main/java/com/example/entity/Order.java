package com.example.entity;

import com.example.utils.Constants;
import lombok.Getter;
import lombok.Setter;

/**
 * @author akshay on 19/01/19
 */
@Getter
@Setter
public class Order {
    private Integer orderId;
    private String time;
    private String stock;
    private String type;
    private Integer quantity;
    private Double pricePerUnit;
    private boolean orderStatus;

    public Order(String line) {
        String[] temp=line.split(" ");
        this.orderId = Integer.valueOf(temp[0]);
        this.time = temp[1];
        this.stock = temp[2];
        this.type = temp[3];
        this.quantity = Integer.valueOf(temp[4]);;
        this.pricePerUnit = Double.valueOf(temp[5]);
        this.orderStatus= true;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", time='" + time + '\'' +
                ", stock='" + stock + '\'' +
                ", type='" + type + '\'' +
                ", quantity=" + quantity +
                ", pricePerUnit=" + pricePerUnit +
                '}';
    }
}

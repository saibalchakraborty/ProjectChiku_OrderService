package com.chiku.order.service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "Order_Details")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ORDER_NAME")
    private String orderName;
    @Column(name = "AMOUNT")
    private Double amount;
    @Column(name = "ORDER_DATE")
    private Date orderDate;
}

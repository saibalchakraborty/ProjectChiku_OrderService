package com.chiku.order.service.controller;

import com.chiku.order.service.function.OrderService;
import com.chiku.order.service.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Objects;

@RestController
@RequestMapping("/v1")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/order", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> createOrder(@RequestBody Order reqOrder){
        log.info("Starting to create order at :: {}", LocalDateTime.now());
        Order createdOrder = orderService.addOrder(reqOrder);
        log.info("Added order successfully in system with id :: {}", createdOrder.getId());
        return new ResponseEntity<Order>(createdOrder, HttpStatus.OK);
    }

    @GetMapping(value = "/order/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> getOrder(@PathVariable("id") String id){
        log.info("Fetching order with id :: {}", id);
        Order order = orderService.fetchOrder(id);
        log.info("Order found with id :: {} - {}", id, Objects.nonNull(order));
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }
}

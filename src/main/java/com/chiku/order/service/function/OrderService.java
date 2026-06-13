package com.chiku.order.service.function;

import com.chiku.order.service.model.Order;
import com.chiku.order.service.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order addOrder(Order order){
        return orderRepository.save(order);
    }

    public Order fetchOrder(String id) {
        Optional<Order> optionalOrder = orderRepository.findById(Integer.valueOf(id));
        if(optionalOrder.isPresent()){
            log.info("Order found with id - {}", id);
            return optionalOrder.get();
        }
        log.info("No order found with id - {}", id);
        return null;
    }
}

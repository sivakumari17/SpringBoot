package com.springboot.h2.service;

import com.springboot.h2.repository.OrderItemRepository;
import com.springboot.h2.model.OrderItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void saveOrderItems(List<OrderItems> orderItemsList) {
    	orderItemRepository.saveAll(orderItemsList);
    }

    @Override
    public List<OrderItems> getOrderItems() {
        return orderItemRepository.findAll();
    }

}

package com.springboot.h2.service;

import com.springboot.h2.model.OrderItems;

import java.util.List;

public interface OrderItemService {

    public List<OrderItems> getOrderItems();

	public void saveOrderItems(List<OrderItems> orderItemsList);

}
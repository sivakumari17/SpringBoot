package com.springboot.h2.service;

import java.util.List;

import com.springboot.h2.Exception.OrderNotFoundException;
import com.springboot.h2.model.OnlineOrder;

public interface OrderProcessService {

	void saveOrder(OnlineOrder order);

	List<OnlineOrder> getOrderList();

	OnlineOrder findByCustNameAndOrderDate(String custName, String orderDate)  throws OrderNotFoundException ;

}

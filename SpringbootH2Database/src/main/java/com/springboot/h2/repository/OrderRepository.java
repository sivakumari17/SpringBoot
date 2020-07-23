package com.springboot.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.h2.model.OnlineOrder;

@Repository
public interface OrderRepository  extends JpaRepository<OnlineOrder, Integer>{

	OnlineOrder findByOrderId(int orderId);

	OnlineOrder findByCustNameAndOrderDate(String custName, String orderDate);

}

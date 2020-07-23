package com.springboot.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.h2.model.OrderItems;

@Repository
public interface OrderItemRepository  extends JpaRepository<OrderItems, Integer>{


}

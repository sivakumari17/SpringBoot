package com.springboot.h2.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.h2.Exception.OrderNotFoundException;
import com.springboot.h2.model.OnlineOrder;
import com.springboot.h2.model.OrderItems;
import com.springboot.h2.service.OrderItemService;
import com.springboot.h2.service.OrderProcessService;

@RestController
public class OrderItemController {

	private final Logger log = LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	OrderProcessService orderService;
	
	@Autowired
	OrderItemService orderItemService;

    @RequestMapping(value = "/orderItemsList", method = RequestMethod.GET)
    public @ResponseBody List<OrderItems> getOrderItemsList(){
        return orderItemService.getOrderItems();
    }

    @PostMapping("/saveOrderItem/{custName}/{orderDate}")
    public String saveStudent(@RequestBody @Valid List<OrderItems> orderItemsList, @PathVariable String custName,
    		@PathVariable String orderDate){
        try {
        	OnlineOrder order = orderService.findByCustNameAndOrderDate(custName,orderDate);
        	for(OrderItems item :orderItemsList){
        		item.setOnlineOrder(order);
        	}
        	orderItemService.saveOrderItems(orderItemsList);          
            return "order Items saved successfully..";
        }
        catch (OrderNotFoundException ex){
            ex.printStackTrace();
            return ex.getMessage();
        }catch (Exception ex){
            ex.printStackTrace();
            return "Error in saving Order Items .."+ex.getMessage();
        }
    }
}
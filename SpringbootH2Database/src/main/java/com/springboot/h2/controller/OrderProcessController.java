package com.springboot.h2.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.h2.model.OnlineOrder;
import com.springboot.h2.service.OrderProcessService;

@RestController		// Useful to create the RESTful webservices.
public class OrderProcessController {

	private final Logger log = LoggerFactory.getLogger(this.getClass()); 

	// @Autowired annotation provides the automatic dependency injection.	
	@Autowired
	OrderProcessService orderService;
	
    @PostMapping("/saveOrder")
    public String saveOrder(@RequestBody @Valid OnlineOrder order){
    	orderService.saveOrder(order);
        return "Order Details Saved successfully...";
    }

    @RequestMapping(value = "/getOrderList", method = RequestMethod.GET)
    public @ResponseBody List<OnlineOrder> getOrderList(){
        return orderService.getOrderList();
    }
}

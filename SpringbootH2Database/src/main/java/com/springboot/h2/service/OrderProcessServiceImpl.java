package com.springboot.h2.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.springboot.h2.Exception.OrderNotFoundException;
import com.springboot.h2.model.OnlineOrder;
import com.springboot.h2.model.OrderItems;
import com.springboot.h2.repository.OrderItemRepository;
import com.springboot.h2.repository.OrderRepository;
import com.google.gson.Gson;

@Service
public class OrderProcessServiceImpl implements OrderProcessService{

	@Autowired
	private OrderRepository orderRepository;
	
	public void saveOrder(OnlineOrder order) {
		orderRepository.save(order);
		
	}

	public List<OnlineOrder> getOrderList() {
		return orderRepository.findAll();
	}

	@Override
	public OnlineOrder findByCustNameAndOrderDate(String custName, String orderDate) throws OrderNotFoundException {
		OnlineOrder order = orderRepository.findByCustNameAndOrderDate(custName,orderDate);
		if(StringUtils.isEmpty(order)){
			throw new OrderNotFoundException("Order Not found with custName ->"+custName+
				" and orderDate -> "+orderDate);
		}else{
			return order;
		}
	}	
	
	/*@Transactional
	public void save( OnlineOrder order) {
		orderRepository.save(order);		
	}

	public String getAll() {
		List<OnlineOrder> orderList = (List<OnlineOrder>) orderRepository.findAll();
		return new Gson().toJson(orderList);
	}
	
	public String getOrderItems(int orderId) throws OrderNotFoundException {
		OnlineOrder order = orderRepository.findByOrderId(orderId);
		if(order !=null && !StringUtils.isEmpty(order))	{
			List<OrderItems> orderItems = orderItemRepository.findByOrder(order);
			return  new Gson().toJson(orderItems);
		}else{
			throw new OrderNotFoundException("Order Id: "+orderId+" not found");
		}	
	}

	public String saveOrderDetails(HashMap<String, Object> requestBean) {
		OnlineOrder order = new OnlineOrder();
		if(!StringUtils.isEmpty(requestBean.get("custName")))
			order.setCustName(requestBean.get("custName").toString());
		if(!StringUtils.isEmpty(requestBean.get("orderDate")))
			order.setOrderDate(requestBean.get("orderDate").toString());
		if(!StringUtils.isEmpty(requestBean.get("shippingAddress")))
			order.setShippingAddress(requestBean.get("shippingAddress").toString());
		if(!StringUtils.isEmpty(requestBean.get("total")))
			order.setTotal(Integer.parseInt(requestBean.get("total").toString()));
		List<HashMap<String,Object>> orderItems = (List<HashMap<String, Object>>) requestBean.get("OrderItems");
		List<OrderItems> itemsList = new ArrayList<OrderItems>();
		for(HashMap<String,Object> obj : orderItems){
			OrderItems item = new OrderItems();
			if(!StringUtils.isEmpty(requestBean.get("productCode")))
				item.setProductCode(requestBean.get("productCode").toString());
			if(!StringUtils.isEmpty(requestBean.get("productName")))
				item.setProductName(requestBean.get("productName").toString());
			if(!StringUtils.isEmpty(requestBean.get("quantity")))
				item.setQuantity(Integer.parseInt(requestBean.get("quantity").toString()));
			item.setOrder(order);
			itemsList.add(item);
		}
		order.setOrderItems(itemsList);
		orderRepository.save(order);
		String str = "Order Details Saved Successfully and order id is :---->"+order.getOrderId();
		return "Order Details Saved Successfully";
	}
*/
	
}

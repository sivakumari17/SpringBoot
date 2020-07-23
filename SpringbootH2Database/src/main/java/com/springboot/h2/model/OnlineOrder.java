package com.springboot.h2.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class OnlineOrder {
	@Id
	@GeneratedValue
	private int orderId;
	
	private String custName;
	private String orderDate;
	private String shippingAddress;
	public OnlineOrder(){
		
	}
	
	public OnlineOrder(int orderId, String custName, String orderDate, String shippingAddress, double total) {
		this.orderId = orderId;
		this.custName = custName;
		this.orderDate = orderDate;
		this.shippingAddress = shippingAddress;
		this.total = total;
	}


	@OneToMany(mappedBy = "onlineOrder", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<OrderItems> OrderItems;
	 
	private double total;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public List<OrderItems> getOrderItems() {
		return OrderItems;
	}
	public void setOrderItems(List<OrderItems> orderItems) {
		OrderItems = orderItems;
	}
	
}
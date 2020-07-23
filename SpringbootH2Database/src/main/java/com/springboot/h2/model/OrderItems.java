package com.springboot.h2.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderItems {
	// @Id annotation specifies the primary key of an entity.
		// @GeneratedValue provides the generation strategy specification for the primary key values.
		@Id
		@GeneratedValue
		private int orderItemId;
		private String productCode;
		private String productName;
		private int quantity;	
		
		 
		/*@ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "order_id") */ 	
		@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    @JoinColumn(name = "id", nullable = false)	
		private OnlineOrder onlineOrder;
		
		public OrderItems(){
		
		}
		
		public OrderItems(int orderItemId, String productCode, String productName, int quantity/*, Order order*/) {
			super();
			this.orderItemId = orderItemId;
			this.productCode = productCode;
			this.productName = productName;
			this.quantity = quantity;
			/*this.order = order;*/
		}

		public int getOrderItemId() {
			return orderItemId;
		}
		public void setOrderItemId(int orderItemId) {
			this.orderItemId = orderItemId;
		}
		public String getProductCode() {
			return productCode;
		}
		public void setProductCode(String productCode) {
			this.productCode = productCode;
		}
		
		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public OnlineOrder getOnlineOrder() {
			return onlineOrder;
		}

		public void setOnlineOrder(OnlineOrder onlineOrder) {
			this.onlineOrder = onlineOrder;
		}
}
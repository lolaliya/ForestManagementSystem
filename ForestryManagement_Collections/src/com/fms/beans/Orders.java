package com.fms.beans;

public class Orders {
	
	private int orderNo ;   
	private int customerId ; 
	private int  productId;    
	private int haulierId ;  
	private String deliveryDate; 
	private int quantity;
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getHaulierId() {
		return haulierId;
	}
	public void setHaulierId(int haulierId) {
		this.haulierId = haulierId;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Orders [orderNo = " + orderNo + ", customerId = " + customerId + ", productId = " + productId + ", haulierId = "
				+ haulierId + ", delivery Date = " + deliveryDate + ", quantity = " + quantity + "]";
	}    
	
}

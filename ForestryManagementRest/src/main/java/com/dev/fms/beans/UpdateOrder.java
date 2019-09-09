package com.dev.fms.beans;

import java.sql.Date;

public class UpdateOrder {

	Orders order = new Orders();
	private int orderNo;
	private Date deliveryDate;
	
	public int getOrderNo() {
		return order.getOrderNo();
	}
	public void setOrderNo(int orderNo) {
		order.setOrderNo(orderNo);
	}
	public Date getDeliveryDate() {
		return order.getDeliveryDate();
	}
	public void setDeliveryDate(Date deliveryDate) {
		order.setDeliveryDate(deliveryDate);
	}
	@Override
	public String toString() {
		return "UpdateOrder [orderNo=" + orderNo + ", deliveryDate=" + deliveryDate + "]";
	}
	
}

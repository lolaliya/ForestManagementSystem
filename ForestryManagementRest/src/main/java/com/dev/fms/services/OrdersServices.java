package com.dev.fms.services;

import java.sql.Date;

import com.dev.fms.beans.Orders;

public interface OrdersServices {
	public Boolean addOrder(Orders contract);
	public Orders searchOrder(Integer orderId);
	public Orders deleteOrder(Integer orderId);
	public Boolean updateDeliveryDate(Integer orderId, Date DeliverDate);
}
package com.dev.fms.dao;

import java.sql.Date;

import com.dev.fms.beans.Orders;

public interface OrdersDAO {
	
	public Boolean addOrder(Orders contract);
	public Orders searchOrder(Integer orderId);
	public Orders deleteOrder(Integer orderId);
	public Boolean updateDeliveryDate(Integer orderId, Date deliveryDate);
}

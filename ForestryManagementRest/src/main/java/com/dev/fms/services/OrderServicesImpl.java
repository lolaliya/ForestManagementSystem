package com.dev.fms.services;

import java.sql.Date;

import com.dev.fms.beans.Orders;
import com.dev.fms.dao.OrdersDAO;
import com.dev.fms.dao.OrdersJPAImpl;

public class OrderServicesImpl implements OrdersServices{

	private OrdersDAO db = new OrdersJPAImpl();
	
	@Override
	public Orders deleteOrder(Integer orderId) {
		return db.deleteOrder(orderId);
	}

	@Override
	public Boolean updateDeliveryDate(Integer contractId, Date deliverDate) {
		return db.updateDeliveryDate(contractId, deliverDate);
	}

	@Override
	public Boolean addOrder(Orders order) {
		return db.addOrder(order);
	}

	@Override
	public Orders searchOrder(Integer orderId) {
		return db.searchOrder(orderId);
	}
}


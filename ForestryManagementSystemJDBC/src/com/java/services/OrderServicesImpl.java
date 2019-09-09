package com.java.services;

import com.java.beans.Orders;
import com.java.dao.OrderDAO;
import com.java.dao.OrderJDBCImpl;

public class OrderServicesImpl implements OrderServices {
	private OrderDAO db = new OrderJDBCImpl();

	@Override
	public Orders addOrders(Orders order) {
	return db.addOrders(order);
	}

	@Override
	public boolean modifyOrders(Integer orderNo, Integer quantity) {
		return db.modifyOrders(orderNo,quantity);
	}

	@Override
	public boolean deleteOrders(Integer orderNo) {
		return db.deleteOrders(orderNo);
		
	}

}

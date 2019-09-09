package com.java.dao;

import com.java.beans.Orders;

public interface OrderDAO {
	public Orders addOrders(Orders order);
	public boolean modifyOrders(Integer orderId, Integer quantity);
	public boolean deleteOrders(Integer orderId);

}

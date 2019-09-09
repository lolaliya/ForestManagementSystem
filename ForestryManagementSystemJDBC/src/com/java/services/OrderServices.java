package com.java.services;

import com.java.beans.Orders;

public interface OrderServices {
	public Orders addOrders(Orders order);
	public boolean modifyOrders(Integer orderNo, Integer quantity);
	public boolean deleteOrders(Integer orderNo);

}



package com.fms.services;

import com.fms.beans.Orders;
import com.fms.dao.OrdersRepoImpl;
import com.fms.dao.OrdersDAO;

public class OrdersServicesImpl implements OrdersServices {

	private OrdersDAO db = new OrdersRepoImpl();

	@Override
	public Boolean createProfile(Orders user) {
		return db.createProfile(user);
	}

	@Override
	public Orders searchUser(Integer userId) {
		return db.searchUser(userId);
	}

	@Override
	public Boolean deleteUser(Integer userId) {
		return db.deleteUser(userId);
	}

	@Override
	public Boolean updateDeliveryDate(Integer userId, String oldId, String newId) {
     return db.updateDeliveryDate(userId, oldId, newId);
	}

	@Override
	public Boolean updateQuantity(Integer userId, int oldQuantity, int newQuantity) {
	return db.updateQuantity(userId, oldQuantity, newQuantity);
	}
}
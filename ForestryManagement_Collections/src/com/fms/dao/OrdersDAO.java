package com.fms.dao;

import com.fms.beans.Orders;

public interface OrdersDAO {
	public Boolean createProfile(Orders user);
	public Orders searchUser(Integer userId);
	public Boolean deleteUser(Integer userId);
	public Boolean updateDeliveryDate(Integer userId, String oldId, String newId);
	public Boolean updateQuantity(Integer userId, int oldQuantity, int newQuantity);
}

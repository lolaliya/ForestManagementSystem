package com.fms.services;

import com.fms.beans.Orders;

public interface OrdersServices {
	public Boolean createProfile(Orders user);
	public Orders searchUser(Integer userId);
	public Boolean deleteUser(Integer userId);
	public Boolean updateDeliveryDate(Integer userId, String oldId, String newId);
	public Boolean updateQuantity(Integer userId, int oldQuantity, int newQuantity);
	

}
package com.fms.services;

import com.fms.beans.Contract;

public interface ContractServices {
	public Boolean createProfile(Contract user);
	public Contract searchUser(Integer userId);
	public Boolean deleteUser(Integer userId);
	public Boolean updatePassword(Integer userId, String oldPassword, String newPassword);
	public Boolean updateCustomerId(Integer userId, Integer oldCustomerId, Integer newCustomerId);
	public Boolean updateHaulierId(Integer userId, int oldHaulierId, int newHaulierId);
	public Boolean updateProductId(Integer userId, int oldProductId, int newProductId);
	public Boolean updateQuantity(Integer userId, int oldQuantity, int newQuantity);
	public Boolean updateDeliveryDate(Integer userId, String oldId, String newId);
	public Boolean updateDeliveryDay(Integer userId, String oldDeliveryDay, String newDeliveryDay);
}


package com.fms.services;

import com.fms.beans.Contract;
import com.fms.dao.ContractRepoImpl;
import com.fms.dao.ContractDAO;

public class ContractServicesImpl implements ContractServices {

	private ContractDAO db = new ContractRepoImpl();

	@Override
	public Boolean createProfile(Contract user) {
		return db.createProfile(user);
	}

	@Override
	public Contract searchUser(Integer userId) {
		return db.searchUser(userId);
	}

	@Override
	public Boolean deleteUser(Integer userId) {
		return db.deleteUser(userId);
	}

	@Override
	public Boolean updatePassword(Integer userId, String oldPassword, String newPassword) {
	return db.updatePassword(userId,oldPassword,newPassword);
	}

	@Override
	public Boolean updateCustomerId(Integer userId, Integer oldCustomerId, Integer newCustomerId) {
		return db.updateCustomerId(userId,oldCustomerId,newCustomerId);
	}

	@Override
	public Boolean updateHaulierId(Integer userId, int oldHaulierId, int newHaulierId) {
		return db.updateHaulierId(userId,oldHaulierId,newHaulierId);
	}

	@Override
	public Boolean updateProductId(Integer userId, int oldProductId, int newProductId) {
		return db.updateProductId(userId,oldProductId,newProductId);
	}

	@Override
	public Boolean updateQuantity(Integer userId, int oldQuantity, int newQuantity) {
		return db.updateQuantity(userId,oldQuantity,newQuantity);
	}

	@Override
	public Boolean updateDeliveryDate(Integer userId, String oldId, String newId) {
		return db.updateDeliveryDate(userId,oldId,newId);
	}

	@Override
	public Boolean updateDeliveryDay(Integer userId, String oldDeliveryDay, String newDeliveryDay) {
		return db.updateDeliveryDay(userId,oldDeliveryDay,newDeliveryDay);
	}

}
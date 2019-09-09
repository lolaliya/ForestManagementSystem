package com.fms.services;

import com.fms.beans.Customer;
import com.fms.dao.CustomerRepoImpl;
import com.fms.dao.CustomerDAO;

public class CustomerServicesImpl implements CustomerServices {

	private CustomerDAO db = new CustomerRepoImpl();

	@Override
	public Customer searchUser(Integer userId) {
		return db.searchUser(userId);
	}

	@Override
	public Boolean deleteUser(Integer userId) {
		return db.deleteUser(userId);
	}

	@Override
	public Boolean createProfile(Customer user1) {
		return db.createProfile(user1);
	}

	@Override
	public Boolean updateTelephone(Integer userId, Integer oldTelephone, Integer newTelephone) {
		return db.updateTelephone(userId,oldTelephone,newTelephone);	}

	@Override
	public Boolean updateEmail(Integer userId, String oldEmail, String newEmail) {
		return db.updateEmail(userId,oldEmail,newEmail);	
	}

	@Override
	public Boolean updatePassword(Integer userId, String oldPassword, String newPassword) {
		return db.updatePassword(userId,oldPassword,newPassword);
	}


}
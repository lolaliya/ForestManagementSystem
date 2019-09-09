package com.fms.services;

import com.fms.beans.Haulier;
import com.fms.dao.HaulierRepoImpl;
import com.fms.dao.HaulierDAO;

public class HaulierServicesImpl implements HaulierServices {

	private HaulierDAO db = new HaulierRepoImpl();

	@Override
	public Haulier searchUser(Integer userId) {
		return db.searchUser(userId);
	}

	@Override
	public Boolean deleteUser(Integer userId) {
		return db.deleteUser(userId);
	}

	@Override
	public Boolean createProfile(Haulier user1) {
		return db.createProfile(user1);
	}

	@Override
	public Boolean updateTelephone(Integer userId, Integer oldTelephone, Integer newTelephone) {
		return db.updateTelephone(userId, oldTelephone, newTelephone);
	}

	@Override
	public Boolean updateEmail(Integer userId, String oldEmail, String newEmail) {
		return db.updateEmail(userId, oldEmail, newEmail);
	}




}
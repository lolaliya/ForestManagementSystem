package com.fms.services;

import com.fms.beans.Haulier;

public interface HaulierServices {
	public Boolean createProfile(Haulier user1);
	public Haulier searchUser(Integer userId);
	public Boolean deleteUser(Integer userId);
	public Boolean updateTelephone(Integer userId, Integer oldTelephone, Integer newTelephone); 
	public Boolean updateEmail(Integer userId, String oldEmail, String newEmail);
}
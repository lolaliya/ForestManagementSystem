package com.fms.dao;

import com.fms.beans.Haulier;

public interface HaulierDAO {
	public Boolean createProfile(Haulier user);
	public Haulier searchUser(Integer userId);
	public Boolean deleteUser(Integer userId);
	public Boolean updateTelephone(Integer userId, Integer oldTelephone, Integer newTelephone); 
	public Boolean updateEmail(Integer userId, String oldEmail, String newEmail);
	
}

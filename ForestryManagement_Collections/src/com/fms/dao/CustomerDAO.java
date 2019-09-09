package com.fms.dao;

import com.fms.beans.Customer;

public interface CustomerDAO {
	public Boolean createProfile(Customer user);
	public Customer searchUser(Integer userId);
	public Boolean deleteUser(Integer userId);
	public Boolean updateTelephone(Integer userId, Integer oldTelephone, Integer newTelephone);
	public Boolean updateEmail(Integer userId, String oldEmail, String newEmail);
	public Boolean updatePassword(Integer userId, String oldPassword, String newPassword) ;
}

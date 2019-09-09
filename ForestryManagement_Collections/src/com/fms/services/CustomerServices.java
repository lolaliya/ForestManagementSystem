package com.fms.services;

import com.fms.beans.Customer;

public interface CustomerServices {
	public Boolean createProfile(Customer user1);
	public Customer searchUser(Integer userId);
	public Boolean deleteUser(Integer userId);
	public Boolean updateTelephone(Integer userId, Integer oldTelephone, Integer newTelephone);
	public Boolean updateEmail(Integer userId, String oldEmail, String newEmail);
	public Boolean updatePassword(Integer userId, String oldPassword, String newPassword);

}
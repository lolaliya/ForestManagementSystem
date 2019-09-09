package com.fms.services;

import com.fms.beans.Product;

public interface ProductServices {
	public Boolean createProfile(Product user);
	public Product searchUser(Integer userId);
	public Boolean deleteUser(Integer userId);

}
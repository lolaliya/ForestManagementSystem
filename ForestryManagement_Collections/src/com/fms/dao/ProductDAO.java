package com.fms.dao;

import com.fms.beans.Product;

public interface ProductDAO {
	public Boolean createProfile(Product product);
	public Product searchUser(Integer productId);
	public Boolean deleteUser(Integer productId);
}
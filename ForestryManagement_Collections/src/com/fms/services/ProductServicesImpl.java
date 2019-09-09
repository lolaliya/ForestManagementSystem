package com.fms.services;

import com.fms.beans.Product;
import com.fms.dao.ProductRepoImpl;
import com.fms.dao.ProductDAO;

public class ProductServicesImpl implements ProductServices {

	private ProductDAO db = new ProductRepoImpl();

	@Override
	public Boolean createProfile(Product user) {
		return db.createProfile(user);
	}

	@Override
	public Product searchUser(Integer userId) {
		return db.searchUser(userId);
	}

	@Override
	public Boolean deleteUser(Integer userId) {
		return db.deleteUser(userId);
	}

}
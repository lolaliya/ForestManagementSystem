package com.java.services;

import com.java.beans.Product;
import com.java.dao.ProductDAO;
import com.java.dao.ProductJDBCImpl;

public class ProductServicesImpl implements ProductServices {
	private ProductDAO db = new ProductJDBCImpl();

	@Override
	public Product addProduct(Product product) {
		return db.addProduct(product);
	}

	@Override
	public boolean deleteProduct(Integer custosmerId) {
		return db.deleteProduct(custosmerId);

	}

	@Override
	public Product modifyProduct(Integer productId, Product product) {
		return db.modifyProduct(productId,product);
	}

}

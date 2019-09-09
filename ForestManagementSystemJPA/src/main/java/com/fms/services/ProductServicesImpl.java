package com.fms.services;

import com.fms.beans.Product;
import com.fms.dao.ProductDAO;
import com.fms.dao.ProductJPAImpl;

public class ProductServicesImpl implements  ProductServices{

	private ProductDAO db = new ProductJPAImpl();

	@Override
	public Boolean addProduct(Product product) {
		return db.addProduct(product);
	}

	@Override
	public Product searchProduct(Integer productId) {
		return db.searchProduct(productId);
	}

	@Override
	public Product deleteProduct(Integer productId) {
		return db.deleteProduct(productId);
	}

	@Override
	public Boolean updateProduct(Integer productId, String description) {
		return db.updateProduct(productId, description);
	}


}

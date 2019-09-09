package com.dev.fms.dao;

import com.dev.fms.beans.Product;

public interface ProductDAO {
	
	public Boolean addProduct(Product product);
	public Product searchProduct(Integer productId);
	public Product deleteProduct(Integer productId);
	public Boolean updateProduct(Integer productId, String description);
}

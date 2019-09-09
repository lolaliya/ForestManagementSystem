package com.java.services;

import com.java.beans.Product;

public interface ProductServices {
	public Product addProduct(Product product);
	public Product modifyProduct(Integer productId, Product product);
	public boolean deleteProduct(Integer productId);

}



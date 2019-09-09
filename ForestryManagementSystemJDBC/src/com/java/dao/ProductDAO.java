package com.java.dao;

import com.java.beans.Product;

public interface ProductDAO {
	public Product addProduct(Product prod);
	public Product modifyProduct(Integer prod_id, Product product);
	public boolean deleteProduct(Integer cust_id);
	

}

package com.fms.repo;

import java.util.HashMap;
import com.fms.beans.Product;

public class ProductRepository {
	public static HashMap<Integer, Product> db = new HashMap<>();

	public ProductRepository(){
		Product user1 = new Product();
		user1.setProductId(1);
		user1.setProductName("Timber");
		user1.setProductDescription("Used for tables");
		db.put(1, user1);

		Product user2 = new Product();
		user2.setProductId(2);
		user2.setProductName("Gum");
		user2.setProductDescription("Used for preparing gum");
		db.put(2, user2);

		Product user3 = new Product();
		user3.setProductId(3);
		user3.setProductName("Sandalwood");
		user3.setProductDescription("Used for making soap");
		db.put(3, user3);
	}
}
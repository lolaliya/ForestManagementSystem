package com.fms.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import com.fms.beans.Product;
import com.fms.repo.ProductRepository;

public class ProductRepoImpl implements ProductDAO {

	ProductRepository repo = new ProductRepository();
	private HashMap<Integer, Product> db = repo.db;

	Scanner in = new Scanner(System.in);

	@Override
	public Boolean createProfile(Product user) {
		Boolean state = false;
		db.put(user.getProductId(), user);
		if(user != null){
			state = true;
		}
		return state;
	}


	@Override
	public Product searchUser(Integer userId) {
		Product user = null;
		Iterator it = db.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			if(pair.getKey().equals(userId)){
				return (Product)pair.getValue();
			}
		}return user;
	}

  @Override
	public Boolean deleteUser(Integer userId) {
		boolean state = false;
		Product user = searchUser(userId);
		if(user != null){
			db.remove(userId);
			state = true;
		}else{
			state = false;
		}return state;
	}

}
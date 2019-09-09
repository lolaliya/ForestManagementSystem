package com.fms.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import com.fms.beans.Orders;
import com.fms.repo.OrdersRepository;

public class OrdersRepoImpl implements OrdersDAO {

	OrdersRepository repo = new OrdersRepository();
	private HashMap<Integer, Orders> db = repo.db;

	Scanner in = new Scanner(System.in);

	@Override
	public Boolean createProfile(Orders user) {
		Boolean state = false;
		db.put(user.getOrderNo(), user);
		if(user != null){
			state = true;
		}
		return state;
	}


	@Override
	public Orders searchUser(Integer userId) {
		Orders user = null;
		Iterator it = db.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			if(pair.getKey().equals(userId)){
				return (Orders)pair.getValue();
			}
		}return user;
	}



	@Override
	public Boolean deleteUser(Integer userId) {
		boolean state = false;
		Orders user = searchUser(userId);
		if(user != null){
			db.remove(userId);
			state = true;
		}else{
			state = false;
		}return state;
	}

	@Override
	public Boolean updateQuantity(Integer userId, int oldQuantity, int newQuantity) {
		boolean state = false;
		Orders user = searchUser(userId);
		if(user != null){
			if(user.getQuantity() == oldQuantity){
				user.setQuantity(newQuantity);
				db.put(user.getOrderNo(), user);
				state =  true;
			}
			else {
				state = false;
			}
		}return state;
	}

	@Override
	public Boolean updateDeliveryDate(Integer userId, String oldId, String newId) {
		boolean state = false;
		Orders user = searchUser(userId);
		if(user != null){
			if(user.getDeliveryDate().equals(oldId)){
				user.setDeliveryDate(newId);
				db.put(user.getOrderNo(), user);
				state =  true;
			}
			else {
				state = false;
			}
		}
		return state;
	}
}







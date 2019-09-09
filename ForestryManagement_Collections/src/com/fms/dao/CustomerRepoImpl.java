package com.fms.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import com.fms.beans.Customer;
import com.fms.repo.CustomerRepository;

public class CustomerRepoImpl implements CustomerDAO {

	CustomerRepository repo = new CustomerRepository();
	private HashMap<Integer, Customer> db = repo.db;

	Scanner in = new Scanner(System.in);

	@Override
	public Boolean createProfile(Customer user) {
		Boolean state = false;
		db.put(user.getCustomerId(), user);
		if(user != null){
			state = true;
		}
		return state;
	}


	@Override
	public Customer searchUser(Integer userId) {
		Customer user = null;
		Iterator it = db.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			if(pair.getKey().equals(userId)){
				return (Customer)pair.getValue();
			}
		}return user;
	}



	@Override
	public Boolean deleteUser(Integer userId) {
		boolean state = false;
		Customer user = searchUser(userId);
		if(user != null){
			db.remove(userId);
			state = true;
		}else{
			state = false;
		}return state;
	}

	@Override
	public Boolean updatePassword(Integer userId, String oldPassword, String newPassword) {
		boolean state = false;
		Customer user = searchUser(userId);
		if(user != null){
			if(user.getPassword().equals(oldPassword)){
				user.setPassword(newPassword);
				db.put(user.getCustomerId(), user);
				state =  true;
			}
		}
		return state;

	}

	@Override
	public Boolean updateTelephone(Integer userId, Integer oldTelephone, Integer newTelephone) {
		boolean state = false;
		Customer user = searchUser(userId);
		if(user != null){
			if(user.getTelephoneNo() == oldTelephone){
				user.setTelephoneNo(newTelephone);
				db.put(user.getCustomerId(), user);
				state =  true;
			}
			else {

				state = false;
			}
		}return state;
	}

@Override
	public Boolean updateEmail(Integer userId, String oldEmail, String newEmail) {
		boolean state = false;
		Customer user = searchUser(userId);
		if(user != null){
			if(user.getEmail().equals(oldEmail)){
				user.setEmail(newEmail);
				db.put(user.getCustomerId(), user);
				state =  true;
			}
			else {

				state = false;
			}
		}
		return state;
	}
}







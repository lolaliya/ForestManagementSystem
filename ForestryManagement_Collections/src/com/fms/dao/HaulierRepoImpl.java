package com.fms.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import com.fms.beans.Haulier;
import com.fms.repo.HaulierRepository;

public class HaulierRepoImpl implements HaulierDAO {

	HaulierRepository repo = new HaulierRepository();
	private HashMap<Integer, Haulier> db = repo.db;

	Scanner in = new Scanner(System.in);

	@Override
	public Boolean createProfile(Haulier user) {
		Boolean state = false;
		db.put(user.getHaulierId(), user);
		if(user != null){
			state = true;
		}return state;
	}


	@Override
	public Haulier searchUser(Integer userId) {
		Haulier user = null;
		Iterator it = db.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			if(pair.getKey().equals(userId)){
				return (Haulier)pair.getValue();
			}
		}return user;
	}


	@Override
	public Boolean deleteUser(Integer userId) {
		boolean state = false;
		Haulier user = searchUser(userId);
		if(user != null){
			db.remove(userId);
			state = true;
		}else{
			state = false;
		}return state;
	}

	@Override
	public Boolean updateTelephone(Integer userId, Integer oldTelephone, Integer newTelephone) {
		boolean state = false;
		Haulier user = searchUser(userId);
		if(user != null){
			if(user.getTelephoneNo() == oldTelephone){
				user.setTelephoneNo(newTelephone);
				db.put(user.getHaulierId(), user);
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
		Haulier user = searchUser(userId);
		if(user != null){
			if(user.getEmail().equals(oldEmail)){
				user.setEmail(newEmail);
				db.put(user.getHaulierId(), user);
				state =  true;
			}
			else {
				state = false;
			} 
		}
		return state;
	}
}









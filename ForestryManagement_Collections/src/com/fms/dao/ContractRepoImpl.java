package com.fms.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import com.fms.beans.Contract;
import com.fms.repo.ContractRepository;

public class ContractRepoImpl implements ContractDAO {

	ContractRepository repo = new ContractRepository();
	private HashMap<Integer, Contract> db = repo.db;

	Scanner in = new Scanner(System.in);

	@Override
	public Boolean createProfile(Contract user) {
		Boolean state = false;
		db.put(user.getContractNo(), user);
		if(user != null)
		{
			state = true;
		}
		return state;
	}


	@Override
	public Contract searchUser(Integer userId) {
		Contract user = null;
		Iterator it = db.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			if(pair.getKey().equals(userId)){
				return (Contract)pair.getValue();
			}
		}return user;
	}



	@Override
	public Boolean deleteUser(Integer userId) {
		boolean state = false;
		Contract user = searchUser(userId);
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
		Contract user = searchUser(userId);
		if(user != null){
			if(user.getPassword().equals(oldPassword)){
				user.setPassword(newPassword);
				db.put(user.getContractNo(), user);
				state =  true;
			}
			else {
		     state = false;
			}
		}
		return state;
	}

	@Override
	public Boolean updateCustomerId(Integer userId, Integer oldCustomerId, Integer newCustomerId) {
		boolean state = false;
		Contract user = searchUser(userId);
		if(user != null){
			if(user.getCustomerId() == oldCustomerId){
				user.setCustomerId(newCustomerId);
				db.put(user.getContractNo(), user);
				state =  true;
			}
			else {
			   state = false;
			}
		}return state;
	}

	@Override
	public Boolean updateHaulierId(Integer userId, int oldHaulierId, int newHaulierId) {
		boolean state = false;
		Contract user = searchUser(userId);
		if(user != null){
			if(user.getHaulierId() == oldHaulierId){
				user.setHaulierId(newHaulierId);
				db.put(user.getContractNo(), user);
				state =  true;
			}
			else {
				
				state = false;
			}
		}return state;
	}

	@Override
	public Boolean updateProductId(Integer userId, int oldProductId, int newProductId) {
		boolean state = false;
		Contract user = searchUser(userId);
		if(user != null){
			if(user.getProductId() == oldProductId){
				user.setProductId(newProductId);
				db.put(user.getContractNo(), user);
				state =  true;
			}
			else {
				
				state = false;
			}
		}return state;
	}

	@Override
	public Boolean updateQuantity(Integer userId, int oldQuantity, int newQuantity) {
		boolean state = false;
		Contract user = searchUser(userId);
		if(user != null){
			if(user.getQuantity() == oldQuantity){
				user.setQuantity(newQuantity);
				db.put(user.getContractNo(), user);
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
		Contract user = searchUser(userId);
		if(user != null){
			if(user.getDeliveryDate().equals(oldId)){
				user.setDeliveryDate(newId);
				db.put(user.getContractNo(), user);
				state =  true;
			}
			else {
			
				state = false;
			}
       }
		return state;
	}

	@Override
	public Boolean updateDeliveryDay(Integer userId, String oldDeliveryDay, String newDeliveryDay) {
		boolean state = false;
		Contract user = searchUser(userId);
		if(user != null){
			if(user.getDeliveryDay().equals(oldDeliveryDay)){
				user.setDeliveryDay(newDeliveryDay);
				db.put(user.getContractNo(), user);
				state =  true;
			}
			else {
				
				state = false;
			}
	
		}
		return state;
	}
}







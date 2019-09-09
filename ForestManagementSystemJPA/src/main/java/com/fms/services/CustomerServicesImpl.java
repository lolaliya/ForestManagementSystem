package com.fms.services;

import com.fms.beans.Customer;
import com.fms.dao.CustomerDAO;
import com.fms.dao.CustomerJPAImpl;

public class CustomerServicesImpl implements CustomerServices{

	private CustomerDAO db = new CustomerJPAImpl();

	public Boolean addCustomer(Customer customer) {
		return db.addCustomer(customer);
	}

	public Customer searchCustomer(Integer customerId) {
		return db.searchCustomer(customerId);
	}

	public Customer deleteCustomer(Integer customerId) {
		return db.deleteCustomer(customerId);
	}

	public Boolean updatePassword(Integer customerId, String passwd) {
		return db.updatePassword(customerId, passwd);
	}

	@Override
	public Boolean updateTelephone(Integer customerId, long number) {
		return db.updateTelephone(customerId, number);
	}

	@Override
	public Boolean updateEmail(Integer customerId, String email) {
		return db.updateEmail(customerId, email);
	}

}

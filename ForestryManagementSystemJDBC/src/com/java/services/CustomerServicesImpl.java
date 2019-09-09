package com.java.services;

import com.java.beans.Customer;
import com.java.dao.CustomerDAO;
import com.java.dao.CustomerJDBCImpl;

public class CustomerServicesImpl implements CustomerServices {
	private CustomerDAO db = new CustomerJDBCImpl();

	@Override
	public Customer addCustomer(Customer customer) {
		return db.addCustomer(customer) ;
	}

	@Override
	public boolean deleteCustomer(Integer customerId, String customerPassword) {
		return db.deleteCustomer(customerId,customerPassword);
	}

	@Override
	public Customer modifyCustomer(Customer customer, Integer customerId) {
		return db.modifyCustomer(customer,customerId) ;
	}

}

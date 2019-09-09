package com.java.dao;

import com.java.beans.Customer;

public interface CustomerDAO {
	public Customer addCustomer(Customer cust);
	public boolean deleteCustomer(Integer customerId, String customerPassword);
	public Customer modifyCustomer(Customer cust , Integer customerId);
}



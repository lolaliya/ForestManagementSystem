package com.java.services;

import com.java.beans.Customer;

public interface CustomerServices {
	public Customer addCustomer(Customer customer);
	public boolean deleteCustomer(Integer customerId, String customerPassword);
	public Customer modifyCustomer(Customer customer , Integer customerId);
}



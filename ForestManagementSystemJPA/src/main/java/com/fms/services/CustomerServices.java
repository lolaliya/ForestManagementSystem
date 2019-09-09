package com.fms.services;

import com.fms.beans.Customer;

public interface CustomerServices {
	public Boolean addCustomer(Customer customer);
	public Customer searchCustomer(Integer customerId);
	public Customer deleteCustomer(Integer customerId);
	public Boolean updateTelephone(Integer customerId, long number);
	public Boolean updateEmail(Integer customerId, String email);
	public Boolean updatePassword(Integer customerId, String passwd);
}

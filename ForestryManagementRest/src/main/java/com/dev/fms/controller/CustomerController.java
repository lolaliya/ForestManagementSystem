package com.dev.fms.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.fms.beans.Customer;
import com.dev.fms.beans.UpdateCustomer;
import com.dev.fms.services.CustomerServices;
import com.dev.fms.services.CustomerServicesImpl;

@RestController
public class CustomerController {
CustomerServices services = new CustomerServicesImpl();

	@RequestMapping(value = "/rest/customer/{id}", method = RequestMethod.GET)
	public Customer getCustomer(@PathVariable("id") int customerId) {
		Customer customer = null;
		customer = services.searchCustomer(customerId);
		return customer;
	}

	@RequestMapping(value = "/rest/customer/create", method = RequestMethod.POST)
	public Customer createCustomer(@RequestBody Customer customer) {
		services.addCustomer(customer);
		return customer;
	}

	@RequestMapping(value = "/rest/customer/delete/{id}", method = RequestMethod.DELETE)
	public Customer deleteCustomer(@PathVariable("id") int customerId) {
		Customer customer = services.deleteCustomer(customerId);
		return customer;
	}

	@RequestMapping(value = "/rest/customer/updatepassword", method = RequestMethod.PUT)
	public Boolean updatePassword(@RequestBody UpdateCustomer passwordUpdate) {
		Boolean e = false;
		e = services.updatePassword(passwordUpdate.getCustomerId(), passwordUpdate.getPassword());
		return e;

	}
	
	@RequestMapping(value = "/rest/customer/updatetelephoneno", method = RequestMethod.PUT)
	public Boolean updateTelephone(@RequestBody UpdateCustomer telephoneUpdate) {
		Boolean e = false;
		e = services.updateTelephone(telephoneUpdate.getCustomerId(), telephoneUpdate.getTelephoneNo());
		return e;

	}
	
	@RequestMapping(value = "/rest/customer/updateemail", method = RequestMethod.PUT)
	public Boolean updateEmail(@RequestBody UpdateCustomer emailUpdate) {
		Boolean e = false;
		e = services.updateEmail(emailUpdate.getCustomerId(), emailUpdate.getEmail());
		return e;

	}
}

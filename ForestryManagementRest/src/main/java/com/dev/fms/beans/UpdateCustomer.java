package com.dev.fms.beans;

public class UpdateCustomer {

	Customer customer = new Customer();
	
	private int customerId;
	private long telephoneNo;
	private String password;
	private String email;
	public int getCustomerId() {
		return customer.getCustomerId();
	}
	public void setCustomerId(int customerId) {
		customer.setCustomerId(customerId);
	}
	public long getTelephoneNo() {
		return customer.getTelephoneNo();
	}
	public void setTelephoneNo(long telephoneNo) {
		customer.setTelephoneNo(telephoneNo);
	}
	public String getPassword() {
		return customer.getPassword();
	}
	public void setPassword(String password) {
		customer.setPassword(password);
	}
	public String getEmail() {
		return customer.getEmail();
	}
	public void setEmail(String email) {
		customer.setEmail(email);
	}
	@Override
	public String toString() {
		return "UpdateCustomer [customerId=" + customerId + ", telephoneNo=" + telephoneNo + ", password=" + password
				+ ", email=" + email + "]";
	}
	
}

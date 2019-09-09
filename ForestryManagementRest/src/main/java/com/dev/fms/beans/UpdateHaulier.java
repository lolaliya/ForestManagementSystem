package com.dev.fms.beans;

public class UpdateHaulier {

	Haulier haulier = new Haulier();
	
	private int haulierId;
	private long telephoneNo;
	private String password;
	private String email;
	
	public int getHaulierId() {
		return haulier.getHaulierId();
	}
	public void setHaulierId(int haulierId) {
		haulier.setHaulierId(haulierId);
	}
	public long getTelephoneNo() {
		return haulier.getTelephoneNo();
	}
	public void setTelephoneNo(long telephoneNo) {
		haulier.setTelephoneNo(telephoneNo);
	}
	public String getPassword() {
		return haulier.getPassword();
	}
	public void setPassword(String password) {
		haulier.setPassword(password);
	}
	public String getEmail() {
		return haulier.getEmail();
	}
	public void setEmail(String email) {
		haulier.setEmail(email);
	}
	@Override
	public String toString() {
		return "UpdateHaulier [haulierId=" + haulierId + ", telephoneNo=" + telephoneNo + ", password=" + password
				+ ", email=" + email + "]";
	}
	
}

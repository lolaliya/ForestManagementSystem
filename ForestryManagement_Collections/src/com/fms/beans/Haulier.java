package com.fms.beans;

public class Haulier {
	
	 private int haulierId ;
	private String haulierName; 
	private String  streetAddress1; 
	private String streetAddress2; 
	private String townCity;   
	private String postCode;  
	private Integer telephoneNo ; 
	private String email;
	public int getHaulierId() {
		return haulierId;
	}
	public void setHaulierId(int haulierId) {
		this.haulierId = haulierId;
	}
	public String getHaulierName() {
		return haulierName;
	}
	public void setHaulierName(String haulierName) {
		this.haulierName = haulierName;
	}
	public String getStreetAddress1() {
		return streetAddress1;
	}
	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}
	public String getStreetAddress2() {
		return streetAddress2;
	}
	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}
	public String getTownCity() {
		return townCity;
	}
	public void setTownCity(String townCity) {
		this.townCity = townCity;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public Integer getTelephoneNo() {
		return telephoneNo;
	}
	public void setTelephoneNo(Integer telephoneNo) {
		this.telephoneNo = telephoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Haulier [haulierId = " + haulierId + ", haulier Name = " + haulierName + ", street Address1 = " + streetAddress1
				+ ", street Address2 = " + streetAddress2 + ", town City = " + townCity + ", post Code = " + postCode
				+ ", telephone No = " + telephoneNo + ", email = " + email + "]";
	}    
	

}

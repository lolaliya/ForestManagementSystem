package com.fms.beans;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="haulier_jpa")
public class Haulier {

	@Id//@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="haulier_id")
	private int haulierId ;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="haulier"
        , joinColumns={
            @JoinColumn(name="haulier_id")
            }
        , inverseJoinColumns={
            @JoinColumn(name="contract_id")
            }
        )
	private List<Contract> contract;
	
	private String haulierName; 
	private String  streetAddress1; 
	private String streetAddress2; 
	private String townCity;   
	private int postCode;  
	private long telephoneNo ; 
	private String email;
	private String password;
	public int getHaulierId() {
		return haulierId;
	}
	public void setHaulierId(int haulierId) {
		this.haulierId = haulierId;
	}
	public List<Contract> getContract() {
		return contract;
	}
	public void setContract(List<Contract> contract) {
		this.contract = contract;
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
	public int getPostCode() {
		return postCode;
	}
	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}
	public long getTelephoneNo() {
		return telephoneNo;
	}
	public void setTelephoneNo(long telephoneNo) {
		this.telephoneNo = telephoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Haulier [haulierId=" + haulierId + ", haulierName=" + haulierName + ", streetAddress1=" + streetAddress1
				+ ", streetAddress2=" + streetAddress2 + ", townCity=" + townCity + ", postCode=" + postCode
				+ ", telephoneNo=" + telephoneNo + ", email=" + email + "]";
	}
}
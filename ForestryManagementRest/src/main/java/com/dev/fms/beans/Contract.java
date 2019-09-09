package com.dev.fms.beans;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="contract_jpa")
public class Contract {

	@Id 
	@Column(name="contract_id")
	private int contractNo;

	@ManyToMany(mappedBy="contracts",cascade = CascadeType.ALL)
	private List<Customer> customers;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="product_id")
	private List<Product> products;

	@ManyToMany(mappedBy="contract",cascade = CascadeType.ALL)
	private List<Haulier> hauliers;

	private Date deliveryDate;
	private String password;
	private String deliveryDay;

	
	public int getContractNo() {
		return contractNo;
	}

	public void setContractNo(int contractNo) {
		this.contractNo = contractNo;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Haulier> getHauliers() {
		return hauliers;
	}

	public void setHauliers(List<Haulier> hauliers) {
		this.hauliers = hauliers;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDeliveryDay() {
		return deliveryDay;
	}

	public void setDeliveryDay(String deliveryDay) {
		this.deliveryDay = deliveryDay;
	}

	@Override
	public String toString() {
		return "Contract [contractNo=" + contractNo + ", deliveryDate=" + deliveryDate + ", deliveryDay=" + deliveryDay
				+ "]";
	}




}

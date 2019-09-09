package com.fms.beans;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="order_jpa")
public class Orders {

	@Id//@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="orderNo")
	private int orderNo ;  

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="product_id")
	private List<Product> products;

	@ManyToOne
	private Contract contract;

	private Date deliveryDate; 
	private int quantity;
	
	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Orders [orderNo=" + orderNo + ", deliveryDate=" + deliveryDate + ", quantity=" + quantity + "]";
	}

	



}

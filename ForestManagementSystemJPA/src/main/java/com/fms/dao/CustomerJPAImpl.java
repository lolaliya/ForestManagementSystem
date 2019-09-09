package com.fms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fms.beans.Customer;

public class CustomerJPAImpl implements CustomerDAO{
	private final static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("MySQLUnit");
	
	@Override
	public Boolean addCustomer(Customer customer) {
		Boolean state = false;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(customer);
			em.getTransaction().commit();
			em.close();
			state = true;
		} catch (Exception e) {
			//throw custom exception
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public Customer searchCustomer(Integer customerId) {
		EntityManager em = emf.createEntityManager();
		Customer customer = em.find(Customer.class, customerId);
		em.close();
		return customer;
	}

	@Override
	public Customer deleteCustomer(Integer customerId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Customer customer = em.find(Customer.class, customerId);
		em.remove(customer);
		em.getTransaction().commit();
		em.close();
		return customer;
	}

	@Override
	public Boolean updatePassword(Integer customerId, String passwd) {
		Boolean state = false;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Customer customer = em.find(Customer.class, customerId);
			customer.setPassword(passwd);
			em.getTransaction().commit();
			em.close();
			state = true;
		} catch (Exception e) {
			//Custom Exception
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public Boolean updateTelephone(Integer customerId, long number) {
		Boolean state = false;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Customer customer = em.find(Customer.class, customerId);
			customer.setTelephoneNo(number);
			em.getTransaction().commit();
			em.close();
			state = true;
		} catch (Exception e) {
			//Custom Exception
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public Boolean updateEmail(Integer customerId, String email) {
		Boolean state = false;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Customer customer = em.find(Customer.class, customerId);
			customer.setEmail(email);
			em.getTransaction().commit();
			em.close();
			state = true;
		} catch (Exception e) {
			//Custom Exception
			e.printStackTrace();
		}
		return state;
	}
}

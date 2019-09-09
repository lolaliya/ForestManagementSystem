package com.fms.dao;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.fms.beans.Orders;

public class OrdersJPAImpl implements OrdersDAO{
	private final static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("MySQLUnit");
	
	@Override
	public Boolean addOrder(Orders order) {
		Boolean state = false;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(order);
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
	public Orders searchOrder(Integer orderId) {
		EntityManager em = emf.createEntityManager();
		Orders order = em.find(Orders.class, orderId);
		em.close();
		return order;
	}

	public Orders deleteOrder(Integer orderId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Orders order = em.find(Orders.class, orderId);
		em.remove(order);
		em.getTransaction().commit();
		em.close();
		return order;
	}

	@Override
	public Boolean updateDeliveryDate(Integer orderId, Date deliveryDate) {
		Boolean state = false;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Orders contract = em.find(Orders.class, orderId);
			contract.setDeliveryDate(deliveryDate);
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

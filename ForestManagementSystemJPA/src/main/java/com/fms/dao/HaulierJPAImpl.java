package com.fms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fms.beans.Haulier;

public class HaulierJPAImpl implements HaulierDAO{
	private final static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("MySQLUnit");

	@Override
	public Boolean addHaulier(Haulier haulier) {
		Boolean state = false;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(haulier);
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
	public Haulier searchHaulier(Integer haulierId) {
		EntityManager em = emf.createEntityManager();
		Haulier haulier = em.find(Haulier.class, haulierId);
		em.close();
		return haulier;
	}

	@Override
	public Haulier deleteHaulier(Integer haulierId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Haulier haulier = em.find(Haulier.class, haulierId);
		em.remove(haulier);
		em.getTransaction().commit();
		em.close();
		return haulier;
	}

	@Override
	public Boolean updatePassword(Integer haulierId, String passwd) {
		Boolean state = false;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Haulier haulier = em.find(Haulier.class, haulierId);
			haulier.setPassword(passwd);
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
	public Boolean updateTelephone(Integer haulierId, long number) {
		Boolean state = false;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Haulier haulier = em.find(Haulier.class, haulierId);
			haulier.setTelephoneNo(number);
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
	public Boolean updateEmail(Integer haulierId, String email) {
		Boolean state = false;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Haulier haulier = em.find(Haulier.class, haulierId);
			haulier.setEmail(email);
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

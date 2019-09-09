package com.fms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fms.beans.Contract;

public class ContractJPAImpl implements ContractDAO{
	private final static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("MySQLUnit");

	public Boolean addContract(Contract contract) {
		Boolean state = false;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(contract);
			em.getTransaction().commit();
			em.close();
			state = true;
		} catch (Exception e) {
			//throw custom exception
			e.printStackTrace();
		}
		return state;
	}

	public Contract searchContract(Integer contractId) {
		EntityManager em = emf.createEntityManager();
		Contract user = em.find(Contract.class, contractId);
		em.close();
		return user;
	}

	public Contract deleteContract(Integer contractId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Contract contract = em.find(Contract.class, contractId);
		em.remove(contract);
		em.getTransaction().commit();
		em.close();
		return contract;
	}

	@Override
	public Boolean updatePassword(Integer contractId, String passwd) {
		Boolean state = false;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Contract contract = em.find(Contract.class, contractId);
			contract.setPassword(passwd);
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
	public boolean updateDeliveryDay(int contractId, String newDay) {
		Boolean state = false;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Contract contract = em.find(Contract.class, contractId);
			contract.setDeliveryDay(newDay);
			em.getTransaction().commit();
			em.close();
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

}

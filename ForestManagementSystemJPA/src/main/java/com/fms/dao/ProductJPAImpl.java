package com.fms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fms.beans.Product;

public class ProductJPAImpl implements ProductDAO{
	private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MySQLUnit");

	public Boolean addProduct(Product product) {
		Boolean state = false;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(product);
			em.getTransaction().commit();
			em.close();
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public Product searchProduct(Integer productId) {
		EntityManager em = emf.createEntityManager();
		Product product = em.find(Product.class, productId);
		em.close();
		return product;
	}

	public Product deleteProduct(Integer productId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Product product = em.find(Product.class, productId);
		em.remove(product);
		em.getTransaction().commit();
		em.close();
		return product;
	}

	public Boolean updateProduct(Integer productId, String description) {
		Boolean state = false;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Product product = em.find(Product.class, productId);
			product.setProductDescription(description);
			em.getTransaction().commit();
			em.close();
			state = true;
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return state;
	}
}

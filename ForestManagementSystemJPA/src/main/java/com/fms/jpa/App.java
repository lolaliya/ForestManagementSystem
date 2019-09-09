package com.fms.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App 
{
	public static void main( String[] args )
	{

		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("MySQLUnit");
		EntityManager em = emf.createEntityManager();

		em.close();
		emf.close();
	}
}

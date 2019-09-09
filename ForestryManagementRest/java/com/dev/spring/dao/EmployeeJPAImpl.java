package com.dev.spring.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dev.spring.beans.Employee;

public class EmployeeJPAImpl implements EmployeeDAO  {
	private final static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("MySQLUnit");


	@Override
	public Boolean createEmployee(Employee employee) {
		Boolean state = false;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(employee);
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
	public Employee getEmployee(Integer employeeId) {
		EntityManager em=emf.createEntityManager();
		Employee user = em.find(Employee.class, employeeId);
		em.close();
		return user;
	}

	@Override
	public Employee removeEmployee(Integer employeeId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Employee user = em.find(Employee.class, employeeId);
		em.remove(user);
		em.getTransaction().commit();
		em.close();
		return user;
	}

	

	@Override
	public Boolean updateEmail(Integer empId, String oldEmail, String newEmail) {
		Boolean state = false;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Employee employee= em.find(Employee.class,empId);
			if(employee.getEmail().equals(oldEmail)) {
			employee.setEmail(newEmail);
			
	     	em.getTransaction().commit();
			em.close(); 
			state = true;
			}
		} catch (Exception e) {
			//Custom Exception
			e.printStackTrace();
		}
		return state;
	
	}
}






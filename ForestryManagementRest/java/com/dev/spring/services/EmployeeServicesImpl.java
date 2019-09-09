package com.dev.spring.services;

import com.dev.spring.beans.Employee;
import com.dev.spring.dao.EmployeeDAO;
import com.dev.spring.dao.EmployeeJPAImpl;

public class EmployeeServicesImpl implements EmployeeServices {
	
	private EmployeeDAO db = new EmployeeJPAImpl();

	@Override
	public Boolean createEmployee(Employee employee) {
		return db.createEmployee(employee);
	}

	@Override
	public Employee getEmployee(Integer employeeId) {
		return db.getEmployee(employeeId);
	}

	@Override
	public Employee removeEmployee(Integer employeeId) {
		return db.removeEmployee(employeeId);
	}

	@Override
	public Boolean updateEmail(Integer empId, String oldEmail,String newEmail){
		return db.updateEmail(empId,oldEmail,newEmail);
	}

}

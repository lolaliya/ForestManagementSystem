package com.dev.spring.services;

import com.dev.spring.beans.Employee;

public interface EmployeeServices {
	public Boolean createEmployee(Employee employee);
	public Employee getEmployee(Integer employeeId);
	public Employee removeEmployee(Integer employeeId);
	public Boolean updateEmail(Integer empId, String oldEmail,String newEmail);


}

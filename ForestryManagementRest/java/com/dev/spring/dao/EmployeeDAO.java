package com.dev.spring.dao;

import com.dev.spring.beans.Employee;

public interface EmployeeDAO {
	public Boolean createEmployee(Employee employee);
	public Employee getEmployee(Integer employeeId);
	public Employee removeEmployee(Integer employeeId);
	public Boolean updateEmail(Integer empId, String oldEmail,String newEmail);


}

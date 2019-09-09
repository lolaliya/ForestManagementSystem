package com.dev.spring.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.spring.beans.Employee;
import com.dev.spring.services.EmployeeServices;
import com.dev.spring.services.EmployeeServicesImpl;

/**
 * Handles requests for the Employee service.
 */
@RestController
public class EmployeeController {
	
	EmployeeServices services = new EmployeeServicesImpl();
	@RequestMapping(value = "/rest/emp/dummy", method = RequestMethod.GET)
	public Employee getDummyEmployee() {
		Employee emp = new Employee();
		emp.setId(9999);
		emp.setName("Dummy");
		emp.setEmail("emp@mail.com");
		return emp;
	}
	
	@RequestMapping(value = "/rest/emp/{id}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable("id") int empId) {
		return services.getEmployee(empId);
		
	}
	
/*	@RequestMapping(value = "/rest/emps", method = RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		List<Employee> emps = new ArrayList<Employee>();
		Set<Integer> empIdKeys = services.getEmployee.keySet();
		for(Integer i : empIdKeys){
			emps.add(getEmployee(empIdKeys).get(i));
		}
		return emps;
	}*/
	
	@RequestMapping(value = "/rest/emp/create", method = RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee emp1) {
		services.createEmployee(emp1);
		return emp1;
	}
	
	@RequestMapping(value = "/rest/emp/update/{id}/{oldEmail}/{newEmail}", method = RequestMethod.PUT)
	public Boolean updateEmail(@PathVariable("id")int id,@PathVariable("oldEmail")String oldEmail,@PathVariable("newEmail")String newEmail) {
    Boolean e = false;
	e = services.updateEmail(id,oldEmail,newEmail);
	return true;
		
	}


}
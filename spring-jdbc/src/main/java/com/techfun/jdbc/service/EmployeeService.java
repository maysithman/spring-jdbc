package com.techfun.jdbc.service;

import java.util.List;

import com.techfun.jdbc.model.Employee;

public interface EmployeeService {

	void createEmployee (Employee employee);
	
	void updateEmployee (Employee employee);
	
	List<Employee> selectEmployee (Employee employee);
	
	void deleteEmployee (Employee employee);
	
}

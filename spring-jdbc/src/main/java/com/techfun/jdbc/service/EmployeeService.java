package com.techfun.jdbc.service;

import com.techfun.jdbc.model.Employee;

public interface EmployeeService {

	void createEmployee (Employee employee);
	
	void updateEmployee (Employee employee);
	
	void selectEmployee (Employee employee);
	
	void deleteEmployee (Employee employee);
	
}

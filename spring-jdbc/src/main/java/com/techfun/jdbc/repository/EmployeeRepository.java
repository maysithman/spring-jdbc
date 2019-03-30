package com.techfun.jdbc.repository;

import com.techfun.jdbc.model.Employee;

public interface EmployeeRepository {

	void createEmployee(Employee employee);
	
	void updateEmployee(Employee employee);
	
	void selectEmployee(Employee employee);
	
	void deleteEmployee(Employee employee);
	
}

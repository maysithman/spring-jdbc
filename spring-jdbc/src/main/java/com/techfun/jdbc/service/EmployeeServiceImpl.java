package com.techfun.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techfun.jdbc.model.Employee;
import com.techfun.jdbc.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void createEmployee(Employee employee) {
		employeeRepository.createEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.updateEmployee(employee);
	}

	@Override
	public void selectEmployee(Employee employee) {
		employeeRepository.selectEmployee(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeRepository.deleteEmployee(employee);
	}

}

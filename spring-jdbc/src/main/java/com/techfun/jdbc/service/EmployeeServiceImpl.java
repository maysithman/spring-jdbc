package com.techfun.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techfun.jdbc.model.Employee;
import com.techfun.jdbc.model.Ride;
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
	public List<Employee> selectEmployee(Employee employee) {
		return employeeRepository.selectEmployee(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeRepository.deleteEmployee(employee);
	}
	
	public void insertEmployeeAndRide(Employee employee, Ride ride) {
		employeeRepository.insertEmployeeAndRide(employee, ride);
	}

	@Override
	public int numOfEmployee(Employee employee) {
		return employeeRepository.numOfEmployee(employee);
	}

	@Override
	public Employee selectExactEmployee(Employee employee) {
		return employeeRepository.selectExactEmployee(employee);
	}

}

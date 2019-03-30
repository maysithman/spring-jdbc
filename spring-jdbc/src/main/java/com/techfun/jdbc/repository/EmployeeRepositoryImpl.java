package com.techfun.jdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.techfun.jdbc.model.Employee;

@Repository("employeeRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void createEmployee(Employee employee) {
		String insertTableSQL = "INSERT INTO Employee(NAME, AGE, ADDRESS) VALUES(?, ?, ?)";
		jdbcTemplate.update(insertTableSQL, employee.getName(), employee.getAge(), employee.getAddress());
	}

	@Override
	public void updateEmployee(Employee employee) {
		String updateTableSQL = "UPDATE Employee SET NAME = ?, AGE = ?, ADDRESS = ? WHERE ID = ?";
		jdbcTemplate.update(updateTableSQL, employee.getName(), employee.getAge(), employee.getAddress(), employee.getId());
	}

	@Override
	public void selectEmployee(Employee employee) {
		String selectTableSQL = "SELECT * FROM Employee WHERE id=?";
		
	}

	@Override
	public void deleteEmployee(Employee employee) {
		String deleteTableSQL = "DELETE FROM Employee WHERE id = ?";
		jdbcTemplate.update(deleteTableSQL, employee.getId());
	}

}

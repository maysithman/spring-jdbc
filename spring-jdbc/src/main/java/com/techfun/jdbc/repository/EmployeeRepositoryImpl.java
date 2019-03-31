package com.techfun.jdbc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techfun.jdbc.model.Employee;
import com.techfun.jdbc.model.Ride;
import com.techfun.jdbc.repository.util.EmployeeRowMapper;

@Repository("employeeRepository")
@Transactional
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
	public List<Employee> selectEmployee(Employee employee) {
		String selectTableSQL = "SELECT * FROM Employee";
		List<Employee> employees = jdbcTemplate.query(selectTableSQL, new EmployeeRowMapper());

		return employees;
	}

	@Override
	public void deleteEmployee(Employee employee) {
		String deleteTableSQL = "DELETE FROM Employee WHERE id = ?";
		jdbcTemplate.update(deleteTableSQL, employee.getId());
	}
	
	//@Transactional
	public void insertEmployeeAndRide(Employee employee, Ride ride) {
		String insertEmployeeSQL = "INSERT INTO Employee(NAME, AGE, ADDRESS) VALUES(?, ?, ?)";
		jdbcTemplate.update(insertEmployeeSQL, employee.getName(), employee.getAge(), employee.getAddress());
		
		String insertRideSQL = "INSERT INTO Ride111(NAME, DURATION) VALUES(?, ?)";
		jdbcTemplate.update(insertRideSQL, ride.getName(), ride.getDuration());
	}

	@Override
	public int numOfEmployee(Employee employee) {
		String countEmployee = "SELECT COUNT(*) FROM Employee";
		int numofEmployees = jdbcTemplate.queryForObject(countEmployee, Integer.class);
		return numofEmployees;
	}

	@Override
	public Employee selectExactEmployee(Employee employee) {
		String selectTableSQL = "SELECT * FROM Employee WHERE id=?";
		Employee emp = (Employee) jdbcTemplate.queryForObject(selectTableSQL, new EmployeeRowMapper(), employee.getId());

		return emp;
	}

}

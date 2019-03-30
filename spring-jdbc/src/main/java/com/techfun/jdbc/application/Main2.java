package com.techfun.jdbc.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techfun.jdbc.model.Employee;
import com.techfun.jdbc.service.EmployeeService;
import com.techfun.jdbc.service.RideService;

public class Main2 {

	public static void main(String[] args) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeService employeeService = appContext.getBean("employeeService", EmployeeService.class);

		//testCreateEmployee(employeeService);
		//testUpdateEmployee(employeeService);
		testSelectEmployee(employeeService);
		//testDeleteEmployee(employeeService);
	}

	private static void testCreateEmployee(EmployeeService employeeService) {
		Employee employee = new Employee();
		employee.setName("Jin Jin");
		employee.setAge(23);
		employee.setAddress("Yangon");

		employeeService.createEmployee(employee);

		System.out.println("Successfully Insert.");
	}

	private static void testUpdateEmployee(EmployeeService employeeService) {
		Employee employee = new Employee();
		employee.setName("Su Ei San");
		employee.setAge(24);
		employee.setAddress("Ba Luu Kyun");
		employee.setId(4);

		employeeService.updateEmployee(employee);

		System.out.println("Successfully Update.");
	}

	private static void testSelectEmployee(EmployeeService employeeService) {
		Employee employee = new Employee();
		employee.setId(2);

		employeeService.selectEmployee(employee);

		System.out.println("Selected Employee Successfully.");
	}

	private static void testDeleteEmployee(EmployeeService employeeService) {
		Employee employee = new Employee();
		employee.setId(5);

		// RideService rideService = new RideServiceImpl();
		employeeService.deleteEmployee(employee);

		System.out.println("Successfully Delete.");
	}

}

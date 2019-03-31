package com.techfun.jdbc.application;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techfun.jdbc.model.Employee;
import com.techfun.jdbc.model.Ride;
import com.techfun.jdbc.service.EmployeeService;
import com.techfun.jdbc.service.RideService;

public class AppEmployee {

	public static void main(String[] args) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeService employeeService = appContext.getBean("employeeService", EmployeeService.class);

		//testCreateEmployee(employeeService);
		//testUpdateEmployee(employeeService);
		//testSelectEmployee(employeeService);
		//testDeleteEmployee(employeeService);
		
		//testInsertEmployeeAndRide(employeeService);
		testNumOfEmployee(employeeService);
		testSelectExactEmployee(employeeService);
	}

	private static void testSelectExactEmployee(EmployeeService employeeService) {
		Employee employee = new Employee();
		employee.setId(2);
		
		Employee emp = employeeService.selectExactEmployee(employee);
		
		System.out.println(
		    		"ID : " + emp.getId() + " 	" + 
		    		"Name : " + emp.getName() + " 	" + 
		    		"Age : " + emp.getAge() + " 	" + 
		    		"Address : " + emp.getAddress() + "\n"
		    		);

		System.out.println("Selected Exact Employee Successfully.");
	}

	private static void testNumOfEmployee(EmployeeService employeeService) {
		Employee employee = new Employee();
		System.out.println("The number of employees : " + employeeService.numOfEmployee(employee));
	}

	private static void testInsertEmployeeAndRide(EmployeeService employeeService) {
		Employee employee = new Employee();
		employee.setName("kk");
		employee.setAge(23);
		employee.setAddress("Yangon");
		
		Ride ride = new Ride();
		ride.setName("Myo Myo");
		ride.setDuration(10);
		
		employeeService.insertEmployeeAndRide(employee, ride);
		
		System.out.println("Inserted Employee and Ride Successfully.");
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
		
		List<Employee> employees = employeeService.selectEmployee(employee);
		
		for (Employee emp : employees) {
		    System.out.println(
		    		"ID : " + emp.getId() + " 	" + 
		    		"Name : " + emp.getName() + " 	" + 
		    		"Age : " + emp.getAge() + " 	" + 
		    		"Address : " + emp.getAddress() + "\n"
		    		);
		}

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

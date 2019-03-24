package com.techfun.jdbc.application;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techfun.jdbc.model.Ride;
import com.techfun.jdbc.service.RideService;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		RideService rideService = appContext.getBean("rideService", RideService.class);
		
		testCreateRide(rideService);
		testUpdateRide(rideService);
		testSelectRide(rideService);
		testDeleteRide(rideService);
	}
	
	private static void testCreateRide(RideService rideService) {
		Ride ride = new Ride();
		ride.setName("May Sit Hman");
		ride.setDuration(10);
		
		//RideService rideService = new RideServiceImpl();
		rideService.createRide(ride);
		
		System.out.println("Successfully Insert.");
	}
	
	private static void testUpdateRide(RideService rideService) {
		Ride ride = new Ride();
		ride.setName("Jin Jin");
		ride.setDuration(20);
		ride.setId(5);
		
		//RideService rideService = new RideServiceImpl();
		rideService.updateRide(ride);
		
		System.out.println("Successfully Update.");
	}
	
	private static void testSelectRide(RideService rideService) {
		Ride ride = new Ride();
		
		//RideService rideService = new RideServiceImpl();
		rideService.selectRide(ride);
		
		System.out.println("Successfully Update.");
	}
	
	private static void testDeleteRide(RideService rideService) {
		Ride ride = new Ride();
		ride.setId(7);
		
		//RideService rideService = new RideServiceImpl();
		rideService.deleteRide(ride);
		
		System.out.println("Successfully Delete.");
	}

}

package com.techfun.jdbc.application;

import java.util.List;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techfun.jdbc.model.Ride;
import com.techfun.jdbc.service.RideService;

public class AppRide {

	public static void main(String[] args) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		RideService rideService = appContext.getBean("rideService", RideService.class);
		
		//testCreateRide(rideService);
		//testUpdateRide(rideService);
		//testSelectRide(rideService);
		//testDeleteRide(rideService);
		testSelectExactRide(rideService);
		testNumOfRide(rideService);
	}
	
	private static void testNumOfRide(RideService rideService) {
		Ride ride = new Ride();
		System.out.println("The number of Ride : " + rideService.numOfRide(ride));
	}

	private static void testSelectExactRide(RideService rideService) {
		Ride ride = new Ride();
		ride.setId(9);
		
		Ride r = rideService.selectExactRide(ride);
		
		System.out.println(
					"ID : " + r.getId() + "		" +
					"Name : " + r.getName() + " 	" +
					"Duration : " + r.getDuration() + "\n"
					);
	}

	private static void testCreateRide(RideService rideService) {
		Ride ride = new Ride();
		ride.setName("Ma Ma");
		ride.setDuration(10);
		
		//RideService rideService = new RideServiceImpl();
		rideService.createRide(ride);
		
		System.out.println("Successfully Insert.");
	}
	
	private static void testUpdateRide(RideService rideService) {
		Ride ride = new Ride();
		ride.setName("Su Ei San");
		ride.setDuration(20);
		ride.setId(11);
		
		rideService.updateRide(ride);
		
		System.out.println("Successfully Update.");
	}
	
	private static void testSelectRide(RideService rideService) {
		Ride ride = new Ride();
		
		List<Ride> rides = rideService.selectRide(ride);
		
		for(Ride r : rides) {
			System.out.println(
					"ID : " + r.getId() + "		" +
					"Name : " + r.getName() + " 	" +
					"Duration : " + r.getDuration() + "\n"
					);
		}
		
		System.out.println("Successfully Update.");
	}
	
	private static void testDeleteRide(RideService rideService) {
		Ride ride = new Ride();
		ride.setId(8);
		
		//RideService rideService = new RideServiceImpl();
		rideService.deleteRide(ride);
		
		System.out.println("Successfully Delete.");
	}

}

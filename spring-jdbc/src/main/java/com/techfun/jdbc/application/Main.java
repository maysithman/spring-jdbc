package com.techfun.jdbc.application;

import com.techfun.jdbc.model.Ride;
import com.techfun.jdbc.service.RideService;
import com.techfun.jdbc.service.RideServiceImpl;

public class Main {

	public static void main(String[] args) {

		testCreateRide();
		testUpdateRide();
		testSelectRide();
		testDeleteRide();
	}
	
	private static void testCreateRide() {
		Ride ride = new Ride();
		ride.setName("May Sit Hman");
		ride.setDuration(10);
		
		RideService rideService = new RideServiceImpl();
		rideService.createRide(ride);
		
		System.out.println("Successfully Insert.");
	}
	
	private static void testUpdateRide() {
		Ride ride = new Ride();
		ride.setName("Jin Jin");
		ride.setDuration(20);
		ride.setId(5);
		
		RideService rideService = new RideServiceImpl();
		rideService.updateRide(ride);
		
		System.out.println("Successfully Update.");
	}
	
	private static void testSelectRide() {
		Ride ride = new Ride();
		
		RideService rideService = new RideServiceImpl();
		rideService.selectRide(ride);
		
		System.out.println("Successfully Update.");
	}
	
	private static void testDeleteRide() {
		Ride ride = new Ride();
		
		RideService rideService = new RideServiceImpl();
		rideService.deleteRide(ride);
		
		System.out.println("Successfully Delete.");
	}

}

package com.techfun.jdbc.application;

import com.techfun.jdbc.model.Ride;
import com.techfun.jdbc.service.RideService;
import com.techfun.jdbc.service.RideServiceImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		testCreateRide();
	}
	
	private static void testCreateRide() {
		Ride ride = new Ride();
		ride.setName("May Sit Hman");
		ride.setDuration(10);
		
		RideService rideService = new RideServiceImpl();
		rideService.createRide(ride);
		
		System.out.println("Successfully Insert.");
	}

}

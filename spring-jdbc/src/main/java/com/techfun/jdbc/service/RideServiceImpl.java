package com.techfun.jdbc.service;

import com.techfun.jdbc.model.Ride;
import com.techfun.jdbc.repository.RideRepository;
import com.techfun.jdbc.repository.RideRepositoryImpl;

public class RideServiceImpl implements RideService {
	
	public void createRide(Ride ride) {
		
		RideRepository rideRepository = new RideRepositoryImpl();
		rideRepository.createRide(ride);
		
	}
	
	public void updateRide(Ride ride) {
		RideRepository rideRepository = new RideRepositoryImpl();
		rideRepository.updateRide(ride);
	}

	public void selectRide(Ride ride) {
		RideRepository rideRepository = new RideRepositoryImpl();
		rideRepository.selectRide(ride);
	}
	
	public void deleteRide(Ride ride) {
		RideRepository rideRepository = new RideRepositoryImpl();
		rideRepository.deleteRide(ride);
	}
	
}
package com.techfun.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techfun.jdbc.model.Ride;
import com.techfun.jdbc.repository.RideRepository;

@Service("rideService")
public class RideServiceImpl implements RideService {
	
	@Autowired
	private RideRepository rideRepository;
	
	public void createRide(Ride ride) {
		
		//RideRepository rideRepository = new RideRepositoryImpl();
		rideRepository.createRide(ride);
		
	}
	
	public void updateRide(Ride ride) {
		//RideRepository rideRepository = new RideRepositoryImpl();
		rideRepository.updateRide(ride);
	}

	public void selectRide(Ride ride) {
		//RideRepository rideRepository = new RideRepositoryImpl();
		rideRepository.selectRide(ride);
	}
	
	public void deleteRide(Ride ride) {
		//RideRepository rideRepository = new RideRepositoryImpl();
		rideRepository.deleteRide(ride);
	}
	
}

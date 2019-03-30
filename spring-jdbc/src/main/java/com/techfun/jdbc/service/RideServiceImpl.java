package com.techfun.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techfun.jdbc.model.Ride;
import com.techfun.jdbc.repository.RideRepository;

@Service("rideService")
public class RideServiceImpl implements RideService {
	
	@Autowired
	private RideRepository rideRepository;
	
	public void createRide(Ride ride) {
		rideRepository.createRide(ride);
	}
	
	public void updateRide(Ride ride) {
		rideRepository.updateRide(ride);
	}

	public List<Ride> selectRide(Ride ride) {
		return rideRepository.selectRide(ride);
	}
	
	public void deleteRide(Ride ride) {
		rideRepository.deleteRide(ride);
	}
	
}

package com.techfun.jdbc.service;

import java.util.List;

import com.techfun.jdbc.model.Ride;

public interface RideService {

	void createRide (Ride ride);
	void updateRide (Ride ride);
	List<Ride> selectRide (Ride ride);
	void deleteRide (Ride ride);
	
}

package com.techfun.jdbc.service;

import com.techfun.jdbc.model.Ride;

public interface RideService {

	void createRide (Ride ride);
	void updateRide (Ride ride);
	void selectRide (Ride ride);
	void deleteRide (Ride ride);
	
}

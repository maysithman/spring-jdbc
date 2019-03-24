package com.techfun.jdbc.repository;

import com.techfun.jdbc.model.Ride;

public interface RideRepository {
	
	void createRide(Ride ride);
	void updateRide(Ride ride);
	void selectRide(Ride ride);
	void deleteRide(Ride ride);
	
}

package com.techfun.jdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.techfun.jdbc.model.Ride;

@Repository("rideRepository")
public class RideRepositoryImpl implements RideRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void createRide(Ride ride) {	
		String insertTableSQL = "INSERT INTO Ride(NAME, DURATION) VALUES(?, ?)";
		jdbcTemplate.update(insertTableSQL, ride.getName(), ride.getDuration());
	}
	
	public void updateRide(Ride ride) {
		String updateTableSQL = "UPDATE Ride SET NAME = ?, DURATION = ? WHERE ID = ?";
		jdbcTemplate.update(updateTableSQL, ride.getName(), ride.getDuration(), ride.getId());
	}
	
	public void selectRide(Ride ride) {
		String updateTableSQL = "SELECT * FROM Ride";
		
	}
	
	public void deleteRide(Ride ride) {
		String deleteTableSQL = "DELETE FROM Ride WHERE id = ?";
		jdbcTemplate.update(deleteTableSQL, ride.getId());
	}

}

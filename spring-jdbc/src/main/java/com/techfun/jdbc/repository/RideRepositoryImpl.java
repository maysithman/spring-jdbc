package com.techfun.jdbc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.techfun.jdbc.model.Ride;
import com.techfun.jdbc.repository.util.RideRowMapper;

@Repository("rideRepository")
public class RideRepositoryImpl implements RideRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void createRide(Ride ride) {	
		String insertTableSQL = "INSERT INTO Ride(NAME, DURATION) VALUES(?, ?)";
		jdbcTemplate.update(insertTableSQL, ride.getName(), ride.getDuration());
		
		System.out.println("Test Transaction.");
	}
	
	public void updateRide(Ride ride) {
		String updateTableSQL = "UPDATE Ride SET NAME = ?, DURATION = ? WHERE ID = ?";
		jdbcTemplate.update(updateTableSQL, ride.getName(), ride.getDuration(), ride.getId());
	}
	
	public List<Ride> selectRide(Ride ride) {
		String selectTableSQL = "SELECT * FROM Ride";
		List<Ride> rides = jdbcTemplate.query(selectTableSQL, new RideRowMapper());
		
		return rides;
	}
	
	public void deleteRide(Ride ride) {
		String deleteTableSQL = "DELETE FROM Ride WHERE id = ?";
		jdbcTemplate.update(deleteTableSQL, ride.getId());
	}

}

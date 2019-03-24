package com.techfun.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.techfun.jdbc.connectionhelper.ConnectionHelper;
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
		
		try(Connection dbConnection = ConnectionHelper.getDBConnection();
				PreparedStatement preparedStatedment = dbConnection.prepareStatement(updateTableSQL)){
			
			ResultSet rs = preparedStatedment.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\n");
			}
			
			System.out.println("Record is selected successfully.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteRide(Ride ride) {
		String deleteTableSQL = "DELETE FROM Ride WHERE id = ?";
		jdbcTemplate.update(deleteTableSQL, ride.getId());
	}

}

package com.techfun.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.techfun.jdbc.connectionhelper.ConnectionHelper;
import com.techfun.jdbc.model.Ride;

public class RideRepositoryImpl implements RideRepository {
	
	public void createRide(Ride ride) {
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		String insertTableSQL = "INSERT INTO Ride"
				+ "(NAME, DURATION) VALUES"
				+ "(?, ?)";
		
		try {
			dbConnection = ConnectionHelper.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			
			preparedStatement.setString(1, ride.getName());
			preparedStatement.setInt(2, ride.getDuration());
			
			preparedStatement.executeUpdate();
			System.out.println("Record is inserted into Ride table.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (dbConnection != null){
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}

}

package com.techfun.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.techfun.jdbc.connectionhelper.ConnectionHelper;
import com.techfun.jdbc.model.Ride;

public class RideRepositoryImpl implements RideRepository {
	
	public void createRide(Ride ride) {	
		String insertTableSQL = "INSERT INTO Ride"
				+ "(NAME, DURATION) VALUES"
				+ "(?, ?)";
		
		try (Connection dbConnection = ConnectionHelper.getDBConnection();
				PreparedStatement preparedStatement = dbConnection.prepareStatement(insertTableSQL)) {
						
			preparedStatement.setString(1, ride.getName());
			preparedStatement.setInt(2, ride.getDuration());
			
			preparedStatement.executeUpdate();
			System.out.println("Record is inserted into Ride table.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void updateRide(Ride ride) {
		String updateTableSQL = "UPDATE Ride SET NAME = ?, DURATION = ? WHERE ID = ?";
		
		try(Connection dbConnection = ConnectionHelper.getDBConnection();
				PreparedStatement preparedStatedment = dbConnection.prepareStatement(updateTableSQL)){
			
			preparedStatedment.setString(1, ride.getName());
			preparedStatedment.setInt(2, ride.getDuration());
			preparedStatedment.setInt(3, ride.getId());
			
			preparedStatedment.executeUpdate();
			System.out.println("Record is updated successfully.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		try(Connection dbConnection = ConnectionHelper.getDBConnection();
				PreparedStatement preparedStatedment = dbConnection.prepareStatement(deleteTableSQL)){
			
			preparedStatedment.setInt(1, ride.getId());
			
			preparedStatedment.executeUpdate();
			System.out.println("Record is deleted successfully.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

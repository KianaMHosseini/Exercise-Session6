package ir.isc.session6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateNameOfCountry {

	// JDBC URL, username and password of H2 server
	private static final String URL = "jdbc:h2:tcp://localhost:9092/~/testdb";
	private static final String USER = "sa"; // Default username
	private static final String PASSWORD = ""; // Default password (empty)

	public static void main(String[] args) throws SQLException {
		// Declare the connection and statement objects
		
		String OldCountryID = "US";
		String NewCountryID = "AR";
		try (
		Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
		PreparedStatement preparedStatement = connection.prepareStatement
				("UPDATE LOCATIONS SET COUNTRY_ID = ? WHERE COUNTRY_ID = ?");
				){		
				
				System.out.println("Connect to H2 Database successfully!");
				
				preparedStatement.setString(1, NewCountryID);
				preparedStatement.setString(2, OldCountryID);
				
				int rowsUpdated = preparedStatement.executeUpdate();

	            // Print the result
	            if (rowsUpdated > 0) {
	                System.out.println("Country ID updated successfully!");
	                System.out.println("Rows affected: " + rowsUpdated);
	            } else {
	                System.out.println("No matching Country ID found to update.");
	
	}
}}}

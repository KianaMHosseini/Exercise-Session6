package ir.isc.session6;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListOfDepartment1Employees {
	// JDBC URL, username and password of H2 server
	private static final String URL = "jdbc:h2:tcp://localhost:9092/~/testdb";
	private static final String USER = "sa"; // Default username
	private static final String PASSWORD = ""; // Default password (empty)

	public static void main(String[] args) throws SQLException {
		// Declare the connection and statement objects
		
		String DepartmentID = "1";
		try (
		Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEES WHERE Department_ID = ?");
		//ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?");
				){		
				
				System.out.println("Connect to H2 Database successfully!");
				preparedStatement.setString(1, DepartmentID);
		
				try(ResultSet resultSet = preparedStatement.executeQuery()){
				
				while (resultSet.next()) {
					String id= resultSet.getString("DEPARTMENT_ID");
					String name = resultSet.getString("FIRST_NAME");
					String Lname = resultSet.getString("LAST_NAME");
					System.out.println("Department ID: " + id + ",Employee's name "+ name + Lname);
				}
				
	
	}
}}}
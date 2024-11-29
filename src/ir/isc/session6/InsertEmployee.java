package ir.isc.session6;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEmployee {
	// JDBC URL, username and password of H2 server
	private static final String URL = "jdbc:h2:tcp://localhost:9092/~/testdb";
	private static final String USER = "sa"; // Default username
	private static final String PASSWORD = ""; // Default password (empty)

	public static void main(String[] args) throws SQLException {
		// Declare the connection and statement objects
		
		String DepartmentID = "1";
		try (
		Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
		PreparedStatement preparedStatement = connection.prepareStatement
				("INSERT INTO EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY) VALUES(?, ?, ?, ?, ?, ?, ?, ?)"
						);
		
				){		
				
				System.out.println("Connect to H2 Database successfully!");
				preparedStatement.setString(1, "501");//EMPLOYEE_ID
				preparedStatement.setString(2, "Kiana");//FIRST_NAME
				preparedStatement.setString(3, "Mohammad Hosseini");//LAST_NAME
				preparedStatement.setString(4, "Kiana.hosseini@gmail.com");//EMAIL
				preparedStatement.setString(5, "313.127.4653");//PHONE_NUMBER
				preparedStatement.setString(6, "2024-05-12");//HIRE_DATE
				preparedStatement.setString(7, "12");//JOB_ID
				preparedStatement.setString(8, "140");//SALARY
				//preparedStatement.setString(9, "100");//MANAGER_ID
				//preparedStatement.setString(1, "2");//DEPARTMENT_ID
				
				
		
				int rowsInserted = preparedStatement.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("A new employee was inserted successfully!");
	            }
				
			     } 
			    
			}}
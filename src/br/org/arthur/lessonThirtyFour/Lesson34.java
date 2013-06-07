package br.org.arthur.lessonThirtyFour;

import java.sql.*;


public class Lesson34 {
	public static void main(String[] args)
	{
		Connection conn = null;
		
		try
		{
			// It throws a ClassNotFoundException...
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/derek_java_lessons", "arthur", "artdna07");
			
			Statement sqlStatement = conn.createStatement();
			
			String sqlQuery = "SELECT * FROM customers";
			
			ResultSet rows = sqlStatement.executeQuery(sqlQuery);
			
			while(rows.next())
			{
				System.out.println(rows.getString("first_name"));
				System.out.println(rows.getString("birth_date"));
				System.out.println(rows.getString("money_owed"));
				System.out.println();
			}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) 
		{
			System.out.println("SQL Exception: " + e.getMessage());
			System.out.println("Vendor Error: " + e.getErrorCode());
			System.exit(0);
		} 
	}
}

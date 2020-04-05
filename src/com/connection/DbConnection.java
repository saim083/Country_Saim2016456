package com.connection;

import java.sql.*;

public class DbConnection {   
	private static Connection con;

	private DbConnection() {
	}

	public static Connection getConnection() throws SQLException {
		if (con == null) {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://52.50.23.197:3306/world", "cctstudent", "Pass1234!");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
}

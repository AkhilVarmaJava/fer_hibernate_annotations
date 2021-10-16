package com.rs.fer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getConnection() {
		Connection connection = null;
		// 1. Register the driver
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 2. Get the connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fer_jdbc", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return connection;

	}

	public static void closeConnection(Connection connection) {

		try {
			// close the connection
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

package com.joy.ers.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	private static String url = System.getenv("ERS_HOME");
	private static Connection conn;

	private ConnectionUtils() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(url);
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public static Connection getInstance() {

		return conn;

	}

}
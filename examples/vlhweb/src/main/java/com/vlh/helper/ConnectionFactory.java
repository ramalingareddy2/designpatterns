package com.vlh.helper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static Properties props;

	static {
		try {
			props = new Properties();
			props.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties"));
			Class.forName(props.getProperty("db.driverClassname"));
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException("failed in loading db configuration file", e);
		}
	}

	public static Connection newConnection() {
		Connection con = null;

		try {
			con = DriverManager.getConnection(props.getProperty("db.url"), props.getProperty("db.username"),
					props.getProperty("db.password"));
			con.setAutoCommit(false);
		} catch (SQLException e) {
			throw new RuntimeException("failed in getting database connection", e);
		}
		return con;
	}
}

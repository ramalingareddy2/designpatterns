package com.daop.helper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.daop.exception.GenericException;

public class ConnectionFactory {
	private static Properties dbProperties;

	static {
		dbProperties = new Properties();
		try {
			dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties"));
			Class.forName(dbProperties.getProperty("db.driverClassname"));
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new GenericException("unable to read the db.properties", e);
		}
	}

	public static Connection newConnection() {
		Connection con = null;

		try {
			con = DriverManager.getConnection(dbProperties.getProperty("db.url"),
					dbProperties.getProperty("db.username"), dbProperties.getProperty("db.password"));
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new GenericException("unable to open connection to database", e);
		}

		return con;
	}
}

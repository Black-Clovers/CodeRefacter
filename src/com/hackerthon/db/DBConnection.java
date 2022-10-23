package com.hackerthon.db;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private static DBConnection dbConnection;
	private final Connection connection;
	private final Properties properties;

	private DBConnection() throws ClassNotFoundException, SQLException, IOException {
		properties = new Properties();
		properties.load(new FileReader("src/com/hackerthon/utils/config.properties"));
		Class.forName(properties.getProperty("driverName"));
		connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),
				properties.getProperty("password"));
	}

	public static DBConnection getInstance() throws ClassNotFoundException, SQLException, IOException {
		if (dbConnection == null) {
			dbConnection = new DBConnection();
		}
		return dbConnection;
	}

	public Connection getConnection() {
		return connection;
	}

}

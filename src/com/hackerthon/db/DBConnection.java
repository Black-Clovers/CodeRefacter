package com.hackerthon.db;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private static DBConnection dbConnection;// create private static instance
	private final Connection connection; // create private final connection instance
	private final Properties properties; // create private final properties instance

	private DBConnection() throws ClassNotFoundException, SQLException, IOException {// create private constructor
		properties = new Properties();// create properties object and assign to properties instance
		properties.load(new FileReader("src/com/hackerthon/config/config.properties"));// load the properties file
		Class.forName(properties.getProperty("driverName"));// load the driver from properties file
		connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),
				properties.getProperty("password")); // create connection object and assign to connection instance
	}

	public static DBConnection getInstance()
			throws ClassNotFoundException, SQLException, IOException {// create public static getInstance method
		if (dbConnection == null) {// check whether dbConnection is null
			dbConnection = new DBConnection(); // if null create new DBConnection object and assign to dbConnection instance
		}
		return dbConnection;// if not null return dbConnection
	}

	public Connection getConnection() {// create public getConnection method
		return connection;// return connection
	}

}

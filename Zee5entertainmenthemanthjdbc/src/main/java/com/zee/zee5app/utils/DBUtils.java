package com.zee.zee5app.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
//this class is used to get and close the database collection
	Connection connection = null;
	static Properties properties;
	private DBUtils() throws IOException{
		// TODO Auto-generated constructor stub
		properties = this.loadProperties();
	}
	
	public static DBUtils dbutils;
	
	public static DBUtils getInstance() throws IOException {
		if(dbutils==null) {
			dbutils=new DBUtils();
			return dbutils;
		}
		return dbutils;
	}
	
	public Connection getConnection() {
		//connection with database
		
		//Properties properties;
		try {
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(properties.getProperty("jdbc.url"),
						properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password"));
				connection.setAutoCommit(false);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
		
	}
	
	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Properties loadProperties() throws IOException {
		//read the properties
		InputStream inputstream = DBUtils.class.getClassLoader().getResourceAsStream("application.properties");
		
		
		Properties properties = new Properties();
		properties.load(inputstream);// it will read the properties internally
		return properties;
		
	}
	
	public static void main(String[] args) throws IOException {
		
		DBUtils dbutils = DBUtils.getInstance();
		Connection connection = dbutils.getConnection();
		System.out.println(connection!=null);
		//closeConnection(connection);
	}
	
}

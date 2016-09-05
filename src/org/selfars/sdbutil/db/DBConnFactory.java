package org.selfars.sdbutil.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnFactory {
	
	private final String dbURL;
	private final String dbID;
	private final String dbPasswd;
	private final String dbDriverClass; 
	
	private static DBConnFactory instance = new DBConnFactory();
	
	public static DBConnFactory getInstance() {
		return instance;
	}
			
	private DBConnFactory() {
		Properties dbProps = new Properties();
		try {
			dbProps.load(getClass().getClassLoader().getResourceAsStream("resources/db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbURL = dbProps.getProperty("db.url");
		dbID = dbProps.getProperty("db.user");
		dbPasswd = dbProps.getProperty("db.password");
		dbDriverClass = dbProps.getProperty("db.driverClass");
	}

	public Connection getConnection() {
		Connection dbConn = null;
		
		try {
			Class.forName(dbDriverClass);
		} catch(ClassNotFoundException noClassEx) {
			noClassEx.printStackTrace(System.out);
		}
		
		try {
			dbConn = DriverManager.getConnection(dbURL, dbID, dbPasswd);
			//dbConn.createStatement().executeUpdate("create table contacts (name varchar(45),email varchar(45),phone varchar(45))");
		} catch(SQLException sqlEx) {
			sqlEx.printStackTrace(System.out);
		}
		
		return dbConn;
	}
}

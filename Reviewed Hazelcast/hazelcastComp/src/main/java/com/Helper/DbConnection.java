package com.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbConnection {
	
	public static Statement Connect()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:XE","system","oracle");
			return connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

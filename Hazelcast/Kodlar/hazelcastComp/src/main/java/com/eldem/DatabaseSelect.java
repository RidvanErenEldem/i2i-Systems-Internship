package com.eldem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseSelect {

	public static void main(String[] args) {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:XE","system","oracle");
			Statement smt = connection.createStatement();
			
			int number;
			long startTime = System.nanoTime();
			String select = "SELECT NUMBERS FROM HR.RANDNUM WHERE ID = ";
			for(int i = 0; i< 100000; i++)
			{
				ResultSet result = smt.executeQuery(select+i);
				result.next();
				number = result.getInt("NUMBERS");
			}
			long endTime = System.nanoTime()- startTime;
			double passedSeconds = (double)endTime / 1000000000.0;
			System.out.print(passedSeconds);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}

}

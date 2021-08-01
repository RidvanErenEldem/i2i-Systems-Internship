package com.eldem;

import java.sql.*;
import java.util.Random;

public class DatabaseInsert {

	public static void main(String[] args) {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:XE","system","oracle");
			Statement smt = connection.createStatement();
			
			Random rand = new Random();
			long startTime = System.nanoTime();
			String insert = "INSERT INTO HR.RANDNUM VALUES(";
			for(int i = 0; i< 100000; i++)
			{
				smt.executeUpdate(insert+ i+"," +rand.nextInt(100000)+")");
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

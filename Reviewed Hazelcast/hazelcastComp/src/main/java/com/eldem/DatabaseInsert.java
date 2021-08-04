package com.eldem;

import java.sql.*;
import java.util.Random;

import com.Helper.DbConnection;
import com.Helper.Timer;

public class DatabaseInsert {

	public static void main(String[] args) {
		try
		{
			Statement statement = DbConnection.Connect();
			
			Random random = new Random();
			Timer timer = new Timer();
			timer.StartTimer();
			String queryString = "INSERT INTO HR.RANDNUM VALUES(";
			for(int i = 0; i< 100000; i++)
			{
				statement.executeUpdate(queryString+ i+"," +random.nextInt(100000)+")");
			}
			timer.EndTimer();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}

	}

}

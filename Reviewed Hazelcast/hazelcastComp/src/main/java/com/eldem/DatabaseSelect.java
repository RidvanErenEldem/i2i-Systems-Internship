package com.eldem;

import java.sql.ResultSet;
import java.sql.Statement;

import com.Helper.DbConnection;
import com.Helper.Timer;

public class DatabaseSelect {

	public static void main(String[] args) {
		try
		{
			Statement statement = DbConnection.Connect();
			
			int number;
			Timer timer = new Timer();
			timer.StartTimer();
			String queryString = "SELECT NUMBERS FROM HR.RANDNUM WHERE ID = ";
			for(int i = 0; i< 100000; i++)
			{
				ResultSet result = statement.executeQuery(queryString+i);
				result.next();
				number = result.getInt("NUMBERS");
			}
			timer.EndTimer();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}

}

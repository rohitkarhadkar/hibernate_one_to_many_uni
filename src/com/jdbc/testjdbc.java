package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class testjdbc {

	public static void main(String[] args) {
		
		//String jdbcUrl = "jdbc:mysql://remotemysql.com:3306/SpOAczwTUg";
		//String user = "SpOAczwTUg";
		//String pass = "NR8Dm6VlKX";
		String jdbcUrl = "jdbc:mysql://localhost:33061/hb-04-one-to-many-uni?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			System.out.println("connecting to database: "+jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("connection successfull!!!");
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}

	}

}

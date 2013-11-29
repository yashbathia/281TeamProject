package com.laptop.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
	
	
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CON_URL = "jdbc:mysql://localhost/cmpe281";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "purpose";
	private static Connection con = null;
	public DBConnection()
	{}
	
	public static Connection getConnection()
	{
	
		   try {
			      Class.forName(DB_DRIVER).newInstance();
			      con = DriverManager.getConnection(DB_CON_URL,DB_USER, DB_PASSWORD);
			      if(con!= null && !con.isClosed())
				        System.out.println("Successfully connected to MySQL server using TCP/IP...");
	    
			    } catch(Exception e) {
			      System.err.println("Exception: " + e.getMessage());
			    } 

		
		return con;
	}
	
	public Connection getConnectionForTenent(int tenentId){
		
		String connectionURL = "jdbc:mysql://localhost/";
		String userId = "";
		String pwd = "";
		switch(tenentId)
		{
		case 1:
			connectionURL = connectionURL+"db_1";
			userId = "";
			pwd = "";
			break;
			
		case 2:
			connectionURL = connectionURL+"db_1";
			userId = "";
			pwd = "";
			break;
			
		case 3:
			connectionURL = connectionURL+"db_1";
			userId = "";
			pwd = "";
			break;
			
		case 4:
			connectionURL = connectionURL+"db_1";
			userId = "";
			pwd = "";
			break;
			
			
		}
		
		
		   try {
			      Class.forName(DB_DRIVER).newInstance();
			      con = DriverManager.getConnection(connectionURL,userId, pwd);
			      if(con!= null && !con.isClosed())
				        System.out.println("Successfully connected to MySQL server using TCP/IP...");
	    
			    } catch(Exception e) {
			      System.err.println("Exception: " + e.getMessage());
			    } 

		
		return con;
		
		
	}
	

}

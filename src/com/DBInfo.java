package com;

import java.sql.Connection;
import java.sql.DriverManager;



class DBInfo
{
	
	static Connection con;
	
	static
	{
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/login","root","root");
		}
		 catch(Exception e)
		 {
			e.printStackTrace();
		}
		
}
	
}

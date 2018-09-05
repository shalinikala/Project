package com;

import java.sql.Connection;
import java.sql.DriverManager;
class DBInfo1
{
	
	static Connection con1;
	
	static
	{
		
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			con1=DriverManager.getConnection("jdbc:mysql://localhost/fixed","root","root");
		}
		 catch(Exception e)
		 {
			e.printStackTrace();
		}
		
}
	
}
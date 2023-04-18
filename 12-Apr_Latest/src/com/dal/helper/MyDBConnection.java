package com.dal.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDBConnection {
	
	public static Connection con;
	public static Connection getDbConnection() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","abc123" );
			//jdbc:oracle:thin:@localhost:1521:xe
		} catch (SQLException e) {
						e.printStackTrace();
		}
		return con;
	}

	
	public static void main(String[] args) {
		System.out.println(getDbConnection());
	}

}

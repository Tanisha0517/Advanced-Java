package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestConnection {

	public static void main(String[] args) throws Exception {
		
		//Step 1 : Load Driver Class into the class loader
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Step 2 : Make connection to the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
		
		System.out.println("Connection established successfully....." +conn.getCatalog());
		
		
	}
}

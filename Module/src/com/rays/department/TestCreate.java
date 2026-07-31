package com.rays.department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestCreate {
	public static void main(String[] args) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("create table department(departmentId int primary key, departmentName varchar(50), hodName varchar(50), totalFaculty int, location varchar(50))");
		System.out.println("record inserted " + i + " row affected");
		
		

	}
}

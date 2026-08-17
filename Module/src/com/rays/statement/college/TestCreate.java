package com.rays.statement.college;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestCreate {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		
		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("create table college(collegeId int primary key, collegeName varchar(55), city varchar(45) , university varchar(50), contactNo int)");
		System.out.println("record inserted " + i + " row affected");
	}
}

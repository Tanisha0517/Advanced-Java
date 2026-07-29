package com.rays.department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("update department set departmentName= 'Information Technology' where departmentId = 7");

		System.out.println("Record inserted " + i + " rows affected");

	}
}

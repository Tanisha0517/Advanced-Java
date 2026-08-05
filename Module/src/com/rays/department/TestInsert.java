package com.rays.department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate(
			    "INSERT INTO department VALUES " +
			    "(42, 'Computer Science', 'Dr. Sharma', 25, 'Indore')"
//			    "(22, 'Information Technology', 'Dr. Gupta', 20, 'Bhopal')," +
//			    "(19, 'Mechanical', 'Dr. Verma', 18, 'Ujjain')," +
//			    "(20, 'Civil', 'Dr. Singh', 15, 'Dewas')," +
//			    "(21, 'Electronics', 'Dr. Patel', 22, 'Indore')," +
//			    "(22,'Computer Science' , 'Dr. Tanisha', 6, 'Ujjain')"
			);
		 System.out.println("Record inserted " + i + " rows affected");
	}
}

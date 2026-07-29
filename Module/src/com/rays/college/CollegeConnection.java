package com.rays.college;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CollegeConnection {
	public static void main(String[] args) throws Exception {

//		Step 1
		Class.forName("com.mysql.cj.jdbc.Driver");

//		Step 2
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		System.out.println("Connection established successfully....." + conn.getCatalog());
		// step 3. create Statement and get ResultSet or insert, update and delete
		// records
		Statement stmt = conn.createStatement();

		// step 4 get records
		ResultSet rs = stmt.executeQuery("select * from college");

		while (rs.next()) {
			System.out.println(rs.getInt("collegeId"));
			System.out.println(rs.getString("collegeName"));
			System.out.println(rs.getString("city"));
			System.out.println(rs.getString("university"));
			System.out.println(rs.getInt("contactNo"));

			System.out.println("--------------");
		}
	}

}

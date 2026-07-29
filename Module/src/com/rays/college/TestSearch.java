package com.rays.college;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSearch {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from college");

		while (rs.next()) {
			System.out.println(rs.getInt("collegeId"));
			System.out.println(rs.getString("collegeName"));
			System.out.println(rs.getString("city"));
			System.out.println(rs.getString("university"));
			System.out.println(rs.getString("contactNo"));

			System.out.println("--------------");

		}
	}
}

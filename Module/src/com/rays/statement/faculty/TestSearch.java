package com.rays.statement.faculty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSearch {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		conn.setAutoCommit(false); // Transaction begin

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from faculty");

		while (rs.next()) {
			System.out.println(rs.getInt("FacultyId"));
			System.out.println(rs.getString("FacultyName"));
			System.out.println(rs.getString("Subject"));
			System.out.println(rs.getString("Qualification"));
			System.out.println(rs.getInt("Experience"));

			System.out.println("--------------");
		}
	}
}

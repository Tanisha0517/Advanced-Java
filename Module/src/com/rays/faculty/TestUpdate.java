package com.rays.faculty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {
	public static void main(String[] args) throws Exception {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate("update faculty set facultyName= 'Prof. Isha' where facultyId = 6");

			System.out.println("Record inserted " + i + " rows affected");
			conn.commit();
		} catch (Exception e) {
			System.out.println("exception: " + e.getMessage());
			conn.rollback();
		} finally {
			conn.close(); // Transaction end
		}
	}
}

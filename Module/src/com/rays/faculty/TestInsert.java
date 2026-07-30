package com.rays.faculty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) throws Exception {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate("INSERT INTO faculty VALUES " + "(1, 'Dr. Sharma', 'Java', 'PhD', 15),"
					+ "(2, 'Prof. Gupta', 'Python', 'M.Tech', 10)," + "(3, 'Dr. Verma', 'Database', 'PhD', 12),"
					+ "(4, 'Prof. Singh', 'Computer Networks', 'M.Tech', 8),"
					+ "(5, 'Dr. Patel', 'Operating Systems', 'PhD', 14),"
					+ "(6, 'Prof. Joshi', 'Data Structures', 'M.E.', 7),"
					+ "(7, 'Dr. Mehta', 'Software Engineering', 'PhD', 11)");

			System.out.println("record inserted : " + i + " row affected");
			conn.commit();
		} catch (Exception e) {
			System.out.println("exception: " + e.getMessage());
			conn.rollback();
		} finally {
			conn.close(); // Transaction end
		}
	}
}

package com.rays.statement.faculty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestCreate {

	public static void main(String[] args) throws Exception {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			conn.setAutoCommit(false); // Transaction begin

			
			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate(
					"create table faculty(facultyId int primary key, facultyName varchar(50), subject varchar(50), qualification varchar(50), experience int )");

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

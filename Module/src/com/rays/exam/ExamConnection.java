package com.rays.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExamConnection {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		System.out.println("Connection Established Successfully !" + conn.getCatalog());

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select*from exam");

		while (rs.next()) {
			System.out.println(rs.getInt("examId"));
			System.out.println(rs.getString("examName"));
			System.out.println(rs.getDate("examDate"));
			System.out.println(rs.getInt("totalMarks"));
			System.out.println(rs.getInt("passingMarks"));

		}
	}
}

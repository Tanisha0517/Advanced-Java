package com.rays.department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSearch {
	public static void main(String[] args) throws Exception {

     Class.forName("com.mysql.cj.jdbc.Driver");
     
     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
     
   

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from department");

		while (rs.next()) {
			System.out.println(rs.getInt("departmentId"));
			System.out.println(rs.getString("departmentName"));
			System.out.println(rs.getString("hodName"));
			System.out.println(rs.getInt("totalFaculty"));
			System.out.println(rs.getString("location"));

			System.out.println("--------------");

		}
	}
}

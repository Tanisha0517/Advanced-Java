
//task - 28-7-2026
package com.rays.jdbc.marksheet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class CreateConnection {
	public static void main(String[] args) throws Exception {

		// Step 1 : Load Driver Class into the class loader
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2 : Make connection to the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		System.out.println("Connection established successfully....." + conn.getCatalog());

		// step 3. create Statement and get ResultSet or insert, update and delete
		// records
		Statement stmt = conn.createStatement();

		// step 4 get records
		ResultSet rs = stmt.executeQuery("select * from marksheet");

		while (rs.next()) {
			System.out.println("ID = "+rs.getInt("id"));
			System.out.println("Roll No = "+rs.getInt("rollno"));
			System.out.println("Name of Student = "+rs.getString("name"));
			System.out.println("Physics Marks = "+rs.getInt("phy"));
			System.out.println("Chemistry Marks = "+rs.getInt("chem"));
			System.out.println("Maths Marks = "+rs.getInt("maths"));
			
			
			System.out.println("----------------------------------------");
			
			
			int total = (rs.getInt("phy")+rs.getInt("Chem")+rs.getInt("maths"));
			System.out.println("Total : " +total);
			
			
			double percentage = (total/3);
			System.out.println("Percentage : " +percentage);
			
			
		}
	}
}

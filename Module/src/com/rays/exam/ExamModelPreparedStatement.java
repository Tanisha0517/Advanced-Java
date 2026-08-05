package com.rays.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class ExamModelPreparedStatement {

	public void create() throws SQLException {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

//			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"create table exam(examID int primary key, examName varchar(50), examDate date, totalMarks varchar(50), passingMarks varchar(50))");

			int i = pstmt.executeUpdate();
//			conn.commit();
			System.out.println("Table created  successfully");
		} catch (Exception e) {
			e.printStackTrace();
//			conn.rollback();
		} finally {
			conn.close();
		}
	}
		
//		--------------------------------------------------------------------------------------
		
		public void insert(int examId, String examName,  Date examDate, int totalMarks, int passingMarks)
				throws SQLException {

			Connection conn = null;

			try {

				Class.forName("com.mysql.cj.jdbc.Driver");

				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

				conn.setAutoCommit(false);

				PreparedStatement pstmt = conn.prepareStatement("insert into exam values(?, ?, ?, ?, ?)");

				pstmt.setInt(1, examId);
				pstmt.setString(2, examName);
				pstmt.setDate(3, new java.sql.Date(examDate.getTime()));
				pstmt.setInt(4, totalMarks);
				pstmt.setInt(5, passingMarks);
				

				int i = pstmt.executeUpdate();

				conn.commit();

				System.out.println("record inserted successfully: " + i);

			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			} finally {
				conn.close();
			}

		}
		
//		--------------------------------------------------------------------------------------
		
		public void update(int examId, String examName,  Date examDate, int totalMarks, int passingMarks)
				throws SQLException {

			Connection conn = null;

			try {

				Class.forName("com.mysql.cj.jdbc.Driver");

				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

				conn.setAutoCommit(false);

				PreparedStatement pstmt = conn.prepareStatement(
						"update exam set examName = ?, examDate = ?, totalMarks = ?, passingMarks = ? where examId = ?");

				
				pstmt.setString(1, examName);
				pstmt.setDate(2, new java.sql.Date(examDate.getTime()));
				pstmt.setInt(3, totalMarks);
				pstmt.setInt(4, passingMarks);
				pstmt.setInt(5, examId);
				
				
				int i = pstmt.executeUpdate();

				conn.commit();

				System.out.println("record updated successfully: " + i);

			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			} finally {
				conn.close();
			}

		}

//		-------------------------------------------------------------------------
		
		public void delete(int examId) throws SQLException {

			Connection conn = null;

			try {

				Class.forName("com.mysql.cj.jdbc.Driver");

				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

				conn.setAutoCommit(false);

				PreparedStatement pstmt = conn.prepareStatement("delete from exam where examId = ?");

				pstmt.setInt(1, examId);

				int i = pstmt.executeUpdate();

				conn.commit();

				System.out.println("record delete successfully: " + i);

			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			} finally {
				conn.close();
			}

		}

	}
		
		

	



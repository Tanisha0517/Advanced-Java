package com.rays.result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.rays.util.JDBCDataSource;

public class ResultModel {
	public void create() throws SQLException {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"create table result(resultID int auto_increment primary key, studentId int ,percentage int ,grade varchar(45),resultStatus varchar(45))");
			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Table created  successfully"+i);
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

//	-----------------------------------------------------------------------------

	public void add(ResultBean bean) throws Exception {

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into result values(?, ?, ?, ?, ?)");

			pstmt.setInt(1, bean.getResultId());
			pstmt.setInt(2, bean.getStudentId());
			pstmt.setInt(3, bean.getPercentage());
			pstmt.setString(4, bean.getGrade());
			pstmt.setString(5, bean.getResultStatus());

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

//		--------------------------------------------------------------------------------------------

	public void update(ResultBean bean) throws Exception {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update result set studentId = ?, percentage = ?, grade = ?, resultStatus = ? where resultId = ?");

			pstmt.setInt(1, bean.getStudentId());
			pstmt.setInt(2, bean.getPercentage());
			pstmt.setString(3, bean.getGrade());
			pstmt.setString(4, bean.getResultStatus());
			pstmt.setInt(5, bean.getResultId());

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
//		-------------------------------------------------------------------------------------

	public void delete( int resultId) throws Exception {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from result where resultId = ?");

			pstmt.setInt(1, resultId);

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

package com.rays.jdbc.preparedstmt;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.rays.jdbc.util.JDBCDataSource;

public class MarkSheetModel {
	public static void add(MarkSheetBean bean) throws Exception {

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?, ?)");

			pstmt.setInt(1, bean.getId());
			pstmt.setInt(2, bean.getRollno());
			pstmt.setString(3, bean.getName());
			pstmt.setInt(4, bean.getPhy());
			pstmt.setInt(5, bean.getChem());
			pstmt.setInt(6, bean.getMaths());

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
		
//		-------------------------------------------------------------------------------------
		
		
		public void update(MarkSheetBean bean) throws Exception {

			Connection conn = null;

			try {

				conn = JDBCDataSource.getConnection();

				conn.setAutoCommit(false);

				PreparedStatement pstmt = conn.prepareStatement(
						"update marksheet set rollno = ?, name = ?, phy = ?, chem = ?, maths = ? where id = ?");

				pstmt.setInt(1, bean.getRollno());
				pstmt.setString(2, bean.getName());
				pstmt.setInt(3, bean.getPhy());
				pstmt.setInt(4, bean.getChem());
				pstmt.setInt(5, bean.getMaths());
				pstmt.setInt(6, bean.getId());

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

		public void delete(int id) throws Exception {

			Connection conn = null;

			try {

				conn = JDBCDataSource.getConnection();

				conn.setAutoCommit(false);

				PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where id = ?");

				pstmt.setInt(1, id);

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

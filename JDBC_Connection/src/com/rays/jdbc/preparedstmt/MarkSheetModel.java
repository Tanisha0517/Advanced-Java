package com.rays.jdbc.preparedstmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

//		--------------------------------

	public List<MarkSheetBean> search(MarkSheetBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = null;
		List<MarkSheetBean> list = new ArrayList<MarkSheetBean>();
		try {
			conn = JDBCDataSource.getConnection();

			

			PreparedStatement pstmt = conn.prepareStatement("select *, (phy+chem+maths) as total, ((phy+chem+maths)/3) as percentage, if(phy >= 33 and chem >= 33 and maths >= 33, 'pass', 'fail') as result from marksheet order by total desc;");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new MarkSheetBean();
				bean.setId(rs.getInt("id"));
				bean.setRollno(rs.getInt("rollno"));
				bean.setName(rs.getString("name"));
				bean.setPhy(rs.getInt("phy"));
				bean.setChem(rs.getInt("chem"));
				bean.setMaths(rs.getInt("maths"));
				
				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return list;

	}

}

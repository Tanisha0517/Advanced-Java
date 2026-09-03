package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.DoctorBean;
import com.rays.util.JDBCDataSource;

public class DoctorModel {

	public int nextPk() throws SQLException {

		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max(id) from doctor");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk + 1; // return next auto-increment non-business primary key
	}

//	---------------------------------------------Insert--------------------------------------------------

	public void add(DoctorBean bean) throws Exception {

		Connection conn = null;

		DoctorBean existBean = findByDoctorId(bean.getDoctorId());
		int pk = 0;

		if (existBean != null) {
			throw new RuntimeException("Doctor Id already exists");
		}

		try {

			pk = nextPk();
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into doctor values(?, ?, ?, ?, ?, ?)");

			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getDoctorId());
			pstmt.setString(3, bean.getDoctorName());
			pstmt.setString(4, bean.getSpecialization());
			pstmt.setInt(5, bean.getExperience());
			pstmt.setString(6, bean.getContactNo());

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("record inserted successfully: " + i);

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.trnRollBack(conn);
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

	}

//	---------------------------------------------Update--------------------------------------------------

//	public void update(UserBean bean) throws Exception {
//
//		Connection conn = null;
//
//		try {
//
//			conn = JDBCDataSource.getConnection();
//
//			conn.setAutoCommit(false);
//
//			PreparedStatement pstmt = conn.prepareStatement(
//					"update st_user set firstName = ?, lastName = ?, loginId = ?, password = ?, dob = ? where id = ?");
//
//			pstmt.setString(1, bean.getFirstName());
//			pstmt.setString(2, bean.getLastName());
//			pstmt.setString(3, bean.getLoginId());
//			pstmt.setString(4, bean.getPassword());
//			pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
//			pstmt.setInt(6, bean.getId());
//
//			int i = pstmt.executeUpdate();
//
//			conn.commit();
//
//			System.out.println("record updated successfully: " + i);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			conn.rollback();
//		} finally {
//			conn.close();
//		}
//
//	}

//	---------------------------------------------Delete--------------------------------------------------
	public void delete(int id) throws Exception {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from doctor where id = ?");

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

//	-------------------------------findByDoctorId()--------------------------------------
	public DoctorBean findByDoctorId(String doctorId) throws SQLException {

		Connection conn = null;
		DoctorBean bean = null;

		try {

			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select * from doctor where doctorId = ?");

			pstmt.setString(1, doctorId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new DoctorBean();
				bean.setId(rs.getInt("id"));
				bean.setDoctorId(rs.getString("doctorId"));
				bean.setDoctorName(rs.getString("doctorName"));
				bean.setSpecialization(rs.getString("specialization"));
				bean.setExperience(rs.getInt("experience"));
				bean.setContactNo(rs.getString("contactNo"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return bean;

	}

//	-----------------------------------------Search - findbypk--------------------------------------------

	public DoctorBean findByPk(int id) throws Exception {

		Connection conn = null;
		DoctorBean bean = null;

		try {

			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select * from doctor where id = ?");

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new DoctorBean();
				bean.setId(rs.getInt("id"));
				bean.setDoctorId(rs.getString("doctorId"));
				bean.setDoctorName(rs.getString("doctorName"));
				bean.setSpecialization(rs.getString("specialization"));
				bean.setExperience(rs.getInt("experience"));
				bean.setContactNo(rs.getString("contactNo"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return bean;

	}

//	-----------------------------------------------Search -------------------------------------------------

	public List<DoctorBean> search(DoctorBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = null;
		List<DoctorBean> list = new ArrayList<DoctorBean>();
		StringBuffer sql = new StringBuffer("select * from doctor where 1=1 ");

		if (bean != null) {
			if (bean.getDoctorId() != null && bean.getDoctorId().length() > 0) {
				sql.append("and doctorId like '" + bean.getDoctorId() + "%' ");
			}
			if (bean.getDoctorName() != null && bean.getDoctorName().length() > 0) {
				sql.append("and doctorName like '" + bean.getDoctorName() + "%' ");
			}
			if (bean.getSpecialization() != null && bean.getSpecialization().length() > 0) {
				sql.append("and specialization like '" + bean.getSpecialization() + "%' ");
			}
			if (bean.getExperience() > 0) {
				sql.append("and experience = " + bean.getExperience() + " ");
			}
			if (bean.getContactNo() != null && bean.getContactNo().length() > 0) {
				sql.append("and contactNo like '" + bean.getContactNo() + "%' ");
			}
		}

		if (pageSize > 0) {
			int index = (pageNo - 1) * pageSize;
			sql.append("limit " + index + ", " + pageSize);
		}

		conn = JDBCDataSource.getConnection();

		System.out.println("sql search query ====> " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new DoctorBean();
			bean.setId(rs.getInt("id"));
			bean.setDoctorId(rs.getString("doctorId"));
			bean.setDoctorName(rs.getString("doctorName"));
			bean.setSpecialization(rs.getString("specialization"));
			bean.setExperience(rs.getInt("experience"));
			bean.setContactNo(rs.getString("contactNo"));
			list.add(bean);
		}

		try {

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return list;

	}

}

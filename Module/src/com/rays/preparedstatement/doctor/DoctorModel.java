package com.rays.preparedstatement.doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.util.JDBCDataSource;

public class DoctorModel {

//	--------------------------------------Create-------------------------------------------
	public void create() throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"create table doctor(doctorId Bigint primary key, doctorName varchar(50), specialization varchar(50), experience int, contactNo varchar(50))");
			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Table created successfully");

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

//	----------------------------------------Insert----------------------------------------------

	public void insert(DoctorBean bean) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into doctor values(?,?,?,?,?)");

			pstmt.setLong(1, bean.getDoctorId());
			pstmt.setString(2, bean.getDoctorName());
			pstmt.setString(3, bean.getSpecialization());
			pstmt.setInt(4, bean.getExperience());
			pstmt.setString(5, bean.getContactNo());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record inserted successfully");

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

//	------------------------------------------------Update--------------------------------------------------

	public void update(DoctorBean bean) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update doctor set doctorName = ?, specialization = ?, experience = ?, contactNo = ? where doctorId = ?");

			pstmt.setString(1, bean.getDoctorName());
			pstmt.setString(2, bean.getSpecialization());
			pstmt.setInt(3, bean.getExperience());
			pstmt.setString(4, bean.getContactNo());
			pstmt.setLong(5, bean.getDoctorId());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record updated successfully");

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

//	--------------------------------------------Delete----------------------------------------------------
	public void delete(long doctorId) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from doctor where doctorId = ?");

			pstmt.setLong(1, doctorId);

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record deleted successfully");

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

//	--------------------------------------------Search-----------------------------------------------------
	public List<DoctorBean> search(DoctorBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = null;
		List<DoctorBean> list = new ArrayList<DoctorBean>();
		StringBuffer sql = new StringBuffer("select * from doctor where 1=1 ");

		try {

			conn = JDBCDataSource.getConnection();

			System.out.println("sql search query ====> " + sql.toString());

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new DoctorBean();
				bean.setDoctorId(rs.getLong("doctorid"));
				bean.setDoctorName(rs.getString("doctorName"));
				bean.setSpecialization(rs.getString("specialization"));
				bean.setExperience(rs.getInt("experience"));
				bean.setContactNo(rs.getString("contactNo"));

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

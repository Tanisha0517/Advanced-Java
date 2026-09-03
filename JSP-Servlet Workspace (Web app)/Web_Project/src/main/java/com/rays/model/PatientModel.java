package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.PatientBean;

import com.rays.util.JDBCDataSource;

public class PatientModel {

//	----------------------------nextPk()-------------------------------------
	public int nextPk() throws SQLException {

		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max(id) from patient");
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

//	----------------------------add()-------------------------------------
	public void add(PatientBean bean) throws SQLException {

		Connection conn = null;
		PatientBean existBean = findByPatientId(bean.getPatientId());
		int pk = 0;

		if (existBean != null) {
			throw new RuntimeException("Patient Id already exists");
		}

		try {
			pk = nextPk();
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into patient values(?, ?, ?, ?, ?, ?)");

			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getPatientId());
			pstmt.setString(3, bean.getPatientName());
			pstmt.setString(4, bean.getDisease());
			pstmt.setString(5, bean.getDoctorName());
			pstmt.setDate(6, new java.sql.Date(bean.getAdmissionDate().getTime()));

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

//	------------------------------------------delete()-----------------------------------------------
	public void delete(int id) throws Exception {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from patient where id = ?");

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
	
//	-------------------------------------------findByPk()--------------------------------------------
	public PatientBean findByPk(int id) throws SQLException {

		Connection conn = null;
		PatientBean bean = null;

		try {

			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select * from patient where id = ?");

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new PatientBean();
				bean.setId(rs.getInt("id"));
				bean.setPatientId(rs.getString("patientId"));
				bean.setPatientName(rs.getString("patientName"));
				bean.setDisease(rs.getString("disease"));
				bean.setDoctorName(rs.getString("doctorName"));
				bean.setAdmissionDate(rs.getDate("admissionDate"));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean;

	}


//	-------------------------------------------search()----------------------------------------------
	public List<PatientBean> search(PatientBean bean, int pageNo, int pageSize) throws SQLException {
		Connection conn = null;

		List<PatientBean> list = new ArrayList<PatientBean>();
		StringBuffer sql = new StringBuffer("select * from patient where 1=1 ");

		if (bean != null) {
			if (bean.getPatientId() != null && bean.getPatientId().length() > 0) {
				sql.append("and patientId like '" + bean.getPatientId() + "%' ");
			}
			if (bean.getPatientName() != null && bean.getPatientName().length() > 0) {
				sql.append("and patientName like '" + bean.getPatientName() + "%' ");
			}
			if (bean.getDisease() != null && bean.getDisease().length() > 0) {
				sql.append("and disease like '" + bean.getDisease() + "%' ");
			}
			if (bean.getDoctorName() != null && bean.getDoctorName().length() > 0) {
				sql.append("and doctorName like '" + bean.getDoctorName() + "%' ");
			}
			if (bean.getAdmissionDate() != null && bean.getAdmissionDate().getTime() > 0) {
				sql.append("and addmisionDate like '" + bean.getAdmissionDate() + "'% ");
			}

			if (pageSize > 0) {
				int index = (pageNo - 1) * pageSize;
				sql.append("limit " + index + ", " + pageSize);
			}

			try {
				conn = JDBCDataSource.getConnection();

				System.out.println("sql search query ====> " + sql.toString());

				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					bean = new PatientBean();
					bean.setId(rs.getInt("id"));
					bean.setPatientId(rs.getString("patientId"));
					bean.setPatientName(rs.getString("patientName"));
					bean.setDisease(rs.getString("disease"));
					bean.setDoctorName(rs.getString("doctorName"));
					bean.setAdmissionDate(rs.getDate("admissionDate"));
					list.add(bean);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn.close();
			}

		}
		return list;
	}
//	------------------------------------findByProductId()---------------------------------------

	public PatientBean findByPatientId(String patientId) throws SQLException {

		Connection conn = null;
		PatientBean bean = null;

		try {

			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select * from patient where patientId = ?");

			pstmt.setString(1, patientId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new PatientBean();
				bean.setId(rs.getInt("id"));
			    bean.setPatientId(rs.getString("patientId"));
			    bean.setPatientName(rs.getString("patientName"));
			    bean.setDisease(rs.getString("disease"));
			    bean.setDoctorName(rs.getString("doctorName"));
			    bean.setAdmissionDate(rs.getDate("admissionDate"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean;

	}

}

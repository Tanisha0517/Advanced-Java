package com.rays.preparedstatement.patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.util.JDBCDataSource;

public class PatientModel {

//------------------------------------------------------Create----------------------------------------------------
	public void create() throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"create table patient(patientId Bigint primary key, patientName varchar(50), disease varchar(50), doctorName varchar(50), admissionDate date)");
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

//	------------------------------------------------------Insert----------------------------------------------------
	public void insert(PatientBean bean) throws Exception {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into patient values(?,?,?,?,?)");

			pstmt.setLong(1, bean.getPatientId());
			pstmt.setString(2, bean.getPatientName());
			pstmt.setString(3, bean.getDisease());
			pstmt.setString(4, bean.getDoctorName());
			pstmt.setDate(5, new java.sql.Date(bean.getAdmissionDate().getTime()));

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record Inserted Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

//	------------------------------------------------------Update----------------------------------------------------
	public void update(PatientBean bean) throws Exception {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update patient set patientName = ?, disease = ?, doctorName = ?, admissionDate = ? where patientId = ?");

			pstmt.setString(1, bean.getPatientName());
			pstmt.setString(2, bean.getDisease());
			pstmt.setString(3, bean.getDoctorName());
			pstmt.setDate(4, new java.sql.Date(bean.getAdmissionDate().getTime()));
			pstmt.setLong(5, bean.getPatientId());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record Updated Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

//	------------------------------------------------------Delete----------------------------------------------------
	public void delete(long patientId) throws Exception {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from patient where patientId = ?");

			pstmt.setLong(1, patientId);

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record Deleted Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

//	------------------------------------------------------Search----------------------------------------------------

	public List<PatientBean> search(PatientBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = null;
		List<PatientBean> list = new ArrayList<PatientBean>();
		StringBuffer sql = new StringBuffer("select * from patient where 1=1 ");

		try {

			conn = JDBCDataSource.getConnection();

			System.out.println("sql search query ====> " + sql.toString());

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new PatientBean();
				bean.setPatientId(rs.getLong("patientid"));
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

		return list;

	}
}

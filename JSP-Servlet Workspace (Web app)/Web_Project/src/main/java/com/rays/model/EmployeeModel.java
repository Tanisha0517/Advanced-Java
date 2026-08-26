package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.EmployeeBean;

import com.rays.util.JDBCDataSource;

public class EmployeeModel {

//	----------------------------nextPk()-------------------------------------
	public int nextPk() throws SQLException {

		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max(id) from employee");
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
	public void add(EmployeeBean bean) throws SQLException {

		Connection conn = null;
		EmployeeBean existBean = findByEmployeeCode(bean.getEmployeeCode());
		int pk = 0;

		if (existBean != null) {
			throw new RuntimeException("Employee Code already exists");
		}

		try {
			pk = nextPk();
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into employee values(?, ?, ?, ?, ?, ?)");

			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getEmployeeCode());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getDesignation());
			pstmt.setDouble(5, bean.getSalary());
			pstmt.setDate(6, new java.sql.Date(bean.getJoinDate().getTime()));

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

	
	
	
//	-------------------------------------------search()----------------------------------------------
	public List<EmployeeBean> search(EmployeeBean bean, int pageNo, int pageSize) throws SQLException {
		Connection conn = null;

		List<EmployeeBean> list = new ArrayList<EmployeeBean>();
		StringBuffer sql = new StringBuffer("select * from employee where 1=1 ");

		try {
//		if (bean != null) {
//			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
//				sql.append("and firstName like '" + bean.getFirstName() + "%' ");
//			}
//			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
//				sql.append("and lastName like '" + bean.getLastName() + "%' ");
//			}
//			if (bean.getLoginId() != null && bean.getLoginId().length() > 0) {
//				sql.append("and loginId like '" + bean.getLoginId() + "%' ");
//			}
//			if (bean.getPassword() != null && bean.getPassword().length() > 0) {
//				sql.append("and password like '" + bean.getPassword() + "%' ");
//			}
//			if (bean.getDob() != null && bean.getDob().getTime() > 0) {
//				sql.append("and dob like '" + new java.sql.Date(bean.getDob().getTime()) + "'% ");
//			}
//		}
//
			if (pageSize > 0) {
				int index = (pageNo - 1) * pageSize;
				sql.append("limit " + index + ", " + pageSize);
			}

			conn = JDBCDataSource.getConnection();

			System.out.println("sql search query ====> " + sql.toString());

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new EmployeeBean();
				bean.setId(rs.getInt("id"));
				bean.setEmployeeCode(rs.getString("employee_code"));
				bean.setName(rs.getString("name"));
				bean.setDesignation(rs.getString("designation"));
				bean.setSalary(rs.getDouble("salary"));
				bean.setJoinDate(rs.getDate("joiningDate"));
				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return list;

	}
	
	
	
//	------------------------------------findByProductId()---------------------------------------
	
	public EmployeeBean findByEmployeeCode(String employeeCode) throws SQLException {

		Connection conn = null;
		EmployeeBean bean = null;

		try {

			
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select * from employee where employeeCode = ?");

			pstmt.setString(1, employeeCode);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new EmployeeBean();
				bean.setId(rs.getInt("id"));
				pstmt.setString(2, bean.getEmployeeCode());
				pstmt.setString(3, bean.getName());
				pstmt.setString(4, bean.getDesignation());
				pstmt.setDouble(5, bean.getSalary());
				pstmt.setDate(6, new java.sql.Date(bean.getJoinDate().getTime()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean;

	}
	
}

package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.CustomerBean;

import com.rays.util.JDBCDataSource;

public class CustomerModel {

//	----------------------------nextPk()-------------------------------------
	public int nextPk() throws SQLException {

		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max(id) from customer");
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
	public void add(CustomerBean bean) throws SQLException {

		Connection conn = null;
		CustomerBean existBean = findByCustomerId(bean.getCustomerId());
		int pk = 0;

		if (existBean != null) {
			throw new RuntimeException("Customer Id already exists");
		}

		try {
			pk = nextPk();
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into customer values(?, ?, ?, ?, ?, ?)");

			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getCustomerId());
			pstmt.setString(3, bean.getCustomerName());
			pstmt.setString(4, bean.getEmail());
			pstmt.setString(5, bean.getPhoneNo());
			pstmt.setString(6, bean.getAddress());

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
	public List<CustomerBean> search(CustomerBean bean, int pageNo, int pageSize) throws SQLException {
		Connection conn = null;

		List<CustomerBean> list = new ArrayList<CustomerBean>();
		StringBuffer sql = new StringBuffer("select * from customer where 1=1 ");

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
				bean = new CustomerBean();
				bean.setId(rs.getInt("id"));
				bean.setCustomerId(rs.getString("customerId"));
				bean.setCustomerName(rs.getString("customerName"));
				bean.setEmail(rs.getString("email"));
				bean.setPhoneNo(rs.getString("phoneNumber"));
				bean.setAddress(rs.getString("address"));
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

	public CustomerBean findByCustomerId(String customerId) throws SQLException {

		Connection conn = null;
		CustomerBean bean = null;

		try {

			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select * from customer where customerId = ?");

			pstmt.setString(1, customerId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new CustomerBean();
				bean.setId(rs.getInt("id"));
				pstmt.setString(2, bean.getCustomerId());
				pstmt.setString(3, bean.getCustomerName());
				pstmt.setString(4, bean.getEmail());
				pstmt.setString(5, bean.getPhoneNo());
				pstmt.setString(6, bean.getAddress());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean;

	}

}

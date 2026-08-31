package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.OrderBean;
import com.rays.util.JDBCDataSource;

public class OrderModel {

//	----------------------------nextPk()-------------------------------------
	public int nextPk() throws SQLException {

		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max(id) from orders");
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
	public void add(OrderBean bean) throws SQLException {

		Connection conn = null;
		OrderBean existBean = findByOrderId(bean.getOrderId());
		int pk = 0;

		if (existBean != null) {
			throw new RuntimeException("Order Id already exists");
		}

		try {
			pk = nextPk();
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into orders values(?, ?, ?, ?, ?)");

			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getOrderId());
			pstmt.setDate(3, new java.sql.Date(bean.getOrderDate().getTime()));
			pstmt.setDouble(4, bean.getAmount());
			pstmt.setString(5, bean.getStatus());
//			pstmt.setString(6, (bean.getCustomerId()));

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
	public List<OrderBean> search(OrderBean bean, int pageNo, int pageSize) throws SQLException {
		Connection conn = null;

		List<OrderBean> list = new ArrayList<OrderBean>();
		StringBuffer sql = new StringBuffer("select * from orders where 1=1 ");

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
				bean = new OrderBean();
				bean.setId(rs.getInt("id"));
				bean.setOrderId(rs.getString("orderId"));
				bean.setOrderDate(rs.getDate("orderDate"));
				bean.setAmount(rs.getDouble("amount"));
				bean.setStatus(rs.getString("status"));
//				bean.setCustomerId(rs.getString("customerId"));
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

	public OrderBean findByOrderId(String orderId) throws SQLException {

		Connection conn = null;
		OrderBean bean = null;

		try {

			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select * from orders where orderId = ?");

			pstmt.setString(1, orderId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new OrderBean();
				bean.setId(rs.getInt("id"));
				pstmt.setString(2, bean.getOrderId());
				pstmt.setDate(3, new java.sql.Date(bean.getOrderDate().getTime()));
				pstmt.setDouble(4, bean.getAmount());
				pstmt.setString(5, bean.getStatus());
//				pstmt.setString(6, (bean.getCustomerId()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean;

	}

}

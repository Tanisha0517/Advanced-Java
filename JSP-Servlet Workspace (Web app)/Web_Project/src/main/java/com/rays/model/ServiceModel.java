package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.ServiceBean;
import com.rays.util.JDBCDataSource;

public class ServiceModel {
	public int nextPk() throws SQLException {

		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max(id) from service");
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

	
	
	
	public void add(ServiceBean bean) throws SQLException {

		Connection conn = null;
		ServiceBean existBean = findByServiceId(bean.getServiceId());
		int pk = 0;

		if (existBean != null) {
			throw new RuntimeException("Servide Id already exists");
		}

		try {
			pk = nextPk();
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into service values(?, ?, ?, ?, ?, ?)");

			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getServiceId());
			pstmt.setString(3, bean.getServiceName());
			pstmt.setString(4, bean.getPrice());
			pstmt.setString(5, bean.getDescription());
			pstmt.setString(6, (bean.getServiceCategory()));

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

	public List<ServiceBean> search(ServiceBean bean, int pageNo, int pageSize) throws SQLException {
		Connection conn = null;

		List<ServiceBean> list = new ArrayList<ServiceBean>();
		StringBuffer sql = new StringBuffer("select * from service where 1=1 ");

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
				bean = new ServiceBean();
				bean.setId(rs.getInt("id"));
				bean.setServiceId(rs.getString("serviceId"));
				bean.setServiceName(rs.getString("serviceName"));
				bean.setPrice(rs.getString("Price"));
				bean.setDescription(rs.getString("description"));
				bean.setServiceCategory(rs.getString("serviceCategory"));
				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return list;

	}
	
	
	
	
	
	public ServiceBean findByServiceId(String serviceId) throws SQLException {

		Connection conn = null;
		ServiceBean bean = null;

		try {

			
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select * from service where id = ?");

			pstmt.setString(1, serviceId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new ServiceBean();
				bean.setId(rs.getInt("id"));
				bean.setServiceId(rs.getString("serviceId"));
				bean.setServiceName(rs.getString("serviceName"));
				bean.setPrice(rs.getString("price"));
				bean.setDescription(rs.getString("description"));
				bean.setServiceCategory(rs.getString("serviceCategory"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean;

	}

}

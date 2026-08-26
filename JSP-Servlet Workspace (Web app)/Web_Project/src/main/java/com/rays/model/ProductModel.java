package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.rays.bean.ProductBean;
import com.rays.util.JDBCDataSource;

public class ProductModel {

	
//	----------------------------nextPk()-------------------------------------
	public int nextPk() throws SQLException {

		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max(id) from product");
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
	public void add(ProductBean bean) throws SQLException {

		Connection conn = null;
		ProductBean existBean = findByProductId(bean.getProductId());
		int pk = 0;

		if (existBean != null) {
			throw new RuntimeException("Product Id already exists");
		}

		try {
			pk = nextPk();
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into product values(?, ?, ?, ?, ?, ?)");

			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getProductId());
			pstmt.setString(3, bean.getProductName());
			pstmt.setString(4, bean.getPrice());
			pstmt.setString(5, bean.getQuantity());
			pstmt.setString(6, (bean.getCategory()));

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
	public List<ProductBean> search(ProductBean bean, int pageNo, int pageSize) throws SQLException {
		Connection conn = null;

		List<ProductBean> list = new ArrayList<ProductBean>();
		StringBuffer sql = new StringBuffer("select * from product where 1=1 ");

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
				bean = new ProductBean();
				bean.setId(rs.getInt("id"));
				bean.setProductId(rs.getString("productId"));
				bean.setProductName(rs.getString("productName"));
				bean.setPrice(rs.getString("price"));
				bean.setQuantity(rs.getString("quantity"));
				bean.setCategory(rs.getString("category"));
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
	
	public ProductBean findByProductId(String productId) throws SQLException {

		Connection conn = null;
		ProductBean bean = null;

		try {

			
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select * from product where productId = ?");

			pstmt.setString(1, productId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new ProductBean();
				bean.setId(rs.getInt("id"));
				pstmt.setString(2, bean.getProductId());
				pstmt.setString(3, bean.getProductName());
				pstmt.setString(4, bean.getPrice());
				pstmt.setString(5, bean.getQuantity());
				pstmt.setString(6, (bean.getCategory()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean;

	}
}

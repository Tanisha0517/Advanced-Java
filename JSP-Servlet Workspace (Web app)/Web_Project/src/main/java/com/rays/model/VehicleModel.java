package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.CustomerBean;
import com.rays.bean.VehicleBean;
import com.rays.util.JDBCDataSource;

public class VehicleModel {

//	----------------------------nextPk()-------------------------------------
	public int nextPk() throws SQLException {

		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max(id) from vehicle");
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
	public void add(VehicleBean bean) throws SQLException {

		Connection conn = null;
		VehicleBean existBean = findByVehicleNo(bean.getVehicleNo());
		int pk = 0;

		if (existBean != null) {
			throw new RuntimeException("Vehicle Number already exists");
		}

		try {
			pk = nextPk();
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into vehicle values(?, ?, ?, ?, ?, ?)");

			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getVehicleNo());
			pstmt.setString(3, bean.getVehicleName());
			pstmt.setString(4, bean.getModel());
			pstmt.setString(5, bean.getColor());
			pstmt.setDouble(6, bean.getPrice());

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
	public List<VehicleBean> search(VehicleBean bean, int pageNo, int pageSize) throws SQLException {
		Connection conn = null;

		List<VehicleBean> list = new ArrayList<VehicleBean>();
		StringBuffer sql = new StringBuffer("select * from vehicle where 1=1 ");

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
				bean = new VehicleBean();
				bean.setId(rs.getInt("id"));
				bean.setVehicleNo(rs.getString("vehicleNo"));
				bean.setVehicleName(rs.getString("vehicleName"));
				bean.setModel(rs.getString("model"));
				bean.setColor(rs.getString("color"));
				bean.setPrice(rs.getDouble("price"));
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

	public VehicleBean findByVehicleNo(String vehicleNo) throws SQLException {

		Connection conn = null;
		VehicleBean bean = null;

		try {

			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select * from vehicle where vehicleNo = ?");

			pstmt.setString(1, vehicleNo);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new VehicleBean();
				bean.setId(rs.getInt("id"));
				pstmt.setString(2, bean.getVehicleNo());
				pstmt.setString(3, bean.getVehicleName());
				pstmt.setString(4, bean.getModel());
				pstmt.setString(5, bean.getColor());
				pstmt.setDouble(6, bean.getPrice());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean;

	}

}

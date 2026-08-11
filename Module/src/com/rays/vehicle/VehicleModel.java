package com.rays.vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.util.JDBCDataSource;

public class VehicleModel {

//	---------------------------------------------Create-------------------------------------------------------

	public void create() throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"create table vehicle (vehicleId Bigint PRIMARY KEY, vehicleName varchar(50), model varchar(50), color varchar(50), price double)");
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

//	--------------------------------------------Insert---------------------------------------------------------
	public void insert(VehicleBean bean) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into vehicle values(?,?,?,?,?)");

			pstmt.setLong(1, bean.getVehicleId());
			pstmt.setString(2, bean.getVehicleName());
			pstmt.setString(3, bean.getModel());
			pstmt.setString(4, bean.getColor());
			pstmt.setDouble(5, bean.getPrice());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record Inserted Scucessfully");

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

//	--------------------------------------------Update---------------------------------------------------------

	public void update(VehicleBean bean) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn
					.prepareStatement("update vehicle set vehicleName=?, model=?, color=?, price=? where vehicleId=?");

			pstmt.setString(1, bean.getVehicleName());
			pstmt.setString(2, bean.getModel());
			pstmt.setString(3, bean.getColor());
			pstmt.setDouble(4, bean.getPrice());
			pstmt.setLong(5, bean.getVehicleId());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record Updated Scucessfully");
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

//	--------------------------------------------Delete---------------------------------------------------------

	public void delete(long vehicleId) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from vehicle where vehicleId = ?");
			pstmt.setLong(1, vehicleId);

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

//	--------------------------------------------Search---------------------------------------------------------

	public List<VehicleBean> search(VehicleBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = null;
		List<VehicleBean> list = new ArrayList<VehicleBean>();
		StringBuffer sql = new StringBuffer("select * from vehicle where 1=1 ");

		try {

			conn = JDBCDataSource.getConnection();

			System.out.println("sql search query ====> " + sql.toString());

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new VehicleBean();
				bean.setVehicleId(rs.getLong("vehicleid"));
				bean.setVehicleName(rs.getString("vehicleName"));
				bean.setModel(rs.getString("model"));
				bean.setColor(rs.getString("color"));
				bean.setPrice(rs.getDouble("price"));

				list.add(bean);
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return list;

	}
}

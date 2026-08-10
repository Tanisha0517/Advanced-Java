package com.rays.vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.rays.util.JDBCDataSource;

public class VehicleModel {

//	---------------------------------------------Create-------------------------------------------------------

	public void create() throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"create table vehicle (vehicleId Bigint, vehicleName varchar(50), model varchar(50), color varchar(50), price double)");
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
	
//	--------------------------------------------Delete---------------------------------------------------------
	
//	--------------------------------------------Search---------------------------------------------------------

}

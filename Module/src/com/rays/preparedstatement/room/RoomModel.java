package com.rays.preparedstatement.room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.hotel.HotelBean;
import com.rays.util.JDBCDataSource;

public class RoomModel {

//	---------------------------------------------create-----------------------------------------------

	public  void create() throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"create table room (roomId int primary key, roomNumber varchar(50), roomType varchar(50), pricePerDay double, availability boolean )");

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

//	---------------------------------------------insert-----------------------------------------------

	public  void insert(RoomBean bean) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into room values(?,?,?,?,?)");

			pstmt.setLong(1, bean.getRoomId());
			pstmt.setString(2, bean.getRoomNumber());
			pstmt.setString(3, bean.getRoomType());
			pstmt.setDouble(4, bean.getPricePerDay());
			pstmt.setBoolean(5, bean.getAvailability());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record Inserted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
//	---------------------------------------------update-----------------------------------------------

	
	public  void update(RoomBean bean) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("update room set roomNumber = ?,roomType = ?,pricePerDay = ?,availability = ? where roomId = ?");

			
			pstmt.setString(1, bean.getRoomNumber());
			pstmt.setString(2, bean.getRoomType());
			pstmt.setDouble(3, bean.getPricePerDay());
			pstmt.setBoolean(4, bean.getAvailability());
			pstmt.setLong(5, bean.getRoomId());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record Updated successfully");
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

//	---------------------------------------------delete-----------------------------------------------
	public  void delete(long roomId) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from room where roomId = ?");

			
			pstmt.setLong(1, roomId);
			
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

//	-----------------------------------------Search------------------------------------------------
	
	public List<RoomBean> search(RoomBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = null;
		List<RoomBean> list = new ArrayList<RoomBean>();
		StringBuffer sql = new StringBuffer("select * from room where 1=1 ");

		try {

			conn = JDBCDataSource.getConnection();

			System.out.println("sql search query ====> " + sql.toString());

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new RoomBean();
				bean.setRoomId(rs.getLong("roomId"));
				bean.setRoomNumber(rs.getString("roomNumber"));
				bean.setRoomType(rs.getString("roomType"));
				bean.setPricePerDay(rs.getDouble("pricePerDay"));
				bean.setAvailability(rs.getBoolean("availability"));

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

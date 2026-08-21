package com.rays.preparedstatement.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.preparedstatement.insurance.InsuranceBean;
import com.rays.util.JDBCDataSource;

public class HotelModel {
	
//	----------------------------------------------create---------------------------------------------

	public void create() throws Exception {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"create table hotel (hotelId bigint primary key, hotelName varchar(50), location varchar(50), rating double, contactNo varchar(50))");

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
	
//	----------------------------------------------insert---------------------------------------------
	public void insert(HotelBean bean) throws Exception {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"insert into hotel values(?,?,?,?,?)");
			
			pstmt.setLong(1, bean.getHotelId());
			pstmt.setString(2, bean.getHotelName());
			pstmt.setString(3, bean.getLocation());
			pstmt.setDouble(4, bean.getRating());
			pstmt.setString(5, bean.getContactNo());
			

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
//	----------------------------------------------update---------------------------------------------
	public void update(HotelBean bean) throws Exception {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update hotel set hotelName = ?,location = ?,rating = ?,contactNo = ? where hotelId = ?");
			
			pstmt.setString(1, bean.getHotelName());
			pstmt.setString(2, bean.getLocation());
			pstmt.setDouble(3, bean.getRating());
			pstmt.setString(4, bean.getContactNo());
			pstmt.setLong(5, bean.getHotelId());
			

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
//	----------------------------------------------delete---------------------------------------------
	public void delete(long hotelId) throws Exception {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"delete from hotel where hotelId = ?");
			
			pstmt.setLong(1, hotelId);
			
			

			int i = pstmt.executeUpdate();
			conn.commit();

			System.out.println("Record Deleted successfully");

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();

		} finally {
			conn.close();
		}
	}
	
//	----------------------------------------------search---------------------------------------------
	public List<HotelBean> search(HotelBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = null;
		List<HotelBean> list = new ArrayList<HotelBean>();
		StringBuffer sql = new StringBuffer("select * from hotel where 1=1 ");

		try {

			conn = JDBCDataSource.getConnection();

			System.out.println("sql search query ====> " + sql.toString());

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new HotelBean();
				bean.setHotelId(rs.getLong("hotelId"));
				bean.setHotelName(rs.getString("hotelName"));
				bean.setLocation(rs.getString("location"));
				bean.setRating(rs.getDouble("rating"));
				bean.setContactNo(rs.getString("contactNo"));

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

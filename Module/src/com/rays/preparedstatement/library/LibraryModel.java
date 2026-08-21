package com.rays.preparedstatement.library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.preparedstatement.course.CourseBean;
import com.rays.util.JDBCDataSource;

public class LibraryModel {

//	------------------------------------------create--------------------------------------------
	public void create() throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"create table library(libraryId BIGINT primary key, libraryName varchar(45), address varchar(50), totalBooks int, contactNo varchar(50))");

			int i = pstmt.executeUpdate();
			System.out.println("Table created successfully");
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

//	------------------------------------------insert--------------------------------------------
	public void insert(LibraryBean bean) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into library values(?,?,?,?,?)");

			pstmt.setLong(1, bean.getLibraryId());
			pstmt.setString(2, bean.getLibraryName());
			pstmt.setString(3, bean.getAddress());
			pstmt.setInt(4, bean.getTotalBooks());
			pstmt.setString(5, bean.getContactNo());

			int i = pstmt.executeUpdate();
			System.out.println("Record inserted successfully");
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

//	------------------------------------------update--------------------------------------------
	public void update(LibraryBean bean) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update library set libraryName = ?,address = ?,totalBooks = ?,contactNo = ? where libraryId = ?");

			pstmt.setString(1, bean.getLibraryName());
			pstmt.setString(2, bean.getAddress());
			pstmt.setInt(3, bean.getTotalBooks());
			pstmt.setString(4, bean.getContactNo());
			pstmt.setLong(5, bean.getLibraryId());

			int i = pstmt.executeUpdate();
			System.out.println("Record updated successfully");
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

//	------------------------------------------delete--------------------------------------------
	public void delete(long libraryId) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from library where libraryId = ?");

			pstmt.setLong(1, libraryId);

			int i = pstmt.executeUpdate();
			System.out.println("Record deleted successfully");
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

//	------------------------------------------search--------------------------------------------
	public List<LibraryBean> search(LibraryBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = null;
		List<LibraryBean> list = new ArrayList<LibraryBean>();
		StringBuffer sql = new StringBuffer("select * from library where 1=1 ");

		try {

			conn = JDBCDataSource.getConnection();

			System.out.println("sql search query ====> " + sql.toString());

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new LibraryBean();
				bean.setLibraryId(rs.getLong("libraryId"));
				bean.setLibraryName(rs.getString("libraryName"));
				bean.setAddress(rs.getString("address"));
				bean.setTotalBooks(rs.getInt("totalBooks"));
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

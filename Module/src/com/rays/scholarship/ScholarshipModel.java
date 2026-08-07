package com.rays.scholarship;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.util.JDBCDataSource;

public class ScholarshipModel {

	public void Create() throws Exception {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"create table scholarship(scholarshipId int PRIMARY KEY, scholarshipName varchar(50), amount int, eligibility varchar(50), lastDate date)");
			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Table Created Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

//	------------------------------------------Insert--------------------------------------

	public void Insert(ScholarshipBean bean) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into scholarship values(?,?,?,?,?)");

			pstmt.setInt(1, bean.getScholarshiId());
			pstmt.setString(2, bean.getScholarshipName());
			pstmt.setInt(3, bean.getAmount());
			pstmt.setString(4, bean.getEligibility());
			pstmt.setDate(5, new java.sql.Date(bean.getLastDate().getTime()));

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("Record inserted successfully");

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

//	--------------------------------------Update-------------------------------------------

	public void Update(ScholarshipBean bean) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update scholarship set scholarshipName=?, amount =?, eligibility =?, lastDate = ? where scholarshipId=?");

			pstmt.setString(1, bean.getScholarshipName());
			pstmt.setInt(2, bean.getAmount());
			pstmt.setString(3, bean.getEligibility());
			pstmt.setDate(4, new java.sql.Date(bean.getLastDate().getTime()));
			pstmt.setInt(5, bean.getScholarshiId());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record Updated Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

//	--------------------------------------------Delete-----------------------------------------

	public void Delete(int scholarshipId) throws Exception {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from scholarship where scholarshipId=?");
			pstmt.setInt(1, scholarshipId);

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record Deleted Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}
	
//	-----------------------------------------------Search----------------------------------
	
	public List<ScholarshipBean> search(ScholarshipBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = null;
		List<ScholarshipBean> list = new ArrayList<ScholarshipBean>();
		StringBuffer sql = new StringBuffer("select * from scholarship where 1=1 ");

		try {

		if (pageSize > 0) {
			int index = (pageNo - 1) * pageSize;
			sql.append("limit " + index + ", " + pageSize);
		}

		conn = JDBCDataSource.getConnection();

		System.out.println("sql search query ====> " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new ScholarshipBean();
			bean.setScholarshiId(rs.getInt("scholarshipid"));
			bean.setScholarshipName(rs.getString("scholarshipName"));
			bean.setAmount(rs.getInt("amount"));
			bean.setEligibility(rs.getString("eligibility"));
			bean.setLastDate(rs.getDate("lastDate"));
			
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

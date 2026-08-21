package com.rays.preparedstatement.fee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.util.JDBCDataSource;

public class FeeModel {

//	-----------------------------Create----------------------------------------
	public void Create() throws Exception {

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"create table fee ( feeId int PRIMARY KEY, studentId int, amount int, paymentDate date, paymentStatus varchar(50))");

			int i = pstmt.executeUpdate();
			conn.commit();

			System.out.println("Table Created Successfully ......" + i);

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}

	}

//	-----------------------------Insert----------------------------------------
	public void Insert(FeeBean bean) throws Exception {

		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into fee values(?,?,?,?,?)");

			pstmt.setInt(1, bean.getFeeId());
			pstmt.setInt(2, bean.getStudentId());
			pstmt.setInt(3, bean.getAmount());
			pstmt.setDate(4, new java.sql.Date(bean.getPaymentDate().getTime()));
			pstmt.setString(5, bean.getPaymentstatus());

			int i = pstmt.executeUpdate();

			conn.commit();
			System.out.println("Record Inserted Successfully.....");

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

//	-----------------------------Update----------------------------------------
	public void Update(FeeBean bean) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update fee set studentId=?, amount=?, paymentDate=?, paymentstatus=? where feeId=?");

			pstmt.setInt(1, bean.getStudentId());
			pstmt.setInt(2, bean.getAmount());
			pstmt.setDate(3, new java.sql.Date(bean.getPaymentDate().getTime()));
			pstmt.setString(4, bean.getPaymentstatus());
			pstmt.setInt(5, bean.getFeeId());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record Updated Successfully......");

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();

		} finally {
			conn.close();
		}
	}

//	-----------------------------Delete----------------------------------------
	public void Delete(int feeId) throws Exception {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from fee where feeId=?");
			pstmt.setInt(1, feeId);

			int i = pstmt.executeUpdate();
			conn.commit();

			System.out.println("Record Deleted Successfully.....");

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

//		----------------------------------Search------------------------------------------
	public List<FeeBean> search(FeeBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = null;
		List<FeeBean> list = new ArrayList<FeeBean>();
		StringBuffer sql = new StringBuffer("select * from fee where 1=1 ");

		try {

			if (bean != null) {
				if (bean.getStudentId() != 0) {
					sql.append("and studentId = " + bean.getStudentId());
				}
				if (bean.getAmount() != 0) {
					sql.append("and Amount = " + bean.getAmount());
				}
				if (bean.getPaymentDate() != null && bean.getPaymentDate().getTime() > 0) {
					sql.append("and paymentDate = '" + new java.sql.Date(bean.getPaymentDate().getTime())+"'");
				//  or 
				//  sql.append("and paymentDate like '" + new java.sql.Date(bean.getPaymentDate().getTime())+"'");
				}

				if (bean.getPaymentstatus() != null && bean.getPaymentstatus().length() > 0) {
					sql.append("and paymentStatus like '" + bean.getPaymentstatus() + "%' ");
				}
			}
			if (pageSize > 0) {
				int index = (pageNo - 1) * pageSize;
				sql.append("limit " + index + ", " + pageSize);
			}

			conn = JDBCDataSource.getConnection();

			System.out.println("sql search query ====> " + sql.toString());

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new FeeBean();
				bean.setFeeId(rs.getInt("feeid"));
				bean.setStudentId(rs.getInt("studentId"));
				bean.setAmount(rs.getInt("amount"));
				bean.setPaymentDate(rs.getDate("paymentDate"));
				bean.setPaymentstatus(rs.getString("paymentStatus"));

				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

		return list;

	}

}

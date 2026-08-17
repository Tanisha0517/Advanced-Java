package com.rays.preparedstatement.bankaccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.patient.PatientBean;
import com.rays.util.JDBCDataSource;

public class BankAccountModel {

	public void create() throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"create table bankAccount (accountNumber BIGINT primary key, accountHolderName varchar(50),accountType varchar(50), balance double, branchName varchar(50))");
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

//	-----------------------------------Insert------------------------------------------------

	public void insert(BankAccountBean bean) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into bankAccount values(?,?,?,?,?)");

			pstmt.setLong(1, bean.getAccountNumber());
			pstmt.setString(2, bean.getAccountHolderName());
			pstmt.setString(3, bean.getAccountType());
			pstmt.setDouble(4, bean.getBalance());
			pstmt.setString(5, bean.getBranchName());
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

//	-----------------------------------Update-------------------------------------------------

	public void update(BankAccountBean bean) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update bankAccount set accountHolderName = ?,accountType = ?,balance =  ?,branchName = ? where accountNumber = ?");

			pstmt.setString(1, bean.getAccountHolderName());
			pstmt.setString(2, bean.getAccountType());
			pstmt.setDouble(3, bean.getBalance());
			pstmt.setString(4, bean.getBranchName());
			pstmt.setLong(5, bean.getAccountNumber());

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

//	---------------------------------------------Delete---------------------------------------------

	public void delete(long accountNumber) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from bankAccount where accountNumber = ? ");

			pstmt.setLong(1, accountNumber);

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
	
//	-----------------------------------------------Search-----------------------------------------
	
	public List<BankAccountBean> search(BankAccountBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = null;
		List<BankAccountBean> list = new ArrayList<BankAccountBean>();
		StringBuffer sql = new StringBuffer("select * from bankAccount where 1=1 ");

		try {

			conn = JDBCDataSource.getConnection();

			System.out.println("sql search query ====> " + sql.toString());

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new BankAccountBean();
				bean.setAccountNumber(rs.getLong("accountNumber"));
				bean.setAccountHolderName(rs.getString("accountHolderName"));
				bean.setAccountType(rs.getString("accountType"));
				bean.setBalance(rs.getDouble("balance"));
				bean.setBranchName(rs.getString("branchName"));

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

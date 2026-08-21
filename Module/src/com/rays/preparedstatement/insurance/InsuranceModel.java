package com.rays.preparedstatement.insurance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.util.JDBCDataSource;

public class InsuranceModel {

//	-----------------------------------------Create--------------------------------------------
	public void Create() throws Exception {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"create table insurance(policyId int PRIMARY KEY, policyHolderName varchar(50), policyType varchar(50), premiumAmount int, expiryDate date )");

			int i = pstmt.executeUpdate();
			conn.commit();

			System.out.println("Table Created Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			conn.commit();

		} finally {
			conn.close();
		}
	}

//	--------------------------------------------------Insert-----------------------------------------------

	public void Insert(InsuranceBean bean) throws Exception {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareCall("Insert into insurance values(?,?,?,?,?)");

			pstmt.setInt(1, bean.getPolicyId());
			pstmt.setString(2, bean.getPolicyHolderName());
			pstmt.setString(3, bean.getPolicyType());
			pstmt.setInt(4, bean.getPremiumAmount());
			pstmt.setDate(5, new java.sql.Date(bean.getExpiryDate().getTime()));

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

//	--------------------------------------------------Update---------------------------------------------------

	public void Update(InsuranceBean bean) throws Exception {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update insurance set policyHolderName = ?, policyType = ?, premiumAmount = ?, expiryDate = ? where policyId=?");

			pstmt.setString(1, bean.getPolicyHolderName());
			pstmt.setString(2, bean.getPolicyType());
			pstmt.setInt(3, bean.getPremiumAmount());
			pstmt.setDate(4, new java.sql.Date(bean.getExpiryDate().getTime()));
			pstmt.setInt(5, bean.getPolicyId());

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

//	----------------------------------------------------Delete---------------------------------------------------------------

	public void Delete(int policyId) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from insurance where policyId = ?");
			pstmt.setInt(1, policyId);

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
	
//	----------------------------------------------------Search-------------------------------------------------------------
	
	public List<InsuranceBean> search(InsuranceBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = null;
		List<InsuranceBean> list = new ArrayList<InsuranceBean>();
		StringBuffer sql = new StringBuffer("select * from insurance where 1=1 ");

		try {

			conn = JDBCDataSource.getConnection();

			System.out.println("sql search query ====> " + sql.toString());

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new InsuranceBean();
				bean.setPolicyId(rs.getInt("policyid"));
				bean.setPolicyHolderName(rs.getString("policyHolderName"));
				bean.setPolicyType(rs.getString("policyType"));
				bean.setPremiumAmount(rs.getInt("premiumAmount"));
				bean.setExpiryDate(rs.getDate("expiryDate"));

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

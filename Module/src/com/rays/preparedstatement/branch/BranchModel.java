package com.rays.preparedstatement.branch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.util.JDBCDataSource;

public class BranchModel {

//	-------------------------------------------------Create------------------------------------------
	public void Create() throws Exception {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"create table branch(branchId int PRIMARY KEY, branchName varchar(50), city varchar(50), managerName varchar(50), contactNumber varchar(50))");

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

//	------------------------------------------------Insert-------------------------------------------------

	public void Insert(BranchBean bean) throws Exception {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into branch values(?,?,?,?,?)");

			pstmt.setInt(1, bean.getBranchId());
			pstmt.setString(2, bean.getBranchName());
			pstmt.setString(3, bean.getCity());
			pstmt.setString(4, bean.getManagerName());
			pstmt.setString(5, bean.getContactNo());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record Inserted Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

//	----------------------------------------------Update------------------------------------------------

	public void Update(BranchBean bean) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update branch set branchName = ?, city = ?, managerName = ?, contactNumber = ? where branchId = ?");

			pstmt.setString(1, bean.getBranchName());
			pstmt.setString(2, bean.getCity());
			pstmt.setString(3, bean.getManagerName());
			pstmt.setString(4, bean.getContactNo());
			pstmt.setInt(5, bean.getBranchId());

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

//	----------------------------------------------Delete------------------------------------------------

	public void Delete(int branchId) throws Exception {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from branch where branchId = ?");

			pstmt.setInt(1, branchId);

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

//	------------------------------------------Search---------------------------------------------------

	public List<BranchBean> search(BranchBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = null;
		List<BranchBean> list = new ArrayList<BranchBean>();
		StringBuffer sql = new StringBuffer("select * from branch where 1=1 ");

		try {

			conn = JDBCDataSource.getConnection();

			System.out.println("sql search query ====> " + sql.toString());

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new BranchBean();
				bean.setBranchId(rs.getInt("branchid"));
				bean.setBranchName(rs.getString("BranchName"));
				bean.setCity(rs.getString("city"));
				bean.setManagerName(rs.getString("managerName"));
				bean.setContactNo(rs.getString("contactNumber"));

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

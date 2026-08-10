package com.rays.subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.util.JDBCDataSource;

public class SubjectModel {

//	--------------------------------------Create--------------------------------------------
	public void create() throws Exception {
		Connection conn = null;
		
		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);
			
			PreparedStatement pstmt = conn.prepareStatement(
					"create table subject(subjectId int primary key, subjectName varchar(50) ,subjectCode varchar(50) ,credits int,semester int)");
			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Table created  successfully" + i);
			
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			
		} finally {
			conn.close();
		}
	}

//	--------------------------------------Insert--------------------------------------------

	public void insert(SubjectBean bean) throws Exception {

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into subject values(?, ?, ?, ?, ?)");

			pstmt.setInt(1, bean.getSubjectId());
			pstmt.setString(2, bean.getSubjectName());
			pstmt.setString(3, bean.getSubjectCode());
			pstmt.setInt(4, bean.getCredits());
			pstmt.setInt(5, bean.getSemester());

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("record inserted successfully: " + i);

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

//		--------------------------------------Update--------------------------------------------

	public void update(SubjectBean bean) throws Exception {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update subject set subjectName = ?, subjectCode = ?, credits = ?, semester = ? where subjectId = ?");

			pstmt.setString(1, bean.getSubjectName());
			pstmt.setString(2, bean.getSubjectCode());
			pstmt.setInt(3, bean.getCredits());
			pstmt.setInt(4, bean.getSemester());
			pstmt.setInt(5, bean.getSubjectId());

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("record updated successfully: " + i);

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}
		
//	--------------------------------------Delete--------------------------------------------
		
		public void delete( int subjectId) throws Exception {

			Connection conn = null;

			try {

				conn = JDBCDataSource.getConnection();

				conn.setAutoCommit(false);

				PreparedStatement pstmt = conn.prepareStatement("delete from subject where subjectId = ?");

				pstmt.setInt(1, subjectId);

				int i = pstmt.executeUpdate();

				conn.commit();

				System.out.println("record delete successfully: " + i);

			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			} finally {
				conn.close();
			}
		}
		
//		---------------------------Search - FindByPK--------------------------------------
		
		public SubjectBean findByPk(int subjectId) throws Exception {

			Connection conn = null;
			SubjectBean bean = null;

			try {

				conn = JDBCDataSource.getConnection();

				PreparedStatement pstmt = conn.prepareStatement("select * from subject where subjectId = ?");

				pstmt.setInt(1, subjectId);

				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					bean = new SubjectBean();
					bean.setSubjectId(rs.getInt("subjectId"));
					bean.setSubjectName(rs.getString("subjectName"));
					bean.setSubjectCode(rs.getString("subjectCode"));
					bean.setCredits(rs.getInt("credits"));
					bean.setSemester(rs.getInt("semester"));
				
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn.close();
			}

			return bean;

		}
		
//		--------------------------------------
		
		public List<SubjectBean> search(SubjectBean bean, int pageNo, int pageSize) throws Exception {

			Connection conn = null;
			List<SubjectBean> list = new ArrayList<SubjectBean>();
			StringBuffer sql = new StringBuffer("select * from subject where 1=1 ");

			if (bean != null) {
				if (bean.getSubjectName() != null && bean.getSubjectName().length() > 0) {
					sql.append("and firstName like '" + bean.getSubjectName() + "%' ");
				}
				if (bean.getSubjectCode() != null && bean.getSubjectCode().length() > 0) {
					sql.append("and lastName like '" + bean.getSubjectCode() + "%' ");
				}
				if (bean.getCredits() != 0  && bean.getCredits()>0) {
					sql.append("and Credits like '" + bean.getCredits() + "%' ");
				}
				if (bean.getSemester() !=0 && bean.getSemester() > 0) {
					sql.append("and password like '" + bean.getSemester() + "%' ");
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
				bean = new SubjectBean();
				bean.setSubjectId(rs.getInt("subjectId"));
				bean.setSubjectName(rs.getString("SubjectName"));
				bean.setSubjectCode(rs.getString("subjectCode"));
				bean.setCredits(rs.getInt("credits"));
				bean.setSemester(rs.getInt("Semester"));
				
				list.add(bean);
			}

			try {

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn.close();
			}

			return list;

		}

}

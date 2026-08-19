package com.rays.preparedstatement.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.preparedstatement.room.RoomBean;
import com.rays.util.JDBCDataSource;

public class CourseModel {

//	------------------------------------------Create-------------------------------------------------
	public void create() throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"create table course (courseId int primary key, courseName varchar(50), duration varchar(50), fees double, trainerName varchar(50))");

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

//	------------------------------------------Insert-------------------------------------------------
	public void insert(CourseBean bean) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into course values(?,?,?,?,?)");

			pstmt.setLong(1, bean.getCourseId());
			pstmt.setString(2, bean.getCourseName());
			pstmt.setString(3, bean.getDuration());
			pstmt.setDouble(4, bean.getFees());
			pstmt.setString(5, bean.getTrainerName());

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

//	------------------------------------------Update-------------------------------------------------
	public void update(CourseBean bean) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update course set courseName = ?,duration = ?,fees = ?,trainerName = ? where courseId = ?");

			pstmt.setString(1, bean.getCourseName());
			pstmt.setString(2, bean.getDuration());
			pstmt.setDouble(3, bean.getFees());
			pstmt.setString(4, bean.getTrainerName());
			pstmt.setLong(5, bean.getCourseId());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record updated successfully");

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

//	------------------------------------------Delete-------------------------------------------------
	public void delete(long courseId) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from course where courseId = ?");

			pstmt.setLong(1, courseId);
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

//	------------------------------------------Search-------------------------------------------------

	public List<CourseBean> search(CourseBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = null;
		List<CourseBean> list = new ArrayList<CourseBean>();
		StringBuffer sql = new StringBuffer("select * from course where 1=1 ");

		try {

			conn = JDBCDataSource.getConnection();

			System.out.println("sql search query ====> " + sql.toString());

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new CourseBean();
				bean.setCourseId(rs.getLong("courseId"));
				bean.setCourseName(rs.getString("courseName"));
				bean.setDuration(rs.getString("duration"));
				bean.setFees(rs.getDouble("fees"));
				bean.setTrainerName(rs.getString("trainerName"));

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

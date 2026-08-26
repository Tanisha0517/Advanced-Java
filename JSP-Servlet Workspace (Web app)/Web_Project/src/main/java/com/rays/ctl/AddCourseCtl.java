package com.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.CourseBean;
import com.rays.bean.ServiceBean;
import com.rays.model.CourseModel;
import com.rays.model.ServiceModel;
import com.rays.util.InputValidatorUtility;
import com.rays.util.ServletUtility;

@WebServlet("/AddCourseCtl")
public class AddCourseCtl extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("request method == " + request.getMethod());

		if (request.getMethod().equalsIgnoreCase("POST")) {
			if (InputValidatorUtility.courseValidator(request) == false) {
				ServletUtility.forward("AddCourseView.jsp", request, response);
				return;
			}
		}

		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletUtility.forward("AddCourseView.jsp", request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doPost() method");

		CourseBean bean = new CourseBean();
		CourseModel model = new CourseModel();

		String courseId = request.getParameter("courseId");
		String courseName = request.getParameter("courseName");
		String duration = request.getParameter("duration");
		String fees = request.getParameter("fees");
		String trainerName = request.getParameter("trainerName");

//		System.out.println(firstName + "\n" + lastName + "\n" + login + "\n" + password + "\n" + dob);

		try {

			bean.setCourseId(courseId);
			bean.setCourseName(courseName);
			bean.setDuration(duration);
			bean.setFees(fees);
			bean.setTrainerName(trainerName);
			model.add(bean);

			request.setAttribute("successMsg", "Course added successfully");

		} catch (Exception e) {
			request.setAttribute("errorMsg", "CourseId already exist");
			e.printStackTrace();
		}

		ServletUtility.forward("AddCourseView.jsp", request, response);

	}
}

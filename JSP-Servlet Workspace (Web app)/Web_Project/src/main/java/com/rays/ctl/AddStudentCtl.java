package com.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.ProductBean;
import com.rays.bean.StudentBean;
import com.rays.model.ProductModel;
import com.rays.model.StudentModel;
import com.rays.util.InputValidatorUtility;
import com.rays.util.ServletUtility;

@WebServlet("/AddStudentCtl")
public class AddStudentCtl extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("request method == " + request.getMethod());

		if (request.getMethod().equalsIgnoreCase("POST")) {
			if (InputValidatorUtility.studentValidator(request) == false) {
				ServletUtility.forward("AddStudentView.jsp", request, response);
				return;
			}
		}

		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletUtility.forward("AddStudentView.jsp", request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doPost() method");

		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();

		String rollNo = request.getParameter("rollNo");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobileNo = request.getParameter("mobileNo");
		String course = request.getParameter("course");

//		System.out.println(firstName + "\n" + lastName + "\n" + login + "\n" + password + "\n" + dob);

		try {

			bean.setRollNo(rollNo);
			bean.setName(name);
			bean.setEmail(email);
			bean.setMobileNo(mobileNo);
			bean.setCourse(course);
			model.add(bean);

			request.setAttribute("successMsg", "Student added successfully");

		} catch (Exception e) {
			request.setAttribute("errorMsg", "RollNo already exist");
			e.printStackTrace();
		}

		ServletUtility.forward("AddStudentView.jsp", request, response);

	}

}

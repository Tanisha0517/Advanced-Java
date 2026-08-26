package com.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.rays.bean.EmployeeBean;
import com.rays.model.EmployeeModel;
import com.rays.util.InputValidatorUtility;
import com.rays.util.ServletUtility;


@WebServlet("/AddEmployeeCtl")
public class AddEmployeeCtl extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("request method == " + request.getMethod());

		if (request.getMethod().equalsIgnoreCase("POST")) {
			if (InputValidatorUtility.employeeValidator(request) == false) {
				ServletUtility.forward("AddEmployeeView.jsp", request, response);
				return;
			}
		}

		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletUtility.forward("AddEmployeeView.jsp", request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doPost() method");

		EmployeeBean bean = new EmployeeBean();
		EmployeeModel model = new EmployeeModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String employeeCode = request.getParameter("employeeCode");
		String name = request.getParameter("name");
		String designation = request.getParameter("designation");
		double salary = Double.parseDouble(request.getParameter("salary"));
		String joiningDate = request.getParameter("joiningDate");

//		System.out.println(firstName + "\n" + lastName + "\n" + login + "\n" + password + "\n" + dob);

		try {

			bean.setEmployeeCode(employeeCode);
			bean.setName(name);
			bean.setDesignation(designation);
			bean.setSalary(salary);
			bean.setJoinDate(sdf.parse(joiningDate));
			model.add(bean);

			request.setAttribute("successMsg", "Employee added successfully");

		} catch (Exception e) {
			request.setAttribute("errorMsg", "EmployeeCode already exist");
			e.printStackTrace();
		}

		ServletUtility.forward("AddEmployeeView.jsp", request, response);

	}
}

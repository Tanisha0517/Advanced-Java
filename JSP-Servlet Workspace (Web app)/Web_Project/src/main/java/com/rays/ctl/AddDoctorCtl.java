package com.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.DoctorBean;
import com.rays.model.DoctorModel;
import com.rays.util.InputValidatorUtility;
import com.rays.util.ServletUtility;

@WebServlet("/AddDoctorCtl")
public class AddDoctorCtl extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("request method == " + request.getMethod());

		DoctorModel model = new DoctorModel();
		DoctorBean bean = new DoctorBean();
		String id = request.getParameter("id");
		
		if (id != null) {
			try {
				bean = model.findByPk(Integer.parseInt(id));
				request.setAttribute("bean", bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (request.getMethod().equalsIgnoreCase("POST")) {
			if (InputValidatorUtility.doctorValidator(request) == false) {
				ServletUtility.forward("AddDoctorView.jsp", request, response);
				return;
			}
		}

		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletUtility.forward("AddDoctorView.jsp", request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doPost() method");

		DoctorBean bean = new DoctorBean();
		DoctorModel model = new DoctorModel();

		String doctorId = request.getParameter("doctorId").trim();
		String doctorName = request.getParameter("doctorName").trim();
		String specialization = request.getParameter("specialization").trim();
		int experience = Integer.parseInt(request.getParameter("experience").trim());
		String contactNo = request.getParameter("contactNo").trim();

//		System.out.println(firstName + "\n" + lastName + "\n" + login + "\n" + password + "\n" + dob);

		try {

			bean.setDoctorId(doctorId);
			bean.setDoctorName(doctorName);
			bean.setSpecialization(specialization);
			bean.setExperience(experience);
			bean.setContactNo(contactNo);
			model.add(bean);

			request.setAttribute("successMsg", "Doctor added successfully");

		} catch (Exception e) {
			request.setAttribute("errorMsg", "Doctor Id already exist");
			e.printStackTrace();
		}

		ServletUtility.forward("AddDoctorView.jsp", request, response);

	}

}

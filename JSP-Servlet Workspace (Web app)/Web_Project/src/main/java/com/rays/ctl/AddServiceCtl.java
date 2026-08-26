package com.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.ServiceBean;
import com.rays.model.ServiceModel;
import com.rays.util.InputValidatorUtility;
import com.rays.util.ServletUtility;

@WebServlet("/AddServiceCtl")
public class AddServiceCtl extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("request method == " + request.getMethod());

		if (request.getMethod().equalsIgnoreCase("POST")) {
			if (InputValidatorUtility.serviceValidator(request) == false) {
				ServletUtility.forward("AddServiceView.jsp", request, response);
				return;
			}
		}

		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletUtility.forward("AddServiceView.jsp", request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doPost() method");

		ServiceBean bean = new ServiceBean();
		ServiceModel model = new ServiceModel();

		String serviceId = request.getParameter("serviceId");
		String serviceName = request.getParameter("serviceName");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		String serviceCategory = request.getParameter("serviceCategory");

//		System.out.println(firstName + "\n" + lastName + "\n" + login + "\n" + password + "\n" + dob);

		try {

			bean.setServiceId(serviceId);
			bean.setServiceName(serviceName);
			bean.setPrice(price);
			bean.setDescription(description);
			bean.setServiceCategory(serviceCategory);
			model.add(bean);

			request.setAttribute("successMsg", "Service added successfully");

		} catch (Exception e) {
			request.setAttribute("errorMsg", "serviceId already exist");
			e.printStackTrace();
		}

		ServletUtility.forward("AddServiceView.jsp", request, response);

	}
}

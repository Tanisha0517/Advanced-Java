package com.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.CustomerBean;
import com.rays.bean.VehicleBean;
import com.rays.model.CustomerModel;
import com.rays.model.VehicleModel;
import com.rays.util.InputValidatorUtility;
import com.rays.util.ServletUtility;

@WebServlet("/AddVehicleCtl")
public class AddVehicleCtl extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("request method == " + request.getMethod());

		if (request.getMethod().equalsIgnoreCase("POST")) {
			if (InputValidatorUtility.vehicleValidator(request) == false) {
				ServletUtility.forward("AddVehicleView.jsp", request, response);
				return;
			}
		}

		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletUtility.forward("AddVehicleView.jsp", request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doPost() method");

		VehicleBean bean = new VehicleBean();
		VehicleModel model = new VehicleModel();

		String vehicleNo = request.getParameter("vehicleNo");
		String vehicleName = request.getParameter("vehicleName");
		String vehicleModel = request.getParameter("vehicleModel");
		String color = request.getParameter("color");
		double price = Double.parseDouble(request.getParameter("price"));

//		System.out.println(firstName + "\n" + lastName + "\n" + login + "\n" + password + "\n" + dob);

		try {

			bean.setVehicleNo(vehicleNo);
			bean.setVehicleName(vehicleName);
			bean.setModel(vehicleModel);
			bean.setColor(color);
			bean.setPrice(price);

			model.add(bean);

			request.setAttribute("successMsg", "Vehicle added successfully");

		} catch (Exception e) {
			request.setAttribute("errorMsg", "Vehicle Number already exist");
			e.printStackTrace();
		}

		ServletUtility.forward("AddVehicleView.jsp", request, response);

	}

}

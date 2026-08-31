package com.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.OrderBean;
import com.rays.bean.ProductBean;
import com.rays.model.OrderModel;
import com.rays.model.ProductModel;
import com.rays.util.InputValidatorUtility;
import com.rays.util.ServletUtility;

@WebServlet("/AddOrderCtl")
public class AddOrderCtl extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("request method == " + request.getMethod());

		if (request.getMethod().equalsIgnoreCase("POST")) {
			if (InputValidatorUtility.orderValidator(request) == false) {
				ServletUtility.forward("AddOrderView.jsp", request, response);
				return;
			}
		}

		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletUtility.forward("AddOrderView.jsp", request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doPost() method");

		OrderBean bean = new OrderBean();
		OrderModel model = new OrderModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String orderId = request.getParameter("orderId");
		String orderDate = request.getParameter("orderDate");
		double amount = Double.parseDouble(request.getParameter("amount"));
		String status = request.getParameter("status");
//		String customerId = request.getParameter("customerId");

//		System.out.println(firstName + "\n" + lastName + "\n" + login + "\n" + password + "\n" + dob);

		try {

			bean.setOrderId(orderId);
			bean.setOrderDate(sdf.parse(orderDate));
			bean.setAmount(amount);
			bean.setStatus(status);
//			bean.setCustomerId(customerId);
			model.add(bean);

			request.setAttribute("successMsg", "Order Placed successfully");

		} catch (Exception e) {
			request.setAttribute("errorMsg", "OrderId already exist");
			e.printStackTrace();
		}

		ServletUtility.forward("AddOrderView.jsp", request, response);

	}

}

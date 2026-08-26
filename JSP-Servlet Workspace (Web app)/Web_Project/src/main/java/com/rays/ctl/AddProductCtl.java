package com.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.CourseBean;
import com.rays.bean.ProductBean;
import com.rays.model.CourseModel;
import com.rays.model.ProductModel;
import com.rays.util.InputValidatorUtility;
import com.rays.util.ServletUtility;

@WebServlet("/AddProductCtl")
public class AddProductCtl extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("request method == " + request.getMethod());

		if (request.getMethod().equalsIgnoreCase("POST")) {
			if (InputValidatorUtility.productValidator(request) == false) {
				ServletUtility.forward("AddProductView.jsp", request, response);
				return;
			}
		}

		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletUtility.forward("AddProductView.jsp", request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doPost() method");

		ProductBean bean = new ProductBean();
		ProductModel model = new ProductModel();

		String productId = request.getParameter("productId");
		String productName = request.getParameter("productName");
		String price = request.getParameter("price");
		String quantity = request.getParameter("quantity");
		String category = request.getParameter("category");

//		System.out.println(firstName + "\n" + lastName + "\n" + login + "\n" + password + "\n" + dob);

		try {

			bean.setProductId(productId);
			bean.setProductName(productName);
			bean.setPrice(price);
			bean.setQuantity(quantity);
			bean.setCategory(category);
			model.add(bean);

			request.setAttribute("successMsg", "Product added successfully");

		} catch (Exception e) {
			request.setAttribute("errorMsg", "ProductId already exist");
			e.printStackTrace();
		}

		ServletUtility.forward("AddProductView.jsp", request, response);

	}
}

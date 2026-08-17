package com.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;
import com.rays.util.ServletUtility;

@WebServlet("/UserRegistrationCtl") // Wild card mapping of servlet
public class UserRegistrationCtl extends HttpServlet {

	// get method is default HTTP method by default call by HTTP
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doGet() method");

		RequestDispatcher rd = request.getRequestDispatcher("UserRegistrationView.jsp");
		rd.forward(request, response); // forward same request on view

	}

	// post method is not default HTTP method it is call when user submit request
	// from view
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doPost() method");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String dob = request.getParameter("dob");

		System.out.println(firstName + "\n" + lastName + "\n" + login + "\n" + password + "\n" + dob);

		try {

			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			bean.setLoginId(login);
			bean.setPassword(password);
			bean.setDob(sdf.parse(dob));
			model.add(bean);

			request.setAttribute("successMsg", "user registration successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}

		ServletUtility.forward("UserRegistrationView.jsp", request, response);

	}

}

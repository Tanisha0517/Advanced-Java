package com.rays.ctl;
import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;
import com.rays.util.InputValidatorUtility;
import com.rays.util.ServletUtility;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("request method == " + request.getMethod());

		if (request.getMethod().equalsIgnoreCase("POST")) {
			if (InputValidatorUtility.loginValidator(request) == false) {
				ServletUtility.forward("LoginView.jsp", request, response);
				return;
			}
		}

		super.service(request, response);
	}
	
//	-------

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");

		if (op != null) {
			HttpSession session = request.getSession();
			session.invalidate();// invalidate method use to destroy session attribute
			request.setAttribute("successMsg", "user logout successfully");
		}

		ServletUtility.forward("LoginView.jsp", request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		HttpSession session = request.getSession();

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		try {
			bean = model.authenticate(login, password);

			if (bean != null) {
				session.setAttribute("user", bean);
				response.sendRedirect("WelcomeCtl");
			} else {
				request.setAttribute("errorMsg", "loginId or password is invalid");
				ServletUtility.forward("LoginView.jsp", request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//------------------------------------------------
//@WebServlet("/LoginCtl") // Wild card mapping of servlet
//public class LoginCtl extends HttpServlet{
//
//	// get method is default HTTP method by default call by HTTP
//		@Override
//		protected void doGet(HttpServletRequest request, HttpServletResponse response)
//				throws ServletException, IOException {
//
//			System.out.println("this is doGet() method");
//
//			RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
//			rd.forward(request, response); // forward same request on view
//
//		}
//
//		// post method is not default HTTP method it is call when user submit request
//		// from view
//		@Override
//		protected void doPost(HttpServletRequest request, HttpServletResponse response)
//				throws ServletException, IOException {
//
//		}
//--------------------------------------------------
		
	
}

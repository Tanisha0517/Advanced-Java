package com.rays.util;

import javax.servlet.http.HttpServletRequest;

public class InputValidatorUtility {

	public static boolean loginValidator(HttpServletRequest request) {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		boolean pass = true;

		if (login.equals("")) {
			pass = false;
			request.setAttribute("login", "loginId is required");
		}

		if (password.equals("")) {
			pass = false;
			request.setAttribute("password", "password is required");
		}
//		else if (password.length() < 8 || password.length() > 12) {
//			pass = false;
//			request.setAttribute("password", "password lenght shuld be > 8 or == 12");
//		}

		return pass;

	}

//	-------------------------------------------------------------------------------------------
	public static boolean userValidator(HttpServletRequest request) {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String dob = request.getParameter("dob");

		boolean pass = true;

		if (firstName.equals("")) {
			pass = false;
			request.setAttribute("firstName", "First Name is required");
		} else if (!firstName.matches("[a-zA-Z]+")) {
			pass = false;
			request.setAttribute("firstName", "First Name is required");
		}

		if (lastName.equals("")) {
			pass = false;
			request.setAttribute("lastName", "Last Name is required");
		}

		else if (!lastName.matches("[a-zA-Z]+")) {
			pass = false;
			request.setAttribute("lastName", "Last Name is required");
		}

		if (login.equals("")) {
			pass = false;
			request.setAttribute("login", "Login is required");
		}

		if (password.equals("")) {
			pass = false;
			request.setAttribute("password", "password is required");
		} else if (password.length() < 8 || password.length() > 12) {
			pass = false;
			request.setAttribute("password", "password lenght shuld be > 8 or == 12");
		}

		if (dob.equals("")) {
			pass = false;
			request.setAttribute("dob", "dob is required");
		}
		return pass;
	}

}

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

	public static boolean serviceValidator(HttpServletRequest request) {

		String serviceId = request.getParameter("serviceId");
		String serviceName = request.getParameter("serviceName");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		String serviceCategory = request.getParameter("serviceCategory");

		boolean pass = true;

		if (serviceId.equals("")) {
			pass = false;
			request.setAttribute("serviceId", "Service Id is required");
		}

		if (serviceName.equals("")) {
			pass = false;
			request.setAttribute("serviceName", "Service Name is required");
		}

		if (price.equals("")) {
			pass = false;
			request.setAttribute("price", "Price is required");
		}

		if (description.equals("")) {
			pass = false;
			request.setAttribute("description", "Description is required");
		}

		if (serviceCategory.equals("")) {
			pass = false;
			request.setAttribute("serviceCategory", "Service Category is required");
		}
		return pass;
	}

	public static boolean courseValidator(HttpServletRequest request) {

		String courseId = request.getParameter("courseId");
		String courseName = request.getParameter("courseName");
		String duration = request.getParameter("duration");
		String fees = request.getParameter("fees");
		String trainerName = request.getParameter("trainerName");

		boolean pass = true;

		if (courseId.equals("")) {
			pass = false;
			request.setAttribute("courseId", "Course Id is required");
		}

		if (courseName.equals("")) {
			pass = false;
			request.setAttribute("courseName", "Course Name is required");
		}

		if (duration.equals("")) {
			pass = false;
			request.setAttribute("duration", "Duration is required");
		}

		if (fees.equals("")) {
			pass = false;
			request.setAttribute("fees", "Fees is required");
		}

		if (trainerName.equals("")) {
			pass = false;
			request.setAttribute("trainerName", "Trainer Name is required");
		}
		return pass;
	}

//	-----------------------------productValidator()---------------------------------------------

	public static boolean productValidator(HttpServletRequest request) {

		String productId = request.getParameter("productId");
		String productName = request.getParameter("productName");
		String price = request.getParameter("price");
		String quantity = request.getParameter("quantity");
		String category = request.getParameter("category");

		boolean pass = true;

		if (productId.equals("")) {
			pass = false;
			request.setAttribute("productId", "Product Id is required");
		}

		if (productName.equals("")) {
			pass = false;
			request.setAttribute("productName", "Product Name is required");
		}

		if (price.equals("")) {
			pass = false;
			request.setAttribute("price", "Price is required");
		}

		if (quantity.equals("")) {
			pass = false;
			request.setAttribute("quantity", "Quantity is required");
		}

		if (category.equals("")) {
			pass = false;
			request.setAttribute("category", "Category is required");
		}
		return pass;
	}

//	-----------------------------employeeValidator()-------------------------------

	public static boolean employeeValidator(HttpServletRequest request) {
		// id = non business pk

		String employeeCode = request.getParameter("employeeCode");
		String name = request.getParameter("name");
		String designation = request.getParameter("designation");
		String salary = request.getParameter("salary");
		String joiningDate = request.getParameter("joiningDate");

		boolean pass = true;

		if (employeeCode.equals("")) {
			pass = false;
			request.setAttribute("employeeCode", "Employee Code is required");
		}

		if (name.equals("")) {
			pass = false;
			request.setAttribute("name", "Name is required");
		}

		if (designation.equals("")) {
			pass = false;
			request.setAttribute("designation", "Designation is required");
		}

		if (salary.equals("")) {
			pass = false;
			request.setAttribute("salary", "Salary is required");
		}

		if (joiningDate == null || joiningDate.trim().isEmpty()) {
			pass = false;
			request.setAttribute("joiningDate", "Joining Date is required");
		}
		return pass;
	}

//	----------------------------------studentValidator()-------------------------------------------

	public static boolean studentValidator(HttpServletRequest request) {

		String rollNo = request.getParameter("rollNo");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobileNo = request.getParameter("mobileNo");
		String course = request.getParameter("course");

		boolean pass = true;

		if (rollNo.equals("")) {
			pass = false;
			request.setAttribute("rollNo", "Roll No is required");
		}

		if (name.equals("")) {
			pass = false;
			request.setAttribute("name", "Name is required");
		}

		if (email.equals("")) {
			pass = false;
			request.setAttribute("email", "email is required");
		}

		if (mobileNo.equals("")) {
			pass = false;
			request.setAttribute("mobileNo", "Contact No is required");
		}

		if (course.equals("")) {
			pass = false;
			request.setAttribute("course", "Course is required");
		}
		return pass;
	}

//	----------------------------------customerValidator----------------------------------------

	public static boolean customerValidator(HttpServletRequest request) {
		// id = non business pk

		String customerId = request.getParameter("customerId");
		String customerName = request.getParameter("customerName");
		String email = request.getParameter("email");
		String phoneNo = request.getParameter("phoneNo");
		String address = request.getParameter("address");

		boolean pass = true;

		if (customerId.equals("")) {
			pass = false;
			request.setAttribute("customerId", "Customer Id is required");
		}

		if (customerName.equals("")) {
			pass = false;
			request.setAttribute("customerName", "Customer Name is required");
		}

		if (email.equals("")) {
			pass = false;
			request.setAttribute("email", "email is required");
		}

		if (phoneNo.equals("")) {
			pass = false;
			request.setAttribute("phoneNo", "Phone No is required");
		}

		if (address.equals("")) {
			pass = false;
			request.setAttribute("address", "Address is required");
		}
		return pass;
	}

//	--------------------------------------------orderValidator()--------------------------------------------------

	public static boolean orderValidator(HttpServletRequest request) {
		// id = non business pk

		String orderId = request.getParameter("orderId");
		String orderDate = request.getParameter("orderDate");
		String amount = request.getParameter("amount");
		String status = request.getParameter("status");
//		String customerId = request.getParameter("customerId");

		boolean pass = true;

		if (orderId.equals("")) {
			pass = false;
			request.setAttribute("orderId", "Order Id is required");
		}

		if (orderDate.equals("")) {
			pass = false;
			request.setAttribute("orderDate", "Order Date is required");
		}

		if (amount.equals("")) {
			pass = false;
			request.setAttribute("amount", "Amount is required");
		}

		if (status.equals("")) {
			pass = false;
			request.setAttribute("status", "Status is required");
		}

//		if (customerId.equals("")) {
//			pass = false;
//			request.setAttribute("customerId", "Customer Id is required");
//		}
		return pass;
	}

//	----------------------------------vehicleValidator()-------------------------------------------
	public static boolean vehicleValidator(HttpServletRequest request) {
		// id = non business pk

		String vehicleNo = request.getParameter("vehicleNo");
		String vehicleName = request.getParameter("vehicleName");
		String model = request.getParameter("model");
		String color = request.getParameter("color");
		String price = request.getParameter("price");

		boolean pass = true;

		if (vehicleNo.equals("")) {

		    pass = false;
		    request.setAttribute("vehicleNo", "Vehicle Number is required");

		} else if (!vehicleNo.matches("^[A-Z]{2}[0-9]{2}[A-Z]{1,2}[0-9]{4}$")) {

		    pass = false;
		    request.setAttribute("vehicleNo", "Please enter a valid vehicle number (e.g., MP09AB1234)");
		}

		if (vehicleName.equals("")) {
			pass = false;
			request.setAttribute("vehicleName", "Vehicle Name is required");
		}

		if (model.equals("")) {
			pass = false;
			request.setAttribute("model", "Model is required");
		}

		if (color.equals("")) {
			pass = false;
			request.setAttribute("color", "Color is required");
		}

		if (price.equals("")) {
			pass = false;
			request.setAttribute("price", "Price is required");
		}
		return pass;
	}
}

<%@ page import="com.rays.bean.UserBean"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Insert title here</title>

<style>

/* CSS: Basic page styling */
body {
	margin: 0;
	font-family: Arial, sans-serif;
	background-color: #F8FAFC;
	color: #334155;
}

/* CSS: Professional dark header */
.header {
	background-color: #111827;
	text-align: center;
	padding: 18px;
	border-bottom: 3px solid #2563EB;
}

/* CSS: Welcome heading */
.header h2 {
	color: white;
	margin: 5px 0 20px;
	font-size: 25px;
}

/* CSS: Navigation links */
.header a {
	color: white;
	text-decoration: none;
	font-size: 16px;
	margin: 0 4px;
}

/* CSS: Navigation link hover effect */
.header a:hover {
	color: yellow;
	text-decoration: underline;
}

/* CSS: Horizontal line */
.header hr {
	border: 0;
	border-top: 1px solid #334155;
	margin-top: 18px;
}
</style>
</head>

<body>

	<%
	UserBean user = (UserBean) session.getAttribute("user");
	%>

	<div class="header">

		<%
		if (user != null) {
		%>

		<h2><%="Hii, " + user.getFirstName()%></h2>

		<a href="WelcomeCtl">Welcome</a> | 
		<a href="UserListCtl">User List</a>|
		<a href="UserCtl">Add User</a> | 
		<a href="AddServiceCtl">Add Service</a> | 
		<a href="ServiceListCtl">View Service</a> | 
		<a href="AddCourseCtl">Add Courses</a> | 
		<a href="CourseListCtl">View Courses</a> | 
		<a href="AddProductCtl">Add Product</a> | 
		<a href="ProductListCtl">View Product</a> | 
		<a href="AddEmployeeCtl">Add Employee</a> | 
		<a href="EmployeeListCtl">View Employee</a> | 
		<a href="AddStudentCtl">Add Student</a> | 
		<a href="StudentListCtl">View Student</a> | 
		<a href="AddCustomerCtl">Add Customer</a> | 
		<a href="CustomerListCtl">View Customer</a> | 
		<a href="AddOrderCtl">Add Orders</a> |
		<a href="OrderListCtl">View Orders</a> | 
		<a href="LoginCtl?operation=logout">Logout</a> |

		<%
		} else {
		%>

		<h2>Hii, Guest</h2>

		<a href="LoginCtl">Login</a> | <a href="UserRegistrationCtl">SignUp</a>
		| <a href="WelcomeCtl">Welcome</a>

		<%
		}
		%>

	</div>

</body>

</html>


<%-- <a href="LoginCtl">Login</a> |
	<a href="UserRegistrationCtl">SignUp</a> |
	<a href="WelcomeCtl">Welcome</a>

	<hr>--%>
<%@page import="com.rays.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String succ = (String) request.getAttribute("successMsg");
	String err = (String) request.getAttribute("errorMsg");
	%>


	<%@ include file="Header.jsp"%>

	<div align="center">
		<h1 align="center" style="color: darkblue;">Add Employee</h1>

		<h3 style="color: red"><%=err != null ? err : ""%></h3>
		<h3 style="color: green"><%=succ != null ? succ : ""%></h3>

		<form action="AddCustomerCtl" method="post">


			<table>

				<tr>
					<th>Customer Id:<font color="red">*</font></th>
					<td><input type="text" name="customerId" value=""
						placeholder="enter customer id"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("customerId", request)%></td>
				</tr>

				<tr>
					<th>Customer Name:<font color="red">*</font></th>
					<td><input type="text" name="customerName" value=""
						placeholder="enter name"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("customerName", request)%></td>
				</tr>

				<tr>
					<th>Email:<font color="red">*</font></th>
					<td><input type="text" name="email" value=""
						placeholder="enter email"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("email", request)%></td>
				</tr>

				<tr>
					<th>Phone No:<font color="red">*</font></th>
					<td><input type="text" name="phoneNo" value=""
						placeholder="enter phone no"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("phoneNo", request)%></td>
				</tr>

				<tr>
					<th>Address:<font color="red">*</font></th>
					<td><input type="text" name="address" value=""
						placeholder="enter address"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("address", request)%></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" value="Add Course"></td>
				</tr>

			</table>
		</form>
	</div>
</body>
</html>
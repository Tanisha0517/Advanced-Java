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
		<h1 align="center" style="color: darkblue;">Add Orders</h1>

		<h3 style="color: red"><%=err != null ? err : ""%></h3>
		<h3 style="color: green"><%=succ != null ? succ : ""%></h3>
		
		<form action="AddOrderCtl" method="post">


			<table>

				<tr>
					<th>Order Id:<font color="red">*</font></th>
					<td><input type="text" name="orderId" value=""
						placeholder="enter order Id"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("orderId", request)%></td>
				</tr>

				<tr>
					<th>Order Date:<font color="red">*</font></th>
					<td><input type="date" name="orderDate" value=""
						placeholder="enter order date"></td>
						<td style="color: red"><%=ServletUtility.getErrorMessage("orderDate", request)%></td>
				</tr>

				<tr>
					<th>Amount:<font color="red">*</font></th>
					<td><input type="text" name="amount" value=""
						placeholder="enter amount"></td>
						<td style="color: red"><%=ServletUtility.getErrorMessage("amount", request)%></td>
				</tr>

				<tr>
					<th>Status:<font color="red">*</font></th>
					<td><input type="text" name="status" value=""
						placeholder="enter status"></td>
						<td style="color: red"><%=ServletUtility.getErrorMessage("status", request)%></td>
				</tr>



				<tr>
					<th></th>
					<td><input type="submit" value="Add Orders"></td>
				</tr>

			</table>
			</form>
	</div>

</body>
</html>
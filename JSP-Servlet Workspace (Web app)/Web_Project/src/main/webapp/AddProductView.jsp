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
		<h1 align="center" style="color: darkblue;">Add Products</h1>

		<h3 style="color: red"><%=err != null ? err : ""%></h3>
		<h3 style="color: green"><%=succ != null ? succ : ""%></h3>

		<form action="AddProductCtl" method="post">


			<table>

				<tr>
					<th>Product Id:<font color="red">*</font></th>
					<td><input type="text" name="productId" value=""
						placeholder="enter product Id"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("productId", request)%></td>
				</tr>

				<tr>
					<th>Product Name:<font color="red">*</font></th>
					<td><input type="text" name="productName" value=""
						placeholder="enter product Name"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("productName", request)%></td>
				</tr>

				<tr>
					<th>Price:<font color="red">*</font></th>
					<td><input type="text" name="price" value=""
						placeholder="enter price"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("price", request)%></td>
				</tr>

				<tr>
					<th>Quantity:<font color="red">*</font></th>
					<td><input type="text" name="quantity" value=""
						placeholder="enter quantity"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("quantity", request)%></td>
				</tr>

				<tr>
					<th>Category:<font color="red">*</font></th>
					<td><input type="text" name="category" value=""
						placeholder="enter category"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("category", request)%></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" value="Add Products"></td>
				</tr>

			</table>
		</form>
	</div>

</body>
</html>
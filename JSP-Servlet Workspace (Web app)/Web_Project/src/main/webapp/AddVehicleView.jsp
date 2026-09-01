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
		<h1 align="center" style="color: darkblue;">Add Vehicle</h1>

		<h3 style="color: red"><%=err != null ? err : ""%></h3>
		<h3 style="color: green"><%=succ != null ? succ : ""%></h3>

		<form action="AddVehicleCtl" method="post">


			<table>

				<tr>
					<th>Vehicle No:<font color="red">*</font></th>
					<td><input type="text" name="vehicleNo" value=""
						placeholder="enter vehicle no"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("vehicleNo", request)%></td>
				</tr>

				<tr>
					<th>Vehicle Name:<font color="red">*</font></th>
					<td><input type="text" name="vehicleName" value=""
						placeholder="enter vehicle name"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("vehicleName", request)%></td>
				</tr>

				<tr>
					<th>Model:<font color="red">*</font></th>
					<td><input type="text" name="model" value=""
						placeholder="enter model"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("model", request)%></td>
				</tr>

				<tr>
					<th>Color:<font color="red">*</font></th>
					<td><input type="text" name="color" value=""
						placeholder="enter color"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("color", request)%></td>
				</tr>

				<tr>
					<th>Price:<font color="red">*</font></th>
					<td><input type="text" name="price" value=""
						placeholder="enter price"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("price", request)%></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" value="Add Vehicle"></td>
				</tr>

			</table>
		</form>
	</div>


</body>
</html>
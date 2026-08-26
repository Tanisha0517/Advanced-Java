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
		<h1 align="center" style="color: darkblue;">Add Service</h1>

		<h3 style="color: red"><%=err != null ? err : ""%></h3>
		<h3 style="color: green"><%=succ != null ? succ : ""%></h3>
		
		<form action="AddServiceCtl" method="post">


			<table>

				<tr>
					<th>Service Id:<font color="red">*</font></th>
					<td><input type="text" name="serviceId" value=""
						placeholder="enter service Id"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("serviceId", request)%></td>
				</tr>

				<tr>
					<th>Service Name:<font color="red">*</font></th>
					<td><input type="text" name="serviceName" value=""
						placeholder="enter serviceName"></td>
						<td style="color: red"><%=ServletUtility.getErrorMessage("serviceName", request)%></td>
				</tr>

				<tr>
					<th>Price:<font color="red">*</font></th>
					<td><input type="text" name="price" value=""
						placeholder="enter price"></td>
						<td style="color: red"><%=ServletUtility.getErrorMessage("price", request)%></td>
				</tr>

				<tr>
					<th>Description:<font color="red">*</font></th>
					<td><input type="text" name="description" value=""
						placeholder="enter description"></td>
						<td style="color: red"><%=ServletUtility.getErrorMessage("description", request)%></td>
				</tr>

				<tr>
					<th>Service Category:<font color="red">*</font></th>
					<td><input type="text" name="serviceCategory" value=""
						placeholder="enter service category"></td>
						<td style="color: red"><%=ServletUtility.getErrorMessage("serviceCategory", request)%></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" value="Add Service"></td>
				</tr>

			</table>
			</form>
	</div>
</body>
</html>
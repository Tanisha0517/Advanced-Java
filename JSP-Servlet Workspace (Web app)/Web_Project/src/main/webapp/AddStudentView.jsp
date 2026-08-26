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
		<h1 align="center" style="color: darkblue;">Add Student</h1>

		<h3 style="color: red"><%=err != null ? err : ""%></h3>
		<h3 style="color: green"><%=succ != null ? succ : ""%></h3>

		<form action="AddStudentCtl" method="post">


			<table>

				<tr>
					<th>Roll No:<font color="red">*</font></th>
					<td><input type="text" name="rollNo" value=""
						placeholder="enter roll no"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("rollNo", request)%></td>
				</tr>

				<tr>
					<th>Name:<font color="red">*</font></th>
					<td><input type="text" name="name" value=""
						placeholder="enter name"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("name", request)%></td>
				</tr>

				<tr>
					<th>Email:<font color="red">*</font></th>
					<td><input type="text" name="email" value=""
						placeholder="enter email"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("email", request)%></td>
				</tr>

				<tr>
					<th>Mobile No:<font color="red">*</font></th>
					<td><input type="text" name="mobileNo" value=""
						placeholder="enter mobile no"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("mobileNo", request)%></td>
				</tr>

				<tr>
					<th>Course:<font color="red">*</font></th>
					<td><input type="date" name="course" value=""
						placeholder="enter course"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("course", request)%></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" value="Add Student"></td>
				</tr>

			</table>
		</form>
	</div>

</body>
</html>
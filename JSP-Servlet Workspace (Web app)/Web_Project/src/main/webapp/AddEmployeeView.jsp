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

		<form action="AddEmployeeCtl" method="post">


			<table>

				<tr>
					<th>Employee Code:<font color="red">*</font></th>
					<td><input type="text" name="employeeCode" value=""
						placeholder="enter employee code"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("employeeCode", request)%></td>
				</tr>

				<tr>
					<th>Name:<font color="red">*</font></th>
					<td><input type="text" name="name" value=""
						placeholder="enter name"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("name", request)%></td>
				</tr>

				<tr>
					<th>Designation:<font color="red">*</font></th>
					<td><input type="text" name="designation" value=""
						placeholder="enter designation"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("designation", request)%></td>
				</tr>

				<tr>
					<th>Salary:<font color="red">*</font></th>
					<td><input type="text" name="salary" value=""
						placeholder="enter salary"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("salary", request)%></td>
				</tr>

				<tr>
					<th>Joining Date:<font color="red">*</font></th>
					<td><input type="date" name="joiningDate" value=""
						placeholder="enter joining date"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("joiningDate", request)%></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" value="Add Employee"></td>
				</tr>

			</table>
		</form>
	</div>

</body>
</html>
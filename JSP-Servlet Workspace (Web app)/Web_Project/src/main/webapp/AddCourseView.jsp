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
		<h1 align="center" style="color: darkblue;">Add Courses</h1>

		<h3 style="color: red"><%=err != null ? err : ""%></h3>
		<h3 style="color: green"><%=succ != null ? succ : ""%></h3>
		
		<form action="AddCourseCtl" method="post">


			<table>

				<tr>
					<th>Course Id:<font color="red">*</font></th>
					<td><input type="text" name="courseId" value=""
						placeholder="enter course Id"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("courseId", request)%></td>
				</tr>

				<tr>
					<th>Course Name:<font color="red">*</font></th>
					<td><input type="text" name="courseName" value=""
						placeholder="enter course Name"></td>
						<td style="color: red"><%=ServletUtility.getErrorMessage("courseName", request)%></td>
				</tr>

				<tr>
					<th>Duration:<font color="red">*</font></th>
					<td><input type="text" name="duration" value=""
						placeholder="enter duration"></td>
						<td style="color: red"><%=ServletUtility.getErrorMessage("duration", request)%></td>
				</tr>

				<tr>
					<th>Fees:<font color="red">*</font></th>
					<td><input type="text" name="fees" value=""
						placeholder="enter fees"></td>
						<td style="color: red"><%=ServletUtility.getErrorMessage("fees", request)%></td>
				</tr>

				<tr>
					<th>Trainer Name:<font color="red">*</font></th>
					<td><input type="text" name="trainerName" value=""
						placeholder="enter trainer name"></td>
						<td style="color: red"><%=ServletUtility.getErrorMessage("trainerName", request)%></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" value="Add Courses"></td>
				</tr>

			</table>
			</form>
	</div>
</body>
</html>
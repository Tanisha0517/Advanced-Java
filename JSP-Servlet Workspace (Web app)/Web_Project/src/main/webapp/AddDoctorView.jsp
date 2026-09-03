<%@page import="com.rays.util.ServletUtility"%>
<%@page import="com.rays.bean.DoctorBean"%>

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
	DoctorBean bean = (DoctorBean) request.getAttribute("bean");
	%>


	<%@ include file="Header.jsp"%>

	<div align="center">
		<h1 align="center" style="color: darkblue;">Add Doctor</h1>

		<h3 style="color: red"><%=err != null ? err : ""%></h3>
		<h3 style="color: green"><%=succ != null ? succ : ""%></h3>
		
		<form action="AddDoctorCtl" method="post">


			<table>

				<tr>
					<th>Doctor Id:<font color="red">*</font></th>
					<td><input type="text" name="doctorId" value="<%=bean != null ? bean.getDoctorId() : ""%>"
						placeholder="enter doctor Id"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("doctorId", request)%></td>
				</tr>

				<tr>
					<th>Doctor Name:<font color="red">*</font></th>
					<td><input type="text" name="doctorName" value="<%=bean != null ? bean.getDoctorName() : ""%>"
						placeholder="enter Doctor name"></td>
						<td style="color: red"><%=ServletUtility.getErrorMessage("doctorName", request)%></td>
				</tr>

				<tr>
					<th>Specialization:<font color="red">*</font></th>
					<td><input type="text" name="specialization" value="<%=bean != null ? bean.getSpecialization() : ""%>"
						placeholder="enter specialization"></td>
						<td style="color: red"><%=ServletUtility.getErrorMessage("specialization", request)%></td>
				</tr>

				<tr>
					<th>Experience:<font color="red">*</font></th>
					<td><input type="number" name="experience" value="<%=bean != null ? bean.getExperience() : ""%>"
						placeholder="enter experience"></td>
						<td style="color: red"><%=ServletUtility.getErrorMessage("experience", request)%></td>
				</tr>

                <tr>
					<th>Contact No:<font color="red">*</font></th>
					<td><input type="text" name="contactNo" value="<%=bean != null ? bean.getContactNo() : ""%>"
						placeholder="enter contact no"></td>
						<td style="color: red"><%=ServletUtility.getErrorMessage("contactNo", request)%></td>
				</tr>
                


				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=bean != null ? "update" : "save"%>"></td>
				</tr>

			</table>
			</form>
	</div>
</body>
</html>
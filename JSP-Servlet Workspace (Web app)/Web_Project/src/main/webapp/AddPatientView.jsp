<%@page import="com.rays.util.ServletUtility"%>
<%@page import="com.rays.bean.PatientBean"%>

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
	PatientBean bean = (PatientBean) request.getAttribute("bean");
	%>


	<%@ include file="Header.jsp"%>

	<div align="center">
		<h1 align="center" style="color: darkblue;">Add Patient</h1>

		<h3 style="color: red"><%=err != null ? err : ""%></h3>
		<h3 style="color: green"><%=succ != null ? succ : ""%></h3>

		<form action="AddPatientCtl" method="post">


			<table>

				<tr>
					<th>Patient Id:<font color="red">*</font></th>
					<td><input type="text" name="patientId" value="<%=bean != null ? bean.getPatientId() : ""%>"
						placeholder="enter patient id"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("patientId", request)%></td>
				</tr>

				<tr>
					<th>Patient Name:<font color="red">*</font></th>
					<td><input type="text" name="patientName" value="<%=bean != null ? bean.getPatientName() : ""%>"
						placeholder="enter patient name"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("patientName", request)%></td>
				</tr>

				<tr>
					<th>Disease:<font color="red">*</font></th>
					<td><input type="text" name="disease" value="<%=bean != null ? bean.getDisease() : ""%>"
						placeholder="enter disease"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("disease", request)%></td>
				</tr>

				<tr>
					<th>Doctor Name:<font color="red">*</font></th>
					<td><input type="text" name="doctorName" value="<%=bean != null ? bean.getDoctorName() : ""%>"
						placeholder="enter doctor name"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("doctorName", request)%></td>
				</tr>

				<tr>
					<th>Admission Date:<font color="red">*</font></th>
					<td><input type="date" name="admissionDate" value="<%=bean != null ? bean.getAdmissionDate() : ""%>"
						placeholder="enter admission date"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("admissionDate", request)%></td>
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
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
	List<PatientBean> list = (List) request.getAttribute("list");
	Iterator<PatientBean> it = list.iterator();
	
	String succ = (String) request.getAttribute("successMsg");
	String err = (String) request.getAttribute("errorMsg");
	int pageNo = (int) request.getAttribute("pageNo");
	%>

	<%@ include file="Header.jsp"%>
	<form action="PatientListCtl.do" method="post">
	<div align="center">

		<h1>Patient List</h1>

        <h3 style="color: red"><%=err != null ? err : ""%></h3>
		<h3 style="color: green"><%=succ != null ? succ : ""%></h3>


        <input type="hidden" name="pageNo" value="<%=pageNo%>">

        <table>
				<tr>
					<td><input type="text" name="patientId" value=""
						placeholder="search by patient id"></td>
					<td><input type="text" name="disease" value=""
						placeholder="search by disease"></td>
					<td><input type="submit" name="operation" value="search"></td>
				</tr>
		</table>

		<table border="1px" width="100%">

			<tr style="background-color: skyblue">
			<th><input type="checkbox"
						onclick="document.querySelectorAll('input[name=ids]').forEach(c=>c.checked=this.checked)"></th>
				<th>Patient Id</th>
				<th>Patient Name</th>
				<th>Disease</th>
				<th>Doctor Name</th>
				<th>Admission Date</th>
				<th>Edit</th>
			</tr>

			<%
			while (it.hasNext()) {
				PatientBean bean = it.next();
			%>
			<tr align="center" style="background-color: lightgrey">
			<td><input type="checkbox" name="ids"
						value="<%=bean.getId()%>"></td>
				<td><%=bean.getPatientId()%></td>
				<td><%=bean.getPatientName()%></td>
				<td><%=bean.getDisease()%></td>
				<td><%=bean.getDoctorName()%></td>
				<td><%=bean.getAdmissionDate()%></td>
				<td><a href="PatientListCtl.do?id=<%=bean.getId()%>">Edit</a></td>
			</tr>
			<%
			}
			%>

		</table>

	<h3>
			pageNo=<%=pageNo%>
		</h3>

	</div>
	
	<table width="100%">
			<tr>
				<td><input type="submit" name="operation" value="previous" <%=pageNo == 1 ? "disabled" : ""%>></td>
				<td align="center"><input type="submit" name="operation"
					value="delete"></td>
				<td align="right"><input type="submit" name="operation"
					value="next" <%=list.size() < 5 ? "disabled" : ""%>></td>
			</tr>
		</table>
	</form>

	<%@ include file="Footer.jsp"%>

</body>
</html>
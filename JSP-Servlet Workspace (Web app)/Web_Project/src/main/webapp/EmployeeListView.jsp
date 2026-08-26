<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.bean.EmployeeBean"%>


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
	List<EmployeeBean> list = (List) request.getAttribute("list");
	Iterator<EmployeeBean> it = list.iterator();
	%>

	<%@ include file="Header.jsp"%>
	<div align="center">

		<h1>Employee List</h1>

		<table border="1px" width="100%">

			<tr style="background-color: lightblue">
			    <th>Id</th>
				<th>Employee Code</th>
				<th>Name</th>
				<th>Designation</th>
				<th>Salary</th>
				<th>Joining Date</th>
			</tr>

			<%
			while (it.hasNext()) {
				EmployeeBean bean = it.next();
			%>
			<tr align="center" style="background-color: white">
			    <td><%=bean.getId()%></td>
				<td><%=bean.getEmployeeCode()%></td>
				<td><%=bean.getName()%></td>
				<td><%=bean.getDesignation()%></td>
				<td><%=bean.getSalary()%></td>
				<td><%=bean.getJoinDate()%></td>
			</tr>
			<%
			}
			%>

		</table>

	</div>

	<%@ include file="Footer.jsp"%>

</body>
</html>
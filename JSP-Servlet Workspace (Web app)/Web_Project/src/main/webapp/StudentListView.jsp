<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.bean.StudentBean"%>

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
	List<StudentBean> list = (List) request.getAttribute("list");
	Iterator<StudentBean> it = list.iterator();
	%>

	<%@ include file="Header.jsp"%>
	<div align="center">

		<h1>Course List</h1>

		<table border="1px" width="100%">

			<tr style="background-color: lightblue">
			    <th>Id</th>
				<th>Roll No</th>
				<th>Name</th>
				<th>Email</th>
				<th>Mobile No</th>
				<th>Course</th>
			</tr>

			<%
			while (it.hasNext()) {
				StudentBean bean = it.next();
			%>
			<tr align="center" style="background-color: white">
			    <td><%=bean.getId()%></td>
				<td><%=bean.getRollNo()%></td>
				<td><%=bean.getName()%></td>
				<td><%=bean.getEmail()%></td>
				<td><%=bean.getMobileNo()%></td>
				<td><%=bean.getCourse()%></td>
			</tr>
			<%
			}
			%>

		</table>

	</div>

	<%@ include file="Footer.jsp"%>

</body>
</html>
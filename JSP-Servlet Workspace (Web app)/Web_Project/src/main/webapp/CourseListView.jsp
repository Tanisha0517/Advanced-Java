<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.bean.CourseBean"%>

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
	List<CourseBean> list = (List) request.getAttribute("list");
	Iterator<CourseBean> it = list.iterator();
	%>

	<%@ include file="Header.jsp"%>
	<div align="center">

		<h1>Course List</h1>

		<table border="1px" width="100%">

			<tr style="background-color: lightblue">
			    <th>Id</th>
				<th>Course Id</th>
				<th>Course Name</th>
				<th>Duration</th>
				<th>Fees</th>
				<th>Trainer Name</th>
			</tr>

			<%
			while (it.hasNext()) {
				CourseBean bean = it.next();
			%>
			<tr align="center" style="background-color: white">
			    <td><%=bean.getId()%></td>
				<td><%=bean.getCourseId()%></td>
				<td><%=bean.getCourseName()%></td>
				<td><%=bean.getDuration()%></td>
				<td><%=bean.getFees()%></td>
				<td><%=bean.getTrainerName()%></td>
			</tr>
			<%
			}
			%>

		</table>

	</div>

	<%@ include file="Footer.jsp"%>

</body>
</html>
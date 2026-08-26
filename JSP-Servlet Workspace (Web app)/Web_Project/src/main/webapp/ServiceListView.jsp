<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.bean.ServiceBean"%>

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
	List<ServiceBean> list = (List) request.getAttribute("list");
	Iterator<ServiceBean> it = list.iterator();
	%>

	<%@ include file="Header.jsp"%>
	<div align="center">

		<h1>Service List</h1>

		<table border="1px" width="100%">

			<tr style="background-color: skyblue">
				<th>Service Id</th>
				<th>Service Name</th>
				<th>Price</th>
				<th>Description</th>
				<th>Service Category</th>
			</tr>

			<%
			while (it.hasNext()) {
				ServiceBean bean = it.next();
			%>
			<tr align="center" style="background-color: lightgrey">
				<td><%=bean.getServiceId()%></td>
				<td><%=bean.getServiceName()%></td>
				<td><%=bean.getPrice()%></td>
				<td><%=bean.getDescription()%></td>
				<td><%=bean.getServiceCategory()%></td>
			</tr>
			<%
			}
			%>

		</table>

	</div>

	<%@ include file="Footer.jsp"%>
</body>
</html>
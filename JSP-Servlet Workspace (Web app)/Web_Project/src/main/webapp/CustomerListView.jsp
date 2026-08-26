<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.bean.CustomerBean"%>

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
	List<CustomerBean> list = (List) request.getAttribute("list");
	Iterator<CustomerBean> it = list.iterator();
	%>

	<%@ include file="Header.jsp"%>
	<div align="center">

		<h1>Customer List</h1>

		<table border="1px" width="100%">

			<tr style="background-color: lightblue">
				<th>Id</th>
				<th>Customer Id</th>
				<th>Customer Name</th>
				<th>Email</th>
				<th>Phone Number</th>
				<th>Address</th>
			</tr>

			<%
			while (it.hasNext()) {
				CustomerBean bean = it.next();
			%>
			<tr align="center" style="background-color: white">
				<td><%=bean.getId()%></td>
				<td><%=bean.getCustomerId()%></td>
				<td><%=bean.getCustomerName()%></td>
				<td><%=bean.getEmail()%></td>
				<td><%=bean.getPhoneNo()%></td>
				<td><%=bean.getAddress()%></td>
			</tr>
			<%
			}
			%>

		</table>

	</div>

	<%@ include file="Footer.jsp"%>

</body>
</html>
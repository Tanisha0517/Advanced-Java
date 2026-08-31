<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.bean.OrderBean"%>


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
	List<OrderBean> list = (List) request.getAttribute("list");
	Iterator<OrderBean> it = list.iterator();
	%>

	<%@ include file="Header.jsp"%>
	<div align="center">

		<h1>Order List</h1>

		<table border="1px" width="100%">

			<tr style="background-color: skyblue">
				<th>Id</th>
				<th>Order Id</th>
				<th>Order Date</th>
				<th>Amount</th>
				<th>Status</th>
				
			</tr>

			<%
			while (it.hasNext()) {
				OrderBean bean = it.next();
			%>
			<tr align="center" style="background-color: lightgrey">
				<td><%=bean.getId()%></td>
				<td><%=bean.getOrderId()%></td>
				<td><%=bean.getOrderDate()%></td>
				<td><%=bean.getAmount()%></td>
				<td><%=bean.getStatus()%></td>
			</tr>
			<%
			}
			%>

		</table>

	</div>

	<%@ include file="Footer.jsp"%>

</body>
</html>
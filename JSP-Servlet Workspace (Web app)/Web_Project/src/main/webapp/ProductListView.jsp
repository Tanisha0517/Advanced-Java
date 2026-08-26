<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.bean.ProductBean"%>

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
	List<ProductBean> list = (List) request.getAttribute("list");
	Iterator<ProductBean> it = list.iterator();
	%>

	<%@ include file="Header.jsp"%>
	<div align="center">

		<h1>Course List</h1>

		<table border="1px" width="100%">

			<tr style="background-color: lightblue">
			    <th>Id</th>
				<th>Product Id</th>
				<th>Product Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Category</th>
			</tr>

			<%
			while (it.hasNext()) {
				ProductBean bean = it.next();
			%>
			<tr align="center" style="background-color: white">
			    <td><%=bean.getId()%></td>
				<td><%=bean.getProductId()%></td>
				<td><%=bean.getProductName()%></td>
				<td><%=bean.getPrice()%></td>
				<td><%=bean.getQuantity()%></td>
				<td><%=bean.getCategory()%></td>
			</tr>
			<%
			}
			%>

		</table>

	</div>

	<%@ include file="Footer.jsp"%>

</body>
</html>
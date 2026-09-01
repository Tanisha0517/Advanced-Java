<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.bean.VehicleBean"%>


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
	List<VehicleBean> list = (List) request.getAttribute("list");
	Iterator<VehicleBean> it = list.iterator();
	
	String succ = (String) request.getAttribute("successMsg");
	String err = (String) request.getAttribute("errorMsg");
	
	%>

	<%@ include file="Header.jsp"%>
	
	<form action = "VehicleListCtl" method="post">
	<div align="center">

		<h1>Vehicle List</h1>
		
		<h3 style="color: red"><%=err != null ? err : ""%></h3>
		<h3 style="color: green"><%=succ != null ? succ : ""%></h3>
		
		<table>
				<tr>
					<td><input type="text" name="vehicleNo" value=""
						placeholder="search by vehicleNo"></td>
					<td><input type="text" name="vehicleName" value=""
						placeholder="search by vehicleName"></td>
					<td><input type="submit" name="operation" value="search"></td>
				</tr>
		</table>

		<table border="1px" width="100%">

			<tr style="background-color: lightblue">
			<th><input type="checkbox"
						onclick="document.querySelectorAll('input[name=ids]').forEach(c=>c.checked=this.checked)"></th>
			
			    <th>Id</th>
				<th>Vehicle No</th>
				<th>Vehicle Name</th>
				<th>Model</th>
				<th>Color</th>
				<th>Price</th>
			</tr>

			<%
			while (it.hasNext()) {
				VehicleBean bean = it.next();
			%>
			<tr align="center" style="background-color: white">
			<td><input type="checkbox" name="ids"
						value="<%=bean.getId()%>"></td>
			    <td><%=bean.getId()%></td>
				<td><%=bean.getVehicleNo()%></td>
				<td><%=bean.getVehicleName()%></td>
				<td><%=bean.getModel()%></td>
				<td><%=bean.getColor()%></td>
				<td><%=bean.getPrice()%></td>
			</tr>
			<%
			}
			%>

		</table>

	</div>
	
	<table width="100%">
			<tr>
				<td><input type="submit" name="operation" value="previous"></td>
				<td align="center"><input type="submit" name="operation"
					value="delete"></td>
				<td align="right"><input type="submit" name="operation"
					value="next"></td>
			</tr>
		</table>
	</form>

	<%@ include file="Footer.jsp"%>

</body>
</html>
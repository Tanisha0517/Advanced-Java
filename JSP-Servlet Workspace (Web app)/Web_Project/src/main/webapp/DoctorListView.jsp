<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.bean.DoctorBean"%>


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
	List<DoctorBean> list = (List) request.getAttribute("list");
	Iterator<DoctorBean> it = list.iterator();
	
	String succ = (String) request.getAttribute("successMsg");
	String err = (String) request.getAttribute("errorMsg");
	int pageNo = (int) request.getAttribute("pageNo");
	%>

	<%@ include file="Header.jsp"%>
	
	<form action="DoctorListCtl.do" method="post">
	<div align="center">

		<h1>Doctor List</h1>
		
		<h3 style="color: red"><%=err != null ? err : ""%></h3>
		<h3 style="color: green"><%=succ != null ? succ : ""%></h3>


        <input type="hidden" name="pageNo" value="<%=pageNo%>">

        
        <!-- Search -->
        <table>
				<tr>
					<td><input type="text" name="doctorId" value=""
						placeholder="search by doctor id"></td>
					<td><input type="text" name="doctorName" value=""
						placeholder="search by doctor name"></td>
					<td><input type="submit" name="operation" value="search"></td>
				</tr>
		</table>
		
		
		
        <!-- Doctor List -->
		<table border="1px" width="100%">

			<tr style="background-color: skyblue">
			<th><input type="checkbox"
						onclick="document.querySelectorAll('input[name=ids]').forEach(c=>c.checked=this.checked)"></th>
				<th>Id</th>
				<th>Doctor Id</th>
				<th>Doctor Name</th>
				<th>Specialization</th>
				<th>Experience</th>
				<th>Contact No</th>
				<th>Edit</th>
			</tr>

			<%
			while (it.hasNext()) {
				DoctorBean bean = it.next();
			%>
			<tr align="center" style="background-color: lightgrey">
			<td><input type="checkbox" name="ids"
						value="<%=bean.getId()%>"></td>
				<td><%=bean.getId()%></td>
				<td><%=bean.getDoctorId()%></td>
				<td><%=bean.getDoctorName()%></td>
				<td><%=bean.getSpecialization()%></td>
				<td><%=bean.getExperience()%></td>
				<td><%=bean.getContactNo()%></td>
				<td><a href="AddDoctorCtl.do?id=<%=bean.getId()%>">Edit</a></td>
			</tr>
			<%
			}
			%>

		</table>

	<!-- Pagination -->
	   <p>
				Page
				<%=pageNo%></p>
	
	<table>
				<tr>

					<td align="left"><input type="submit"
						name="operation" value="previous"
						<%=pageNo == 1 ? "disabled" : ""%>></td>

					<td align="center"><input type="submit"
						name="operation" value="delete"></td>

					<td align="right"><input type="submit"
						name="operation" value="next"
						<%=list.size() < 5 ? "disabled" : ""%>></td>

				</tr>
			</table>

		</div>

	</form>

	<%@ include file="Footer.jsp"%>

</body>
</html>
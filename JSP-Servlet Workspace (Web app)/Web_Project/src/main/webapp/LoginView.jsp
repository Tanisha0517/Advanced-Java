<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>

<body>

	<%@ include file="Header.jsp"%>
	<form>

		<div align="center">

			<h1 style="color: darkblue;">Login</h1>

			<table>
				<tr>
					<th>Login:<font color="red">*</font></th>
					<td><input type="email" name="login" value=""
						placeholder="enter you email"></td>
				</tr>

				<tr>
					<th>Password:<font color="red">*</font></th>
					<td><input type="password" name="password" value=""
						placeholder="enter you password"></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" value="signIn"></td>
				</tr>
			</table>

		</div>

	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>
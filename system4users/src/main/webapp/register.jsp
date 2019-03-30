<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	HttpServletResponse httpResponse = (HttpServletResponse) response;
	if(session.getAttribute("conf") != null) {
		httpResponse.getWriter().println("Your account has been already registered. Please login now.");
		return;
	}
	else if (session.getAttribute("user") != null) {
		httpResponse.sendRedirect("profile.jsp");
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>System4Users - register</title>
</head>
<body>
	<form action="register" method="post">
		<h3>Register to "System4Users"</h3>
		<table>
			<tr>
				<td style="text-align:right">User name:</td>
				<td><input name="name" id="name" type="text" required style="width:200px"></td>
			</tr>
			<tr>
				<td style="text-align:right">Password:</td>
				<td><input name="password" id="password" type="password" required style="width:200px"></td>
			</tr>
			<tr>
				<td style="text-align:right">Confirm Password:</td>
				<td><input name="confirmpassword" id="password" type="password" required style="width:200px"></td>
			</tr>
			<tr>
				<td style="text-align:right">E-mail:</td>
				<td><input name="email" id="email" type="email" required style="width:200px"></td>
			</tr>
			<tr>
				<td style="text-align:right"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>
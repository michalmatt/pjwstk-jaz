<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	HttpServletResponse httpResponse = (HttpServletResponse) response;	
	if (session.getAttribute("user") != null) {
		httpResponse.sendRedirect("profile.jsp");
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>System4Users - login</title>
</head>
<body>
	<form action="login" method="post">
		<h3>Login to "System4Users"</h3>
		<table>
			<tr>
				<td style="text-align:right">User name:</td>
				<td><input name="name" id="name" type="text" required style="width:200px"></td>
			</tr>
			<tr>
				<td style="text-align:right">Password:</td>
				<td><input name="password" id="password" type="password" style="width:200px"></td>
			</tr>
			<tr>
				<td style="text-align:right"></td>
				<td><input type="submit" value="Login"></td>
			</tr>
			</table>
	</form>
</body>
</html>
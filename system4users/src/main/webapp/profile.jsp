<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>System4Users - profile</title>
</head>
<body>
	<h3>Welcome to your profile page on "System4Users"</h3>
	<ul>
		<li style="margin-top: 10px">User name: <%session.getAttribute("name");%></li>
		<li style="margin-top: 10px">E-mail: <%session.getAttribute("email");%></li>
	</ul>
</body>
</html>
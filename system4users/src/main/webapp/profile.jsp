<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="domain.User" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>System4Users - profile</title>
</head>
<body>
	<h3>Welcome to your profile page on "System4Users"</h3>
	<ul>
		<li style="margin-top: 10px">User name: <b><jsp:getProperty property="name" name="user"/></b></li>
		<li style="margin-top: 10px">E-mail: <b><jsp:getProperty property="email" name="user"/></b></li>
	</ul>
</body>
</html>
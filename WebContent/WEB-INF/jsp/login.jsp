<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simple DB Query Utility - Login</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<form name="login-form" class="sdbu-form" action="loginCheck" method="post">
	<div align="center">
		<c:if test='${not empty sessionScope.errorMessage}'>
			<br/>
			<div class="content" style="color:#FF0000">
				${sessionScope.errorMessage}
			</div>
			<br/>
		</c:if>
		<h1>Sign In</h1>
		<a href="register"><h3>Register</h3></a>
		<div class="content">
			<input name="user" type="text" class="input username" placeholder="User Name">
			<br/>
			<input name="password" type="password" class="input password" placeholder="Password">
			<br/><br/>
		<input name="signin" type="submit" value="Login" class="button">
		<br/><br/>
		</div>	
	</div>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simple DB Query Utility - Register</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<form name="register-form" class="sdbu-form" action="regSuccess" method="post">
	<div align="center">
		<h1>Registration</h1>
		<div class="content">
			<input name="user" type="text" placeholder="User Name" class="input username">
			<br/>
			<input name="password" type="password" placeholder="Password" class="input password">
			<br/>
			<input name="email" type="text" placeholder="email" class="input email">
			<br/><br/>
			<input name="register" type="submit" value="Register" class="button">
			<br/><br/>
		</div>	
	</div>
</form>
</body>
</html>
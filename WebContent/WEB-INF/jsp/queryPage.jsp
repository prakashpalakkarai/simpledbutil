<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simple DB Query Utility - query Page</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<form name="queryPage-form" class="sdbu-query-form" action="queryResult" method="post">
	<div align="center" class="content">
		<h3>Enter Query</h3>
		<textarea name="query" class="queryarea query" rows="10" cols="500">
		</textarea>
		<br/><br/>
		<input name="queryButton" type="submit" value="Query" class="button">
		<br/><br/>
	</div>	
</form>
</body>
</html>
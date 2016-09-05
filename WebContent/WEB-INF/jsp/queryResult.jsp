<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simple DB Query Utility - query Result</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<form name="queryResult-form" class="sdbu-query-form" action="queryPage" method="post">
	<div align="center" class="content">
		<h3>Query Result</h3>
		<c:if test='${not empty sessionScope.queryResult}'>
			<div class="content">
				${sessionScope.queryResult}
			</div>
		</c:if>
		<br/><br/>
		<input name="backbutton" type="submit" value="Back" class="button">
		<br/><br/>
	</div>	
</form>
</body>
</html>
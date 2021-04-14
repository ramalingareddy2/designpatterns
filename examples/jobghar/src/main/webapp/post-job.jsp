<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Post Job</title>
	</head>
	<body>
		<h2>Post Job</h2>
		<form action="${pageContext.request.contextPath}/postJob.web" method="post">
			Title: <input type="text" name="title"><br>
			Description: <textarea name="description" rows="20" cols="4"></textarea> <br>
			experience: <input type="number" name="experience" min="0" max="30"/><br>
			<input type="submit" value="post"/>
		</form>
	</body>
</html>
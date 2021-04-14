<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add Stock</title>
	</head>
	<body>
		<h2>Add Stock</h2>
		<form action="${pageContext.request.contextPath}/add-stock" method="post">
			Stock Name: <input type="text" name="stockName"/> <br/>
			Description: <input type="text" name="description"/> <br/>
			Manufacturer: <input type="text" name="manufacturer"/> <br/>
			Quantity: <input type="text" name="quantity"/> <br/>
			Price: <input type="text" name="price"/>
			<input type="hidden" name="clientToken" value="${token}"/>
			<input type="submit" value="add"/>
		</form>
	</body>
</html>
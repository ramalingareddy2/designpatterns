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
		<form action="${pageContext.request.contextPath}/add-stock.action" method="post">
			Stock Name: <input type="text" name="stockName"/><br>
			Quantity: <input type="number" name="quantity" min="1" max="50"/><br>
			Manufacturer: <input type="text" name="manufacturer"/><br/>
			Price per unit: <input type="number" name="price"/>
			<input type="submit" value="add stock"/>
		</form>
	</body>
</html>
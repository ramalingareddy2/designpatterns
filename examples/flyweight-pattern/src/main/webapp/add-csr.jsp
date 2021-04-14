<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add Csr</title>
	</head>
	<body>
		<h2>Add Csr</h2>
		<form action="${pageContext.request.contextPath}/addCsr" method="post">
			Csr No: <input type="Text" name="csrNo"/><br/>
			Fullname: <input type="text" name="fullName"/><br/>
			Experience: <input type="text" name="experience"/><br/>
			Designation: <input type="text", name="designation"/><br/>
			Mobile No:<input type="text" name="mobileNo"/><br/>
			<input type="submit" value="Add"/>
		</form>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Stocks</title>
	</head>
	<body>
		<h2>Stocks</h2>
		<table>
			<tr>
				<td colspan="3">
					<table border="1" style="border-collapse: collapse;">
						<thead>
							<tr>
								<th>Stock Name</th>
								<th>Manufacturer name</th>
								<th>Amount</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${stocks}" var="stock">
								<tr>
									<td>${stock.stockName}</td>
									<td>${stock.manufacturer}</td>
									<td>${stock.price}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td align="left">
					<c:if test="${pageNo gt 1}">
						<a href="${pageContext.request.contextPath}/stocks?action=prev&cPageNo=${pageNo}">Previous</a>
					</c:if>
				</td>
				<td align="center">
					${pageNo}/${totalPages}
				</td>
				<td align="right">
					<c:if test="${pageNo lt totalPages}">
						<a href="${pageContext.request.contextPath}/stocks?action=next&cPageNo=${pageNo}">Next</a>
					</c:if>
				</td>
			</tr>
		</table>
	</body>
</html>









<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Image Gallery</title>
		<script type="text/javascript">
			function onChangeAlbum() {
				document.forms['galleryForm'].submit();
			}
			function go(action) {
				var actionHdn = null;
				
				actionHdn = document.getElementById("action");
				actionHdn.value = action;
				document.forms['galleryForm'].submit();
			}
		</script>
	</head>
	<body style="font-family: fantasy; font-size: 20px;">
		<table>
			<tr>
				<td colspan="2">
					<form name="galleryForm" action="${pageContext.request.contextPath}/gallery" method="post">
						<select name="albumNo" onchange="onChangeAlbum();">
							<option value="">select</option>
							<c:forEach items="${albums}" var="entry">
								<c:choose>
									<c:when test="${albumNo eq entry.key}">
										<option value="${entry.key}" selected="selected">${entry.value}</option>
									</c:when>
									<c:otherwise>
										<option value="${entry.key}">${entry.value}</option>	
									</c:otherwise>
								</c:choose>								
							</c:forEach> 
						</select>
						<input type="hidden" name="cPhotoNo" value="${photoNo}">
						<input type="hidden" name="action" id="action"/>
					</form>
				</td>
			</tr>
			<c:if test="${photoNo gt 0}">
				<tr>
					<td colspan="2">
						<hr style="border-style: solid; border: 1px;"/>
					</td>
				</tr>			
				<tr>
					<td colspan="2">
						<img src="${pageContext.request.contextPath}/photo?photoNo=${photoNo}" height="200px" width="200px"/>
					</td>
				</tr>
				<tr>
					<td align="left">
						<input type="button" value="&lt;" onclick="go('prev');"/>
					</td>
					<td align="right">
						<input type="button" value="&gt;" onclick="go('next');"/>
					</td>
				</tr>
			</c:if>
		</table>
	</body>
</html>









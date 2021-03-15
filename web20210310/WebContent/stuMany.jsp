<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Array</title>
</head>
<body>
<table border="1" width="40%">
		<tr>
			<TH>Name</th>
			<TH>Age</th>
		</tr>
		<c:forEach var="current" items="${sts}">
			<tr>
				<td><c:out value="${current.name}" />
				</td>
				<td><c:out value="${current.age}" />
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
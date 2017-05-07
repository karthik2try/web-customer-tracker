<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lists</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div id="wrapper">
<div id="header">
	<h2>CRM</h2>
</div>


</div>
<div id="container">
<div id="content">
<input type="button" value="Add customer" 
onclick="window.location.href='showFormForAdd'; return false;" class="add-button"/>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="tempCust" items="${customers}">
			<c:url var="updateUrl" value="/customer/showUpdateForm">
				<c:param name="id" value="${tempCust.id}"/>
			</c:url>
			<c:url var="DeleteUrl" value="/customer/deleteCustomer">
				<c:param name="id" value="${tempCust.id}"/>
			</c:url>
			<tr>
				<td>${tempCust.firstName}</td>
				<td>${tempCust.lastName}</td>
				<td>${tempCust.email}</td>
				<td><a href="${updateUrl}">update</a> / <a href="${DeleteUrl}">delete</a></td>
			</tr>
		</c:forEach>
		
	</table>
	</div>
</div>
</body>
</html>
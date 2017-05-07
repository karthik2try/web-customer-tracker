<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>customer form</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">

</head>
<body>
<div id="wrapper">
	<div id="header">
		<h2>CRM</h2>
	</div>
</div>
<spring:form action="addCustomer"  method="post" modelAttribute="customer">
	<table>
		<tr><td> <label>First Name:</label>  </td> <td><spring:input path="firstName"/></td> </tr>
		<tr> <td> <label>Last Name:</label>  </td> <td><spring:input path="lastName"/></td> </tr>
		<tr> <td> <label>Email:</label>  </td> <td><spring:input path="email"/></td> </tr>
		<tr> <td>  </td> <td><input type="submit" value="save" class="save"/></td>	 </tr>
	</table>
</spring:form>
<div style="clear;both;"></div>
<a href="${pageContext.request.contextPath}/customer/list">back to list</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application Management</title>
</head>
<body>
<div align="center">
	<h2>Application Management</h2>
	<h3><a href="add">Add Application</a></h3>
	<table border="1" cellpadding="5">
		<tr>
			<th>applicationId</th>
			<th>description</th>
			<th>applicationName</th>
			<th>owner</th>
			
		</tr>
		<c:forEach items="${applications}" var="application">
		<tr>
			<td>${application.applicationId}</td>
			<td>${application.description}</td>
			<td>${application.applicationName}</td>
			<td>${application.owner}</td>
			
			<td>
				<a href="editDetails/${application.applicationId}">Edit</a>
				&nbsp;&nbsp;&nbsp;
				<a href="delete/${application.applicationId}">Delete</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</div>	
</body>
</html>

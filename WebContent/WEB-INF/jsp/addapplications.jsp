<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Customer</title>
</head>
<body>
	<div align="center">
		<h2>Add Application</h2>
		<form:form action="save" method="post" modelAttribute="applicationRequest">
			<table border="0" cellpadding="5">
				<tr>
					<td>description: </td>
					<td><form:input path="description" /></td>
				</tr>
				<tr>
					<td>applicationName: </td>
					<td><form:input path="applicationName" /></td>
				</tr>
				<tr>
					<td>owner: </td>
					<td><form:input path="owner" /></td>
				</tr>		
					
				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>						
			</table>
		</form:form>
	</div>
</body>
</html>
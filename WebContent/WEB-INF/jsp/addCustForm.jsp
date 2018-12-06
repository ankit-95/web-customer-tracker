<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="javax.servlet.*"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>
</head>
<body>
<form:form action="showFormForAdd" modelAttribute="customer" method="post">
Enter the First Name :
<form:input path="firstName"/>
<br>
<br>
Enter the Last Name : 
<form:input path="lastName"/>
<br>
<br>
Enter the Email :
<form:input path="email"/>
<br>
<br>
<input type="submit"/> &nbsp&nbsp&nbsp&nbsp
<input type="button" value="Back to List" onclick="window.location.href='list'; return false;"/> 
</form:form>
</body>
</html>


<% String msg = (String)request.getAttribute("msg"); %>
<% 
if(msg!=null)
{
if(("True").equals(msg))
{
	%>
	<p> Object Added SuccessFully <p>
	<%
}
else if(("False").equals(msg))
{
	%>
	<p> Object Not Added SuccessFully <p>
	<%
}	 
}	%>


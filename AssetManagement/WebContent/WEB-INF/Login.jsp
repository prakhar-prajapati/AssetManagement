<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"> 
  <%
response.addHeader("pragma", "no-cache");
response.addHeader("cache-control", "no-store");
response.addHeader("expire", "0");
%>  
</head>
<body>
${msg}
<center>
<pre>
<form action="AdminLoginCheck" method="post" >
Enter Id : <input type="text" name="id" required>
<br/>
password : <input type="password" name="password" required>
<br/>
Desgination : <select name="Designation" required>
                   <option value="">SELECT </option>
  		           <option value="manager">MANEGER </option>
  		           <option value="employee">EMPLOYEE </option>
  		           <option value="support">Support</option>
                   <option value="admin">Admin</option>
                   </select>
                   <br/>
           <input type="Submit" name="LOGIN">
</form>
</pre>
</center>
</body>
</html>
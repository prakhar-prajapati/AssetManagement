<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin HOME</title>

<% 
	  	int uid=(Integer)session.getAttribute("uid");
 if(uid==0)
 {
	 response.sendRedirect("/");
}
%>

<%@include file="AdminNavbar.jsp" %>

</head>
<body>
<br/><br/>
<h1 align="center" style="color:red; font-family:sans-serif; text-decoration: underline;"><i>Welcome ${uid}</i></h1>
</body>
</html>
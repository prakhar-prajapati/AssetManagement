<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
response.addHeader("pragma", "no-cache");
response.addHeader("cache-control", "no-store");
response.addHeader("expire", "0");
%>
<%
	String user=(String)request.getAttribute("msg");
int uid=(Integer)session.getAttribute("uid");
%> 
<%if( user.equals("employee"))
	{%>
	<%@include file="EmployeeNavbar.jsp" %>
	<h2 align="center" style="font-style: italic; text-decoration: underline; ">Welcome <%=uid%></h2>
	<%} %>
<%if( user.equals("manager"))
	{%>
	<%@include file="ManagerNavbar.jsp" %>
	<h2 align="center" style="font-style: italic; text-decoration: underline; ">Welcome <%=uid%></h2>
	<%} %>
<%if( user.equals("support"))
	{%>
	<%@include file="SupportNavbar.jsp" %>
	<br/><br/>
	<h2 align="center" style="font-style: italic; text-decoration: underline; ">Welcome <%=uid%></h2>
	<%} %>


</body>
</html>
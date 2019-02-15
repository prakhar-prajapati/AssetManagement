<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assets Request</title>
<%@include file="EmployeeNavbar.jsp" %>
</head>
<body>
<h3 align="center">Welcome , ${uid}</h3>
<br/>
<h1 align="center"><i>Assets Request Form</i></h1>
<h2>${msg}</h2>

<%@page import="java.util.ArrayList,bean.AssetsBean" %>
<%ArrayList<AssetsBean> list=(ArrayList<AssetsBean>)request.getAttribute("LIST"); %>

<div class="container">
<div class="col-sm-4">
<form action="RaiseRequest">
<div class="form-group">
<label>ASSETS :</label> 
 <select name="asset_name" >


                   <option value="">SELECT </option>
<%
for(AssetsBean rs:list)
{ 
%>
  <option value="<%=rs.getAsst_id()%>=<%=rs.getAsst_name()%>" > <%=rs.getAsst_id()%>=<%=rs.getAsst_name()%></option>
<%} %>

                   </select>
</div>
<br/><br/>

<input type="submit" value="Raise Request" class="btn btn-primary">

</form>
</div>
</div>

</body>
</html>
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
	  	Integer uid=(Integer)session.getAttribute("uid");
 if(uid==0)
 {
	 response.sendRedirect("/");
}
%>

<%@include file="AdminNavbar.jsp" %>
<h1 align="center"><i>INSERT ASSETS</i></h1>
<h3 align="center">Welcome , ${uid}</h3>
<h2>${msg}</h2>
<div class="container">
<div class="col-sm-4">
<form action="addAssets">

<div class="form-group" >
 <label >Asset Name:</label>
<input type="text" name="asst_name"  class="form-control" />
</div>

<div class="form-group" >
 <label >Status:</label><br/>
<input type="radio" name="status" value="0" checked>Available
<input type="radio" name="status" value="1">Not Available
</div>

<input type="submit" value="ADD ASSETS" class="btn btn-primary btn-md">

</form>
</div>
</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Users</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<% 
	  	String uid=(String)session.getAttribute("uid");
 if(uid==null)
 {
	 response.sendRedirect("/");
}
%>

</head>
<body>
<%@page import="java.util.ArrayList,bean.usersBean" %>
<%@include file="AdminNavbar.jsp" %>
<h1 align="center"> Welcome , ${uid}</h1>
<%ArrayList<usersBean> list=(ArrayList<usersBean>)request.getAttribute("LIST"); %>
 <h2 align="center" style="color:red"> ${msg}</h2>
 	  <div class="container">
	  <table class="table table-bordered">
	 <tr><th>S no.</th><th>First Name</th><th>Last name</th><th>Desgination</th><th>Activation</th><th>Mobile</th><th>DATE-Of-Joining</th>
	 <th>Email</th><th>Password</th><th>Emp id</th><th>Support id</th><th>Manager id</th></tr>
	  <%
for(usersBean rs:list)
{
%>
      <tr>
                <td><%=rs.getUid()%></td>
		        <td><%=rs.getFirstName()%></td>
		        <td><%=rs.getLastName()%></td>
		        <td><%=rs.getDesignation()%></td>
		        <td>
		        
		        <%if(rs.getActive()==1)
		        	out.println("Active user");
		        else
		        	out.println("Deactive user");

		        %></td>
		        <td><%=rs.getMobile()%></td>
		         <td><%=rs.getDateOfJoining()%></td>
		        <td><%=rs.getEmail_Id()%></td>
		        <td><%=rs.getPassword()%></td>
		        <td><%=rs.getEmp_id()%></td>
		        <td><%=rs.getSupport_id()%></td>
		        <td><%=rs.getManager_Id()%></td>
		      <td> <a href="updateUsers_view?uid=<%=rs.getUid()%>" class="glyphicon glyphicon-edit" ></a> </td>
		    
		         </tr>
		  <%
	   }
	  %>
	  </table>
	  </div>

</body>
</html>
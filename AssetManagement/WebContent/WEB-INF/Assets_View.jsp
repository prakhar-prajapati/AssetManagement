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

<%@page import="java.util.ArrayList,bean.AssetsBean" %>
<%@include file="AdminNavbar.jsp" %>
<h1 align="center"> Welcome , ${uid}</h1>
<%ArrayList<AssetsBean> list=(ArrayList<AssetsBean>)request.getAttribute("LIST"); %>
 <h2 align="center" style="color:red"> ${msg}</h2>
 	  <div class="container">
	  <table class="table table-bordered">
	 <tr><th>ASSETS ID</th><th>ASSETS NAME</th><th>STATUS</th></tr>
 <%
for(AssetsBean rs:list)
{
%>
      <tr>
                <td><%=rs.getAsst_id()%></td>
		        <td><%=rs.getAsst_name()%></td>
		        <td>
		        <%if(rs.getStatus()==0){ 
		        out.println("Available..");
		        }else
		        	out.println("Not-Available..");
		        	
		        %>
		        </td>
		    
		         </tr>
		  <%
	   }
	  %>
	  </table>
	  </div>

</body>
</html>
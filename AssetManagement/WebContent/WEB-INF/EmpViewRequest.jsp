<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Veiw Employee Request</title>
</head>

<body>
<% 
	  	int uid=(Integer)session.getAttribute("uid");
 if(uid==0)
 {
	 response.sendRedirect("/");
}
%>

<%@page import="java.util.ArrayList,bean.RequestBean" %>
	<%@include file="EmployeeNavbar.jsp" %>
<h1 align="center"> Welcome , ${uid}</h1>
<%ArrayList<RequestBean> list=(ArrayList<RequestBean>)request.getAttribute("LIST"); %>
 <h2 align="center" style="color:red"> ${msg}</h2>
 	  <div class="container">
	  <table class="table table-bordered">
	 <tr><th>ASSETS ID</th><th>ASSETS NAME</th><th>MANEGER-Id</th><th>REQUEST-DATE</th><th>APPROVED-DATE</th><th>STATUS</th></tr>
 <%
for(RequestBean rs:list)
{
%>
      <tr>      <td><%=rs.getAsst_id()%></td>
		        <td><%=rs.getAsset_name()%></td>
		        <td><%=rs.getManger_id()%></td>
		        <td><%=rs.getRequestDate()%></td>
		        <td>
		        <% if(rs.getManagerApprovedDate()==null)
		        out.println("Pending...");
		        else
		        	out.println(rs.getManagerApprovedDate());
		        	%>
		        	</td>
		        <td>
		        <%
		        if(rs.getStatus()==0){ 
		        out.println("Pending..");
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.util.ArrayList,bean.RequestBean" %>
	<%@include file="ManagerNavbar.jsp" %>
<h1 align="center"> Welcome , ${uid}</h1>
<%ArrayList<RequestBean> list=(ArrayList<RequestBean>)request.getAttribute("LIST"); %>
 <h2 align="center" style="color:red"> ${msg}</h2>
 	  <div class="container">
	  <table class="table table-bordered">
	 <tr><th>ASSETS ID</th><th>ASSETS NAME</th><th>Employee-Id</th><th>REQUEST-DATE</th><th>APPROVED-DATE</th><th>STATUS</th><th>APPROVED</th></tr>
 <%
for(RequestBean rs:list)
{
%>
      <tr>      <td><%=rs.getAsst_id()%></td>
		        <td><%=rs.getAsset_name()%></td>
		        <td><%=rs.getEmp_id()%></td>
		        <td><%=rs.getRequestDate()%></td>
		        <td><%
		        if(rs.getManagerApprovedDate()==null)
		        out.println("Pending...");
		        else
		        	out.println(rs.getManagerApprovedDate());
		        	%>
		        </td>
		        
		        <td><%
		        if(rs.getStatus()==0){ 
			        out.println("Pending..");
			        }else if(rs.getStatus()==1) 
				        out.println("Approved..");
			        else if(rs.getStatus()==2) 
				        out.println("Dis-Approved..");
			    %>
		        </td>
		        
		        
		        <td><a href="Manager_AprooveReq?rid=<%=rs.getRequest_id()%>&action=1"><span class="glyphicon glyphicon-ok"></span>Approved</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="Manager_AprooveReq?rid=<%=rs.getRequest_id()%>&action=2"><span class="glyphicon glyphicon-remove">DIS-Approved </a>		        
		         </td>
		     		      
		         </tr>
		  <%
	   }
	  %>
	  </table>
	  </div>

</body>
</html>
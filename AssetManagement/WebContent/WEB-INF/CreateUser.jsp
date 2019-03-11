<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
      $("#eid").hide();
	  $("#sid").hide();
	  $("#mid").hide();
	$("#des").change(function(){
	var v=$("#des").val();
	  if(v=='manager')
	  {
		  $("#eid").hide();
		  $("#sid").show();
		  $("#mid").show();
	  }
	  else if(v=='employee')
	  { 
		  $("#eid").show();
		  $("#sid").hide();
		  $("#mid").show();
	  }
	  else if(v=='support')
	  { 
		  $("#eid").hide();
		  $("#sid").show();
		  $("#mid").hide();
	  }
	});
		});  //ready end
 </script>


</head>
<% 
	  	Integer uid=(Integer)session.getAttribute("uid");
 if(uid==0)
 {
	 response.sendRedirect("/");
}
%>


<%@include file="AdminNavbar.jsp" %>
<body>
<h1 align="center"><i>Create User</i></h1>
<h3 align="center">Welcome , ${uid}</h3>
<h2>${msg}</h2>
<div class="container">
<div class="col-sm-4">
<form action="InsertUser_details">

<div class="form-group">
<label>Designation :</label> 
 <select name="Designation" id="des">
                   <option value="">SELECT </option>
  		           <option value="manager">MANEGER </option>
  		           <option value="employee">EMPLOYEE </option>
  		           <option value="support">Support</option>
                   </select>
</div>

<div class="form-group" id="eid">
 <label >EMPLOYEE ID:</label>
<input type="text" name="emp_id" value="0" class="form-control" />
</div>

<div class="form-group" id="mid">
 <label >MANAGER ID:</label>
<input type="text" name="manager_Id" value="0" class="form-control" />
</div>

<div class="form-group" id="sid">
 <label >SUPPORT ID:</label>
<input type="text" name="support_id" value="0" class="form-control" />
</div>


<div class="form-group">
 <label >FIRST NAME:</label>
<input type="text" name="firstName" class="form-control" />
</div>

<div class="form-group">
 <label >LAST NAME:</label>
<input type="text" name="lastName" class="form-control" />
</div>

<div class="form-group">
<label>EMAIL-ID :</label> 
 <input type="text" name="email_Id" class="form-control"/>
</div>

<div class="form-group">
<label>PASSWORD :</label> 
<input type="password" name="password" class="form-control"/>
</div>


<div class="form-group">
<label>MOBILE NO. :</label> 
 <input type="text" name="mobile" class="form-control"/>
</div>

<div class="form-group">
<label>DATE-OF-JOINING :</label> 
 <input type="date" name="dateOfJoining" class="form-control"/>
</div>

<%--
<div class="form-group">
<label>Active :</label> 
 <input type="number" name="active" class="form-control"/>
</div>
 --%>

<div class="form-group">
<label>Active :</label><br/> 
<input type="radio" name="Active" value="1" checked>Active user
<input type="radio" name="Active" value="0">Deactive user
</div>

<input type="submit" value="CREATE" class="btn btn-primary">

</form>
</div>
</div>
</body>

</html>

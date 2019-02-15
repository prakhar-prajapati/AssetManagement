<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<%
response.addHeader("pragma", "no-cache");
response.addHeader("cache-control", "no-store");
response.addHeader("expire", "0");
%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Assets Managament</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li ><a href="#">Profile</a></li>
      <li ><a href="EmpAddRequest">Create Request</a></li>
      <li><a href="EmpViewRequest">View My Request</a></li>
      <li ><a href="#">My Assets</a></li>
       <li ><a href="#">Assets Transfer</a></li>
    </ul>
   <ul class="nav navbar-nav navbar-right">
      <li><a href="logout"><i class="fas fa-sign-out-alt"></i></span> Logout</a></li>
    </ul> 
  </div>
</nav>
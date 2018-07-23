<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Banking Application</title>
<link href="css/main.css" rel="stylesheet">
</head>
<body>
<h2><strong>ZOHO BANK</strong></h2>

<div class="login-page">
	<h3><strong>Admin Login</strong></h3>
  <div class="form">
    <form class="login-form" action="LoginController" method="post">
      <input type="text" placeholder="admin-username" name="userid"/>
      <input type="password" placeholder="password" name="password"/>
      <input type="submit" value="Login"/>
    </form>
  </div>
</div>

</body>
</html>


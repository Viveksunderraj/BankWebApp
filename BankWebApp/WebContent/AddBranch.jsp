<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
h3
 {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  font-size: 20px;
  color: white;
 }
body {
  background: #0b63ad; /* fallback for old browsers */
  font-family: "Roboto", sans-serif;
}
</style>
<head>
<meta charset="UTF-8">
<title>Add Branch</title>
</head>
<body>
<div>
<form action="AddBranchController" method="post">
	<h3>Add Branch</h3>
	<input type="text" placeholder="Branch Name" name="branchname"><br><br>
	<input type="text" placeholder="Branch Address" name="branchaddress"><br><br>
    <input type="submit" value="Submit" />

    </form>
</div>
</body>
</html>
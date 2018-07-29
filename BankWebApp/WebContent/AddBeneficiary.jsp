<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>View Users</title>  
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js" integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<style>
.customer{
  padding: 8% 0 0;
  margin: auto;
 }


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
</head>  
<body>  
<script>
$(document).ready(function(){
	$('a').removeClass('active');
	$('#AddBeneficiary').addClass('active');
});
</script>
  
    <div class="row">
  		<div class="col-3">
 			<jsp:include page="CustomerPage.jsp" />  
  		</div>
  	
  	<div class="col-9">
  	<div class="row">
  	</div>
  
  <div class="row">

  <%@page import="com.bank.*,com.bankDAO.*,java.util.*"%>  
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
 
	<form action="AddBeneficiaryController" method="post">
	<div>
	<br><br><h3>ADD BENEFICIARY</h3><br>
	
	<div class="row">
		<div class="col-6">
			<p>Select A Beneficiary Type: </p>
		</div>
		<div class="col-6">
			<select name="beneficiaryType">
				<option value="1">Beneficiary WithIn same Bank</option>
				<option value="2">Beneficiary In Other Bank</option>
			</select>
		</div>
	</div>
	<br>
	<div class="row">
		<div class="col-6">
			<p>Enter Beneficiary Account Number: </p>
		</div>
		<div class="col-6">
			<input type="text" placeholder="Account Number" name="beneficiaryAccountNumber"><br>
		</div>
	</div>
	<br>
	<div class="row">
		<div class="col-6">
			<p>Enter IFSC Code: </p>
		</div>
		<div class="col-6">
			<input type="text" placeholder="IFSC Code" name="IFSCcode"><br>
		</div>
	</div>
   <br>
    <div class="row">
			<div class="col-6">
				<input type="submit" value="Add" />
			</div>
			<div class="col-6">
				<input type="submit" form="cancelform" value="Cancel"/>
			</div>	
	</div>
	</div>
    <p>${param.message}</p>
	</form>
	<form id="cancelform" action="CustomerDashboard.jsp"></form>
   
  </div>
  </div>
</div>
</body>  
</html>
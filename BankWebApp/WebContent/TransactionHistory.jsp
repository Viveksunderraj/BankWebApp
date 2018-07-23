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
	$('#TransactionHistory').addClass('active');
});
</script>
  
    <div class="row">
  		<div class="col-3">
 			<jsp:include page="CustomerPage.jsp" />  
  		</div>
  	
  	<div class="col-9">
  	<div class="row">
  		<jsp:include page="CustomerHeader.jsp" /> 
  	</div>
  
  <div class="row">

  <%@page import="com.bank.*,com.bankDAO.*,java.util.*"%>  
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
 <%
String customerid=(String)session.getAttribute("customerid");
String branchid=(String)session.getAttribute("branchid");
ArrayList<Account> accounts = AccountDAO.getAccountsForCustomer(Integer.parseInt(customerid), Integer.parseInt(branchid), MenuMethods.GetAccountType.ALL_ACCOUNTS);  
request.setAttribute("accounts",accounts);  
%>  
	<form action="TransactionHistory" method="get">
	<br><br><h3>TRANSACTION HISTORY</h3><br>
	
	<div class="row">
		<div class="col-6">
			<p>Select An Account : </p>
		</div>
		<div class="col-6">
			<select name="Accountnumber">
				<c:forEach items="${accounts}" var="account"> 
					<option value="${account.getAccountNumber()}">${account.getAccountNumber()}-${account.getAccountName()}</option><br><br>
				</c:forEach>
			</select>
		</div>
	</div>
	
	
    <input type="submit" value="Show Transaction History"/>
    
    </form><br>
	
	
	
	<table border="2" width="150%" style="color:white">
 	<tr><th>DATE AND TIME</th><th>REFERENCE NUMBER</th><th>TRANSACTION TYPE</th><th>NARRATION</th><th>TRANSACTION AMOUNT</th><th>CLOSING BALANCE</th></tr>  
  	<c:forEach items="${transactionHistory}" var="transaction">
	  	<tr>
	  		<td>${transaction.getTransactionDateTime()}</td>
			<td>${transaction.getTransactionID()}</td>
			<td>${transaction.getTransactionName()}</td>
			<td>${transaction.getDescription()}</td>
			<td>${transaction.getTransactionAmount()}</td>
			<td>${transaction.getAccountBalance()}</td>
	  	</tr>
 	</c:forEach>
</table> 
	
 
  </div>
  </div>
</div>
</body>  
</html> 
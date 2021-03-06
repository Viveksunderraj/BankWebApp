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
	$('#Withdraw').addClass('active');
	
	var currentBalance= 0;
	currentBalance = parseFloat($('#accountList').find('option:selected').attr('id'));
	var currentAccType=  $('#accountList').find('option:selected').attr('data-accType');
	var minBalance = parseFloat($('#accountList').find('option:selected').attr('data-minBalance'));
	//console.log(currentBalance + "     " + currentAccType);
	
	$('#accountList').on('change', function(){
		currentBalance = parseFloat($(this).find('option:selected').attr('id'));	
		currentAccType = $(this).find('option:selected').attr('data-accType');
		minBalance = parseFloat($(this).find('option:selected').attr('data-minBalance'));

		//console.log(currentBalance + "     " + currentAccType);
		$('#withdrawAmount').val("");
	});
	
	$('#withdrawAmount').on('keyup', function(){
		var amount = parseFloat($(this).val());
	//	console.log(amount   + "   ajsdhc - " + (amount > currentBalance));
		//if(amount > currentBalance){
		//	alert("Amount entered is greater than the Minimum Balance.");
		//}
		if((currentBalance - amount < minBalance)){
			alert("Minimum Balance of Rs." + minBalance +" should be maintained.");
		}
	});
	
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
 <%
String customerid=(String)session.getAttribute("customerid");
String branchid=(String)session.getAttribute("branchid");
ArrayList<Account> accounts = AccountDAO.getAccountsForCustomer(Integer.parseInt(customerid), MenuMethods.GetAccountType.SAVINGS_AND_CURRENT);  
request.setAttribute("accounts",accounts);  
%>  
	<form action="WithdrawController" method="post">
	<div>
	<br><br><h3>WITHDRAW</h3><br>
	
	<div class="row">
		<div class="col-6">
			<p>Select An Account : </p>
		</div>
		<div class="col-6">
			<select name="Accountnumber" id="accountList">
				<c:forEach items="${accounts}" var="account"> 
					<option value="${account.getAccountNumber()}" id="${account.getAccountBalance()}" data-accType="${account.getAccountType()}" data-minBalance="${account.getMinimumBalance()}">${account.getAccountNumber()}-${account.getAccountName()}</option><br><br>
				</c:forEach>
			</select>
		</div>
	</div>
	<br>
	<div class="row">
		<div class="col-6">
			<p>Enter Withdrawal Amount: </p>
		</div>
		<div class="col-6">
			<input type="text" placeholder="Amount" id="withdrawAmount" name="amount"><br>
		</div>
	</div>
	<br>
	<div class="row">
		<div class="col-6">
			<p>Enter Message : </p>
		</div>
		<div class="col-6">
			<input type="text" placeholder="Message" name="description"><br>
		</div>
	</div>
	<br>
    
    <div class="row">
			<div class="col-6">
				<input type="submit" value="Withdraw" />
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
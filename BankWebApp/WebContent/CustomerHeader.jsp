<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>

<style>
h2 {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  text-align: center;
  font-size: 36px;
  font-weight: 300;
  color: #f2f2f2;
}
body {
  background: #0b63ad; /* fallback for old browsers */
  font-family: "Roboto", sans-serif;
}
h3{
font-size: 20px;
color:#f2f2f2;
}
.custID{
	float: right;
	padding-left: 40px;
}
</style>
</head>
<body>

<script>
$(document).ready(function(){
	var branchid = $('#Branchid').attr('value');

	
	setSelectedIndex(document.getElementById('branchlist'),branchid);
	
});
function setSelectedIndex(s, v) {

    for ( var i = 0; i < s.options.length; i++ ) {
//console.log(s.options[i].value);
        if ( s.options[i].value == v ) {

            s.options[i].selected = true;

            return;

        }

    }

}


</script>


<div>
<div class="row">
<div class="col-11"> <h2>ZOHO BANK</h2></div>


<h3>
<%
String customerfname=(String)session.getAttribute("customerfname"); 
String customerlname=(String)session.getAttribute("customerlname"); 
String customerid=(String)session.getAttribute("customerid");
int custid = Integer.parseInt(customerid);
out.print("Welcome " + customerfname + " " + customerlname + ", Customer ID = " + customerid);
%>
</h3>
<div class="custID">
<%

%>
</div>

<br><br>

</div>

<%@page import="com.bank.*,com.bankDAO.*,java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<%  
String branchid=(String)session.getAttribute("branchid");
ArrayList<Account> branchList = AccountDAO.getDistinctBranchesForCustomer(custid);


request.setAttribute("branchList",branchList);
%>  
<input type="hidden" value="${branchid}" id="Branchid"/>
<form action="GetAccountsForBranch" method="post">
<div class="row">
		<div class="col-6">
			<p>Select A Branch : </p>
		</div>
		<div class="col-5">
			<select name="Branchid" id="branchlist">
				<c:forEach items="${branchList}" var="u"> 
					<option value="${u.getBranchID()}">${u.getBranchName()}</option>
				</c:forEach>
			</select>
		</div>
		<div class="col-1">
			<input type="submit" value="Ok"/>
		</div>
</div>
</div>
</form>

</body>
</html>
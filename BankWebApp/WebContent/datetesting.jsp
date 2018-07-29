<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="jquery-ui-1.12.1.custom/jquery-ui.min.css">
<script src="jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
<script src="jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js" integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em" crossorigin="anonymous"></script>

<title>Insert title here</title>
</head>
<body>

<script>
$(document).ready(function(){
	$( "#date" ).datepicker({
		dateFormat: 'yy-mm-dd',
        autoclose: true,
        maxDate : new Date(),
        changeYear: true,
        onSelect: function(date) {
            $("#todate").datepicker('option', 'minDate', date);
          }
	});	
	var fromDate=0;
	alert('hi');
	$("#date").on('change',function(){
         fromDate = $(this).val();
         alert('hi');
         
	});
	$( "#todate" ).datepicker({
		dateFormat: 'yy-mm-dd',
        autoclose: true,
        changeYear: true,
        maxDate : new Date()
	});	
});

</script>

<input type="text" name="date" id="date">
<input type="text" name="todate" id="todate">
</body>
</html>
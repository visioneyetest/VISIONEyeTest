<?php
$cont = mysql_connect('localhost','root','root') 
 or die('Could not connect to the server!');


mysql_select_db('registration')
or die('Could not select a database.');

	 
$name1=$_REQUEST['name'];
$r1= mysql_real_escape_string($name1);

$add1=$_REQUEST['add'];
$r2 = mysql_real_escape_string($add1);

$con1=$_REQUEST['con'];
$r3 = mysql_real_escape_string($con1);

$edu1=$_REQUEST['edu'];
$r4 = mysql_real_escape_string($edu1);

$pass1=$_REQUEST['pass'];
$r5 = mysql_real_escape_string($pass1);


	

$flag['code']=0;


$query= "insert into 
registration.dr_reg (dr_name,dr_add,dr_con,dr_edu,dr_pass) values ('$r1', '$r2', '$r3', '$r4', '$r5')";

mysql_query($query) 

or trigger_error(mysql_error()." in ".$query);

	{
		$flag['code']=1;
		echo"hi";
	}


	print(json_encode($flag));
	mysql_close($cont);
?>




<?php
$cont = mysql_connect('localhost','root','root') 
 or die('Could not connect to the server!');


mysql_select_db('vision')
or die('Could not select a database.');

	 
$name1=$_REQUEST['ngoname'];
$r1= mysql_real_escape_string($name1);

$add1=$_REQUEST['ngoadd'];
$r2 = mysql_real_escape_string($add1);

$con1=$_REQUEST['ngocon'];
$r3 = mysql_real_escape_string($con1);

$edu1=$_REQUEST['ngoincharge'];
$r4 = mysql_real_escape_string($edu1);

$pass1=$_REQUEST['ngopass'];
$r5 = mysql_real_escape_string($pass1);


	

$flag['code']=0;


$query= "insert into 
vision.ngo_info (ngo_name,ngo_addr,ngo_con_no,ngo_incharge,ngo_pswd) values ('$r1', '$r2', '$r3', '$r4', '$r5')";

mysql_query($query) 

or trigger_error(mysql_error()." in ".$query);

	{
		$flag['code']=1;
		echo"hi";
	}


	print(json_encode($flag));
	mysql_close($cont);
?>






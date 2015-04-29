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

$uid=$_REQUEST['id'];
$r7= mysql_real_escape_string($uid);


$query1= "update registration.dr_reg set dr_name='$r1',dr_add='$r2',dr_con='$r3',dr_edu='$r4',dr_pass='$r5' where dr_id='$r7' ";
mysql_query($query1) 

or trigger_error(mysql_error()." in ".$query1);

	{
		$flag['cnt']=200;
		echo"hi";
	}

//--------------------------



	print(json_encode($flag));
	mysql_close($cont);
?>


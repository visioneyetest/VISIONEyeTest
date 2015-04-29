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

$inc1=$_REQUEST['ngoinch'];
$r4 = mysql_real_escape_string($inc1);

$pass1=$_REQUEST['ngopass'];
$r5 = mysql_real_escape_string($pass1);

$uid=$_REQUEST['id'];
$r7= mysql_real_escape_string($uid);


$query1= "update vision.ngo_info set ngo_name='$r1',ngo_addr='$r2',ngo_con_no='$r3',ngo_incharge='$r4',ngo_pswd='$r5' where ngo_id='$r7' ";
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


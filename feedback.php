<?php
$cont = mysql_connect('localhost','root','root') 
 or die('Could not connect to the server!');


mysql_select_db('feedback')
or die('Could not select a database.');

	 
$name1=$_REQUEST['p_name'];
$r1= mysql_real_escape_string($name1);

$add=$_REQUEST['p_add'];
$r2 = mysql_real_escape_string($add);

$pcon=$_REQUEST['p_con'];
$r3 = mysql_real_escape_string($pcon);

$cname=$_REQUEST['c_name'];
$r4 = mysql_real_escape_string($cname);

$ccon=$_REQUEST['c_con'];
$r5 = mysql_real_escape_string($ccon);

$feed=$_REQUEST['feed'];
$r6 = mysql_real_escape_string($feed);

$dates=$_REQUEST['dates'];
$r7 = mysql_real_escape_string($dates);


	

$flag['code']=0;

$query= "insert into 
feedback.submitfeedback (names,addr,pcon,cname ,ccon,feed,dates) values ('$r1','$r2','$r3','$r4','$r5','$r6','$r7')";


mysql_query($query) 

or trigger_error(mysql_error()." in ".$query);

	{
		$flag['code']=1;
		echo"hi";
	}


	print(json_encode($flag));
	mysql_close($cont);
?>


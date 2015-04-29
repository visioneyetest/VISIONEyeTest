<?php
$cont = mysql_connect('localhost','root','root') 
 or die('Could not connect to the server!');


mysql_select_db('registration')
or die('Could not select a database.');



$uid=$_REQUEST['uid'];
$typeuid = mysql_real_escape_string($uid);	


$upass=$_REQUEST['upass'];
$typeupass = mysql_real_escape_string($upass);

$k=0;
$c=0;
$cc=0;
$otid=0;
//------------------------------------------counting
$SQL = "SELECT  *  FROM registration.dr_reg where dr_id='$typeuid' AND dr_pass='$typeupass'";
$result = mysql_query($SQL) 
    or die('A error occured: ' . mysql_error());
// Get result count:
$Count = mysql_num_rows($result); 
// Fetch rows:
while ($Row = mysql_fetch_assoc($result)) {

	$cc=100;
	
	$k++;
	}
$flag['lid']=$cc;

	print(json_encode($flag));
	mysql_close($cont);
?>



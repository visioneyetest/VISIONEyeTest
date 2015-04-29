<?php
$cont = mysql_connect('localhost','root','root') 
 or die('Could not connect to the server!');


mysql_select_db('registration')
or die('Could not select a database.');



$name=$_REQUEST['name'];
$typename = mysql_real_escape_string($name);	


$con=$_REQUEST['contact'];
$typecon = mysql_real_escape_string($con);

$k=0;
$c=0;
$cc=0;
$otid=0;
//------------------------------------------counting
$SQL = "SELECT  dr_id  FROM registration.dr_reg where dr_name='$typename' AND dr_con='$typecon'";
$result = mysql_query($SQL) 
    or die('A error occured: ' . mysql_error());
// Get result count:
$Count = mysql_num_rows($result); 
// Fetch rows:
while ($Row = mysql_fetch_assoc($result)) {

	$cc=$Row['dr_id'];
	
	$k++;
	}
$flag['id']=$cc;

	print(json_encode($flag));
	mysql_close($cont);
?>


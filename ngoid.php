<?php
$cont = mysql_connect('localhost','root','root') 
 or die('Could not connect to the server!');


mysql_select_db('vision')
or die('Could not select a database.');



$name=$_REQUEST['ngoname'];
$typename = mysql_real_escape_string($name);	


$con=$_REQUEST['ngocon'];
$typecon = mysql_real_escape_string($con);

$k=0;
$c=0;
$cc=0;
$otid=0;
//------------------------------------------counting
$SQL = "SELECT  ngo_id  FROM vision.ngo_info where ngo_name='$typename' AND ngo_con_no='$typecon'";
$result = mysql_query($SQL) 
    or die('A error occured: ' . mysql_error());
// Get result count:
$Count = mysql_num_rows($result); 
// Fetch rows:
while ($Row = mysql_fetch_assoc($result)) {

	$cc=$Row['ngo_id'];
	
	$k++;
	}
$flag['id']=$cc;

	print(json_encode($flag));
	mysql_close($cont);
?>


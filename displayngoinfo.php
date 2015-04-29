<?php
/*
** Connect to database:
*/
 
// Connect to the database (hostname, username, password)
$cont = mysql_connect('localhost','root','root') 
    or die('Could not connect to the server!');
 

// Select a database:
mysql_select_db('vision') 
    or die('Could not select a database.');
 
$idd=$_REQUEST['id'];
$r1= mysql_real_escape_string($idd);

$countrow=0;

// Example query: (TOP 10 equal LIMIT 0,10 in SQL)
$SQL = "SELECT   * FROM vision.ngo_info where ngo_id=$r1";
 
// Execute query:
$result = mysql_query($SQL) 
    or die('A error occured: ' . sql_error());
 
// Get result count:
$Count = mysql_num_rows($result); 
$i=0; 
$c=0;
$countrow=0;

// Fetch rows:
while ($Row = mysql_fetch_assoc($result)) {
 
    
	$flag['id']=$Row['ngo_id'];
	$flag['name']=$Row['ngo_name'];
	$flag['add']=$Row['ngo_addr'];
	$flag['con']=$Row['ngo_con_no'];
	$flag['inch']=$Row['ngo_incharge'];
	$flag['pass']=$Row['ngo_pswd'];
	$i++;	
}



print(json_encode($flag));
mysql_close($cont);
?>



<?php
/*
** Connect to database:
*/
 
// Connect to the database (hostname, username, password)
$cont = mysql_connect('localhost','root','root') 
    or die('Could not connect to the server!');
 

// Select a database:
mysql_select_db('registration') 
    or die('Could not select a database.');
 
$idd=$_REQUEST['id'];
$r1= mysql_real_escape_string($idd);

$countrow=0;

// Example query: (TOP 10 equal LIMIT 0,10 in SQL)
$SQL = "SELECT   * FROM registration.dr_reg where dr_id=$r1";
 
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
 
    
	$flag['id']=$Row['dr_id'];
	$flag['name']=$Row['dr_name'];
	$flag['add']=$Row['dr_add'];
	$flag['con']=$Row['dr_con'];
	$flag['ed']=$Row['dr_edu'];
	$flag['pass']=$Row['dr_pass'];
	$i++;	
}



print(json_encode($flag));
mysql_close($cont);
?>



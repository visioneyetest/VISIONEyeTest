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
 

$countrow=0;

// Example query: (TOP 10 equal LIMIT 0,10 in SQL)
$SQL = "SELECT   * FROM registration.dr_reg";
 
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
 
    
	$flag['dr_id'.$i]=$Row['dr_id'];
	$flag['dr_name'.$i]=$Row['dr_name'];
	$flag['dr_add'.$i]=$Row['dr_add'];
	$flag['dr_con'.$i]=$Row['dr_con'];
	$flag['dr_edu'.$i]=$Row['dr_edu'];
	$flag['dr_pass'.$i]=$Row['dr_pass'];
	$i++;	
}

$flag['countrow']=$i; 



print(json_encode($flag));
mysql_close($cont);
?>


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
 

$countrow=0;

// Example query: (TOP 10 equal LIMIT 0,10 in SQL)
$SQL = "SELECT   * FROM vision.ngo_info";
 
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
 
    
	$flag['ngo_id'.$i]=$Row['ngo_id'];
	$flag['ngo_name'.$i]=$Row['ngo_name'];
	$flag['ngo_add'.$i]=$Row['ngo_addr'];
	$flag['ngo_con'.$i]=$Row['ngo_con_no'];
	$flag['ngo_inch'.$i]=$Row['ngo_incharge'];
	$flag['ngo_pass'.$i]=$Row['ngo_pswd'];
	$i++;	
}

$flag['countrow']=$i; 



print(json_encode($flag));
mysql_close($cont);
?>


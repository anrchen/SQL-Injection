<?php
    if ($_POST['defense']=="prepared_statement"){
        echo("Thank you for using Prepared Statment");

    }

$mysqli = new mysqli('localhost', 'root', 'root', 'soen321');
$rs = $mysqli->query( 'CALL procedureLogin("soen1232131321", "123")' );

if ($rs){
    $actor = $rs->fetch_assoc();;
    echo ("Hello ".$actor);
    echo ("The data exists");
}
?>
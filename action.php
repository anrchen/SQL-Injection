<?php
    if ($_POST['defense']=="prepared_statement"){
        echo("Hello world");

    }

$mysqli = new mysqli('localhost', 'root', '', 'soen321');
$rs = $mysqli->query( 'CALL procedureLogin("soen1232131321", "123")' );

if ($rs){
    $actor = $rs->fetch_assoc();;
    echo ("Hello ".$actor);
    echo ("The data exists");
}
?>
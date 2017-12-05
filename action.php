<?php
require 'config.php';
    if ($_POST['defense']=="whitelist"){

        $sql = "SELECT * FROM user WHERE email='test' OR 1='1'";
        $rs = $mysqli->query($sql);
        $row = $rs->fetch_array();
        var_dump($row);

    }

$mysqli = new mysqli('localhost', 'root', '', 'soen321');
$rs = $mysqli->query( 'CALL procedureLogin("soen1232131321", "123")' );

if ($rs){
    $actor = $rs->fetch_assoc();;
    echo ("Hello ".$actor);
    echo ("The data exists");
}
?>
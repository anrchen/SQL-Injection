<?php

require ("config.php");
$user = $_POST['email'];
$password = $_POST['password'];

if (empty($_POST['defense'])){
    login($user, $password, $mysqli);
} elseif ($_POST['defense']=="stored_procedure"){
    stored_procedure($user, $password, $mysqli);
} elseif ($_POST['defense']=="prepared_statement"){
    prepared_statement($user, $password, $mysqli);
}


?>

<?php
function login($user, $password, $mysqli) {
    $sql = 'SELECT * FROM User WHERE email="'.$user.'" AND password="'.$password.'"';
    $rs = $mysqli->query($sql);

    if($rs) {
        if($row = $rs->fetch_array()) {
            echo "<script type='text/javascript'>alert('Log successfully!')</script>";
        }
    } else {
        echo "<script type='text/javascript'>alert('Failed!')</script>";

    }

    echo"<script type='text/javascript'>window.location.href='index.php';</script>";
}

function prepared_statement($user, $password, $mysqli){
    $stmt = $mysqli->prepare("SELECT email, password FROM User WHERE email=? AND  password=? LIMIT 1");
    $stmt->bind_param('ss', $user, $password);
    $stmt->execute();
    $stmt->bind_result($user, $password);
    $stmt->store_result();
    if($stmt->num_rows == 1)  //To check if the row exists
    {

        echo "<script type='text/javascript'>alert('Log successfully!')</script>";
        while($stmt->fetch()) //fetching the contents of the row
        {
            $_SESSION['Logged'] = 1;
            $_SESSION['Email'] = $user;
            exit();
        }

    }
    else {
        echo "<script type='text/javascript'>alert('Failed!')</script>";
    }
    $stmt->close();
    $stmt->free_result();

    echo"<script type='text/javascript'>window.location.href='index.php';</script>";
}

function stored_procedure($user, $password, $mysqli) {
    $sql = 'CALL procedureLogin("'.$user.'", "'.$password.'")';
    $rs = $mysqli->query($sql);

    echo "<script type='text/javascript'>alert('Query executed: '+$sql)</script>";


    if($rs) {
        if ($row = $rs->fetch_array()) {
            echo "<script type='text/javascript'>alert('Log successfully!')</script>";
        }
    } else {
        echo "<script type='text/javascript'>alert('Failed!')</script>";

    }

    echo"<script type='text/javascript'>window.location.href='index.php';</script>";
}
?>

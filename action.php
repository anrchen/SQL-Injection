<?php

require ("config.php");
$user = $_POST['email'];
$password = $_POST['password'];
$valid = "";

if (empty($_POST['defense'])){
    login($user, $password, $mysqli);
    $valid = true;
} elseif ($_POST['defense']=="stored_procedure"){
    stored_procedure($user, $password, $mysqli);
    $valid = true;
} elseif ($_POST['defense']=="prepared_statement"){
    prepared_statement($user, $password, $mysqli);
    $valid = true;
} elseif ($_POST['defense'] =="whitelist"){
    whitelist($mysqli);
    $valid = true;
}

if ($valid){
    $_SESSION['session_id'] = "123";
    $_SESSION['is_admin'] = 1;
}

?>

<?php
function login($user, $password, $mysqli) {
    $sql = 'SELECT * FROM User WHERE email="'.$user.'" AND password="'.$password.'"';
    $rs = $mysqli->query($sql);
    if($rs->num_rows) {
        if($row = $rs->fetch_array()) {
            echo "<script type='text/javascript'>alert('Log successfully!')</script>";
            echo"<script type='text/javascript'>window.location.href='home.php';</script>";
        }
    } else {
        echo"<script type='text/javascript'>window.location.href='index.php';</script>";

    }
}
function whitelist($mysqli){
        $sql = "SELECT * FROM user WHERE email='test' OR 1='1'";
        $rs = $mysqli->query($sql);
        $row = $rs->fetch_array();
        var_dump($row);
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
        echo"<script type='text/javascript'>window.location.href='home.php';</script>";

    }
    else {
        echo"<script type='text/javascript'>window.location.href='index.php';</script>";
    }
    $stmt->close();
    $stmt->free_result();

}

function stored_procedure($user, $password, $mysqli) {
    $sql = 'CALL procedureLogin("'.$user.'", "'.$password.'")';
    $rs = $mysqli->query($sql);

    echo "<script type='text/javascript'>alert('Query executed: '+$sql)</script>";


    if($rs) {
        if ($row = $rs->fetch_array()) {
            echo "<script type='text/javascript'>alert('Log successfully!')</script>";
            echo"<script type='text/javascript'>window.location.href='home.php';</script>";
        }
    } else {
        echo"<script type='text/javascript'>window.location.href='index.php';</script>";
    }

}
?>

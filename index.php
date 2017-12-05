<?php
	session_start();
    require 'config.php';


?>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SOEN 321</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="style.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">
      <form class="form-signin" action = "action.php" method = "POST">
        <div class="wrapper">
          <h2 class="form-signin-heading">Please sign in</h2>
          <label for="inputEmail" class="sr-only">Email address</label>
          <input type="email" id="inputEmail" name = "username" class="form-control" placeholder="Email address" required autofocus>
          <label for="inputPassword" class="sr-only">Password</label>
          <input type="password" id="inputPassword" name = "password" class="form-control" placeholder="Password" required>
          <div class="checkbox">
            <label>
              <input type="checkbox" value="remember-me"> Remember me
            </label>
          </div>
            <div>
                <input type="radio" name="defense" value="prepared_statement"/> Prepared Statement <br>
                <input type="radio" name="defense" value="stored_procedure"/> Stored Procedure <br>
                <input type="radio" name="defense" value="whitelist"/> Whitelist <br>
            </div>
        </div>
        <div class="row">
          <div class="col-md-4">
             <button class="btn btn-md btn-primary btn-block" name="login" type="submit">Sign in</button>
          </div>

        </div>
      </form>
	  <?php
	  if(isset($_POST['login']))
	  {
		$username =$_POST['username'];
		$password=$_POST['password'];

		$sql = "SELECT * FROM user WHERE email='$username' AND password='$password'";
		$query_run = mysqli_query($con,$sql);
		if(mysqli_num_rows($query_run)>0){
			$_SESSION['username'] = $username;
			header('location:process.php');

	  }
	  else
	  {
		  echo '<script type="text/javascript">alert("invalid creds") </script>';
	  }
	  }
	  

	  
	  ?>
    </div> <!-- /container -->
  </body>
</html>
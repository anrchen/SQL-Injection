<?php include('server.php'); ?>
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
      <form class="form-register" action = "register.php" method = "POST">
        <div class="wrapper">
          <h2 class="form-signin-heading">Create account</h2>
          <label for="inputEmail" class="sr-only">Email address</label>
          <input type="email" id="inputEmail" name = "email" class="form-control" placeholder="Email address" required autofocus>
          <label for="inputPassword" class="sr-only">Password</label>
          <input type="password" id="inputPassword" name = "password" class="form-control" placeholder="Password" required>
          
            
        </div>
        <div class="row">
          <div class="col-md-4">
             <button class="btn btn-md btn-primary btn-block" name="register" type="submit">Register</button>
          </div>
          <div class="col-md-8">
             <a href="index.php">Login</a>
          </div>

        </div>
      </form>
	
    </div> <!-- /container -->
  </body>
</html>
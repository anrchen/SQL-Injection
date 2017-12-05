<?php
    session_start();

?>
<!DOCTYPE html>
<html lang="en">
  <head>

    <title>SOEN 321</title>

  </head>
  <body>
  <center>
  <h2>welcome <?php echo $_SESSION['username']?></h2> 
  </center>
  
  <form action="process.php" method="post">
	<input type="submit" name ="logout" value ="Log out"/>
	</form>
	
	<?php
		if(isset($_POST['logout']))
		{
		session_destroy();
		header('location:index.php');
		}
	
	?>
  
  
  </body>
  </html>
<?php
   $connect = new mysqli('localhost','root','', 'soen321');
   //if($connect->connect_error){
   //    echo $connect->connect_error;
    //   }


    if(isset($_POST['register'])){
        $salt = "soen321Proj!ect";
       $email = ($_POST['email']);
        $password = ($_POST['password']).$salt;
        
         $password = md5($password);
               $sql = "INSERT INTO user (email, password) VALUES (?, ?)";

               //prepare statement
              $pre = $connect->prepare($sql);
              $pre->bind_param("ss", $email,$password);
                  // $email="test";
                  // $password="123";
                   
                   $pre->execute();
               
                   $connect->close();
   

           

   }

?>

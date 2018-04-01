<html>
    <style>
      body {
        background-image: url("images/image.png");
        }
    </style>
    <body>
    <center>
     <h1>Sign Up, it's FREE!</h1>
       <p>Please fill in the form to create an account.</p>
       <font color="red">
          <p>Warning!</p>
          <p>Login or password data is already in use!</p>
       </font>
       <form action="servlet" method="get">
       <input type="text" name="name" placeholder="name..." required><br>
       <input type="text" name="age" placeholder="age..."  required><br>
       <input type="text" name="email" placeholder="email..." required><br>
       <input type="text" name="login" placeholder="login..." required><br>
       <input type="password" name="password" placeholder="password..." required><br>
       <input type="checkbox" name="subscribe" value="subsribed"> Subsribe me to your news!<br>
       <br>
       <input type="submit" value="register">
       </center>
    </body>
</html>

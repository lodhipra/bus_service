<html>
<head>
    <head>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
        <title>Welcome To Register Page</title>
    </head>
</head>
<body>
<div class="container">
    <h1>Add User Details</h1>
<form method="post" modelAttribute="userDetail">
    <div>
        <label>User Name:</label>
        <input type="text" name="name"><br>

    </div>
    <br>
    <div>
        <label>First Name:</label>
        <input type="text" name="firstName">
    </div><br>
    <div>
        <label>Last Name:</label>
        <input type="text" name="lastName">
    </div><br>
    <div>
        <label>Email Id:</label>
        <input type="text" name="emailid">
    </div><br>
    <div>
        <label>Phone Number:</label>
        <input type="text" name="phoneno">
    </div><br>
    <div>
        <label>Address Detail:</label>
        <input type="text" name="address">
    </div><br>
    <input type="submit" name="submit">
</form>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</div>
</body>
</html>
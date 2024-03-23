<html>
<head>
    <head>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
        <title>Booked Ticket</title>
    </head>
</head>
<body>
<div class="container">
    <h1>Search Bus for you</h1>
    <form method="post" modelAttribute="travel">
        <div>
            <label>Origin:</label>
            <input type="text" name="origin">
        </div><br>
        <div>
            <label>Destination:</label>
            <input type="text" name="destination">
        </div>
        <div><br>
            <label>Date of Journey:</label>
            <input type="datetime-local" name="travelDate">
        </div><br>
    </form>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</div>
</body>
</html>
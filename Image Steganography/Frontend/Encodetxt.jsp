<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Encode Text</title>
</head>
<body>
<div class="container">
        <br><br>
        <div class="jumbotron">
            <br>
                <div class="custom-file">
                    <form action="/DemoApp1/Stegtxt" method="get">
                        <p>Image to hide Text</p>
                        <input type="text" placeholder="Enter the Image file address" name="image"><br><br><br><br>
                        <p>Text to hide</p>
                        <input type="text" placeholder="Enter the text" name="text"><br><br><br>
                        <input type="submit" class="btn btn-primary" value="Submit">
                    </form>  
                    </div>
                    <br><br><br><br>                      
    </div>
    </div>

</body>
</html>

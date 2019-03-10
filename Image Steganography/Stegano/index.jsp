<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="newstega.css">
    
<title>IMAGE STEGANOGRAPHY</title>
</head>
<body>
<br>
    <div class="ui container">

         <h2 class="ui header">
         <i class="unlock alternate icon" id="s4"></i>
         <div class="content" id="s3">
            Image Steganography
         </div>
         </h2>
    <div class="ui center aligned basic segment">
            <div>
                    <a class="btn btn-success" id="b1" data-toggle="collapse" href="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                      Encode
                    </a>
            </div>
                    <div class="collapse" id="collapseExample">
        <div class="jumbotron" id="s1">
            <br>
            <br>
          <a class="btn btn-success" id="a1" href="EncodeImg.jsp">Encode Image</a>
          <a class="btn btn-success" id="a2" href="Encodetxt.jsp">Encode Text</a>
          <br>
            <br>
        </div>
        </div>
        <br><br>
        <div class="ui horizontal divider">
            <br>
         <span id="s5"> Or</span>
          <br>
          <br>
        </div>
        <div>
            <br><br>
                <a class="btn btn-danger" id="b2" data-toggle="collapse" href="#collapseExample1" aria-expanded="false" aria-controls="collapseExample">
                    Decode
                </a>
        </div>
                <div class="collapse" id="collapseExample1">
        <div class="jumbotron" id="s2">
            <br>
            <br>
        <a class="btn btn-danger" id="a3" href="DecodeImg.jsp">
          Decode Image
        </a>
        <a class="btn btn-danger" id="a4" href="Decodetxt.jsp">
            Decrypt Text
          </a>
        <br><br>
    </div>
      </div>
    </div>
</body>
</html>

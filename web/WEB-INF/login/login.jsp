<%-- 
    Document   : login
    Created on : 26-Jan-2016, 1:35:45 PM
    Author     : 680420
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

    <head>
        <link href='https://fonts.googleapis.com/css?family=Raleway:400,500,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" type="text/css" href="css/login.css">
        <script type="text/javascript" src="jquery-1.8.3.js"></script>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>

        <div id="mainButton">

            <form method="post" action="login">
                <div class="login-page">
                    <div class="form">
                        <img src="images/ergorisk.PNG" alt="ergorisk" id="ergoImage"/>
                        <p></p>


                        <input type="text" name="username" placeholder="username"/>
                        <input type="password" name="password" placeholder="password"/>
                        <button input type="submit" value="Submit">login</button>
                        <%--<h3 class="message">Forgot your password? <a href="forgot">Reset it here</a></h3>--%>
                        ${message}


                    </div>
                </div>
            </form>



        </div>



    </body>


</html>

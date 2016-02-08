<%-- 
    Document   : main
    Created on : 8-Feb-2016, 2:52:21 PM
    Author     : 680420
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Document</title>

        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
        
        <link href="../css/testing.css" rel="stylesheet" type="text/css"/>
        <script src="javascript/admintab.js" type="text/javascript"></script>

    </head>
    <body>

        <div class="top">
            <ul class="navbar-fixed-top">
                <li>

                    <a class="active" href="#home" >ErgoRisk </a></li>
                <li><a href="#client">Client</a></li>
                <li><a href="#location">Location</a></li>
                <li><a href="#location">Name</a></li>



            </ul>
        </div>


        <div class="left">
            <ul class="nav nav-tabs nav-stacked ">
                <li><a class="active" href="#admin">Admin</a></li>
                <li><a href="#">Prepare/Maintain Body</a></li>
                <li><a href="#">Safe Postures & Movements</a></li>
                <li><a href="#">Prepare Work Area & Equipment</a></li>
                <li><a href="#discomfort">Discomfort</a></li>
                <li><a href="#fup">Follow-Up</a></li>
            </ul>
        </div>


        <form method="get" action="admintab">
            <div class="right">
               <div id="admin" class="tab-pane fade in active">
                        <h1></h1>
                        <!-- call admininfo.jsp file -->
                        <c:import url="admininfo.jsp"></c:import>
                        
                    </div>
                    <!-------- DISCOMFORT TAB ----------->
                    <div id="discomfort" class="tab-pane fade">
                        <h1>Am i needed on this page or did they get rid of me??</h1>
                        <img src="http://wanna-joke.com/wp-content/uploads/2013/10/funny-gif-dog-smile.gif"
                             alt="Computer man" style="width:100%;height:100%;">
                    </div>
                    <!-------- END DISCOMFORT TAB ----------->
                    <!-------- FOLLOW UP TAB ------->
                    <div id="fup" class="tab-pane fade">
                        <h1>I am the follow up tab. Am i needed?</h1>
                        <img src="http://img.memecdn.com/funny-meme-battery-low_o_390464.jpg"
                             alt="Computer man" style="width:100%;height:100%;">
                    </div>
            </div>


        </form>



    </body>
</html>
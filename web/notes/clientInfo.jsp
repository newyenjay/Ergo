
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html>
    <head
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="jquery-1.9.1.min.js"></script>

        <link href="css/followup.css" rel="stylesheet" type="text/css">   
        <script src="javascript/admintab.js" type="text/javascript"></script>


    </head>
    <body>

    <body>
        <nav class="navbar navbar-default navbar-static-top">
            <div class="container">
                <a href="#" class="navbar-brand">ErgoRisk</a>
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="#client">Client</a>
                    </li>
                    <li>
                        <a href="#location">Location</a>
                    </li>
                    <li>
                        <a href="#name">Name</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="#">Welcome $user.firstname</a>
                    </li>
                </ul>
            </div>
        </nav>
        <!-- JSP part to send to servlet -->
        <form method="get" action="admintab">
            <input type="hidden" name="action" value="login">
            <h1></h1>
            <div class="container">
                <!--------- END NAV -------------->
                <div class="inner-panel">
                    <!----- TABS ---->
                    <ul class="nav nav-tabs" id="myTab">
                        <li class="active">
                            <a href="#admin">Admin</a>
                        </li>
                        <li>
                            <a href="#pmb">Prepare/Maintain Body</a>
                        </li>
                        <li>
                            <a href="#spm">Safe Postures &amp; Movements</a>
                        </li>
                        <li>
                            <a href="#pwa">Prepare Work Area and Equipment</a>
                        </li>
                        <li>
                            <a href="#d">Discomfort</a>
                        </li>
                        <li>
                            <a href="#fup">Follow Up</a>
                        </li>
                    </ul>
                </div>
                <!--------- TAB INFO -------------->
                <div class="tab-content">
                    <!---------- ADMIN tab ----------->
                    <div id="admin" class="tab-pane fade">
                        <h1></h1>
                        <!-- call admininfo.jsp file -->
                        <c:import url="admininfo.jsp"></c:import>
                        
                    </div>
                    <!-------- DISCOMFORT TAB ----------->
                    <div id="d" class="tab-pane fade">
                        <h3>Discomfort</h3>
                                                <c:import url="discomfort.jsp"></c:import>

                       
                    </div>
                    <!-------- END DISCOMFORT TAB ----------->
                    <!-------- FOLLOW UP TAB ------->
                    <div id="fup" class="tab-pane fade">
                        <h3>Follow-Up </h3>
                        followupfollowupfollowupfollowupfollowup
                    </div>
                    <!-------- END FOLLOW UP TAB ------->
                </div>
            </div>
        </form>
    </body>

</html>
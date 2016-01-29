<%-- 
    Document   : followup
    Created on : 20-Jan-2016, 7:02:07 PM
    Author     : 680420
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
        
        
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



    </head>
    <body>
        <div class="container">
            <nav role="navigation" class="navbar navbar-default navbar-static-top">

                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="#" class="navbar-brand">ErgoRisk</a>
                </div>
                <!-- Collection of nav links and other content for toggling -->
                <div id="navbarCollapse" class="collapse navbar-collapse">

                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#">Profile</a></li>
                        <li><a href="#">Messages</a></li>

                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">Welcome $user.firstname</a></li>
                    </ul>
                </div>


            </nav>


            <!--------- END NAV --------------> 
            
            <div class="inner-panel">

                <!----- TABS ----> 
                <ul class="nav nav-tabs" id="myTab">
                    <li class="active"><a href="#admin">Admin Info</a></li>
                    <li><a href="#discomfort">Discomfort</a></li>
                    <li><a href="#workstation">Work Station Layout</a></li>
                    <li><a href="#risk">Risk Metrics</a></li>
                    <li><a href="#rr">Risks/Recommendations</a></li>
                    <li><a href="#fup">Follow Up</a></li>
                    <li><a href="#ws">Work Safe</a></li>
                </ul>
            </div>
            
            <!--------- TAB INFO --------------> 
            <div class="tab-content">

                <!---------- ADMIN tab ----------->
                <div id="admin" class="tab-pane fade">
                    <h1></h1>

                <!-- call admininfo.jsp file --> 
                
                <c:import url="admininfo.jsp" />

                    <!-- END ADMIN TAB -->
                </div>

                <!-------- DISCOMFORT TAB ----------->
                <div id="discomfort" class="tab-pane fade">
                    <h3>Section B</h3>
                </div>
                <!-------- END DISCOMFORT TAB ----------->

                <!-------- FOLLOW UP TAB -------> 
                <div id="fup" class="tab-pane fade">
                    <h3>Notes</h3>

                    <div class="panel panel-default">
                        <div class="panel-body">
                            Accessor: $user.firstName
                            Date: sql.date
                            Communcation type : {make dropbox}
                        </div>
                    </div>
                    <div class="form-group">
                        <textarea class="form-control" rows="5" col="10" id="comment" >
                        </textarea>
                    </div>
                </div>
                <!-------- END FOLLOW UP TAB -------> 
            </div>
        </div>
    </body>
</html>

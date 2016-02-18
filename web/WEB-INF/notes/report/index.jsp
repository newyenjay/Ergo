<%-- 
    Document   : index
    Created on : 12-Feb-2016, 10:37:04 AM
    Author     : 680420
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">

        <title>Ergorisk</title>      
                        <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <!-- Custom styles for this template -->
        <link href="../../css/dashboard.css" rel="stylesheet" type="text/css"/>
        
    </head>

    <body>

        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Ergorisk</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">

                        <li><a href="#">Profile</a></li>
                        <li><a href="#">Sign out</a></li>
                    </ul>
                    <form class="navbar-form navbar-right">
                        <input type="text" class="form-control" placeholder="Search...">
                    </form>
                </div>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 sidebar">
                    <ul class="nav nav-sidebar">
                        <li class="active"><a href="#">Home <span class="sr-only">(current)</span></a></li>
                        <li><a href="#">Client</a></li>
                        <li><a href="#">Location</a></li>
                        <li><a href="#">Company</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Report <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href=#admin class="link" data-toggle="tab">Admin</a></li>
                                <li><a href="#pmb" class="link" data-toggle="tab">Prepare/Maintain Body</a></li>
                                <li><a href="#spm" class="link" data-toggle="tab">Safe Postures & Movements</a></li>
                                <li><a href="#pwae" class="link" data-toggle="tab">Prepare Work Area & Equipment</a></li>
                                <li><a href=#discomfort class="link" data-toggle="tab">Discomfort</a></li>
                                <li><a href="#follow" class="link" data-toggle="tab" >Follow-Up</a></li>
                            </ul>
                        </li>
                        <li><a href="#generate">Generate</a></li>
                    </ul>


                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 content">
                    <ul class="nav nav-pills" id="myTab" style="display: inline">
                        <li><a data-toggle="tab" href="#admin">Admin</a></li>
                        <li><a data-toggle="tab" href="#pmb" >Prepare/Maintain Body</a></li>
                        <li><a data-toggle="tab" href="#spm">Safe Postures & Movements</a></li>
                        <li><a data-toggle="tab" href="#pwae">Prepare Work Area & Equipment</a></li>
                        <li><a data-toggle="tab" href="#discomfort">Discomfort</a></li>
                        <li><a data-toggle="tab" href="#follow">Follow-Up</a></li>
                    </ul>
                    <div class="tab-content" id="myTabContent" style="position: relative;">
                        <div id="admin" class="tab-pane fade">
                            <h2 class="page-header">Admin</h2>
                            <c:import url="admininfo.jsp"></c:import>

                        </div>
                        <div id="pmb" class="tab-pane fade">
                            <h3>Prepare/Maintain Body</h3>
                            <p>Prepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain Body</p>
                        </div>
                        <div id="spm" class="tab-pane fade">
                            <h3>Safe Postures & Movements</h3>
                            <p>WInteger convallis, nulla in sollicitudin placerat, ligula enim auctor lectus, in mollis diam dolor at lorem. Sed bibendum nibh sit amet dictum feugiat. Vivamus arcu sem, cursus a feugiat ut, iaculis at erat. Donec vehicula at ligula vitae venenatis. Sed nunc nulla, vehicula non porttitor in, pharetra et dolor. Fusce nec velit velit. Pellentesque consectetur eros.</p>
                        </div>
                        <div id="pwae" class="tab-pane fade">
                            <h3>Prepare Work Area & Equipment</h3>
                            <c:import url="workstation.jsp"></c:import>
                        </div>
                        <div id="discomfort" class="tab-pane fade">

                            <h2 class="page-header">Discomfort</h2>
                        </div>
                        <div id="follow" class="tab-pane fade">
                            <h3>Follow-Up</h3>
                            <p>Donec vel placerat quam, ut euismod risus. Sed a mi suscipit, elementum sem a, hendrerit velit. Donec at erat magna. Sed dignissim orci nec eleifend egestas. Donec eget mi consequat massa vestibulum laoreet. Mauris et ultrices nulla, malesuada volutpat ante. Fusce ut orci lorem. Donec molestie libero in tempus imperdiet. Cum sociis natoque penatibus et magnis dis parturient.</p>
                        </div>

                    </div>



                </div>
            </div>
        </div>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
          <![endif]-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </body>
</html>


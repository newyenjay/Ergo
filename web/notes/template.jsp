<%-- 
    Document   : template
    Created on : 10-Feb-2016, 7:50:46 PM
    Author     : 680420
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('a[data-toggle="tab"]').on('shown.bs.tab', function(e){
        var activeTab = $(e.target).text(); // Get the name of active tab
        var previousTab = $(e.relatedTarget).text(); // Get the name of previous tab
        $(".active-tab span").html(activeTab);
        $(".previous-tab span").html(previousTab);
    });
		});
	</script>
	<style type="text/css">
		.bs-example{
			margin: 20px;
		}
	</style>
    </head>
    <body>
        <form method="get" action="admintab">

            <div class="row">
                <div class="col-md-12">
                    <nav class="navbar navbar-inverse" role="navigation">
                        <div class="container-fluid">
                            <!-- Brand and toggle get grouped for better mobile display -->
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-5">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                                <a class="navbar-brand" >Ergorisk</a>
                            </div>
                            <!-- Collect the nav links, forms, and other content for toggling -->
                            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-5">
                                <ul class="nav navbar-nav">
                                    <li ><a href="#">Client</a></li>
                                    <li><a href="#">Location</a></li>
                                    <li><a href="#">Commpany</a></li>

                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Report <b class="caret"></b></a>
                                        <ul class="dropdown-menu" role="menu">
                                            <li><a href="#">Admin</a></li>
                                            <li><a href="#">Prepare/Maintain Body</a></li>
                                            <li><a href="#">Safe Postures & Movements</a></li>
                                            <li><a href="#">Prepare Work Area & Equipment</a></li>
                                            <li><a href="#">Discomfort</a></li>
                                            <li><a href="#">Follow-Up</a></li>

                                        </ul>
                                    </li>
                                </ul>
                                
                            </div><!-- /.navbar-collapse -->
                        </div><!-- /.container-fluid -->
                    </nav>
                </div>
            </div> <! -- nav bar ---> 

            <div class="content">
                <div class="container"> 

                    <ul class="nav nav-tabs" id="myTab" style="display: inline">
                        <li class="active"><a data-toggle="tab" href="#admin">Admin</a></li>
                        <li><a data-toggle="tab" href="#pmb">Prepare/Maintain Body</a></li>
                        <li><a data-toggle="tab" href="#spm">Safe Postures & Movements</a></li>
                        <li><a data-toggle="tab" href="#pwae">Prepare Work Area & Equipment</a></li>
                        <li><a data-toggle="tab" href="#discomfort">Discomfort</a></li>
                        <li><a data-toggle="tab" href="#fup">Follow-Up</a></li>
                    </ul>
                    <div class="tab-content" id="myTabContent" style="position: relative;">
                        <div id="admin" class="tab-pane fade in active">
                            <h3>Administration Page</h3>
                            <!-- call admininfo.jsp file -->
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
                            <p>Donec vel placerat quam, ut euismod risus. Sed a mi suscipit, elementum sem a, hendrerit velit. Donec at erat magna. Sed dignissim orci nec eleifend egestas. Donec eget mi consequat massa vestibulum laoreet. Mauris et ultrices nulla, malesuada volutpat ante. Fusce ut orci lorem. Donec molestie libero in tempus imperdiet. Cum sociis natoque penatibus et magnis dis parturient.</p>
                        </div>
                        <div id="discomfort" class="tab-pane fade">
                            <h3>Discomfort</h3>
                             <c:import url="discomfort.jsp"></c:import>

                        </div>

                        <div id="fup" class="tab-pane fade">
                            <h3>Follow-Up</h3>
                            <p>Donec vel placerat quam, ut euismod risus. Sed a mi suscipit, elementum sem a, hendrerit velit. Donec at erat magna. Sed dignissim orci nec eleifend egestas. Donec eget mi consequat massa vestibulum laoreet. Mauris et ultrices nulla, malesuada volutpat ante. Fusce ut orci lorem. Donec molestie libero in tempus imperdiet. Cum sociis natoque penatibus et magnis dis parturient.</p>
                        </div>

                    </div>


                </div>

            </div> <!-- content --> 
        </form>
    </body>
</html>

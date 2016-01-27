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
        <meta name="viewport" content="width=device-width, initial-scale=1"> 

        <script type="text/javascript">
            $(document).ready(function () {
                $("#myTab a").click(function (e) {
                    e.preventDefault();
                    $(this).tab('show');
                });
            });


            $(".date-picker").datepicker();

            $(".date-picker").on("change", function () {
                var id = $(this).attr("id");
                var val = $("label[for='" + id + "']").text();
                $("#msg").text(val + " changed");
            });





        </script>

        <script type ="text/css">
            @import url('//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css');

            .date-form { margin: 10px; }
            label.control-label span { cursor: pointer; }

            textarea {
                resize: both;
            }

        </script>
    </head>
    <body backrground-color="yellow">
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
            <!----  
            <small>
                I'm a little teapot
                Short and stout
                Here is my handle
                Here is my spout
                When I get all steamed up
                I just shout
                Tip me over and pour me out
            </small>
-----> 
            <div class="inner-panel">

                <!----- TABS ----> 
                <ul class="nav nav-tabs" id="myTab">
                    <li class="active"><a href="#admin">Admin Info</a></li>
                    <li><a href="#discomfort">Discomfort</a></li>

                    <!-------- adding this here if needed 
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">Dropdown <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#dropdown1">Dropdown1</a></li>
                            <li><a href="#dropdown2">Dropdown2</a></li>
                        </ul>
                    </li>
                    
                    -->
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

                    <div class="section text-left">
                        <div class="container">
                            <div class="row">
                                <form role="form">
                                    <h2></h2>
                                    <label>Reason for assessment</label>
                                    <div class="radio">
                                        <label class="radio-inline">
                                            <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"
                                                   checked="">New hire/job</label>
                                        <label class="radio-inline">
                                            <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2"
                                                   checked="">New Workstation</label>
                                        <label class="radio-inline">
                                            <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2"
                                                   checked="">Workstation concern</label>
                                        <label class="radio-inline">
                                            <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2"
                                                   checked="">Spot check follow up</label>
                                    </div>
                                    <div class="radio">
                                        <label class="radio-inline">
                                            <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1"
                                                   checked="">New hire/job</label>
                                        <label class="radio-inline">
                                            <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2"
                                                   checked="">New Workstation</label>
                                        <label class="radio-inline">
                                            <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2"
                                                   checked="">Workstation concern</label>
                                        <label class="radio-inline">
                                            <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2"
                                                   checked="">Reaccessment</label>
                                    </div>
                                    <p></p>
                                </form>
                            </div>
                        </div>
                        <div class="section">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-12">
                                        <form role="form" class="text-left">
                                            <div class="form-group">
                                                <div class="col-xs-3">
                                                    <label for="ex1">Manager</label>
                                                    <input class="form-control" id="ex1" type="text">
                                                </div>
                                                <div class="col-xs-3">
                                                    <label for="ex2">Business Unit</label>
                                                    <input class="form-control" id="ex2" type="text">
                                                </div>
                                                <div class="col-xs-4">
                                                    <label for="ex3">Workspace</label>
                                                    <input class="form-control" id="ex3" type="text">
                                                </div>
                                                <div class="col-xs-2">
                                                    <label for="ex3">Job title</label>
                                                    <input class="form-control" id="ex3" type="text">
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <label>Accessor</label>
                                                <div class="form-group">
                                                    <select class="form-control" id="sel1">
                                                        <option></option>
                                                        <option>Tennille Walker</option>
                                                        <option>Mandy Gallant</option>
                                                        <option>Rob Fontaine</option>
                                                        <option>Kerri Downer</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-xs-2">
                                                <label for="ex2">Date</label>
                                                <input class="form-control" id="ex2" type="text">
                                            </div>
                                            <div class="col-xs-1">
                                                <label for="ex3">Gender</label>
                                                <div class="form-group">
                                                    <select class="form-control" name="gender">
                                                        <option value=""></option>
                                                        <option value="s">Male</option>
                                                        <option value="m">Female</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-xs-2">
                                                <label>Height:</label>
                                                <input class="form-control" id="ex3" type="text" placeholder="ft">
                                            </div>
                                            <div class="col-xs-2">
                                                <label> </label>
                                                <input class="form-control" id="ex3" type="text" placeholder="in">
                                            </div>
                                            <div class="col-xs-2">
                                                <label>Handedness</label>
                                                <div class="form-group">
                                                    <select class="form-control input-sm" name="gender">
                                                        <option value=""></option>
                                                        <option value="s">Left</option>
                                                        <option value="m">Right</option>
                                                    </select>
                                                </div>
                                                <!-- end handedness -->
                                            </div>
                                        </form>
                                    </div> <!-- end col-md-12 --> 
                                </div> <!-- end row -->

                                <div class="row">
                                    <div class="container">
                                        <div class="col-xs-3">
                                            <label>days/weeks in office</label>
                                            <input class="form-control" id="office" type="text">
                                        </div>
                                        <div class="col-xs-3">
                                            <label>hrs/day in office</label>
                                            <input class="form-control" id="office" type="text">
                                        </div>
                                        <div class="col-xs-3 text-left">
                                            <label>hrs in VDT</label>
                                            <input class="form-control" id="office" type="text">
                                        </div>
                                        <div class="col-xs-3">
                                            <label>hrs on phone</label>
                                            <input class="form-control" id="office" type="text">
                                        </div>
                                    </div>
                                </div>
                            </div> <!-- end container -->


                        </div>
                    </div>

                    <p></p>
                    <hr>

                    <div class="section">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-4">
                                    <textarea class="form-control" rows="10" cols="45">Enter notes</textarea>
                                </div>
                                <div class="col-md-4">
                                    <div class="col-xs-3">
                                        <div class="form-group">
                                            <label>Discomfort present?</label>
                                            <select class="form-control" name="dpresent">
                                                <option value=""></option>
                                                <option value="no">Yes</option>
                                                <option value="yes">No</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-xs-3">
                                        <div class="form-group">
                                            <label>Discomfort reported?</label>
                                            <select class="form-control" name="dreported">
                                                <option value=""></option>
                                                <option value="no">Yes</option>
                                                <option value="yes">No</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-xs-3">
                                        <div class="form-group">
                                            <label>Treatement sought?</label>
                                            <select class="form-control" name="tsought">
                                                <option value=""></option>
                                                <option value="yes">Yes</option>
                                                <option value="no">No</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-xs-3">
                                        <div class="form-group">
                                            <label>Max discomfort</label>
                                            <select class="form-control" name="maxdiscomfort">
                                                <option value="">0</option>
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="col-md-6">
                                        <li>
                                            <b>High Risk &gt;11</b>
                                            <br>Immediate corretive action</li>
                                        <li>
                                            <b>Moderate Risk 9-11</b>
                                            <br>Discomfort present and/or moderate to significant risk factors present</li>
                                        <li>
                                            <b>Low Risk &lt;9</b>
                                            <br>Minor to moderate hazard controls to minimize the risk of musculoskletal
                                            disorders and discomforts</li>
                                    </div>
                                    <div class="col-md-6">i am part 2</div>
                                </div>
                            </div>
                        </div>
                    </div>


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

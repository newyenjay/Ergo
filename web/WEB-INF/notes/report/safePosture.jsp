<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<form action="safePosture" method="post" roll="form">
    <div class="section">
        <!-- stable base --> 
        <div class="col-md-12">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Stable Base</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-6">
                            <h4>Before</h4>
                            <hr>
                            <!-- stable base option -->
                            <div class="form-group">

                                <div class="col-sm-12">
                                    <div class="radio" id="stableBaseBefore">
                                        <label class="radio-inline" >
                                                <input type="radio" name="optionsRadios" name="stableYes" value="option1" checked="">Yes</label>
                                            <label class="radio-inline">
                                                <input type="radio" name="optionsRadios" name="stableNo" value="option2" checked="">No</label>
                                    </div>
                                    <textarea class="form-control">

                                    </textarea>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <h4>After</h4>
                            <hr>
                            <!-- stable base option -->
                            <div class="form-group">

                                <div class="col-sm-12">
                                    <div class="radio" id="stableBaseAfter">
                                        <label class="radio-inline" >
                                                <input type="radio" name="optionsRadios" name="stableYes" value="option1" checked="">Yes</label>
                                            <label class="radio-inline">
                                                <input type="radio" name="optionsRadios" name="stableNo" value="option2" checked="">No</label>
                                    </div>
                                    <textarea class="form-control"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- stable base --> 


        <!-- shoulders anchored --> 

        <div class="col-md-12">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Shoulders Anchored</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-6">
                            <h4>Before</h4>
                            <hr>
                            <!-- stable base option -->
                            <div class="form-group">

                                <div class="col-sm-12">
                                    <div class="radio" id="shouldersBefore">
                                          <label class="radio-inline" >
                                                <input type="radio" name="optionsRadios" name="shoulderYes" value="option1" checked="">Yes</label>
                                            <label class="radio-inline">
                                                <input type="radio" name="optionsRadios" name="shoulderNo" value="option2" checked="">No</label>
                                    </div>
                                    <textarea class="form-control"></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <h4>After</h4>
                            <hr>
                            <!-- stable base option -->
                            <div class="form-group">

                                <div class="col-sm-12">
                                    <div class="radio" id="shouldersAfter">
                                       <label class="radio-inline" >
                                                <input type="radio" name="optionsRadios" name="shoulderYes" value="option1" checked="">Yes</label>
                                            <label class="radio-inline">
                                                <input type="radio" name="optionsRadios" name="shoulderNo" value="option2" checked="">No</label>
                                    </div>
                                    <textarea class="form-control"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- shoulders anchored --> 
        <div class="col-md-12">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Arms at side</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-6">
                            <h4>Before</h4>
                            <hr>
                            
                            <div class="form-group">


                                <div class="col-sm-12">
                                    <div class="radio" id="armsSideBefore">
                                        <label class="radio-inline">
                                                <input type="radio" name="armsYes" name="armYes" value="option1" >Yes</label>
                                            <label class="radio-inline">
                                                <input type="radio" name="armsNo" name="armNo" value="option2">No</label>
                                    </div>
                                    <textarea class="form-control"></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <h4>After</h4>
                            <hr>
                            <!-- stable base option -->
                            <div class="form-group">

                                <div class="col-sm-12">
                                    <div class="radio" id="armsAfter">
                                        <label class="radio-inline">
                                                <input type="radio" name="optionsRadios" name="armYes" value="option1" >Yes</label>
                                            <label class="radio-inline">
                                                <input type="radio" name="optionsRadios" name="armNo" value="option2">No</label>
                                    </div>
                                    <textarea class="form-control"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <a class="btn btn-primary">Save</a>

        </div>   
        <!-- button  --> 
        <br>
        <br>
        <br>



    </div>




</form>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<form action="spm" method="POST">
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
                                                <input type="radio" name="baseBeBool" value="true">Yes</label>
                                            <label class="radio-inline">
                                                <input type="radio" name="baseBeBool" value="false" checked>No</label>
                                    </div>
                                    <textarea class="form-control" name="baseBeNotes">

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
                                                <input type="radio" name="baseAfBool" value="true">Yes</label>
                                            <label class="radio-inline">
                                                <input type="radio" name="baseAfBool" value="false" checked>No</label>
                                    </div>
                                    <textarea class="form-control" name="baseAfNotes"></textarea>
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
                                                <input type="radio" name="shoulderBeBool" value="true">Yes</label>
                                            <label class="radio-inline">
                                                <input type="radio" name="shoulderBeBool" value="false" checked>No</label>
                                    </div>
                                    <textarea class="form-control" name="shoulderBeNotes"></textarea>
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
                                                <input type="radio" name="shoulderAfBool" value="true">Yes</label>
                                            <label class="radio-inline">
                                                <input type="radio" name="shoulderAfBool" value="false" checked>No</label>
                                    </div>
                                    <textarea class="form-control" name="shoulderAfNotes"></textarea>
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
                                                <input type="radio" name="armBeBool" value="true" >Yes</label>
                                            <label class="radio-inline">
                                                <input type="radio" name="armBeBool" value="false" checked>No</label>
                                    </div>
                                    <textarea class="form-control" name="armBeNotes"></textarea>
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
                                                <input type="radio" name="armAfBool" value="true" >Yes</label>
                                            <label class="radio-inline">
                                                <input type="radio" name="armAfBool" value="false" checked>No</label>
                                    </div>
                                    <textarea class="form-control" name="armAfNotes"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>   
        <!-- button  --> 
        <br>
        <br>
        <br>
<input type="Submit" value="Save"/>


    </div>




</form>
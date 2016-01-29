<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Reason for assessment</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form">
                            <div class="form-group">
                                <label class="control-label">Proactive</label>
                                <select class="form-control">
                                    <option></option>
                                    <option>New hire/job</option>
                                    <option>New Workstation</option>
                                    <option>Workstation concern</option>
                                    <option>Spot check follow up</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label class="control-label">Reactive</label>
                                <select class="form-control">
                                    <option></option>
                                    <option>New hire/job</option>
                                    <option>New Workstation</option>
                                    <option>Discomfort</option>
                                    <option>Reassessement</option>
                                </select>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Accessor information</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form">
                            <div class="form-group">
                                <label class="control-label">Assessment</label>
                                <select class="form-control">
                                    <option></option>
                                    <option>Tennille Walker</option>
                                    <option>Mandy Gallant</option>
                                    <option>Rob Fontaine</option>
                                    <option>Kerri Downer</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label class="control-label">Date</label>
                                <input class="form-control" type="text">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Client information</h3>
                    </div>
                    <div class="panel-body">
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
                        <div class="form-group">
                            <div class="col-xs-3">
                                <label for="ex3">Gender</label>
                                <select class="form-control" name="gender">
                                    <option value=""></option>
                                    <option value="s">Male</option>
                                    <option value="m">Female</option>
                                </select>
                            </div>
                            <div class="col-xs-3">
                                <label>Height:</label>
                                <input class="form-control" id="ex3" type="text" placeholder="ft">
                            </div>
                            <div class="col-xs-4">
                                <label></label>
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
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-3">
                                <label for="ex1">Days/weeks in office</label>
                                <input class="form-control" id="ex1" type="text">
                            </div>
                            <div class="col-xs-3">
                                <label for="ex2">Hrs/day in office</label>
                                <input class="form-control" id="ex2" type="text">
                            </div>
                            <div class="col-xs-4">
                                <label for="ex3">hrs in VDT</label>
                                <input class="form-control" id="ex3" type="text">
                            </div>
                            <div class="col-xs-2">
                                <label for="ex3">hrs on phone</label>
                                <input class="form-control" id="ex3" type="text">
                            </div>
                        </div>
                    </div>
                </div>

                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Notes and comments</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-6">
                                <textarea class="form-control" rows="10" cols="45" placeholder="Enter notes"></textarea>
                            </div>
                            <div class="col-md-6">
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
                                        <label>Maximum discomfort</label>
                                        <select class="form-control" name="maxdiscomfort">
                                            <option></option>
                                            <option value="">0</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                        </select>
                                    </div>
                                </div>
                            </div>


                        </div>
                        <div class="col-md-6">
                            <p></p>
                            <br>
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
                        <div class="col-md-6">

                            <c:import url="table.html" />


                        </div>
                    </div>

                </div>
            </div>
         

        </div>            <!-- end panel 2 -->
        <div class="jumbotron">
  <button type="submit" class="btn btn-default">Submit</button>
            
        </div>
    </div>

</div>
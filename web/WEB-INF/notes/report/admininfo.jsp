<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <c:if test = "${message != null}">

        <c:if test = "${sucess == 0}">
            <div class="alert alert-warning fade in">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Warning! </strong>${message}
            </div>
        </c:if>
        <c:if test = "${sucess == 1}">
            <div class="alert alert-success fade in">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Success! </strong>${message}
            </div>
        </c:if>

    </c:if>
</div> 

<form method="post" action="adminTab">
    <c:if test = "${assessmentInfo.adminId.adminId != null}">
        <input type="hidden" value="update" name="action">
        <input type="hidden" value="${assessmentInfo.adminId.adminId}" name="adminId">

    </c:if>
    <c:if test = "${assessmentInfo.adminId.adminId == null}">
        <input type="hidden" value="add" name="action">
    </c:if>

    <div class="section">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">Reason for assessment</h3>
                        </div>
                        <div class="panel-body">
                            <div class="form-group">
                                <label class="control-label">Proactive</label>
                                <select class="form-control" name="proactive">
                                    <option></option>
                                    <option <c:if test="${assessmentInfo.adminId.proactive == 'New hire/job'}"> selected="selected" </c:if> >New hire/job</option>
                                    <option <c:if test="${assessmentInfo.adminId.proactive == 'New Workstation'}"> selected="selected" </c:if> >New Workstation</option>
                                    <option <c:if test="${assessmentInfo.adminId.proactive == 'Workstation concern'}"> selected="selected" </c:if> >Workstation concern</option>
                                    <option <c:if test="${assessmentInfo.adminId.proactive == 'Spot check follow up'}"> selected="selected" </c:if> >Spot check follow up</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Reactive</label>
                                    <select class="form-control" name="reactive">
                                        <option></option>
                                        <option <c:if test="${assessmentInfo.adminId.reactive == 'New hire/job'}"> selected="selected" </c:if> >New hire/job</option>
                                    <option <c:if test="${assessmentInfo.adminId.reactive == 'New Workstation'}"> selected="selected" </c:if> >New Workstation</option>
                                    <option <c:if test="${assessmentInfo.adminId.reactive == 'Workstation concern'}"> selected="selected" </c:if> >Workstation concern</option>
                                    <option <c:if test="${assessmentInfo.adminId.reactive == 'Spot check follow up'}"> selected="selected" </c:if> >Spot check follow up</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title">Accessor information</h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="control-label">Accessor</label>
                                    <select class="form-control" name="accessor">
                                        <option></option>
                                    <c:forEach var="employee" items="${employeeList}">
                                        <option value="${employee.username}" <c:if test="${assessmentInfo.adminId.assessor == employee.username}"> selected="selected" </c:if> >${employee.firstName} ${employee.lastName}</option>

                                    </c:forEach>
                                </select>
                            </div>

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
                                    <input class="form-control" id="ex1" type="text" name="manager" value="${assessmentInfo.adminId.manager}">
                                </div>
                                <div class="col-xs-3">
                                    <label for="ex2">Business Unit</label>
                                    <input class="form-control" id="ex2" type="text" name="business" value="${assessmentInfo.adminId.businessUnit}">
                                </div>
                                <div class="col-xs-4">
                                    <label for="ex3">Workspace</label>
                                    <input class="form-control" id="ex3" type="text" name="workspace" value="${assessmentInfo.adminId.workspace}">
                                </div>
                                <div class="col-xs-2">
                                    <label for="ex3">Job title</label>
                                    <input class="form-control" id="ex3" type="text" name="jobTitle" value="${assessmentInfo.adminId.jobTitle}">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-3">
                                    <label for="ex3">Gender</label>
                                    <select class="form-control" name="gender">
                                        <option value=""></option>
                                        <option value="Male" <c:if test="${assessmentInfo.adminId.gender == 'Male'}"> selected="selected" </c:if> >Male</option>
                                        <option value="Female" <c:if test="${assessmentInfo.adminId.gender == 'Female'}"> selected="selected" </c:if> >Female</option>
                                        </select>
                                    </div>
                                    <div class="col-xs-3">
                                        <label>Height:</label>
                                        <input class="form-control" id="ex3" type="text" placeholder="ft" name="heightFeet" value="${assessmentInfo.adminId.heightInFeet}">
                                </div>
                                <div class="col-xs-4">
                                    <label></label>
                                    <input class="form-control" id="ex3" type="text" placeholder="in" name="heightInches" value="${assessmentInfo.adminId.heightInInches}">
                                </div>
                                <div class="col-xs-2">
                                    <label>Handedness</label>
                                    <div class="form-group">
                                        <select class="form-control input-sm" name="handedness">
                                            <option value=""></option>
                                            <option value="Left" <c:if test="${assessmentInfo.adminId.handedness == 'Left'}"> selected="selected" </c:if> >Left</option>
                                            <option value="Right" <c:if test="${assessmentInfo.adminId.handedness == 'Rights'}"> selected="selected" </c:if> >Right</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">
                                        <label for="ex1">Days/weeks in office</label>
                                        <input class="form-control" id="ex1" type="text" name="daysWeeksInOffice" value="${assessmentInfo.adminId.daysPerWeek}">
                                </div>
                                <div class="col-xs-3">
                                    <label for="ex2">Hrs/day in office</label>
                                    <input class="form-control" id="ex2" type="text" name="hoursDayInOffice" value="${assessmentInfo.adminId.hoursPerDay}">
                                </div>
                                <div class="col-xs-4">
                                    <label for="ex3">hrs in VDT</label>
                                    <input class="form-control" id="ex3" type="text" name="hoursInVDT" value="${assessmentInfo.adminId.hoursVDT}">
                                </div>
                                <div class="col-xs-2">
                                    <label for="ex3">hrs on phone</label>
                                    <input class="form-control" id="ex3" type="text" name="hoursOnPhone" value="${assessmentInfo.adminId.hoursOnPhone}">
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
                                    <div class="col-xs-2">
                                        <div class="form-group">
                                            <label>Discomfort present?</label>
                                            <select class="form-control" name="dPresent">
                                                <option value=""></option>
                                                <option value="yes" <c:if test="${assessmentInfo.adminId.discomfortPresent == 'yes'}"> selected="selected" </c:if> >Yes</option>
                                                <option value="no" <c:if test="${assessmentInfo.adminId.discomfortPresent == 'no'}"> selected="selected" </c:if> >No</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-xs-2">
                                            <div class="form-group">
                                                <label>Discomfort reported?</label>
                                                <select class="form-control" name="dReported">
                                                    <option value=""></option>
                                                    <option value="yes" <c:if test="${assessmentInfo.adminId.discomfortReported == 'yes'}"> selected="selected" </c:if> >Yes</option>
                                                <option value="no" <c:if test="${assessmentInfo.adminId.discomfortReported == 'no'}"> selected="selected" </c:if> >No</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-xs-2">
                                            <div class="form-group">
                                                <label>Treatment sought?</label>
                                                <select class="form-control" name="tSought">
                                                    <option value=""></option>
                                                    <option value="yes" <c:if test="${assessmentInfo.adminId.treatmentSought == 'yes'}"> selected="selected" </c:if> >Yes</option>
                                                <option value="no" <c:if test="${assessmentInfo.adminId.treatmentSought == 'no'}"> selected="selected" </c:if> >No</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-xs-2">
                                            <div class="form-group">
                                                <label>Maximum discomfort</label>
                                                <select class="form-control" name="maxDiscomfort">
                                                    <option></option>
                                                    <option value="0" selected="selected">0</option>
                                                    <option value="1" <c:if test="${assessmentInfo.adminId.maxDiscomfort == '1'}"> selected="selected" </c:if> >1</option>
                                                <option value="2" <c:if test="${assessmentInfo.adminId.maxDiscomfort == '2'}"> selected="selected" </c:if> >2</option>
                                                <option value="3" <c:if test="${assessmentInfo.adminId.maxDiscomfort == '3'}"> selected="selected" </c:if> >3</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-xs-2">
                                            <div class="form-group">
                                                <label>Workstation fit</label>
                                                <select class="form-control" name="workFit">
                                                    <option></option>
                                                    <option value="0" selected="selected">0</option>
                                                    <option value="1" <c:if test="${assessmentInfo.adminId.workFit == '1'}"> selected="selected" </c:if> >1</option>
                                                <option value="2" <c:if test="${assessmentInfo.adminId.workFit == '2'}"> selected="selected" </c:if> >2</option>
                                                <option value="3" <c:if test="${assessmentInfo.adminId.workFit == '3'}"> selected="selected" </c:if> >3</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="control-label">Identified Risks
                                                <br>
                                            </label>
                                            <textarea class="form-control" name="risks">${assessmentInfo.adminId.risks}</textarea>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label">Equipment Recommendations</label>
                                        <textarea class="form-control" name="equiptRec">${assessmentInfo.adminId.equipmentRecommendations}</textarea>
                                    </div>
                                </div>

                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <label class="control-label">General Notes</label>
                                    <textarea class="form-control" rows="10" cols="45" placeholder="Enter notes" name="generalNotes">${assessmentInfo.adminId.generalNotes}</textarea>
                                </div>

                            </div>
                            <div class="col-md-6">
                                <p></p>
                                <br>
                                <li>
                                    <b>High Risk &gt;11</b>
                                    <br>Immediate corrective action</li>
                                <li>
                                    <b>Moderate Risk 9-11</b>
                                    <br>Discomfort present and/or moderate to significant risk factors present</li>
                                <li>
                                    <b>Low Risk &lt;9</b>
                                    <br>Minor to moderate hazard controls to minimize the risk of musculoskeletal
                                    disorders and discomforts</li>
                                <hr>
                                <div class="form-group">
                                    <div class="col-sm-2">
                                        <label for="inputEmail3" class="control-label">Score</label>
                                    </div>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control"  placeholder="Score" name="scoreVDT" disabled>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-2">
                                        <label class="control-label">Follow up needed</label>
                                    </div>
                                    <div class="col-sm-10">
                                        <label class="radio-inline">
                                            <input type="radio" name="followup" value="yesFollow"  <c:if test="${assessmentInfo.adminId.followUpNeeded == 'yesFollow'}"> checked </c:if> >Yes</label>
                                            <label class="radio-inline">
                                                <input type="radio" name="followup" value="noFollow" <c:if test="${assessmentInfo.adminId.followUpNeeded == 'noFollow'}"> checked </c:if>>No</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <!-- table goes here --> 
                                <c:import url="/WEB-INF/notes/report/table.html"></c:import>


                            </div>
                        </div>
                    </div>
                </div>


            </div>    
            <!-- end panel 2 -->

            <button type="submit" position="offset" class="btn btn-default">Submit</button>
        </div>

    </div>

</form>

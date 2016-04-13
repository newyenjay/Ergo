<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<form action="spm" method="POST">
    <c:if test = "${assessmentInfo.spmId.spmId != null}">
        <input type="hidden" value="update" name="action">
        <input type="hidden" value="${assessmentInfo.spmId.spmId}" name="spmId">

    </c:if>
    <c:if test = "${assessmentInfo.spmId.spmId == null}">
        <input type="hidden" value="add" name="action">
    </c:if>
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
                                            <input type="radio" name="baseBeBool" value="true" <c:if test="${assessmentInfo.spmId.baseBeBool == true}"> checked </c:if> >Yes</label>
                                        <label class="radio-inline">
                                            <input type="radio" name="baseBeBool" value="false" <c:if test="${assessmentInfo.spmId.baseBeBool == false}"> checked </c:if> >No</label>
                                    </div>
                                    <textarea class="form-control" name="baseBeNotes">${assessmentInfo.spmId.baseBeNotes}</textarea>
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
                                            <input type="radio" name="baseAfBool" value="true" <c:if test="${assessmentInfo.spmId.baseAfBool == true}"> checked </c:if> >Yes</label>
                                        <label class="radio-inline">
                                            <input type="radio" name="baseAfBool" value="false" <c:if test="${assessmentInfo.spmId.baseAfBool == false}"> checked </c:if> >No</label>
                                    </div>
                                    <textarea class="form-control" name="baseAfNotes">${assessmentInfo.spmId.baseAfNotes}</textarea>
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
                                            <input type="radio" name="shoulderBeBool" value="true" <c:if test="${assessmentInfo.spmId.shoulderBeBool == true}"> checked </c:if> >Yes</label>
                                        <label class="radio-inline">
                                            <input type="radio" name="shoulderBeBool" value="false" <c:if test="${assessmentInfo.spmId.shoulderBeBool == false}"> checked </c:if> >No</label>
                                    </div>
                                    <textarea class="form-control" name="shoulderBeNotes">${assessmentInfo.spmId.shoulderBeNotes}</textarea>
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
                                            <input type="radio" name="shoulderAfBool" value="true" <c:if test="${assessmentInfo.spmId.shoulderAfBool == true}"> checked </c:if> >Yes</label>
                                        <label class="radio-inline">
                                            <input type="radio" name="shoulderAfBool" value="false" <c:if test="${assessmentInfo.spmId.shoulderAfBool == false}"> checked </c:if> >No</label>
                                    </div>
                                    <textarea class="form-control" name="shoulderAfNotes">${assessmentInfo.spmId.shoulderAfNotes}</textarea>
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
                                            <input type="radio" name="armBeBool" value="true" <c:if test="${assessmentInfo.spmId.armBeBool == true}"> checked </c:if> >Yes</label>
                                        <label class="radio-inline">
                                            <input type="radio" name="armBeBool" value="false" <c:if test="${assessmentInfo.spmId.armBeBool == false}"> checked </c:if> >No</label>
                                    </div>
                                    <textarea class="form-control" name="armBeNotes">${assessmentInfo.spmId.armBeNotes}</textarea>
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
                                            <input type="radio" name="armAfBool" value="true" <c:if test="${assessmentInfo.spmId.armAfBool == true}"> checked </c:if> >Yes</label>
                                        <label class="radio-inline">
                                            <input type="radio" name="armAfBool" value="false" <c:if test="${assessmentInfo.spmId.armAfBool == true}"> checked </c:if> >No</label>
                                    </div>
                                    <textarea class="form-control" name="armAfNotes">${assessmentInfo.spmId.armAfNotes}</textarea>
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
        <input type="submit" class="btn btn-default" value="Save"></input>


    </div>




</form>
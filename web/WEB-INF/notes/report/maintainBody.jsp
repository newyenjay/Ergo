<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<form action="pmb" method="POST">

    <c:if test = "${assessmentInfo.pmbId.pmbId != null}">
        <input type="hidden" value="update" name="action">
        <input type="hidden" value="${assessmentInfo.pmbId.pmbId}" name="pmbId">

    </c:if>
    <c:if test = "${assessmentInfo.pmbId.pmbId == null}">
        <input type="hidden" value="add" name="action">
    </c:if>
    <div class="col-md-12">
        <div class="col-md-12">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Stretch breaks</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-6">
                            <h4>Goal Met</h4>
                            <!-- stretch breaks option -->
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <div class="radio">
                                        <label class="radio-inline">
                                            <input type="radio" name="goalMetBool" value="true" <c:if test="${assessmentInfo.pmbId.goalMetBool == true}"> checked </c:if> >Yes</label>
                                        <label class="radio-inline">
                                            <input type="radio" name="goalMetBool" value="false" <c:if test="${assessmentInfo.pmbId.goalMetBool == false}"> checked </c:if> >No</label>
                                    </div>
                                    <label>Findings</label>
                                    <textarea class="form-control" name="goalMetNotes">${assessmentInfo.pmbId.goalMetNotes}</textarea>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <h4>Educated</h4>
                            <!-- stretch breaks option -->
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <div class="radio">
                                        <label class="radio-inline">
                                            <input type="radio" name="educBool" value="true" <c:if test="${assessmentInfo.pmbId.educBool == true}"> checked </c:if> >Yes</label>
                                        <label class="radio-inline">
                                            <input type="radio" name="educBool" value="false" <c:if test="${assessmentInfo.pmbId.educBool == false}"> checked </c:if> >No</label>
                                    </div>
                                    <label>Recommendations </label>
                                    <textarea class="form-control" name="educNotes">${assessmentInfo.pmbId.educNotes}</textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="col-md-12">
        <div class="col-md-12">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Micro Breaks</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-6">
                            <h4>Before</h4>
                            <!-- micro breaks option -->
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <div class="radio">
                                        <label class="radio-inline">
                                            <input type="radio" name="microBeBool" value="true" <c:if test="${assessmentInfo.pmbId.microBeBool == true}"> checked </c:if> >Yes</label>
                                        <label class="radio-inline">
                                            <input type="radio" name="microBeBool" value="false" <c:if test="${assessmentInfo.pmbId.microBeBool == false}"> checked </c:if> >No</label>
                                    </div>
                                    <textarea class="form-control" name="microBeNotes">${assessmentInfo.pmbId.microBeNotes}</textarea>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <h4>After</h4>
                            <!-- micro breaks option -->
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <div class="radio">
                                        <label class="radio-inline">
                                            <input type="radio" name="microAfBool" value="true" <c:if test="${assessmentInfo.pmbId.microAfBool == true}"> checked </c:if> >Yes</label>
                                        <label class="radio-inline">
                                            <input type="radio" name="microAfBool" value="false" <c:if test="${assessmentInfo.pmbId.microAfBool == false}"> checked </c:if> >No</label>
                                    </div>
                                    <textarea class="form-control" name="microAfNotes">${assessmentInfo.pmbId.microAfNotes}</textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <input type="Submit" value="Save"/>
</form>
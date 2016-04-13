<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <form class="form-horizontal" role="form" method="post" action="followup">
                 <c:if test = "${assessmentInfo.followupId.followUpId != null}">
                    <input type="hidden" value="update" name="action">
                    <input type="hidden" value="${assessmentInfo.followupId.followUpId}" name="followupId">

                </c:if>
                <c:if test = "${assessmentInfo.followupId.followUpId == null}">
                    <input type="hidden" value="add" name="action">
                </c:if>
                    
              <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">Worker Comments</label>
                </div>
                <div class="col-sm-10">
                  <textarea class="form-control" placeholder="Notes" name="workerComments">${assessmentInfo.followupId.comments}</textarea>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">Identified Risks</label>
                </div>
                <div class="col-sm-10">
                  <textarea class="form-control" placeholder="Notes" name="identifiedRisks">${assessmentInfo.followupId.note}</textarea>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">Recommendations</label>
                </div>
                <div class="col-sm-10">
                  <textarea class="form-control" placeholder="Notes" name="recommendations">${assessmentInfo.followupId.recommendations}</textarea>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    
                    <input type="submit" class="btn btn-default" value="Save"></input>
                    <input type="hidden" value="followup"></input>
                    
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
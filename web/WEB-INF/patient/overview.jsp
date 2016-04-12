<%@include file="/WEB-INF/jspf/header.jspf" %>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-10">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Client Informaiton&nbsp;</h3>
                    </div>
                    <div class="panel-body">
                        <p>First Name:${client.firstName}
                            <br>
                            Last Name:${client.lastName}</p>
                    </div>
                </div>
            </div>

            <div class="col-md-2">
                <a class="btn btn-primary">Edit Client profile</a>
            </div>
            <div class = "col-md-12">
                <hr>

                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Assessments
                            <br>
                        </h3>
                    </div>
                    <div class="panel-body">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Date Create</th>
                                    <th>Date Edit</th>
                                    <th>Type</th>
                                    <th>Accessor</th>
                                    <th>Edit</th>
                                    <th>Generate</th>
                                </tr>
                            </thead>

                            <tbody><c:forEach var="assessment" varStatus="theCount" items="${client.assessmentList}">
                                    <tr>
                                        <td>${theCount.count}</td>
                                        <td><fmt:formatDate type="date" value="${assessment.createDate}" /></td>
                                        <td><fmt:formatDate type="date" value="${assessment.editDate}" /></td>
                                        <td>${assessment.type}</td>
                                        <td>${assessment.adminId.assessor}</td>
                                        <td>
                                            <form role="form" action="client" method="post">
                                                <input type="hidden" name="assessmentId" value="${assessment.assessmentId}">
                                                <input type="hidden" name="action" value="edit">
                                                <input type="submit" value="Edit" class="btn btn-info">

                                            </form>
                                        </td>
                                        <td></td>

                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <form role="form" action="client" method="post">
                    <div class = "col-md-4">

                        <div class="form-group">
                            <select class="form-control" name="type">
                                <option id="spotcheck" value="spotcheck">Spot Check</option>
                                <option id="fullevaluation" value="fullevaluation">Full Evaluation</option>
                                <option id="followup" value="followup">Follow Up</option>

                            </select>
                        </div>

                    </div>
                    <div class="col-md-4">
                        <input type="hidden" name="action" value="addAssessment">
                        <button type="submit" class="btn btn-default">Add Assessment</button>

                    </div>
                </form>
                <hr>
            </div>
        </div>
    </div>
</div>


</body>
</html>

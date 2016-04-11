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

                            <tbody><c:forEach var="assessment" items="${client.assessmentList}">
                                    <tr>
                                        <td></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <a class="btn btn-primary">Add Assessment</a>
                <hr>
            </div>
        </div>
    </div>
</div>


</body>
</html>

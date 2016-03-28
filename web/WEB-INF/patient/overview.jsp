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
                        <p>First Name:
                            <br>Last Name:</p>
                    </div>
                </div>
            </div>

            <div class="col-md-2">
                <a class="btn btn-primary">Edit Client profile</a>
            </div>
            <div class = "col-md-12">
                <hr>
                <a class="btn btn-primary">Add Assessment</a>
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
                            <tbody></tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>

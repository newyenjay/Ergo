<%@include file="/WEB-INF/jspf/header.jspf" %>
<script src="js/jquery.tablesorter.js" type="text/javascript"></script>
<script src="js/jquery.tablesorter.pager.js" type="text/javascript"></script>
<link href="css/table_sorting_theme/style.css" rel="stylesheet" type="text/css"/>
<div class="section">

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

        <div class="container">

            <div class="row">
                <div class="col-md-12">
                    <h1>Search</h1>
                </div>
                <div class="col-md-6">
                    <!-- Search company --> 
                    <div class="jumbotron">
                        <h1>Company</h1>
                        <form role="searchCompany" action="search" method="post">
                            <div class="form-group" id="locationRight">
                                <label class="control-label">Company - Location
                                    <br>
                                </label>
                                <select class="form-control" name = "company">
                                    <option value = "0">Company - Location</option>
                                    <c:forEach var="item" items="${location}">
                                        <option value="${item.companyId.companyId}">${item.companyId.name} - ${item.address}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <input type="hidden" name="action" value="searchCompany">
                            <button type="submit" class="btn btn-default" id="searchCompany">Submit</button>
                        </form>
                    </div>
                </div>

                <!-- Search client --> 
                <div class="col-md-6">
                    <div class="jumbotron">
                        <h1>Client</h1>
                        <form role="searchClient"  action="search" method="post">
                            <div class="form-group" id="locationRight">
                                <label class="control-label">Company - Location
                                    <br>
                                </label>
                                <select class="form-control" name ="company" id ="company">
                                    <option value = "0">Company - Location</option>
                                    <c:forEach var="item" items="${location}">
                                        <option value="${item.companyId.companyId}">${item.companyId.name} - ${item.address}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group" id="locationRight">
                                <label class="control-label">Name
                                    <br>
                                </label>
                                <select class="form-control" name = "client" id = "client">
                                    <option value = "0">Client Name</option>
                                    <c:forEach var="item" items="${client}">
                                        <option id="${item.companyId.companyId}" value="${item.clientId}">${item.firstName} ${item.lastName}</option>
                                    </c:forEach>                                
                                </select>
                            </div>
                            <input type="hidden" name="action" value="searchClient">
                            <button type="submit" class="btn btn-default" id="searchClient">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
            <c:if test = "${clientResult != null}">
                <div class="row">
                    <div class="col-md-12">
                        <hr>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="jumbotron">
                            <h1>${comName} </h1>
                            <table  id="myTable"  class="table table-hover table-bordered table-striped tablesorter">                
                                <thead>
                                    <tr>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                        <td></td>
                                    </tr>
                                </thead>
                                <tbody>

                                    <c:forEach var="item" items="${clientResult}">
                                        <tr>
                                            <td>${item.firstName}</td>
                                            <td>${item.lastName}</td>
                                            <td>
                                                <form action="notes" method="post">
                                                    <input type="hidden" name="noteId" value="${item.clientId}">
                                                    <input type="hidden" name="action" value="view">
                                                    <button type="submit" class="btn btn-warning"> Edit</button>
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>


                        </div>
                    </div>
                </div> 

            </c:if>
        </div>

</div>
<script type="text/javascript">
    $(document).ready(function ()
    {
        $("#myTable").tablesorter();
    }
    );

    $("#company").change(function () {
        if ($(this).data('options') === undefined) {
            /*Taking an array of all options-2 and kind of embedding it on the select1*/
            $(this).data('options', $('#client option').clone());
        }
        var id = $(this).val();
        var options = $(this).data('options').filter('[id=' + id + ']');
        $('#client').html(options);
    });
</script>
</div>
</body>
</html>

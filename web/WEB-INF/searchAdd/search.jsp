<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@include file="/WEB-INF/jspf/header.jspf" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>

<div class="section">
    <script type="text/javascript">$("#company").change(function () {
            if ($(this).data('options') == undefined) {
                /*Taking an array of all options-2 and kind of embedding it on the select1*/
                $(this).data('options', $('#client option').clone());
            }
            var id = $(this).val();
            var options = $(this).data('options').filter('[id=' + id + ']');
            $('#client').html(options);
        });</script>
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


    <div class="section">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1>Search</h1>
                </div></div>
            <div class="row">
                <div class="col-md-6">
                    <!-- Search company --> 
                    <div class="jumbotron">
                        <h1>Company</h1>
                        <form role="searchCompany" action="search" method="post">
                            <div class="form-group" id="locationRight">
                                <label class="control-label">Company - Location
                                    <br>
                                </label>
                                <select class="form-control">
                                    <option>Company - Location</option>
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
                                    <option>Company - Location</option>
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
                                    <option>Client Name</option>
                                    <c:forEach var="item" items="${client}">
                                        <option id="${item.companyId.companyId}" value="${item.companyId.companyId}">${item.firstName}</option>
                                    </c:forEach>                                
                                </select>
                            </div>


                            <input type="hidden" name="action" value="searchClient">
                            <button type="submit" class="btn btn-default" id="searchClient">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">$("#company").change(function () {
            if ($(this).data('options') == undefined) {
                /*Taking an array of all options-2 and kind of embedding it on the select1*/
                $(this).data('options', $('#client option').clone());
            }
            var id = $(this).val();
            var options = $(this).data('options').filter('[id=' + id + ']');
            $('#client').html(options);
        });</script>
</div>
</body>

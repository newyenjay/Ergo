<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@include file="/WEB-INF/jspf/header.jspf" %>

<div class="section">
    <div class="container">
    <c:if test = "${message != null}">
        <div class="alert alert-success fade in">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            ${message}
        </div>
    </c:if>

</div>     

    <div class="container">
        <div class="row">
            <c:forEach var="item" items="${company}">
                ${item.companyId}${item.name}<br>

                               
                                </c:forEach>
        </div>
        
        <div class="row">
            <div class="col-md-12">
                <h1>Add</h1>
            </div></div>
        <div class="row">
            <div class="col-md-6">
                <!-- Search company --> 
                <div class="jumbotron">
                    <h1>Company</h1>
                    <form role="searchCompany" action="add" method="post">
                        <div class="form-group" id="companyName">
                            <label class="control-label" for="companyName">Company Name</label>
                            <input class="form-control" id="compName" name="compName" placeholder="Company Name" type="text">
                        </div>
                        <div class="form-group" id="locationLeft">
                            <label class="control-label" for="locName">Location</label>
                            <input class="form-control" id="locAdd" name="locAdd" placeholder="Location Address" type="text">
                        </div>
                        <input type="hidden" name="action" value="addCompany">
                        <button type="submit" class="btn btn-default" id="addCompany">Submit</button>
                    </form>
                </div>
            </div>

            <!-- Add client --> 
            <div class="col-md-6">
                <div class="jumbotron">
                    <h1>Client</h1>
                    <form role="searchClient"  action="add" method="post">
                        <div class="form-group" id="fName">
                            <label class="control-label" for="fname">First Name</label>
                            <input class="form-control" id="fname" name="fname" placeholder="First Name" type="text">
                        </div>
                        <div class="form-group" id="lName">
                            <label class="control-label" for="lname">Last Name
                                <br>
                            </label>
                            <input class="form-control" id="lname" name="lname" placeholder="Last Name" type="text">
                        </div>
                        <div class="form-group" id="locationLeft">
                            <label class="control-label">Company - Location
                                <br>
                            </label>
                            <select class="form-control">
                                <option>Company - Location</option>
                                <c:forEach var="item" items="${comp}">
                                    <option>${item.companyName}</option>
                               
                                </c:forEach>
                                
                            </select>
                        </div>

                        <input type="hidden" name="action" value="addClient">
                        <button type="submit" class="btn btn-default" id="addClient">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
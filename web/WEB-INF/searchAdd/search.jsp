<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@include file="/WEB-INF/jspf/header.jspf" %>

<form action="search" method="post" roll="form">

    <div class="section">
        <div class="container">
            <div class="row">   
                <div class="jumbotron">
                    <h1>Search</h1>
                    <hr>

                    <!-- client search --> 

                    <div class="form-group" id="searchClient">
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputEmail3" placeholder="Client">
                            <br>
                        </div>
                        <div class="col-sm-2"> 
                            <a class="btn btn-primary btn-medium" id="submit">Submit</a>
                        </div>

                        <!-- client search --> 
                        <br>
                    </div>

                    <div class="form-group">
                        <!-- Company search --> 

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputEmail3" placeholder="Company">
                            <br>
                        </div>
                        <div class="col-sm-2"> 
                            <a class="btn btn-primary btn-medium" id="submit">Submit</a>
                        </div>
                        <!-- Company search --> 
                        <br>
                    </div>

                    <div class="form-group" id="searchLocation">
                        <!-- search Location --> 
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputEmail3" placeholder="Location">
                            <br>
                        </div>
                        <div class="col-sm-2"> 
                            <a class="btn btn-primary btn-medium" id="submit">Submit</a>

                        </div>
                        <br>

                        <!-- search Location --> 

                    </div>
                    <br> 
                    <br>
                    <br>
                </div>
            </div>
        </div>
    </div>



</form>
<%@include file="/WEB-INF/jspf/header.jspf" %>

<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="jumbotron">
                    <h1>Search</h1>
                    <hr>

                    <form class="form-horizontal" role="form" id="searchCompany">
                        <div class="form-group" id="searchClient">
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="inputEmail3" placeholder="Client">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="inputEmail3" placeholder="Company">
                            </div>
                        </div>
                        <div class="form-group" id="searchLocation">
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="inputEmail3" placeholder="Location">
                            </div>
                        </div>
                        <a class="btn btn-primary btn-medium" id="submit">Submit</a>
                    </form>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                </div>
            </div>
            <div class="col-md-6">
                <div class="jumbotron">
                    <h1>Add</h1>
                    <hr>
                    <form role="form">
                        <h3>Client</h3>
                        <div class="form-group" id="clientAdd">
                            <input class="form-control" id="exampleInputEmail1" placeholder="Name"
                                   type="email">
                            <input class="form-control" type="date" placeholder="Assessment date" />

                            <input class="form-control" id="exampleInputPassword1" placeholder="Email"
                                   type="email">
                            <br>
                            <a class="btn btn-primary btn-medium" id="submit">Submit</a>
                            <br>
                        </div>
                        
                        
                        <div class="form-group" id="location">
                            <h3>Location</h3>
                            <input class="form-control" type="text" placeholder="Enter address">
                            <br> <a class="btn btn-primary btn-medium" id="submit">Submit</a>

                        </div>
                    </form>
                </div
            </div>
        </div>
    </div>

    <script src="../../js/datepicker.js" type="text/javascript"></script>
</body>
</html>

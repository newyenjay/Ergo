<%@include file="/WEB-INF/jspf/header.jspf" %>

<div class="section">
    <div class="container">
        <div class="row">
         
            <div class="col-md-12">
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

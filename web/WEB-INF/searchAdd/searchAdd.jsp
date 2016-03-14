<%@include file="/WEB-INF/jspf/header.jspf" %>

<div class="section">
    <div class="container">
        <div class="row">
         
            <div class="col-md-12">
                <div class="jumbotron">
                    <h1>Add</h1>
                    <hr>
                    <form role="form" action="main" method="post">
                        <h3>Client</h3>
                        <div class="form-group" id="clientAdd">
                            <input class="form-control" id="firstname" name="firstname" placeholder="First Name" value="${firstname}">
                            <input class="form-control" id="lastname" name="lastname" placeholder="Last Name">
                            <input class="form-control" type="date" id="date" name="date" placeholder="Assessment date"/>
                            <input class="form-control" id="email" name="email" placeholder="Email" type="email">
                            <input type="hidden" name="action" value="addClient">
                            <br>
                            <input class="btn btn-primary btn-medium" type="submit" value="Submit"/>
                            <br>
                        </div>
                    </form>
                    <form role="form" action="main" method="post">
                        
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

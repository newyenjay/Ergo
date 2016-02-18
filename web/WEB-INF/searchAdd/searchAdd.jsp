<%@include file="/WEB-INF/header.jspf" %>

      <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <div class="jumbotron">
              <h1>Search</h1>
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
            </div>
          </div>
          <div class="col-md-6">
            <div class="jumbotron">
              <h1>Add</h1>
              <form class="form-horizontal" role="form">
                <div class="form-group" id="addClient">
                  <div class="col-sm-10">
                    <input type="email" class="form-control" id="inputEmail3" placeholder="Client">
                  </div>
                </div>
                <div class="form-group" id="addCompany">
                  <div class="col-sm-10">
                    <input type="email" class="form-control" id="inputEmail3" placeholder="Company">
                  </div>
                </div>
                <div class="form-group" id="addLocation">
                  <div class="col-sm-10">
                    <input type="email" class="form-control" id="inputEmail3" placeholder="Location">
                  </div>
                </div>
                <a class="btn btn-primary btn-medium" id="dubmit">Submit</a>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    </body>
</html>

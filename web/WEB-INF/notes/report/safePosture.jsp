<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-8">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title">Movement</h3>
              </div>
              <div class="panel-body">
                <form class="form-horizontal" role="form">
                  <div class="form-group">
                    <div class="col-sm-2">
                      <label class="control-label">
                        <br>Stable base</label>
                    </div>
                    <div class="col-sm-10">
                      <div class="radio">
                        <label class="radio-inline">
                          <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">Yes</label>
                        <label class="radio-inline">
                          <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2" checked="">No</label>
                      </div>
                      <textarea class="form-control"></textarea>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-2">
                      <label class="control-label">
                        <br>Shoulders
                        <br>anchored</label>
                    </div>
                    <div class="col-sm-10">
                      <div class="radio">
                        <label class="radio-inline">
                          <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">Yes</label>
                        <label class="radio-inline">
                          <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2" checked="">No</label>
                      </div>
                      <textarea class="form-control"></textarea>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-2">
                      <label class="control-label">
                        <br>Arms at sides</label>
                    </div>
                    <div class="col-sm-10">
                      <div class="radio">
                        <label class="radio-inline">
                          <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">Yes</label>
                        <label class="radio-inline">
                          <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2" checked="">No</label>
                      </div>
                      <textarea class="form-control"></textarea>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
          <div class="col-md-4">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title">Notes</h3>
              </div>
              <div class="panel-body">
                <label class="control-label">General Notes</label>
                <textarea class="form-control" rows="10" cols="45" placeholder="Enter notes"></textarea>
                <br>
                <br>
                <button type="button" class="btn btn-success">Success</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
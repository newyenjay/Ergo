<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div class="col-md-12">
            <div class="section">
              <div class="container">
                <div class="row">
                  <div class="col-md-6">
                    <div class="panel panel-primary">
                      <div class="panel-heading">
                        <h3 class="panel-title">Break Periods</h3>
                      </div>
                      <div class="panel-body">
                        <form role="form">
                          <div class="form-group">
                            <label>Stretch Break</label>
                            <div class="radio">
                              <label class="radio-inline">
                                <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">Yes</label>
                              <label class="radio-inline">
                                <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2" checked="">No</label>
                            </div>
                          </div>
                          <div class="form-group">
                            <label>Micro Break</label>
                            <div class="radio">
                              <label class="radio-inline">
                                <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">Yes</label>
                              <label class="radio-inline">
                                <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2" checked="">No</label>
                            </div>
                          </div>
                        </form>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="panel panel-primary">
                      <div class="panel-heading">
                        <h3 class="panel-title">Notes</h3>
                      </div>
                      <div class="panel-body">
                        <textarea placeholder="Enter Notes" class="form-control"></textarea>
                        <br>
                      </div>
                    </div>
                        <br><button type="button" class="btn btn-primary">Save</button>

                  </div>
                </div>
              </div>
            </div>
          </div>
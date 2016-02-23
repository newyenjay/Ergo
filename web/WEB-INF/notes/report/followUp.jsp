<div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <form class="form-horizontal" role="form">
              <div class="form-group" id="workerComments">
                <div class="col-sm-2">
                  <label class="control-label">Worker Comments</label>
                </div>
                <div class="col-sm-10">
                  <textarea class="form-control" placeholder="Notes"></textarea>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">Identified Risks</label>
                </div>
                <div class="col-sm-10">
                  <textarea class="form-control" placeholder="Notes"></textarea>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">Recommendations</label>
                </div>
                <div class="col-sm-10">
                  <textarea class="form-control" placeholder="Notes"></textarea>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <form method="post" action="assessment">
                  <button type="submit" class="btn btn-default">Save</button>
                  <input type="hidden" name="action" value="followUp"/>
                    </form>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
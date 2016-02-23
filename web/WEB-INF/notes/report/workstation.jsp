<script type="text/javascript">
    $(function () {
        $("#cbchair").click(function () {
            if ($(this).is(":checked")) {
                $("#dvchair").show();
            } else {
                $("#dvchair").hide();
            }
        });
        $("#cbmonitor").click(function () {
            if ($(this).is(":checked")) {
                $("#dvmonitor").show();
            } else {
                $("#dvmonitor").hide();
            }
        });
        $("#cbdesk").click(function () {
            if ($(this).is(":checked")) {
                $("#dvdesk").show();
            } else {
                $("#dvdesk").hide();
            }
        });
        $("#cbaccessories").click(function () {
            if ($(this).is(":checked")) {
                $("#dvaccessories").show();
            } else {
                $("#dvaccessories").hide();
            }
        });
        $("#cbinputDevice").click(function () {
            if ($(this).is(":checked")) {
                $("#dvinputDevice").show();
            } else {
                $("#dvinputDevice").hide();
            }
        });
    });
</script>
<div class="section">
      <div class="container">
        <div class="row"><div class="col-md-12"><h1>Prepare Work Area and Equipment</h1></div></div><div class="row">
          <div class="col-md-12">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title">Work Area</h3>
              </div>
              <div class="panel-body">
                <form role="form">
                  <table class="table">
                    <thead>
                      <tr>
                        <th></th>
                        <th>Ccurrent</th>
                        <th>Recommend</th>
                        <th>Sit-Stand</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>Elbow</td>
                        <td>
                          <input class="form-control" type="number">
                        </td>
                        <td>
                          <input class="form-control" type="number">
                        </td>
                        <td>
                          <input class="form-control" type="number">
                        </td>
                      </tr>
                      <tr>
                        <td>Eye Height</td>
                        <td>
                          <input class="form-control" type="number">
                        </td>
                        <td>
                          <input class="form-control" type="number">
                        </td>
                        <td>
                          <input class="form-control" type="number">
                        </td>
                      </tr>
                      <tr>
                        <td>Monitor</td>
                        <td>
                          <input class="form-control" type="number">
                        </td>
                        <td>
                          <input class="form-control" type="number">
                        </td>
                        <td>
                          <input class="form-control" type="number">
                        </td>
                      </tr>
                      <tr>
                        <td>Desk</td>
                        <td>
                          <input class="form-control" type="number">
                        </td>
                        <td>
                          <input class="form-control" type="number">
                        </td>
                        <td>
                          <input class="form-control" type="number">
                        </td>
                      </tr>
                      <tr>
                        <td>Keyboard</td>
                        <td>
                          <input class="form-control" type="number">
                        </td>
                        <td>
                          <input class="form-control" type="number">
                        </td>
                        <td>
                          <input class="form-control" type="number">
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </form>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-6">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title">Chair</h3>
              </div>
              <div class="panel-body">
                <form role="form">
                  <div class="form-group">
                    <div class="checkbox">
                      <label>
                        <input type="checkbox" id="cbchair">Check me out</label>
                    </div>
                  </div>
                  <div class="form-group" style="display: none" id="dvchair">
                    <label class="control-label">Notes</label>
                    <textarea class="form-control"></textarea>
                  </div>
                </form>
              </div>
            </div>
          </div>
          <div class="col-md-6">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title">Monitors</h3>
              </div>
              <div class="panel-body">
                <form role="form">
                  <div class="form-group">
                    <div class="checkbox">
                      <label>
                        <input type="checkbox" id="cbmonitor">Check me out</label>
                    </div>
                  </div>
                  <div class="form-group" id="dvmonitor" style="display: none">
                    <label class="control-label">Notes</label>
                    <textarea class="form-control"></textarea>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-6">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title">Input Devices</h3>
              </div>
              <div class="panel-body">
                <form role="form">
                  <div class="form-group">
                    <div class="checkbox">
                      <label>
                        <input type="checkbox" id="cbinputDevice">Check me out</label>
                    </div>
                  </div>
                  <div class="form-group" id="dvinputDevice" style="display: none">
                    <label class="control-label">Notes</label>
                    <textarea class="form-control"></textarea>
                  </div>
                </form>
              </div>
            </div>
          </div>
          <div class="col-md-6">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title">Desk</h3>
              </div>
              <div class="panel-body">
                <form role="form">
                  <div class="form-group">
                    <div class="checkbox">
                      <label>
                        <input type="checkbox" id="cbdesk">Check me out</label>
                    </div>
                  </div>
                  <div class="form-group" id="dvdesk" style="display: none">
                    <label class="control-label">Notes</label>
                    <textarea class="form-control"></textarea>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-6">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title">Accessories</h3>
              </div>
              <div class="panel-body">
                <form role="form">
                  <div class="form-group">
                    <div class="checkbox">
                      <label>
                        <input type="checkbox" id="cbaccessories">Check me out</label>
                    </div>
                  </div>
                  <div class="form-group" id="dvaccessories" style="display: none">
                    <label class="control-label">Notes</label>
                    <textarea class="form-control"></textarea>
                  </div>
                </form>
              </div>
            </div>
          </div>
            <div class="row">
            <div class="col-md-6">
                <form method="post" action="assesment">
                    <br><button type="button" class="btn btn-primary">Save</button>
                    <input type="hidden" name="action" value="workstation"/>
                </form>
            </div>
        </div>
        </div>
        
      </div>
    </div>
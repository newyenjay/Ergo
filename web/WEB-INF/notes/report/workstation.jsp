<script type="text/javascript">

    $(function () {
        var countM = $('#mbody').children('tr').length + 1;
        var selector = '<select class="form-control" id="monType" name="monType' + countM + '">' + '<option value="LCD">LCD</option>' + '<option value="Laptop">Laptop</option>' + '</select>';
        var monCurr = '<input class="form-control" type="number" name="monCurr' + countM + '" id="monCurr" placeholder="in">';
        var monRec = '<input class="form-control" type="number" name="monRec' + countM + '" id="monRec" placeholder="in">';
        var monSit = '<input class="form-control" type="number" name="monSit' + countM + '" id="monSit" placeholder="in">';

        $('#addMonitor').click(function () {
            var count = $('#mbody').children('tr').length + 1;
            $('#monitor tbody').append('<tr><td>' + count + '</td><td>' + selector + '</td><td>' + monCurr + '</td><td>' + monRec + '</td><td>' + monSit + '</td></tr>');
            $('input[name=monitorRow]').val(count);
    });

        var countR = $('#sbody').children('tr').length + 1;

        var srRec = '<input class="form-control" type="text" name="srRec' + countR + '" id="srRec" >';
        var srAcc = '<input class="form-control" type="text" name="srAcc' + countR + '" id="srAcc" >';
        var srDate = '<input class="form-control" type="date" name="srDate' + countR + '" id="srDate" >';

        $('#addsiteRecommand').click(function () {
            var count = $('#sbody').children('tr').length + 1;
            $('#siteRecommand tbody').append('<tr><td>' + count + '</td><td>' + srRec + '</td><td>' + srAcc + '</td><td>' + srDate + '</td></tr>');
    $('input[name=siteRow]').val(count);    
    });

    });
</script>     
<form role="form" action="workarea" method="post">
    <div class="row">
        <div class="col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Work Area</h3>
                </div>
                <div class="panel-body">

                    <table class="table">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Current</th>
                                <th>Recommend</th>
                                <th>Sit-Stand</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Elbow</td>
                                <td>
                                    <input class="form-control" type="number" name="elbowCurr">
                                </td>
                                <td>
                                    <input class="form-control" type="number" name="elbowRec">
                                </td>
                                <td>
                                    <input class="form-control" type="number" name="elbowSit">
                                </td>
                            </tr>
                            <tr>
                                <td>Eye Height</td>
                                <td>
                                    <input class="form-control" type="number" name="eyeCurr">
                                </td>
                                <td>
                                    <input class="form-control" type="number" name="eyeRec">
                                </td>
                                <td>
                                    <input class="form-control" type="number" name="eyeSit">
                                </td>
                            </tr>
                            <tr>
                                <td>Desk</td>
                                <td>
                                    <input class="form-control" type="number" name="deskCurr">
                                </td>
                                <td>
                                    <input class="form-control" type="number" name="deskRec">
                                </td>
                                <td>
                                    <input class="form-control" type="number" name="deskSit">
                                </td>
                            </tr>
                            <tr>
                                <td>Keyboard</td>
                                <td>
                                    <input class="form-control" type="number" name="keyboardCurr">
                                </td>
                                <td>
                                    <input class="form-control" type="number" name="keyboardRec">
                                </td>
                                <td>
                                    <input class="form-control" type="number" name="keyboardSit">
                                </td>
                            </tr>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Monitor</h3>
                </div>
                <div class="panel-body">
                    <table class="table" id="monitor">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>Type</th>
                                <th>Current</th>
                                <th>Recommend</th>
                                <th>Sit-Stand</th>
                            </tr>
                        </thead>
                        <tbody id="mbody"></tbody>
                    </table>
                    <input name="monitorRow" type="hidden" value="0">
                    <a class="btn btn-primary" id="addMonitor">Add</a>

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
                    <div class="form-group" id="dvchair">
                        <label class="control-label">Notes</label>
                        <textarea class="form-control" name="chairNote"></textarea>
                    </div>

                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Monitors</h3>
                </div>
                <div class="panel-body">
                    <div class="form-group" id="dvmonitor" >
                        <label class="control-label">Notes</label>
                        <textarea class="form-control" name="monitorNote"></textarea>
                    </div>

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

                    <div class="form-group" id="dvinputDevice" >
                        <label class="control-label">Notes</label>
                        <textarea class="form-control" name="inputNote"></textarea>
                    </div>

                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Desk</h3>
                </div>
                <div class="panel-body">

                    <div class="form-group" id="dvdesk" >
                        <label class="control-label">Notes</label>
                        <textarea class="form-control" name="deskNote"></textarea>
                    </div>

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
                    <div class="form-group" id="dvaccessories" >
                        <label class="control-label">Notes</label>
                        <textarea class="form-control" name="accessNote"></textarea>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Site Recommendation</h3>
                </div>
                <div class="panel-body">
                    <table class="table" id="siteRecommand">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>Recommendation</th>
                                <th>Accessory type</th>
                                <th>Complete Date</th>
                            </tr>
                        </thead>
                        <tbody id="sbody"></tbody>
                    </table>
                    <a class="btn btn-primary" id="addsiteRecommand">Add</a>
                    <input name="siteRow" type="hidden" value="0">
                </div>
            </div>
        </div>
    </div>
    <button type="submit" class="btn btn-default" id="searchCompany">Submit</button>
</form>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<script type="text/javascript">

    $(function () {
        var countM = $('#mbody').children('tr').length + 1;
        var selector = '<select class="form-control" id="monType" name="monType' + countM + '">' + '<option value="LCD">LCD</option>' + '<option value="Laptop">Laptop</option>' + '</select>';
        var monCurr = '<input class="form-control" type="number" name="monCurr' + countM + '" id="monCurr" placeholder="in">';
        var monRec = '<input class="form-control" type="number" name="monRec' + countM + '" id="monRec" placeholder="in">';
        var monSit = '<input class="form-control" type="number" name="monSit' + countM + '" id="monSit" placeholder="in">';
        var monitorId = '<input class="form-control" type="hidden" name="monitorId' + countM + '"  value ="0" >';
        $('#addMonitor').click(function () {
            var count = $('#mbody').children('tr').length + 1;
            $('#monitor tbody').append('<tr><td>' + count + monitorId + '</td><td>' + selector + '</td><td>' + monCurr + '</td><td>' + monRec + '</td><td>' + monSit + '</td></tr>');
            $('input[name=monitorRow]').val(count);
        });

        var countR = $('#sbody').children('tr').length + 1;

        var srRec = '<input class="form-control" type="text" name="srRec' + countR + '" id="srRec" >';
        var srAcc = '<input class="form-control" type="text" name="srAcc' + countR + '" id="srAcc" >';
        var srDate = '<input class="form-control" type="date" name="srDate' + countR + '" id="srDate" >';
        var srId = '<input class="form-control" type="hidden" name="siteRecId' + countR + '"  value ="0" >';

        $('#addsiteRecommand').click(function () {
            var count = $('#sbody').children('tr').length + 1;
            $('#siteRecommand tbody').append('<tr><td>' + count + srId + '</td><td>' + srRec + '</td><td>' + srAcc + '</td><td>' + srDate + '</td></tr>');
            $('input[name=siteRow]').val(count);
        });

    });
</script>     
<form role="form" action="workarea" method="post">

    <c:if test = "${assessmentInfo.pwaId.pwaeId != null}">
        <input type="hidden" value="update" name="action">
        <input type="hidden" value="${assessmentInfo.pwaId.pwaeId}" name="pwaId">

    </c:if>
    <c:if test = "${assessmentInfo.pwaId.pwaeId == null}">
        <input type="hidden" value="add" name="action">
    </c:if>
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
                                    <input class="form-control" type="number" name="elbowCurr" value="${assessmentInfo.pwaId.elbowCurr}">
                                </td>
                                <td>
                                    <input class="form-control" type="number" name="elbowRec" value="${assessmentInfo.pwaId.elbowRec}">
                                </td>
                                <td>
                                    <input class="form-control" type="number" name="elbowSit" value="${assessmentInfo.pwaId.elbowSit}">
                                </td>
                            </tr>
                            <tr>
                                <td>Eye Height</td>
                                <td>
                                    <input class="form-control" type="number" name="eyeCurr" value="${assessmentInfo.pwaId.eyeCurr}">
                                </td>
                                <td>
                                    <input class="form-control" type="number" name="eyeRec" value="${assessmentInfo.pwaId.eyeRec}">
                                </td>
                                <td>
                                    <input class="form-control" type="number" name="eyeSit" value="${assessmentInfo.pwaId.eyeSit}">
                                </td>
                            </tr>
                            <tr>
                                <td>Desk</td>
                                <td>
                                    <input class="form-control" type="number" name="deskCurr" value="${assessmentInfo.pwaId.deskCurr}">
                                </td>
                                <td>
                                    <input class="form-control" type="number" name="deskRec" value="${assessmentInfo.pwaId.deskRec}">
                                </td>
                                <td>
                                    <input class="form-control" type="number" name="deskSit" value="${assessmentInfo.pwaId.deskSit}">
                                </td>
                            </tr>
                            <tr>
                                <td>Keyboard</td>
                                <td>
                                    <input class="form-control" type="number" name="keyboardCurr" value="${assessmentInfo.pwaId.keyboardCurr}">
                                </td>
                                <td>
                                    <input class="form-control" type="number" name="keyboardRec" value="${assessmentInfo.pwaId.keyboardRec}">
                                </td>
                                <td>
                                    <input class="form-control" type="number" name="keyboardSit" value="${assessmentInfo.pwaId.keyboardSit}">
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
                        <tbody id="mbody">
                            <c:set var="rowCount" value="0"/>
                            <c:forEach var="monitors" varStatus="theCount" items="${assessmentInfo.pwaId.monitorList}">
                                <tr>
                                    <td>${theCount.count}
                                        <input type="hidden" name="monitorId${theCount.count}" value="${monitors.monitorId}">
                                        <c:set var="rowCount" value="${theCount.count}"/>
                                    </td>
                                    <td><select class="form-control" id="monType" name="monType${theCount.count}">
                                            <option value="LCD" <c:if test="${monitors.type == 'LCD'}"> selected="selected" </c:if> >LCD</option>
                                            <option value="Laptop" <c:if test="${monitors.type == 'Laptop'}"> selected="selected" </c:if> >Laptop</option>
                                            </select>
                                        </td>
                                        <td><input class="form-control" type="number" name="monCurr${theCount.count}" id="monCurr" placeholder="in" value ="${monitors.current}"></td>
                                    <td><input class="form-control" type="number" name="monRec${theCount.count}" id="monRec" placeholder="in" value ="${monitors.recommand}"></td>
                                    <td><input class="form-control" type="number" name="monSit${theCount.count}" id="monSit" placeholder="in" value ="${monitors.sitStand}"></td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                    <c:if test="${rowCount != 0}">
                        <input name="monitorRow" type="hidden" value="${rowCount}">
                    </c:if>
                    <c:if test="${rowCount == 0}">
                        <input name="monitorRow" type="hidden" value="0">
                    </c:if>
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
                        <textarea class="form-control" name="chairNote">${assessmentInfo.pwaId.chairNote}</textarea>
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
                        <textarea class="form-control" name="monitorNote">${assessmentInfo.pwaId.monitorNote}</textarea>
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
                        <textarea class="form-control" name="inputNote">${assessmentInfo.pwaId.inputNote}</textarea>
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
                        <textarea class="form-control" name="deskNote">${assessmentInfo.pwaId.deskNote}</textarea>
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
                        <textarea class="form-control" name="accessNote">${assessmentInfo.pwaId.accessoriesNote}</textarea>
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
                        <tbody id="sbody">

                            <c:set var="rowCountSite" value="0"/>
                            <c:forEach var="siteRec" varStatus="theCountSite" items="${assessmentInfo.pwaId.siteRecList}">
                                <tr>
                                    <td>
                                        ${theCountSite.count}
                                        <input type="hidden" name="siteRecId${theCountSite.count}" value="${siteRec.siteRecId}">
                                        <c:set var="rowCountSite" value="${theCountSite.count}"/>
                                    </td>
                                    <td>
                                        <input class="form-control" type="text" name="srRec${theCountSite.count}" id="srRec" value="${siteRec.recommand}">
                                    </td>
                                    <td>
                                        <input class="form-control" type="text" name="srAcc${theCountSite.count}" id="srAcc" value="${siteRec.accessoryType}">

                                    </td>
                                    <td>

                                        <fmt:formatDate type="date" value="${siteRec.completeDate}" />
                                        <input class="form-control" type="hidden" name="srDate${theCountSite.count}">
                                    </td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <c:if test="${rowCountSite != 0}">
                        <input name="siteRow" type="hidden" value="${rowCountSite}">
                    </c:if>
                    <c:if test="${rowCountSite == 0}">
                        <input name="siteRow" type="hidden" value="0">
                    </c:if>
                    <a class="btn btn-primary" id="addsiteRecommand">Add</a>

                </div>
            </div>
        </div>
    </div>
    <button type="submit" class="btn btn-default" id="searchCompany">Submit</button>
</form>
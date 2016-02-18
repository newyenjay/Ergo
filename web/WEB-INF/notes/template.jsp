
<%@include file="/WEB-INF/header.jspf" %>

            <div class="content">
                <div class="container"> 
                    <br>
                    <br>

                    <ul class="nav nav-pills" id="myTab" style="display: inline">
                        <li class="active"><a data-toggle="tab" href="#admin">Admin</a></li>
                        <li><a data-toggle="tab" href="#pmb">Prepare/Maintain Body</a></li>
                        <li><a data-toggle="tab" href="#spm">Safe Postures & Movements</a></li>
                        <li><a data-toggle="tab" href="#pwae">Prepare Work Area & Equipment</a></li>
                        <li><a data-toggle="tab" href="#discomfort">Discomfort</a></li>
                        <li><a data-toggle="tab" href="#fup">Follow-Up</a></li>
                    </ul>
                    <div class="tab-content" id="myTabContent" style="position: relative;">
                        <div id="admin" class="tab-pane fade in active">
                            <h3 class="page-header">Administration Page</h3>
                            <!-- call admininfo.jsp file -->
                        <c:import url="report/admininfo.jsp"></c:import>
                        </div>
                        <div id="pmb" class="tab-pane fade">
                            <h3 class="page-header">Prepare/Maintain Body</h3>

                        <c:import url="report/maintainBody.jsp"></c:import>
                        </div>
                        <div id="spm" class="tab-pane fade">
                            <h3 class="page-header">Safe Postures & Movements</h3>
                        <c:import url="report/safePosture.jsp"></c:import>


                        </div>
                        <div id="pwae" class="tab-pane fade">
                            <h3 class="page-header">Prepare Work Area & Equipment</h3>
                           <c:import url="workstation.jsp"></c:import>
                        </div>
                        <div id="discomfort" class="tab-pane fade">
                            <h3 class="page-header">Discomfort</h3>
                             <c:import url="report/discomfort.jsp"></c:import>

                        </div>

                        <div id="fup" class="tab-pane fade">
                            <h3 class="page-header">Follow-Up</h3>

                                                    <c:import url="report/followUp.jsp"></c:import>

                        </div>

                    </div>


                </div>

            </div> <!-- content --> 
        </form>
                <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>

    </body>
</html>

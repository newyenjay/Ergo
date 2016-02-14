
<%@include file="/WEB-INF/nav/header.jspf" %>
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
                            <h3>Administration Page</h3>
                            <!-- call admininfo.jsp file -->
                        <c:import url="report/admininfo.jsp"></c:import>
                        

                        </div>
                        <div id="pmb" class="tab-pane fade">
                            <h3>Prepare/Maintain Body</h3>
                            <p>Prepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain BodyPrepare/Maintain Body</p>
                        </div>
                        <div id="spm" class="tab-pane fade">
                            <h3>Safe Postures & Movements</h3>
                            <p>WInteger convallis, nulla in sollicitudin placerat, ligula enim auctor lectus, in mollis diam dolor at lorem. Sed bibendum nibh sit amet dictum feugiat. Vivamus arcu sem, cursus a feugiat ut, iaculis at erat. Donec vehicula at ligula vitae venenatis. Sed nunc nulla, vehicula non porttitor in, pharetra et dolor. Fusce nec velit velit. Pellentesque consectetur eros.</p>
                        </div>
                        <div id="pwae" class="tab-pane fade">
                            <h3>Prepare Work Area & Equipment</h3>
                            <p>Donec vel placerat quam, ut euismod risus. Sed a mi suscipit, elementum sem a, hendrerit velit. Donec at erat magna. Sed dignissim orci nec eleifend egestas. Donec eget mi consequat massa vestibulum laoreet. Mauris et ultrices nulla, malesuada volutpat ante. Fusce ut orci lorem. Donec molestie libero in tempus imperdiet. Cum sociis natoque penatibus et magnis dis parturient.</p>
                        </div>
                        <div id="discomfort" class="tab-pane fade">
                            <h3>Discomfort</h3>
                             <c:import url="report/discomfort.jsp"></c:import>

                        </div>

                        <div id="fup" class="tab-pane fade">
                            <h3>Follow-Up</h3>
                            <p>Donec vel placerat quam, ut euismod risus. Sed a mi suscipit, elementum sem a, hendrerit velit. Donec at erat magna. Sed dignissim orci nec eleifend egestas. Donec eget mi consequat massa vestibulum laoreet. Mauris et ultrices nulla, malesuada volutpat ante. Fusce ut orci lorem. Donec molestie libero in tempus imperdiet. Cum sociis natoque penatibus et magnis dis parturient.</p>
                        </div>

                    </div>


                </div>

            </div> <!-- content --> 
        </form>
    </body>
</html>

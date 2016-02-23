<%@include file="/WEB-INF/jspf/header.jspf" %>

        <div class="container">
            <c:if test = "${message != null}">
                <div class="alert alert-success">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Success!</strong> ${message}
                </div>
            </c:if>
        </div>     

        <div id="section1" class="container-fluid">
            <h1>Manage Users</h1>
            <h2>Users</h2>
            <div id="main">
                <div id="users">
                    <table class="table table-striped">
                        <tr>
                            <th>Username</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email</th>
                            <th>Password</th>
                            <th>Delete</th>
                            <th>Edit</th>
                        </tr>

                        <c:forEach var="item" items="${users}">
                            <tr>
                                <td><c:out value="${item.username}" /></td>
                                <td>${item.firstName}</td>
                                <td>${item.lastName}</td>
                                <td>${item.email}</td>
                                <td>${item.password}</td>

                           

                                <c:if test="${currentUser.username != item.username}">

                                    <td>
                                        <form action="admin" method="post">
                                            <input type="hidden" name="username" value="${item.username}">
                                            <input type="hidden" name="action" value="delete">
                                            <input type="submit" value="Delete"class="btn btn-danger">
                                        </form>
                                    </td>


                                    <td>

                                        <form action="admin" method="post">
                                            <input type="hidden" name="username" value="${item.username}">
                                            <input type="hidden" name="action" value="view">
                                            <input type="submit" value="Edit" class="btn btn-info">

                                        </form>
                                    </td>
                                </c:if> 


                                <c:if test="${currentUser.username == item.username}"> 
                                    <th colspan="2" > Cannot delete yourself </th>
                                    </c:if>

                                

                            </tr>

                        </c:forEach>

                    </table>
                    <!--${message} -->





                </div>
            </div>


            <div id="addUser" class="container-fluid">


                <c:if test="${selectedUser == null}">
                    <div>
                        <div class="container-fluid" style="background-color:#1E88E5;color:#fff;height:200px;"
                             <center><h1>Add User </h1></center>
                        </div>
                        <form method="post" action="admin" form class="form-horizontal" role="form">

                            <div class="container">
                                <form class="form-inline" role="form">
                                    <div class="form-group">
                                        <label for=" name">Username:</label>
                                        <input type="text" name="username" class="form-control" id="username" placeholder="Enter username" />
                                    </div>
                                    <div class="form-group">
                                        <label for="name">First name:</label>
                                        <input type="text" name="firstname" class="form-control" id="firstname" placeholder="Enter first name" />
                                    </div>

                                    <div class="form-group">
                                        <label for="name">Last name:</label>
                                        <input type="text" name="lastname" class="form-control" id="lastname" placeholder="Enter last name" />
                                    </div>

                                    <div class="form-group">
                                        <label for="pwd">Password:</label>
                                        <input type="password" name="userPassword"  class="form-control" placeholder="Enter password" />
                                    </div>

                                    <div class="form-group">
                                        <label for="email">Email:</label>
                                        <input type="email" name="email"  class="form-control"placeholder="Enter email" />
                                    </div>

                                    <input type="hidden" name="action" value="add">

                                    <button type="submit" value="Save" class="btn btn-success">Submit</button>

                                </form>
                            </div>


                        </c:if>

                        <c:if test="${selectedUser != null}">
                            <div id="formBox" class="leftSideBox">
                                <h2>Edit ${selectedUser.userName}</h2>
                                <form method="post" action="admin">
                                    <div class="fieldset">
                                        <label for="username">Username:</label>
                                        <input type="text" name="username" id="username" value="${selectedUser.userName}" readonly="readonly"/>
                                    </div>
                                    <div class="fieldset">
                                        <label for="username">First Name:</label>
                                        <input type="text" name="firstname" id="firstname" value="${selectedUser.firstName}" />
                                    </div>
                                    <div class="fieldset">
                                        <label for="username">Last Name:</label>
                                        <input type="text" name="lastname" id="lastname" value="${selectedUser.lastName}" />
                                    </div>
                                    <div class="fieldset">
                                        <label for="password">Password:</label>
                                        <input type="password" name="userPassword" id="password" value="${selectedUser.userPassword}" />
                                    </div>
                                    <div class="fieldset">
                                        <label for="access">Email:</label>
                                        <input type="text" name="email" id="email" value="${selectedUser.email}" />
                                    </div>
                                    <div class="fieldset">
                                        <input type="hidden" name="action" value="edit">
                                        <input type="submit" value="Save"/>
                                    </div>
                                </form>
                            </div>
                        </c:if>
                </div>
            </body>
</html>
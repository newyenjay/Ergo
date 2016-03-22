<%@include file="/WEB-INF/jspf/header.jspf" %>




<div class="container">
    <c:if test = "${message != null}">
        <div class="alert alert-success fade in">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            ${message}
        </div>
    </c:if>

</div>     

<div class="container">
    <div class="jumbotron">
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
                                            <input type="submit" value="Edit" class="btn btn-info"
                                                   data-toggle="modal" data-target="#editUser">

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
            <br>
        </div>
        <br>





        <!-- Button trigger modal -->
        <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#addUser">
            Add a user
        </button>

        <!-- Modal -->
        <div class="modal fade" id="addUser" tabindex="-1" role="dialog" 
             aria-labelledby="addUser" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <button type="button" class="close" 
                                data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title" id="addUser">
                            Add a user
                        </h4>
                    </div>


                    <!-- Modal Body -->
                    <div class="modal-body">

                        <form method="post" action="admin" role="form" >
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
                                <input type="password" name="password"  class="form-control" placeholder="Enter password" />
                            </div>

                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" name="email"  class="form-control"placeholder="Enter email" />
                            </div>




                    </div>

                    <!-- Modal Footer -->
                    <div class="modal-footer">
                        <input type="hidden" name="action" value="add">

                        <button type="submit" value="Save" class="btn btn-success">Submit</button>

                    </div>
                </div>
                </form>

            </div>
        </div>


        <!-- Edit a user --> 

        <c:if test="${selectedUser != null}">
            <br>
            <div class="container">
                <div class="jumbotron">
                    <hr>

                    <div class="container-fluid"> 
                        <div id="formBox" class="leftSideBox">
                            <h2>Edit ${selectedUser.username}'s account</h2>
                            <form method="post" action="admin">
                                <div class="form-group">
                                    <label for="username">Username:</label>
                                    <input type="text" name="username" id="username" class="form-control" value="${selectedUser.username}" readonly="readonly"/>
                                </div>
                                <div class="form-group">
                                    <label for="username">First Name:</label>
                                    <input type="text" name="firstname" id="firstname" class="form-control" value="${selectedUser.firstName}" />
                                </div>
                                <div class="form-group">
                                    <label for="username">Last Name:</label>
                                    <input type="text" name="lastname" id="lastname" class="form-control" value="${selectedUser.lastName}" />
                                </div>
                                <div class="form-group">
                                    <label for="access">Email:</label>
                                    <input type="text" name="email" id="email" class="form-control" value="${selectedUser.email}" />
                                </div>
                                <div class="form-group">
                                    <label for="password">Password:</label>
                                    <input type="password" name="password"  class="form-control" id="password" value="${selectedUser.password}" />
                                </div>
                                <div class="form-group">
                                    <input type="hidden" name="action" value="edit">
                                    <input type="submit" class="btn btn-default" value="Save"/>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </c:if>




        </div>







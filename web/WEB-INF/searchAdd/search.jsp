<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@include file="/WEB-INF/jspf/header.jspf" %>

<div class="section">
            <div class="container">
                <div class="row">
                  <div class="col-md-12">
                    <h1>Search</h1>
                  </div></div>
              	<div class="row">
                    <div class="col-md-6">
                    <!-- Search company --> 
                        <div class="jumbotron">
                            <h1>Company</h1>
                            <form role="searchCompany" action="search" method="post">
                                <div class="form-group" id="locationRight">
                                    <label class="control-label">Company - Location
                                        <br>
                                    </label>
                                    <select class="form-control">
                                        <option>Company - Location</option>
                                        <option>2</option>
                                    </select>
                                </div>
                                            <input type="hidden" name="action" value="searchCompany">
                                <button type="submit" class="btn btn-default" id="searchCompany">Submit</button>
                            </form>
                        </div>
                    </div>
                  
                  <!-- Search client --> 
                    <div class="col-md-6">
                        <div class="jumbotron">
                            <h1>Client</h1>
                            <form role="searchClient"  action="search" method="post">
                                <div class="form-group" id="locationRight">
                                    <label class="control-label">Company - Location
                                        <br>
                                    </label>
                                    <select class="form-control">
                                        <option>Company - Location</option>
                                        <option>2</option>
                                    </select>
                                </div>
                                
                                <div class="form-group" id="locationRight">
                                    <label class="control-label">Name
                                        <br>
                                    </label>
                                    <select class="form-control">
                                        <option>Client Name</option>
                                        <option>Client Name2</option>
                                    </select>
                                </div>
                                
                                
                                        <input type="hidden" name="action" value="searchClient">
                                <button type="submit" class="btn btn-default" id="searchClient">Submit</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
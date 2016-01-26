<%-- 
    Document   : login
    Created on : 26-Jan-2016, 1:35:45 PM
    Author     : 680420
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href='https://fonts.googleapis.com/css?family=Raleway:400,500,300' rel='stylesheet' type='text/css'>
<link href="login.css" rel="stylesheet" type="text/css">

<div id="mainButton">
	<div class="btn-text" onclick="openForm()">Sign In</div>
	<div class="modal">
		<div class="close-button" onclick="closeForm()">x</div>
		<div class="form-title">Sign In</div>
		<div class="input-group">
			<input type="text" id="name" onblur="checkInput(this)" />
			<label for="name">Username</label>
		</div>
		<div class="input-group">
			<input type="password" id="password" onblur="checkInput(this)" />
			<label for="password">Password</label>
		</div>
		<div class="form-button" onclick="closeForm()">Go</div>
		<div class="codepen-by">CodePen by Cole Waldrip</div>
	</div>
</div>
<div class="codepen-by">CodePen by Cole Waldrip</div>
